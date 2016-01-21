package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * Created by hanmomhanda on 2016-01-21.
 */
public class MockitoTest {

    @Test
    public void verifyTest() {
        List mockedList = mock(List.class);

        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
//        verify(mockedList).addAll(new ArrayList());
        verify(mockedList).clear();
    }

}
