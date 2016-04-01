import java.util.*;

public class MyDeque<T>{
    ArrayList ary = new ArrayList();
    T start;
    T end;
    int size;

    public MyDeque(){
    }
    /*
    public String toString(){
        return Arrays.toString(ary);
    }
    */
    public void grow(){
	ArrayList temp = new ArrayList(size*2);
	for(int i=0; i<size; i++){
	    temp.add(ary.get(i));
	}
	ary = temp;
    }
    
    public void addFirst(T value){
	
    }

    public void addLast(T value){
    
    }

    public T removeFirst(){
	return start;
    }

    public T removeLast(){
	return start;
    }
    
/*For your MyDeque<T>
0. You need a private method to grow the array and copy over the values.
There are 6 public methods:
1. 
2. 
-When the array is full, re-size, then add. 
-No exceptions are required since you will re-size.
3.  
4. 
-NoSuchElementException is thrown when there are no elements. 
5. T getFirst()
6. T getLast()
-NoSuchElementException is thrown when there are no elements. 
*/
}
