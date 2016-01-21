package practice;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Created by hanmomhanda on 2016-01-21.
 */
public class JUnitTest {
    static Set<JUnitTest> testObjects = new HashSet<>();
    static JUnitTest testObject;

    @Test
    public void test1() {
        assertThat(this, is(not(sameInstance(testObject))));
        testObject = this;
    }

    @Test
    public void test2() {
        assertThat(this, is(not(sameInstance(testObject))));
        testObject = this;
    }

    @Test
    public void test3() {
        assertThat(this, is(not(sameInstance(testObject))));
        testObject = this;
    }

    @Test
    public void test4() {
        assertThat(testObjects, not(hasItem(this)));
        testObjects.add(this);
    }

    @Test
    public void test5() {
        assertThat(testObjects, not(hasItem(this)));
        testObjects.add(this);
    }

    @Test
    public void test6() {
        assertThat(testObjects, not(hasItem(this)));
        testObjects.add(this);
    }
}
