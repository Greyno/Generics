package reynoldstitko.gillian;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by gillianreynolds-titko on 2/22/17.
 */
public class MyArrayList<T> {

    private T[] myArr; //define a private variable

    //Create a no-arg constructor
    public MyArrayList() {

        myArr = (T[]) new Object[0]; //create a new instance with a size of 1
    }

    //Create a one-arg constructor
    public MyArrayList(int startingIndex) {

        myArr = (T[]) new Object[startingIndex];
    }

    //Create another constructor
    public MyArrayList(T[] arr) {

        myArr = arr;
    }

    //Appends the specified element to the end of the list.
    public void add(T element) throws IndexOutOfBoundsException {
        //Since Arrays cannot add an element, will need to copy the array into one that is
        // 1 size larger than the original array

        //Create an array that is 1 larger than the current array
        T[] newArray = (T[]) new Object[myArr.length + 1];

        //Put the elements from the old array into the new array (there will be room for 1 more element)
        for(int i = 0; i < myArr.length; i++){
            newArray[i] = myArr[i];
        }

        //Add the element to the new array
        newArray[myArr.length] = element;
        myArr = newArray; //can now access the new, resized array through get methods
    }

    //Inserts the specified element at the specified position in this list.
    public void add(int insertAtIndex, T elementToInsert) throws IndexOutOfBoundsException {

        try {
            if(insertAtIndex < 0 || insertAtIndex > myArr.length){
                throw new IndexOutOfBoundsException();
            }
        } catch (IndexOutOfBoundsException e){
            e.sendMessage();
            throw e;
        }

        //Break the array into two parts, using a function accessible to Arrays (copyOfRange)
        T[] brokenLeft = breakLeftArray(myArr, insertAtIndex);
        T[] brokenRight = breakRightArray(myArr, insertAtIndex);

        //Set the left-most array to myArr
        myArr = brokenLeft;

        //Add the element of interest to the end of the left-most array (myArr)
        add(elementToInsert);

        //combine both arrays again by adding elements from the right-most array to the end of the left-most array
        for(int i=0; i<brokenRight.length;i++){
            add(brokenRight[i]);
        }
    }

    /*copyOfRange: startIndex is the initial index of the range to be copied, inclusive.
    endIndex is the final index of the range to be copied, exclusive. (This index may lie outside the array) */
    private T[] breakLeftArray(T[] array, int atLocation){
        T[] tempLeft = Arrays.copyOfRange(myArr, 0, atLocation);
        return tempLeft;
    }

    private T[] breakRightArray(T[] array, int atLocation){
        T[] tempRight = Arrays.copyOfRange(myArr, atLocation, myArr.length);
        return tempRight;
    }

    //Returns the element at the specified position in this list
    public T get(int value){

        return myArr[value];
    }

    //Removes the element at the specified location in the list
    public void remove(int removalIndex) throws IndexOutOfBoundsException{

        T[] temp = (T[]) new Object[myArr.length-1];
        T[] brokenLeft = breakLeftArray(myArr, removalIndex+1);
        T[] brokenRight = breakRightArray(myArr, removalIndex);
        myArr = brokenLeft;

        System.out.println("Before null "+myArr.length);
        //create a new array, excluding the item that we want to remove
        set(myArr.length-1, null);
        System.out.println("After null "+myArr.length);

        //resize the array
        for(int i=0; i<myArr.length-1;i++){
            temp[i] = myArr[i];
        }

        myArr = temp;

        for(int i=0; i<brokenRight.length;i++){
            add(brokenRight[i]);
        }
        System.out.println("After rejoin "+myArr.length);

    }

    //Replaces the element at the specified position in this list with the specified element.
    public void set(int indexLocation, T itemToReplace) {
        //Use a function accessible to Arrays (fill), which will replace values in an array
        Arrays.fill(myArr, indexLocation, indexLocation + 1, itemToReplace);
    }

    //Removes all of the elements from this list.
    public void clear() throws IndexOutOfBoundsException{
        for(int i = 0; i < myArr.length; i++){
            remove(i);
        }
        System.out.println(myArr.length);
    }

    //Returns true if this list contains no elements.
    public boolean isEmpty(){
        if((myArr.length) == 0){
            return true;
        } else
            return false;
    }

    //Returns true if this list contains the specified element
    public boolean contains(T item) {
        for (int i = 0; i < myArr.length; i++) {
            if (myArr[i].equals(item)) {
                return true;
            }
        } return true;
    }

    @Override
    public String toString(){
        String value = "";
        for(T t: myArr){
            value = value + " ";
        }
        return value;
    }

}
