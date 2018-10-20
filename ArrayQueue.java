package Lesson6;

public class ArrayQueue implements Queue{

    public static final int DEFAULT_SIZE = 10;
    public int head=0, tail=0;
    private int counter=0;
    public Object[] a = new Object[DEFAULT_SIZE];

    @Override
    public void enqueue(Object item) {

        if(tail==counter)
            growArray();
        a[tail] = item;
        tail = (tail+1)%a.length;
        counter++;

    }

    @Override
    public Object dequeue(){

        Object obj = a[head];
        a[head] = null;
        if(head==a.length)
            head=0;
        head = (head+1)%a.length;
        counter--;
        return obj;
    }

    @Override
    public boolean empty() {
        return (counter==0);
    }

    private void growArray() {
        Object[] mod_arr = new Object[a.length * 2];
        for(int x=0; x<a.length; x++)
//            mod_arr[x] = a[(head+x)%a.length];
            mod_arr[x] = a[x];
        a = mod_arr;

//        head = 0;
//        tail = counter;
    }
}
