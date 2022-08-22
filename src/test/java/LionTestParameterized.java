import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;


import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)

public class LionTestParameterized {
    @Spy
    private Feline feline;
    private String sex;
    private boolean extended;

    public LionTestParameterized(String sex, boolean extended) throws Exception {
        this.sex = sex;
        this.extended = extended;

    }

    @Before
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        Object[][] objects = {
                {"Самка",false},
                {"Самец",true},
        };
        return objects;}


    @Test
    public void testDoesHaveMane() throws Exception {
        Lion lion2 = new Lion(sex, feline);
        boolean actualResult = lion2.doesHaveMane();
        assertEquals("Используйте допустимые значения пола животного - самей или самка",extended, actualResult);
    }

}