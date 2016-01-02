package io.hanmomhanda.spring3;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import io.hanmomhanda.spring3.ch01.dao.UserDao;
import io.hanmomhanda.spring3.ch01.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Ch0101.class)
public class Ch0101 {

	@Test
	public void addAndGet() throws Exception {
		User user = new User();
		user.setId("hanmomhanda");
		user.setName("오명운");
		user.setPassword("2369home");

        UserDao userDao = new UserDao();

        userDao.delete("hanmomhanda");

        userDao.add(user);

        User userFromDB = userDao.get(user.getId());

        assertThat(userFromDB.getName(), is(user.getName()));
        assertThat(userFromDB.getPassword(), is(user.getPassword()));
	}
}
