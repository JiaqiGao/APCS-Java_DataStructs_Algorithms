import java.util.*;

public class MyDeque<T>{
    T[] data;
    int start;
    int end;
    int size;


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

    public String toString(){
        String total = "[ ";
        for(int i=0; i<data.length; i++){
            if(i == data.length-1){
                total += data[data.length-1] + " ]";
            }else{
                total += data[i]+", ";
            }
        }
      
        return total;
    }

    @SuppressWarnings("unchecked")
        public void grow(){
	T[] temp = (T[]) new Object[size*2];
        int count = start;
	for(int i=0; i<size; i++){
            if(count==size)
                count=0;
	    temp[i] = data[count];
            count++;
	}
	data = temp;
        
        start = 0;
        end = size-1;
    }
    
    public void addFirst(T value){
	if(size == data.length)
            grow();
        size++;
        if(start == 0 && data[start] != null){
            start = data.length-1;
        }else{
            start--;
        }
        data[start] = value;
    }

    public void addLast(T value){
        if(size == data.length)
            grow();
        size++;
        if(end == data.length-1 || data[end] == null){
            end = 0;
        }else{
            end++;
        }
        data[end] = value;
    }

    public T removeFirst(){
	if(data[start] == null)
            throw new NoSuchElementException();
        T ret = data[start];
        data[start] = null;
        size--;
        if(start == data.length-1){
            start = 0;
        }else{
            start++;
        }
        
        return ret;
    }
   
    public T removeLast(){
	if(data[end] == null)
            throw new NoSuchElementException();
        T ret = data[end];
        data[end] = null;
        size--;
        if(end == data.length-1){
            end = 0;
        }else{
            end--;
        }
        
        return ret;
        
    }

    public T getFirst(){
    }

    public T getLast(){
    }
    
    public static void main(String[]args){
	MyDeque<String> x = new MyDeque<String>();
	x.add("fish");
	System.out.println(x.get());
    }

}
