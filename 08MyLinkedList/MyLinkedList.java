import java.util.*;
import java.io.*;

public class MyLinkedList<T>{
    LNode<T> start;
    LNode<T> end;
    int size;
    
    public MyLinkedList(){
	
    }
  
   
    public boolean add(int value){
	if(start == null){
            end = start;
	    start = new LNode<T>(value);
	}else{
	    end.setNext(new LNode<T>(value));
	    end = end.getNext();
	}
        
	size++;
	return true;
    }
    
    
    public String toString(){
	String total = "[ ";
	LNode<T> tracker = start.getNext();
	while(tracker != null){
	    total += tracker.getData();
            if(tracker.getNext() != null){
                total += ", ";
            }
	    tracker = tracker.getNext();
	}
        total += " ]";
	return total; 
    }

    public T get(int index){
        LNode<T> current = start;
        for(int i=0; i<index; i++){
            current = current.getNext();
        }
        return current.getData();
    }

    public T set(int index, int indexValue){
        LNode<T> current = start.getNext();
	//int tracker=0;
        for(int i=0; i<index; i++){
	    current = current.getNext();
        }
        T save = current.getValue;
        current.setValue(indexValue);
        
        return save;
    }

    public int size(){
        return size;
    }

    public T remove(int index){
        LNode<T> current = start;
	for (int i=0; i<index-1; i++){
	    current = current.getNext();
	}
	LNode<T> temp = current.getNext();
	T save = temp.getValue();
        
	temp = temp.getNext(); 
	current.setNext(temp);
	size--;
        
        
	return save;
       
    }
    

    public boolean add(int index, int value){
        int temp = set(index, value);
        LNode current = start.getNext();
        for(int i=0; i<index; i++){
            current = current.getNext(); 
        }
        for(int i=index+1; i<size(); i++){
            temp = set(i, temp);
        }
        size++;
        return true;
    }

    public int indexOf(int value){
        LNode<T> current = start;
	int counter = 0;
	while (current.getValue() != value && current.getNext() != null){
	    current = current.getNext();
	    counter++;
	}
	if (current.getNext() == null){
	    return -1;
	}
	return counter;
	
    }
    
 
    //----------------------------------------------
    
    private class LNode<T>{
	private T data;
	private LNode next;
	
	public LNode(T data){
            this.data = data;
	}
        
        public T getData(){
            return data;
        }

        public LNode<T> getNext(){
            return next;
        }
      
        public void setData(T data){
            this.data = data;
        }

        public void setNext(LNode nex){
            next = nex;
        }
        
    }

    //----------------------------------------------------

    public static void main(String[]args){
	MyLinkedList<Integer> m = new MyLinkedList<Integer>();
	
        m.add(5);
        m.add(11);
	System.out.println(m);
        m.add(1,18);
        System.out.println(m);
        System.out.println(m.indexOf(18));
       
	
    }

}

