package io.hanmomhanda.spring3;

import io.hanmomhanda.spring3.ch01.dao.ConnectionMaker;
import io.hanmomhanda.spring3.ch01.dao.ConnectionMakerImpl;
import io.hanmomhanda.spring3.ch01.dao.UserDao;
import io.hanmomhanda.spring3.ch01.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = UserDaoTest.class)
public class UserDaoTest {

    ConnectionMaker connectionMaker;
	UserDao userDao;
    String userId;

	@Before
	public void before() throws Exception {
        connectionMaker = new ConnectionMakerImpl();
		userDao = new UserDao();
        userDao.setConnectionMaker(connectionMaker);

        userId = "hanmomhanda";
        userDao.delete(userId);
	}

	@Test
	public void addAndGet() throws Exception {
		User user = new User();
		user.setId(userId);
		user.setName("오명운");
		user.setPassword("2369home");

        userDao.add(user);

        User userFromDB = userDao.get(user.getId());

        assertThat(userFromDB.getName(), is(user.getName()));
        assertThat(userFromDB.getPassword(), is(user.getPassword()));
	}

    @After
    public void after() throws Exception {
        userDao.delete(userId);
    }
}
