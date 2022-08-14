import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    private Feline feline;

    @Test
    public void getKittensCorrectValue() throws Exception {
        Lion lion = new Lion("Самец", feline);
        int expectedValue = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);
        int actualValue = lion.getKittens();
        assertEquals("Value incorrect", expectedValue, actualValue);
    }

    @Test
            (expected = Exception.class)
    public void testConstructorException() throws Exception {
        try {
            Lion lion = new Lion("Оно", new Feline());
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
            throw e;
        }
    }
}