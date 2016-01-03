package io.hanmomhanda.spring3;

import io.hanmomhanda.spring3.ch03.dao.ConnectionMakerImpl;
import io.hanmomhanda.spring3.ch03.dao.DaoFactory;
import io.hanmomhanda.spring3.ch03.dao.UserDao;
import io.hanmomhanda.spring3.ch03.domain.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {

		UserDao userDao = DaoFactory.getUserDao();

		String userId = "hanmomhanda";
		userDao.delete(userId);

		User user = new User();
		user.setId(userId);
		user.setName("오명운");
		user.setPassword("2369home");

		userDao.add(user);

		User userFromDB = userDao.get(user.getId());

		System.out.println(user.getName());
		System.out.println(userFromDB.getName());
		System.out.println("=== " + user.getName().equals(userFromDB.getName()) + " ===\n");

		System.out.println(user.getPassword());
		System.out.println(userFromDB.getPassword());
		System.out.println("=== " + user.getPassword().equals(userFromDB.getPassword()) + " ===\n");

		userDao.delete(userId);
	}
}
