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

        T[] brokenLeft = breakLeftArray(myArr, insertAtIndex);
        T[] brokenRight = breakRightArray(myArr, insertAtIndex);

        System.out.println(brokenRight.length);//2 - right copy

        System.out.println(myArr.length); //4
        //Set the left-most array to myArr
        myArr = brokenLeft;
        System.out.println(myArr.length); //2 - left copy after split

        //Add the element of interest to the end of the left-most array (myArr)
        add(elementToInsert);
        System.out.println(myArr.length); //3 - left copy after add an element

        //combine both arrays again by adding elements from the right-most array to the end of the left-most array
        for(int i=0; i<brokenRight.length;i++){
            add(brokenRight[i]);
        }
        System.out.println(myArr.length); //5 after reconnecting arrays
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
    public void remove(int removalIndex){

        //Can't figure this out so I tried this method from here:
        // http://stackoverflow.com/questions/35880131/creating-an-array-list-from-scratch

        if (removalIndex < 0 || removalIndex >= myArr.length) return;
        T[] temp = (T[]) new Object[myArr.length - 1];

        boolean found = false;
        // copy everything over to the new element
        for (int i = 0; i < myArr.length; i++)
        {
            // don't copy if the indices are the same
            if (i == removalIndex)
            {
                found = true;
                continue;
            }
            temp[i - (found ? 1 : 0)] = myArr[i];
        }
        myArr = temp;
    }

    //Replaces the element at the specified position in this list with the specified element.
    public void set(int indexLocation, T itemToReplace){

        //Use a function accessible to Arrays (fill)
        Arrays.fill(myArr, indexLocation, indexLocation+1, itemToReplace);
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
        if(myArr.equals(item)){
            return true;
        } else
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
