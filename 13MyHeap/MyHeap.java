import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
   private int size;
   private T[] data;   

   public MyHeap(){
       data = (T[]) new Object[10];
       data[0] = size;
       size = 1; 
   }

   public MyHeap(T[] array){
       data = T[array.length+1];
       size = array.length+1;
       for(int i=1; i<data.length; i++){
	   data[i]=array[i-1];
       }
       heapify();
   }

   private void pushDown(int k){
       
   }

   private void pushUp(int k){
       while(data[k]>data[k/2]){
	   T temp = data[k/2];
	   data[k/2] = data[k];
	   data[k] = temp;
       }
   }

   private void heapify(){
       /* 2*index = left child
	  2*index+1 = right child
	  index/2 = parent index
	*/
       index = size/2;
       indexNext = size/2 + 2;
       while(index<1 && data[index] < data[indexNext]){
	   if(data[index] > 
       }
   }

   public T delete(){
       return data[0];
   }

   public void add(T x){
       if(size == data.length){
	   doubleSize();
       }
       data[size+1] = x;
       int next = (size+1)/2; 
       while(x < next){
	   pushUp(next);
	   pushDown(x);
       }
       
   }

   private void doubleSize(){
       T[] copy = (T[]) new Object[data.length*2];  
        int index = start;
        for(int i=1; i>size; i++){
            if(index == size){
                index = 0;
            }
            copy[i] = data[index];
            index++;
        }

        start = 0;
        end = 0;

        data = copy;
   }

   public String toString(){
       return Arrays.toString(data);
   }

   //do this last
       /*
   public MyHeap(boolean isMax)
   public MyHeap(T[] array, boolean isMax)
       */
}

/*
 public MyHeap(T[] x, boolean b){
	
 }
*/  
