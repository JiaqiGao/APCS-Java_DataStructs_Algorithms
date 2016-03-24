import java.util.*;

public class MyLinkedList<T> implements Iterable<T>{
    LNode start;
    LNode end;
    int size;
    
    public MyLinkedList(){
	
    }
  
    public boolean add(T value){
	if(start == null){
           
	    start = new LNode(value);
	    end = start;
	}else{
	    end.setNext(new LNode(value));
	    end = end.getNext();
	}
        
	size++;
	return true;
    }
    
    public String toString(boolean choice){
	String total = "";
        if(choice){
	    String copy="[";
	    if(size!=0){
		copy+=start.getData();
	    }

	    LNode current = start;
	    for(int i=0; i<size-1; i++){
		current = current.getNext();
		copy += ", "+current.getData();
	    }
	    copy += "]";
	    total+= "Head: "+
                (String)start.getData() + " End: "+
                (String)end.getData();

	    total = copy+total;
        }
        return total;
    }
    
    public String toString(){
	String total = "[ ";
        if(size != 0){
	    total += start.getData();
	}
	LNode tracker = start;
	for(int i=0; i<size-1; i++){
	    tracker = tracker.getNext();
	    total += ", "+ tracker.getData();
	}
        total += " ]";
	return total; 
    }

    public T get(int index){
	if(index < 0 || index > size-1){
	    throw new IndexOutOfBoundsException();
	}
	       
	LNode current = start;
	for(int i=0; i<index; i++){
	    current = current.getNext();
	}
	return current.getData();
	        
    }

    public T set(int index, T indexValue){
        if(index < 0 || index > size-1){
	    throw new IndexOutOfBoundsException();
	}
        LNode current = start;
	//int tracker=0;
        for(int i=0; i<index; i++){
	    current = current.getNext();
        }
        T save = current.getData();
        current.setData(indexValue);
        
        return save;
    }

    public int size(){
        return size;
    }

    public T remove(int index){
        if(index < 0 || index > size-1){
	    throw new IndexOutOfBoundsException();
	}
        T s = start.getData();
        if(index == 0){
            start = start.getNext();
            if(index == size-1){
                end = start;
            }
        }else{
            LNode current = start;
            for (int i=0; i<index-1; i++){
                current = current.getNext();
            }
            LNode temp = current.getNext();
            s = temp.getData();
        
            temp = temp.getNext(); 
            current.setNext(temp);
            if(index == size-1){
		end = current;
	    }
        }
	size--;
        
        
	return s;
       
    }
    

    public boolean add(int index, T value){
        if(index<0 || index>size){
	    throw new IndexOutOfBoundsException();
	}

	if(index==size){
	    add(value);
	}else{ 
	    if(index==0){
		LNode ad = new LNode(value);
		ad.setNext(start);
		start = ad;
		if(start == null){
		    end = ad;
		}
	    }else{
		LNode current = start;
		for(int i=0; i<index-1; i++){
		    current = current.getNext();
		}
		LNode ad = new LNode(value);
		LNode move = current.getNext();
		ad.setNext(move);
		current.setNext(ad);
                
		if(index == size){
		    end = current.getNext();
		}
	    }
	    size++;
	}

	return true;
    }

    public int indexOf(T value){
        LNode current = start;
	int counter = 0;
	while (current.getData() != value && current.getNext() != null){
	    current = current.getNext();
	    counter++;
	}
	if (current.getNext() == null){
	    return -1;
	}
	return counter;
	
    }

    public Iterator<T> iterator(){
    	return new MyLinkedListIterator();       
    }
     
    public class MyLinkedListIterator implements Iterator<T>{
        LNode current;
        
        public MyLinkedListIterator(){
            current = start;
        }
        
    	public boolean hasNext(){
            return current != null;
        }

        public T next(){
	    if(!hasNext()){
		throw new NoSuchElementException();
	    }
            T temp = current.getData();
            current = current.getNext();
            return temp;
        }

        public void remove(){
            throw new UnsupportedOperationException();
        }
    }
    
   
    
    
 
    //----------------------------------------------
    
    private class LNode{
	T data;
	LNode next;
	
	public LNode(T data){
            this.data = data;
	}
        
        public T getData(){
            return data;
        }

        public LNode getNext(){
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
	for(int i=0; i<10; i++){
	    m.add(i);
	}
	Iterator<Integer> it = m.iterator();
	//it.next();
	//enhanced for loop
	for(Integer i : m){
	    System.out.print(i + " ");
	}
	System.out.println();
	
    }

}
