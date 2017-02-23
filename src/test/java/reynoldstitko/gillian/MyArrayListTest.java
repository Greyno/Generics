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
    public void addTest() throws IndexOutOfBoundsException{
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
    public void addInsertElementAtIndexTest() throws IndexOutOfBoundsException {
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        myArr.add(0, "e");
        System.out.println(myArr.toString());
        String actual = myArr.get(0);
        assertSame("Expected", "e", actual);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addInsertElementAtIndexOutOfBoundsTest() throws IndexOutOfBoundsException{
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        myArr.add(10, "e");
        String actual = myArr.get(-1);
        assertSame("Expected", "e", actual);
    }

    @Test
    public void setTest() throws IndexOutOfBoundsException{
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        myArr.set(2, "e");
        assertEquals("e", myArr.get(2));
    }

    @Test
    public void getTest() throws IndexOutOfBoundsException{
        String expected = "c";
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        String actual = myArr.get(2);
        assertEquals("Expected", expected, actual);
    }

    @Test
    public void isEmptyTest() throws IndexOutOfBoundsException{
        myArr.add("a");
        myArr.add("b");
        myArr.remove(1);
        boolean expected = true;
        boolean actual = myArr.isEmpty();
        assertFalse(myArr.isEmpty());
    }

    @Test
    public void clearTest() throws IndexOutOfBoundsException{
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
    public void containsTrueTest() throws IndexOutOfBoundsException{
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        boolean expected = true;
        assertTrue(myArr.contains("c"));
    }

    @Test
    public void containsFalseTest() throws IndexOutOfBoundsException{
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        boolean expected = false;
        assertTrue(myArr.contains("f"));
    }

    @Test
    public void removeTest() throws IndexOutOfBoundsException{
        myArr.add("a");
        myArr.add("b");
        myArr.add("c");
        myArr.add("d");
        myArr.remove(1);
        boolean expected = false;
        String actual = myArr.get(3);
        assertEquals("Expected", "c", actual);
        //assertFalse(myArr.contains("c"));
    }
}
