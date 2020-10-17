package ioc;

import handlers.HealthCheckHandler;
import handlers.UrbappHandler;
import services.UrbappServices;

public interface IoC {

	HealthCheckHandler healthCheckHandler = new HealthCheckHandler();
	UrbappServices urbappServices = new UrbappServices();
	UrbappHandler urbappHandler = new UrbappHandler(urbappServices);
}
