import java.util.*;
import java.io.*;

public class BSTree<T extends Comparable<T>>{
    Node root;
    
    /*
    public BSTree(){
	root = null;
    }
    */
    public int getHeight(){
	if(root == null){
            return 0;
        }
        return root.height();
    }

    public int getHeight(Node nod){
        return nod.height();
    }

   

    public void add(T value){
        if(root == null){
            root = new Node(value);
        }else{
            root.add(value);   
        }
        /*	
	if(parent.getLeft()==null){
	    parent.setLeft(temp);
	}
        else if(temp.getRight()==null){
	    parent.setRight(temp);
	}
        else if(parent.getLeft().getHeight() < parent.getRight().getHeight()){
	    add(value, parent.getLeft());
	}else{
	    add(value, parent.getRight());
	}
        */
	
    }
    
    public String toString(){
	if(root == null){
	    return "";
	}
	  return root.toString();
    }

    
    /*
    public String toString() ***
    public boolean contains(T value)
      //this can be linear for now.
    */
    /*    
    public T remove(T value){
	if(!root.hasChildren()){
	    
	}
    }
    */
    private class Node{
	T data;
	Node left, right;
        int height;
	
	public Node(T value){
	    data = value;
	}
	public T getData(){
	    return data;
	}
	public void setData(T ndat){
	    data = ndat;
	}	
	public Node getLeft(){
	    return left;
	}
	public void setLeft(Node ndat){
	    left = ndat;
	}
	public Node getRight(){
	    return right;
	}
	public void setRight(Node ndat){
	    right = ndat;
	}
	public boolean hasChildren(){
	    if(left==null && right==null){
		return false;
	    }
	    return true;
	}
        
        public String toString(){
	    String combine = getData() + " ";
	    if(getLeft()!=null){
		combine += getLeft().toString();
	    }else{
		combine += "_ ";
	    }
	    if(getRight()!=null){
		combine += getRight().toString();
	    }else{
		combine += "_ ";
	    }
	    return combine;
	}
        
        public void add(T value){
            if(value.compareTo(getData())<0){
		if(getLeft()==null){
		    setLeft(new Node(value));
		}else{
		    getLeft().add(value);
		}
	    }else{
		if(getRight()==null){
		    setRight(new Node(value));
		}else{
		    getRight().add(value);
		}
	    }
        }
        public int height(){
            if(getLeft()==null && getRight()==null){
                return 1;
            }else if(getRight()==null){
                return 1+getLeft().height();
            }else if(getLeft()==null){
                return 1+getRight().height();
            }else{
                return 1+Math.max(getRight().height(), getLeft().height());
            }
            
        }
	
    }

}
