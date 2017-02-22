package reynoldstitko.gillian;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

/**
 * Created by gillianreynolds-titko on 2/22/17.
 */
public class MyArrayListTest {

    MyArrayList<String> myArr;

    @Before
    public void setUp(){
        myArr = new MyArrayList<String>();
    }

    @Test
    public void addTest(){
        String expected = "f";
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        myArr.add("e");
        myArr.add("f");
        String actual = myArr.get(5);
        assertSame("Expected", "f", actual);
    }

    @Test
    public void getTest(){
        String expected = "c";
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        String actual = myArr.get(2);
        assertEquals("Expected", expected, actual);
    }


}
