import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
   private int size;
   private T[] data;   

   public MyHeap(){
       data = (T[])new Comparable[10];
       data[0] = null;
       
   }

   public MyHeap(T[] array){
       data = (T[])new Comparable[10];
       for(int i=1; i<data.length-2; i++){
	   data[i]=array[i-1];
           size++;
       }
       heapify();
    
   }

   private void pushDown(int k){
       
   }

   private void pushUp(int k){
       T temp = data[k/2];
       data[k/2] = data[k];
       data[k] = temp;
       if(2*k < size){
           if(data[k].compareTo(data[2*k])<0 ||
              data[k].compareTo(data[(2*k)+1])<0){
               if(data[(2*k)+1].compareTo(data[2*k])<0){
                   //right larger than left
                   pushUp(2*k);
               }else{
                   pushUp((2*k)+1);
               }
           }
       }
   }

   private void heapify(){
       /* 2*index = left child
	  2*index+1 = right child
	  index/2 = parent index
	*/
       int index, indexNext, indexAbove;
       
       for(int i=size/2; i>0; i--){
           index=i+1;
           indexNext=i+2;
           indexAbove=i;
           System.out.println(index + "," + indexNext + "," + indexAbove);
           if(data[index].compareTo(data[indexNext]) > 0){
               if(data[index].compareTo(data[indexAbove]) > 0){
                   pushUp(index);
               }
           }else{
               if(data[indexNext].compareTo(data[indexAbove]) > 0){
                   pushUp(indexNext);
               }
           }
           
       }
       for(int i=size; i>size/2; i--){
           System.out.println(Arrays.toString(data));
           index=i-1;
           indexNext=i;
           indexAbove=i/2;
           System.out.println(index + "," + indexNext + "," + indexAbove);
           if(data[index].compareTo(data[indexNext]) > 0){
               if(data[index].compareTo(data[indexAbove]) > 0){
                   pushUp(index);
               }
           }else{
               if(data[indexNext].compareTo(data[indexAbove]) > 0){
                   pushUp(indexNext);
               }
           }
           
       }
   }

   public T delete(){
       return data[0];
   }

   public void add(T x){
       /*
       if(size == data.length){
	   doubleSize();
       }
       data[size+1] = x;
       int next = (size+1)/2; 
       while(x < next){
	   pushUp(next);
	   pushDown(x);
       }
       */
       
   }

   private void doubleSize(){
       /*
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
       */
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
