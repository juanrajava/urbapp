package routing;

import handlers.DefaultErrorHandler;
import io.reactivex.Single;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;
import io.vertx.reactivex.ext.web.api.contract.openapi3.OpenAPI3RouterFactory;
import io.vertx.reactivex.ext.web.handler.BodyHandler;
import io.vertx.reactivex.ext.web.handler.CorsHandler;
import io.vertx.reactivex.ext.web.handler.LoggerHandler;
import io.vertx.reactivex.ext.web.handler.ResponseTimeHandler;
import io.vertx.reactivex.ext.web.handler.StaticHandler;
import ioc.IoC;

public class Routing {

	private static final Logger LOGGER = LoggerFactory.getLogger(Routing.class.getName());

	private static final String HEALTH_CHECK = "/health";

	public Single<Router> createRouter(Vertx vertx) {

		return OpenAPI3RouterFactory
			.rxCreate(vertx, "swagger/swagger.yml")
			.doOnError(LOGGER::error)
			.map(routerFactory -> {

				addGlobalHandlers(routerFactory);

				routeHandlersBySwaggerOperationId(routerFactory);

				Router router = routerFactory.getRouter();

				vanillaRouting(router);

				routeCommonsHandlers(router);

				LOGGER.debug("Routing Done");
				return router;
			});
	}

	private void addGlobalHandlers(OpenAPI3RouterFactory routerFactory) {
		routerFactory
			.addGlobalHandler(CorsHandler.create("*"))
			.addGlobalHandler(LoggerHandler.create())
			.addGlobalHandler(ResponseTimeHandler.create())
			.addGlobalHandler(BodyHandler.create());
	}

	private void vanillaRouting(Router router) {
		router.get(HEALTH_CHECK).handler(IoC.healthCheckHandler::check);
	}

	private void routeHandlersBySwaggerOperationId(OpenAPI3RouterFactory routerFactory) {
		routerFactory
			.addHandlerByOperationId("test",
				IoC.urbappHandler::test)
			.addHandlerByOperationId("login",
				IoC.urbappHandler::login)
		;
	}

	private void routeCommonsHandlers(Router router) {
		router.route().failureHandler(new DefaultErrorHandler());
		router.get("/*").handler(StaticHandler.create());
	}
}



