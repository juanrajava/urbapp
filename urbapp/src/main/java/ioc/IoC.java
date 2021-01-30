package ioc;

import com.urbapp.core.config.Config;
import com.urbapp.core.dbconnection.PostgresDbClient;
import com.urbapp.core.handlers.HealthCheckHandler;
import com.urbapp.core.handlers.UrbappHandler;
import services.UrbappServices;

public interface IoC {

	HealthCheckHandler healthCheckHandler = new HealthCheckHandler();
	UrbappServices urbappServices = new UrbappServices();
	UrbappHandler urbappHandler = new UrbappHandler(urbappServices);
	Config config = new Config();
	PostgresDbClient postgresDbClient = new PostgresDbClient(config);
}
