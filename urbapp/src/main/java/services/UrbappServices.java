package services;

import domain.Test;
import io.reactivex.Single;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class UrbappServices {

	private static Logger LOGGER = LoggerFactory.getLogger(UrbappServices.class.getName());

	public Single<Test> test() {

		return Single.just(Test.builder().withValue("123456789 - Test  - ARF - Response OK").build());
	}

	public Single<Test> login() {

		return Single.just(Test.builder().withValue("Login - Response OK").build());
	}
}
