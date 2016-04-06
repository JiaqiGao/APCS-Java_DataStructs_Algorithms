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
	T[] copy = (T[]) new Object[data.length*2];

        int place=0;
        int index=copy.length-1;
        for(int i=data.length-1; i>0; i--){
         
            copy[index]=data[i];
            index--;
           
        }

        start=0;
        end=place-1;

        data = copy;
    }
    
    public void addFirst(T value){
	if(size == data.length)
            grow();
        size++;
        if(start == 0){
            if(data[start] == null){
                start = 0;
            }else{
                start = data.length-1;
            }
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
	if(data[start] == null){
            System.out.println(data);
            throw new NoSuchElementException();
        }
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
	if(data[end] == null){
            System.out.println(data);
            throw new NoSuchElementException();
        }
        T ret = data[end];
        data[end] = null;
        size--;
        if(end != 0)
            end--;
        
        return ret;
        
    }

    public T getFirst(){
        if(data[start] == null)
            throw new NoSuchElementException();
        return data[start];
    }

    public T getLast(){
        if(data[end] == null)
            throw new NoSuchElementException();
        return data[end];
    }
    
    public static void main(String[]args){
	MyDeque<String> x = new MyDeque<String>();
	x.add("fish1");
        x.addLast("fish2");
        x.removeLast();
	System.out.println(x);
    }

}
