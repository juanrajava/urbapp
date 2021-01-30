package com.urbapp.core.dbconnection;

import com.urbapp.core.config.Config;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.jdbc.JDBCClient;
import io.vertx.reactivex.ext.sql.SQLConnection;
import java.util.concurrent.TimeUnit;


public class PostgresDbClient {

	private static final Logger LOGGER = LoggerFactory.getLogger(PostgresDbClient.class.getName());

	private JDBCClient reads;
	private String driverClass;

	public PostgresDbClient(Config config) {

		JsonObject dbConfigReads = config.getDbDConfigReads();
		reads = JDBCClient.createNonShared(Vertx.currentContext().owner(), dbConfigReads);

		this.driverClass = dbConfigReads.getString("driver_class");
		checkConnection();
	}

	public String getDriverClass() {
		return this.driverClass;
	}

	/**
	 * Reads
	 */
	public Single<SQLConnection> getReadsConnection() {
		return createConnection(reads);
	}

	private Single<SQLConnection> createConnection(JDBCClient client) {
		return client.rxGetConnection()
			.timeout(60, TimeUnit.SECONDS)
			.doOnError(error -> {
				LOGGER.fatal("createConnection fatal error " + error.getMessage(), error);
				error.printStackTrace();
			})
			.doAfterSuccess(SQLConnection::close);
	}

	private synchronized void checkConnection() {
		getReadsConnection()
			.flatMap(conn -> conn.rxQuery("select 1 from dual").doOnError(LOGGER::error)
				.doFinally(conn::close))
			.subscribe(rs ->
			LOGGER.info("select 1 from dual ok? " + rs.getResults().size()), err -> {
			LOGGER.fatal("Error checking connections ", err);
			err.printStackTrace();
		});
	}

	public Single<JsonObject> readsHealth(Long oracleHealthTimeout) {
		return checkConnectionHealth(getReadsConnection(), oracleHealthTimeout);
	}

	protected Single<JsonObject> checkConnectionHealth(Single<SQLConnection> sqlConnection, Long oracleHealthTimeout) {
		return sqlConnection.flatMap(conn -> conn.rxQuery("select 1 from dual")
			.timeout(oracleHealthTimeout, TimeUnit.SECONDS)
			.map(rs -> new JsonObject().put("status", "ok"))
			.doFinally(conn::close))
			.onErrorReturn(err -> {
				LOGGER.fatal("Error doOnError: HealthCheckRestHandlerImpl.checkConnection ", err);
				return new JsonObject().put("status", "error").put("error", err.getMessage());
			});
	}

}
