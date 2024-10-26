package prep.google.interview.arrays;

import java.util.Arrays;

public class CustomArrayList<E> {
    private  int INITIAL_SIZE = 10;

    private  int size =0;
    Object arrayData [] = {};

    public CustomArrayList(){
        this.arrayData = new Object[INITIAL_SIZE];
    }

    private  void increaseCapacity(){
        if(arrayData.length == INITIAL_SIZE){
            int newLengthOfArray = INITIAL_SIZE *2;
            arrayData = Arrays.copyOf(arrayData,newLengthOfArray);
        }
    }

    public  void add(E e){
     if(size ==arrayData.length){
         //if size is equal then increase to double size of array
         increaseCapacity();
     }
     arrayData[size ++] = e;

    }

    public E get(int index){
        if(index > 0 || index >arrayData.length){
            throw  new IndexOutOfBoundsException("index->" +index +"size->" +size);
        }
        return (E) arrayData[index] ;
    }

    public Object remove(int index) {
        // if index is negative or greater than size of size, we throw
        // Exception.
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size "
                    + index);
        }
        Object removeData = arrayData[index];

        for(int i=index;i<size-1;i++){
            arrayData[i] = arrayData[i+1];
        }
        size--;

       return removeData;
    }

    public void print(){
        for(int i =0;i<size;i++){
            System.out.println("data are ->" +arrayData[i]);
        }
    }

    public static void main(String[] args) {
        CustomArrayList<String> customArrayList = new CustomArrayList<>();
        customArrayList.add("Adhira");
        customArrayList.add("Gopal");
        customArrayList.print();
        customArrayList.remove(1);
        customArrayList.print();
    }
}
