import java.util.*;

public class Test{

    public static void main(String[] args){
        Integer[] data = {1,3,4,9,2,77,9};
        MyHeap<Integer> h = new MyHeap<Integer>(data);
        System.out.println(h);
    }
}
