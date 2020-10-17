package routing;

import io.vertx.core.Verticle;
import io.vertx.reactivex.core.AbstractVerticle;
import io.vertx.reactivex.core.Vertx;
import io.vertx.reactivex.ext.web.Router;

public class Server extends AbstractVerticle {

	public static void main(String[] args) {
		Verticle verticle = new Server();
		Vertx.vertx().deployVerticle(verticle);
	}

	@Override
	public void start() throws Exception {
		Router router = Router.router(vertx);

		router.route().handler(routingContext -> {
			routingContext.response().putHeader("content-type", "text/html").end("Hello World Niggaa!");
		});

		vertx.createHttpServer().requestHandler(router::accept).listen(8080);
	}

}
