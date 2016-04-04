import java.util.*;

public class MyDeque<T>{
    T[] data;
    T start;
    T end;
    int size;

    public MyDeque(){
    }

    //suppress this ONE function from
    //having warnings.
    @SuppressWarnings("unchecked")	    
    public MyDeque(){
	//typecast object array to generic array
	data = (T[]) new Object[10];
    }
    
    public void add(T n){
	data[0]=n;
    }

    public T get(){
	
	return data[0];
    }
    
    
    public void grow(){
	T[] temp = (T[]) new Object(size*2);
        int count = start;
	for(int i=0; i<size; i++){
            if(count==size)
                count=0;
	    temp[i] = data[count];
            count++;
	}
	ary = temp;
        start = 0;
        end = size-1;
    }
    
    public void addFirst(T value){
	if(size == data.length)
            grow();
        if(start == 0 && data[start] != null){
            start = data.length-1;
        }else{
            start--;
        }
        data[start] = value;
        
        size++;
    }

    public void addLast(T value){
        if(size == data.length){
            grow();
        }
        if(end == data.length-1 || data[end] == null){
            end = 0;
        }else{
            end++;
        }
        data[end] = value;
        size++;
    }

    public T removeFirst(){
	return start;
    }

    public T removeLast(){
	return start;
    }

     public static void main(String[]args){
	Tester<String> x = new Tester<String>();
	x.add("fish");
	System.out.println(x.get());
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
