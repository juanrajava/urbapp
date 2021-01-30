package com.urbapp.core.config;

import io.vertx.core.json.JsonObject;

public class Config extends com.urbapp.core.config.BaseConfig {

	private static final String DB_USER_READS = "DB_USER_READS";
	private static final String DB_PW_READS = "DB_PW_READS";

	public Config() {
		super();

		var conf = Config.getSuperInstance();
		if (conf.getConfig().isPresent()) {
			this.config = conf.getConfig().get();
		}
	}

	public JsonObject getDbDConfigReads() {
		JsonObject dbConfig = (JsonObject) getValue("database_reads");
		dbConfig.put("user", getDbUserReads());
		dbConfig.put("password", getDbPwReads());
		return dbConfig;
	}

	public String getDBTimeZone() {
		return ((JsonObject) getValue("database")).getString("timezone");
	}

	private String getDbUserReads() {
		String dbUserEnv = System.getenv(DB_USER_READS);
		return dbUserEnv != null ? dbUserEnv : (String) getValue("dbCredentialsReads.user");
	}

	private String getDbPwReads() {
		String dbPwEnv = System.getenv(DB_PW_READS);
		return dbPwEnv != null ? dbPwEnv : (String) getValue("dbCredentialsReads.password");
	}
}
