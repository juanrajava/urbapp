package services;

import com.urbapp.core.domain.Test;
import com.urbapp.core.domain.Users;
import io.reactivex.Single;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

public class UrbappServices {

	private static Logger LOGGER = LoggerFactory.getLogger(UrbappServices.class.getName());

	public Single<Test> test() {

		return Single.just(Test.builder().withValue("ARF - Response OK").build());
	}

	public Single<Users> login(String username) {

//		usersDao.getLogin(context, username);

		return Single.just(Users.builder()
			.withId(1)
			.withUsername("Juan")
			.withEmail("juan@juan.com")
			.build());
	}
}
