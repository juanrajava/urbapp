import io.netty.channel.DefaultChannelId;
import io.reactivex.Single;
import io.vertx.core.DeploymentOptions;
import io.vertx.core.VertxOptions;
import io.vertx.core.eventbus.EventBusOptions;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.reactivex.core.Vertx;
import verticles.MainVerticle;

public class Main {

	private static final Logger LOGGER = LoggerFactory.getLogger(Main.class.getName());

	public static void main(String[] args) {
		start(new DeploymentOptions()).subscribe(res -> LOGGER.info("Verticle running with id " + res.toLowerCase()),
			error -> {
				error.printStackTrace();
				LOGGER.error("Error starting !!!!!!!! " + error.getMessage());
			});
	}

	public static Single<String> start(DeploymentOptions deploymentOptions) {
		DefaultChannelId.newInstance();
		VertxOptions vertxOptions = new VertxOptions().setEventBusOptions(getEventBusOptions());
		deploymentOptions.setInstances(1);
		vertxOptions.setEventLoopPoolSize(1);
		vertxOptions.setWorkerPoolSize(10);
		vertxOptions.setInternalBlockingPoolSize(10);
		return run(vertxOptions, deploymentOptions).map(id ->
			id
		);
	}

	private static Single<String> run(VertxOptions options, DeploymentOptions deploymentOptions) {
		final Vertx vertx = Vertx.vertx();
		return vertx.rxDeployVerticle(MainVerticle.class.getName(), deploymentOptions);
	}

	private static EventBusOptions getEventBusOptions() {
		var eventBusOptions = new EventBusOptions();
		var clusterEnable = Boolean.parseBoolean(System.getenv("CLUSTER_ENABLE"));
		if (clusterEnable) {
			var podIp = System.getenv("MY_POD_IP");
			eventBusOptions.setClustered(clusterEnable);
			eventBusOptions.setHost(podIp);
			LOGGER.info("POD IP {0}", podIp);
		}
		return eventBusOptions;
	}

}
