
import java.util.*;
import java.io.*;

public class MyLinkedList{
    LNode start;
    int size;
    
    public MyLinkedList(){
	size = 0;
	start = new LNode(null);
	
    }
    /*
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
    */
    
    public String toString(){
	String total = "[";
	LNode tracker = new LNode(start);
	total += tracker;
	while(tracker.getNext() != null){
	    total += tracker.getNext();
	    tracker = tracker.getNext();
	}
	return total; 
    }

    private class LNode{
	int data;
	LNode next;
	
	public LNode(int value){
	    data = value;
	}
    }


    public static void main(String[]args){
	MyLinkedList m = new MyLinkedList();
	System.out.println(m);
    }

  /*
  
  int get(int index)- get the value of the element at the specified index (0 based)

  int set(int index,int newValue) - change the value of the element at the specified index to the newValue, return the old value
  
  int size() - return the number of elements in the list
  
  int remove(int index) - remove the element at the specified index, returns the value removed
  
  boolean add(int index, int value) - insert a new elmeent at the specified index, 0 at the front, size() at the end.
  
  
  int indexOf(int value) - returns the index of the 1st occurrence of the value in the linked list, -1 if not found.
  
  toString() - returns a list formatted like: [ v1, v2, v3, ... vn-1, vn ]
*/
}
