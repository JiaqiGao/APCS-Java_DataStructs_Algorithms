import java.util.*;

public class MyStack<T> implements Iterable<T>{
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

    LNode start;
    LNode end;
    int size;

    public Iterator<T> iterator(){
	//This uses an anonymous class! You don't need to know this.
	return new Iterator<T>()
	    {
		private LNode current = start;

		public boolean hasNext(){
		    return current != null;
		}
		public T next(){
		    if(!hasNext()){
			throw new NoSuchElementException();
		    }
		    T value = current.getData();
		    current = current.getNext();
		    return value;
		}
		public void remove(){
		    throw new UnsupportedOperationException();
		}
	    };
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
	    String copy="[ ";
	    if(size!=0){
		copy+=start.getData();
	    }

	    LNode current = start;
	    for(int i=0; i<size-1; i++){
		current = current.getNext();
		copy += ", "+current.getData();
	    }
	    copy += " ]";
	    total+= "Start: "+
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
    
    
    public void add(int index, T value){
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

	//return true;
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
 /**
     * Adds the given item to the top of the stack.
     */
    public void push(T item){
        add(0, item);
    }

    /**
     * Removes the top item from the stack and returns it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T pop(){
        if(size==0){
            throw new NoSuchElementException();
        }
        return remove(0);
    }

    /**
     * Returns the top item from the stack without popping it.
     * @exception java.util.NoSuchElementException if the queue is empty.
     */
    public T peek(){
        if(size==0){
            throw new NoSuchElementException();
        }
        return get(0);
    }

    /**
     * Returns the number of items currently in the stack.
     */
    public int size(){
        return size;
    }

    /**
     * Returns whether the stack is empty or not.
     */
    public boolean isEmpty(){
        return size==0;
    }

}
