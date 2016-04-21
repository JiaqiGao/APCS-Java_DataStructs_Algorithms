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
	return 0;
	
    }

    public void add(T value){
	Node temp = new Node(value);
	add(temp, root);
    }

    public void add(Node value, Node parent){	
	if(parent.getLeft()==null){
	    parent.setLeft(temp);
	}else{
	    if(temp.getRight()==null){
		parent.setRight(temp);
	    }else{
		if(parent.getLeft().getHeight() < parent.getRight().getHeight()){
		    add(value, parent.getLeft());
		}
	        add(value, parent.getRight());
	    }
	}
    }
    /*
    public String toString() ***
    public boolean contains(T value)
      //this can be linear for now.
    */
    
    public T remove(T value){
	if(!root.hasChildren()){
	    
	}
    }
    
    private class Node{
	T data;
	Node left, right;
	
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
	
    }

}
