package handlers;

import domain.Test;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.reactivex.Single;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.api.RequestParameters;
import io.vertx.reactivex.ext.web.RoutingContext;
import services.UrbappServices;

public class UrbappHandler {

	private static Logger LOGGER = LoggerFactory.getLogger(UrbappHandler.class.getName());

	UrbappServices urbappServices;

	public UrbappHandler(UrbappServices urbappServices) {
		this.urbappServices = urbappServices;
	}

	public void test(RoutingContext context) {

		urbappServices.test().subscribe(res -> {

				JsonObject result = new JsonObject();
				result.put("value", res.getValue());

				context.response()
					.putHeader("content-type", "application/json")
					.setStatusCode(HttpResponseStatus.OK.code())
					.end(Json.encode(result));

			}, err -> LOGGER.error("Failed test " + err.getMessage())
		);

	}

	public void login(RoutingContext context) {

		RequestParameters params = context.get("parsedParameters");
		var username = params.pathParameter("username").getName();

		System.out.println("trying login with username: " + username);

		urbappServices.login(username).subscribe(res -> {

				JsonObject result = new JsonObject();
				result.put("value", res.getValue());

				context.response()
					.putHeader("content-type", "application/json")
					.setStatusCode(HttpResponseStatus.OK.code())
					.end(Json.encode(result));

			}, err -> LOGGER.error("Failed login " + err.getMessage())
		);

	}
}
