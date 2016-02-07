package practice;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by hanmomhanda on 2016-01-21.
 */
public class MockitoTest {

    @Mock
    private List mockedList;

    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void verifyTest() {
        mockedList.add("one");
        mockedList.add("two");
        mockedList.add("three");
        mockedList.clear();

//        verify(mockedList).add("one");
        verify(mockedList, times(3)).add(any(String.class));
//        verify(mockedList).addAll(new ArrayList());
        verify(mockedList).clear();
    }

}
