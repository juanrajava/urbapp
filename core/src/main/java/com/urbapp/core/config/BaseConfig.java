package com.urbapp.core.config;

import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import java.util.Optional;

public class BaseConfig {

	private static final Logger LOGGER = LoggerFactory.getLogger(BaseConfig.class.getName());

	public static final String DEFAULT_HOST = "127.0.0.1";
	public static final int DEFAULT_PORT = 8080;
	public JsonObject config;
	private static BaseConfig INSTANCE;
	private static final Byte LOCK = 0;

	public static BaseConfig getSuperInstance() {
		if (INSTANCE == null) {
			synchronized(LOCK) {
				if (INSTANCE == null) {
					INSTANCE = new BaseConfig();
				}
			}
		}

		return INSTANCE;
	}

	public BaseConfig() {
	}

	public void init(JsonObject configInit) {
		this.config = configInit;
	}

	public Optional<JsonObject> getConfig() {
		return Optional.of(this.config);
	}

	public Optional<String> getContext() {
		return Optional.ofNullable(this.config.getJsonObject("server").getString("context"));
	}

	public Optional<String> getHost() {
		return Optional.ofNullable(this.config.getJsonObject("server").getString("host"));
	}

	public Optional<Integer> getPort() {
		return Optional.ofNullable(this.config.getJsonObject("server").getInteger("port"));
	}

	public Object getValue(String pattern) {
		return getValue(pattern, null);
	}
	public <T> T getValue(String pattern, T defaultValue) {
		JsonObject conf = this.config;
		String[] accessors = pattern.split("\\.");
		int numAccessors = accessors.length;
		int lastAccessorIndex = numAccessors - 1;

		for(int i = 0; i < lastAccessorIndex; ++i) {
			conf = conf.getJsonObject(accessors[i]);
		}
		if (conf == null) {
			LOGGER.error("Config not found : " + pattern);
			new Throwable().fillInStackTrace().printStackTrace();
		}

		return (T) conf.getValue(accessors[lastAccessorIndex], defaultValue);
	}
}
