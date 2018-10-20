package Lesson6;

import java.util.EmptyStackException;

public class ArrayStack implements Stack {

    public static final int DEFAULT_SIZE = 10;
    private Object[] arr;
    private int top_index;
    private int bottom;
    private int size_count;

    public ArrayStack(){
        top_index = 0;
        size_count = 0;
        arr = new Object[DEFAULT_SIZE];
        bottom = arr.length;
    }

    @Override
    public void push(Object item) {
        // Find the length of the array or object of set of data
        if(top_index+1 >= arr.length) {
//            System.out.println("Hi");
            doubleArrSize();
        }
        arr[top_index] = item;
        top_index++;
    }

    @Override
    public Object pop() throws EmptyStackException {
        if(empty())
            throw new EmptyStackException();
        top_index--;
        Object obj = arr[top_index];
        arr[top_index] = null;
        return obj;
    }

    @Override
    public Object peek() throws EmptyStackException{

        if(!empty())
            return arr[top_index--];
        else
            throw new EmptyStackException();
    }

    @Override
    public boolean empty() {

        return (top_index == 0);
    }

    private void doubleArrSize(){
        Object[] mod_arr = new Object[arr.length * 2];
        for(int x=0; x<arr.length; x++)
            mod_arr[x] = arr[x];
        arr = mod_arr;


//        top_index = 0;
//        bottom = size_count;
//        size_count=arr.length;

    }
}
