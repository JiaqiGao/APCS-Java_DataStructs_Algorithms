
import java.util.*;
import java.io.*;

public class MyLinkedList{
    private LNode start;
    private int size;
    
    public MyLinkedList(){
	size = 0;
	start = new LNode(null);
	
    }
    
    private boolean add(int value){
	LNode current = start;
	LNode temp = new LNode(value);
	
	while (current.getNext() != null){
	    current = current.getNext();
	}
	current.setNext(temp);
	size++;
	return true;
        //current = current.getNext();
    }
    
    
    public String toString(){
	String total = "[ ";
	LNode tracker = start.getNext();
	while(tracker != null){
            //LNode temp = tracker.getNext();
	    total += tracker.getData().toString();
            if(tracker.getNext() != null){
                total += ", ";
            }
	    tracker = tracker.getNext();
	}
        total += " ]";
        //System.out.println(total);
	return total; 
    }

    public int get(int index){
        LNode current = start.getNext();
        for(int i=0; i<index; i++){
            current = current.getNext();
        }
        return (int)current.getData();
    }

    public int set(int index, int indexValue){
        LNode current = start.getNext();
        for(int i=0; i<index; i++){
            current = current.getNext();
        }
        int tracker = (int)current.getData();
        current.setData(indexValue);
        
        return tracker;
    }

    public int size(){
        return size;
    }

    public int remove(int index){
        return -1;
        //not sure if we turn it to null or take it out completely
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
        return true;
    }

    public int indexOf(int value){
        LNode current = start.getNext();
        for(int i=0; i<size(); i++){
            if(current.getData() != null){
                if((int)current.getData()==value){
                    return i;
                }
            }
            current = current.getNext(); 
        }
        return -1;
    }
    
    //----------------------------------------------
    
    private class LNode{
	Object data;
	LNode next;
	
	public LNode(Object dat){
	    data = dat;
            next = null;
	}
        
        public Object getData(){
            return data;
        }

        public LNode getNext(){
            return next;
        }
      
        public void setData(Object dat){
            data = dat;
        }

        public void setNext(LNode nex){
            next = nex;
        }
        
    }

    //----------------------------------------------------

    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
        m.add(5);
        m.add(11);
        m.add(1,18);
        System.out.println(m);
        System.out.println(m.indexOf(18));
	
    }

  /*
  
  int get(int index)- get the value of the element at the specified index (0 based)

  int set(int index,int newValue) - change the value of the element at the specified index to the newValue, return the old value
  
  int size() - return the number of elements in the list
  
  int remove(int index) - remove the element at the specified index, returns the value removed
  
  boolean add(int index, int value) - insert a new elmeent at the specified index, 0 at the front, size() at the end.
  
  
  int indexOf(int value) - returns the index of the 1st occurrence of the value in the linked list, -1 if not found.

*/
}
