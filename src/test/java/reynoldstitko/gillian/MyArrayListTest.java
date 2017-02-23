package reynoldstitko.gillian;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by gillianreynolds-titko on 2/22/17.
 */
public class MyArrayListTest {

    MyArrayList<String> myArr;
    MyArrayList<String> myArr2;

    @Before
    public void setUp(){
        myArr = new MyArrayList<String>();
        myArr2 = new MyArrayList<String>(3);
    }

    @Test
    public void constructor1Test(){

        assertNotNull(myArr);
    }

    @Test
    public void constructor2Test(){

        assertFalse(myArr2.isEmpty());
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
    public void addInsertElementAtIndexTest(){
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        myArr.add(0, "e");
        System.out.println(myArr.toString());
        String actual = myArr.get(0);
        assertSame("Expected", "e", actual);
    }

    @Test
    public void setTest(){
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        myArr.set(2, "e");
        assertEquals("e", myArr.get(2));
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

    @Test
    public void isEmptyTest(){
        myArr.add("a");
        myArr.add("b");
        myArr.remove(1);
        boolean expected = true;
        boolean actual = myArr.isEmpty();
        assertFalse(myArr.isEmpty());
    }

    @Test
    public void clearTest(){
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        boolean expected = true;
        myArr.clear();
        System.out.println(myArr);
        assertTrue(myArr.isEmpty());
    }

    @Test
    public void containsTest(){
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        boolean expected = true;
        myArr.contains("c");
        System.out.println(myArr);
        assertEquals("Expected equal", "c", myArr.contains("c"));
    }

    @Test
    public void removeTest(){
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        myArr.remove(2);
        boolean expected = false;
        myArr.contains("c");
        assertEquals("Expected equal", expected, myArr.contains("c"));
    }
}
