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
    public void add(T element){
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
    public void add(int insertAtIndex, T elementToInsert) {

        T[] finalArray = (T[]) new Object[myArr.length + 1];

        //Break the array into two parts, using a function accessible to Arrays (copyOfRange)

        int arrayLength = myArr.length;

        for (int i = arrayLength - 1; i > insertAtIndex; i--) {
            myArr[arrayLength] = myArr[i];
            arrayLength = arrayLength - 1;
        }
        myArr[insertAtIndex] = elementToInsert;

//        myArr[insertAtIndex] = elementToInsert;

//        T[] broken = breakArrays(myArr, insertAtIndex);
//
//        T[] tempLeft = Arrays.copyOfRange(myArr, 0, insertAtIndex-1);
//        T[] tempRight = Arrays.copyOfRange(myArr, insertAtIndex, myArr.length);
//
//        //add(elementToInsert);
//        T[] newLeftArray = (T[]) new Object[tempLeft.length + 1];
//        for(int i = 0; i < tempLeft.length; i++){
//            tempLeft[i] = myArr[i];
//        }

        //combine both arrays again


//        Arrays.fill(myArr, insertAtIndex, insertAtIndex+1, elementToInsert);
//        Arrays.fill(myArr, insertAtIndex, insertAtIndex+1, elementToInsert);
    }

    private T[] breakArrays(T[] array, int atLocation){
        T[] tempLeft = Arrays.copyOfRange(myArr, 0, atLocation-1);
        T[] tempRight = Arrays.copyOfRange(myArr, atLocation, myArr.length);
        return tempLeft;
    }

    //Returns the element at the specified position in this list
    public T get(int value){
        return myArr[value];
    }


    //Removes the element at the specified location in the list
    public void remove(int removalIndex){
        for(int i = 0; i < myArr.length; i++){
            if
        }

    }

    //Replaces the element at the specified position in this list with the specified element.
    public void set(int indexLocation, T itemToReplace){

    }

    //Removes all of the elements from this list.
    public void clear(){
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
    public boolean contains(T item){
        return false;
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
