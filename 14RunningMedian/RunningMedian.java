import java.util.*;

public class RunningMedian<T>{
    public MyHeap data;
    
    public RunningMedian(){
	data = (Double[])new Double[10];
	//Create an empty running median set.
    }

    public double getMedian(){
	if(data[1]==null){
	    throw new NoSuchElementException();
	}else{
	    return data[1];
	}
	/*
	  When empty: throws new NoSuchElementException()
	  Returns the median value
	*/
    }
    
    public void add(Integer x){
    /*
    add to the "SmallValue" heap if  x < median, 
    add to the "BigValue" heap otherwise. 
    balance the two heaps so that their size differ by no more than 1. 
    */
    }
}
