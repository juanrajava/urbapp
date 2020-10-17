package handlers;

import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.Single;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.ext.web.RoutingContext;

public class HealthCheckHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(HealthCheckHandler.class.getName());
	private JsonObject cachedStatus = initialState();
	private Integer cachedStatusCode = HttpResponseStatus.OK.code();

	public void check(RoutingContext context) {
		context.response()
			.putHeader("content-type", "application/json")
			.setStatusCode(cachedStatusCode)
			.end(cachedStatus.encodePrettily());
	}

	private JsonObject initialState() {
		return new JsonObject()
			.put("postgres", new JsonObject().put("status", "ok"));
	}
}
