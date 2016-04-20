import java.util.*;
import java.io.*;

public class BSTree<T extends Comparable<T>>{
    Node root;
    
    public void add(Node value){
	
    }
    /*
    public String toString() ***
    public boolean contains(T value)
    public int getHeight()  //this can be linear for now.
    */

    private class Node{
	T data;
	Node left, right;

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
    }

}
