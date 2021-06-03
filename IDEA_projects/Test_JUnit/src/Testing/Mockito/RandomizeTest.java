package Testing.Mockito;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Random;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RandomizeTest {

    @Test
    public void getRandom() throws Exception {      // проверяем, что наш метод работает так как надо
        Random mock = mock(Random.class);
        Randomize randomize = new Randomize(mock);

        int val = 10;
        int expected = 3;
        when(mock.nextInt(val)).thenReturn(expected);

        int random = randomize.getRandom(val);

        assertEquals(expected, random);
//        Assert.assertTrue(stringToIdTime1 > stringToIdTime2);   // norm tema
    }

    @Test (expected = IllegalArgumentException.class)   // говорим, что тест бросает исключение - если так, то успешно
    public void exception() throws Exception {
        Random mock = mock(Random.class);
        Randomize randomize = new Randomize(mock);

        int val = 10;
        int expected = 30;
        when(mock.nextInt(val)).thenReturn(expected);

        int random = randomize.getRandom(val);

        Mockito.verify(mock).nextInt(); // проверка, что метод был вызван хотя бы один раз
        assertEquals(expected, random);
    }
}