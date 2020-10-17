package handlers;

import exceptions.BackendException;
import exceptions.BadRequestException;
import exceptions.ResourceNotFoundException;
import exceptions.UnauthorizedException;
import exceptions.UnexpectedException;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.vertx.core.Handler;
import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.ext.web.RoutingContext;
import java.net.UnknownHostException;
import io.vertx.ext.web.api.validation.ValidationException;

public class DefaultErrorHandler implements Handler<RoutingContext> {
	private static Logger LOGGER = LoggerFactory.getLogger(DefaultErrorHandler.class.getName());

	public DefaultErrorHandler() {
	}

	public void handle(RoutingContext context) {
		Throwable error = context.failure();
		String body = "{}";
		if (this.isVxJWTAuthHandlerError(context)) {
			UnauthorizedException unauthorizedException = new UnauthorizedException();
			context.response().setStatusCode(unauthorizedException.getHttpCode());
			body = Json.encodePrettily(unauthorizedException.getErrorDto());
		} else if (error instanceof BackendException) {
			context.response().setStatusCode(((BackendException)error).getHttpCode());
			body = Json.encodePrettily(((BackendException)error).getErrorDto());
		} else if (error instanceof UnknownHostException) {
			ResourceNotFoundException response = new ResourceNotFoundException(error.getMessage());
			context.response().setStatusCode(response.getHttpCode());
			body = Json.encodePrettily(response.getErrorDto());
		} else if (error instanceof ValidationException) {
			BadRequestException response = new BadRequestException(error.getMessage());
			context.response().setStatusCode(response.getHttpCode());
			body = Json.encodePrettily(response.getErrorDto());
		} else {
			UnexpectedException response = new UnexpectedException(error.getMessage());
			context.response().setStatusCode(response.getHttpCode());
			body = Json.encodePrettily(response.getErrorDto());
		}

		LOGGER.info(String.format("Status %s: %s", context.response().getStatusCode(), body));
		context.response().putHeader("Content-Type", "application/json").end(body);
	}

	private boolean isVxJWTAuthHandlerError(RoutingContext context) {
		return context.failed() && HttpResponseStatus.UNAUTHORIZED.code() == context.statusCode() && null == context.failure();
	}
}
