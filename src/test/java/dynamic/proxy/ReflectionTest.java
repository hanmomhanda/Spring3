package dynamic.proxy;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by hanmomhanda on 2016-02-20.
 */
public class ReflectionTest {

    @Test
    public void invokeMethod() throws Exception {
        String name = "Spring";

        assertThat(name.length(), is(6));

        Method lengthMethod = name.getClass().getMethod("length");
        assertThat((Integer)lengthMethod.invoke(name), is(6));

        Method charAtMethod = name.getClass().getMethod("charAt", int.class);
        assertThat((Character)charAtMethod.invoke(name, 3), is('i'));
    }
}
