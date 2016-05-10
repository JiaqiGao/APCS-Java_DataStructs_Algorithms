import java.util.*;

@SuppressWarnings("unchecked")
public class MyHeap<T extends Comparable<T>>{
   private int size;
   private T[] data;
   boolean max = true;

   public MyHeap(){
       data = (T[])new Comparable[10];
       
   }

   public MyHeap(T[] array){
       data = (T[])new Comparable[array.length];
       for(int i=1; i<data.length-2; i++){
	   data[i]=array[i-1];
           size++;
       }
       heapify();
    
   }

   public MyHeap(boolean isMax){
       data = (T[])new Comparable[10];
       max = isMax;
   }

   public MyHeap(T[] array, boolean isMax){
       if(!isMax){
           max = false;
       }
       data = (T[])new Comparable[array.length];
       for(int i=1; i<data.length-2; i++){
	   data[i]=array[i-1];
           size++;
       }
       heapify();
   }
   //public MyHeap(T[] array, boolean isMax)
   
   private void pushDown(int k){
       pushUp(k/2);
   }

   private void pushUp(int k){
       T temp = data[k/2];
       data[k/2] = data[k];
       data[k] = temp;
       if(2*k < size){
           if(max==true){
               if(data[k].compareTo(data[2*k])<0 ||
                  data[k].compareTo(data[(2*k)+1])<0){
                   if(data[(2*k)+1].compareTo(data[2*k])<0){
                       //right larger than left
                       pushUp(2*k);
                   }else{
                       pushUp((2*k)+1);
                   }
               }
           }else{
               if(data[k].compareTo(data[2*k])>0 ||
                  data[k].compareTo(data[(2*k)+1])>0){
                   if(data[(2*k)+1].compareTo(data[2*k])>0){
                       //right larger than left
                       pushUp(2*k);
                   }else{
                       pushUp((2*k)+1);
                   }
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
           //System.out.println(index + "," + indexNext + "," + indexAbove);
           if(max==true){
               if(data[index].compareTo(data[indexNext]) > 0){
                   if(data[index].compareTo(data[indexAbove]) > 0){
                       pushUp(index);
                   }
               }else{
                   if(data[indexNext].compareTo(data[indexAbove]) > 0){
                       pushUp(indexNext);
                   }
               }
           }else{
               if(data[index].compareTo(data[indexNext]) < 0){
                   if(data[index].compareTo(data[indexAbove]) < 0){
                       pushUp(index);
                   }
               }else{
                   if(data[indexNext].compareTo(data[indexAbove]) < 0){
                       pushUp(indexNext);
                   }
               }
           }
           
       }
       for(int i=size; i>size/2; i--){
           //System.out.println(Arrays.toString(data));
           index=i-1;
           indexNext=i;
           indexAbove=i/2;
           //System.out.println(index + "," + indexNext + "," + indexAbove);
           if(max==true){
               if(data[index].compareTo(data[indexNext]) > 0){
                   if(data[index].compareTo(data[indexAbove]) > 0){
                       pushUp(index);
                   }
               }else{
                   if(data[indexNext].compareTo(data[indexAbove]) > 0){
                       pushUp(indexNext);
                   }
               }
           }else{
               if(data[index].compareTo(data[indexNext]) < 0){
                   if(data[index].compareTo(data[indexAbove]) < 0){
                       pushUp(index);
                   }
               }else{
                   if(data[indexNext].compareTo(data[indexAbove]) < 0){
                       pushUp(indexNext);
                   }
               }
           }
           
       }
   }

   public T delete(){
       T save = data[1];
       data[1] = data[size];
       data[size] = null;
       size--;
       heapify();
       return save;
       
   }

   public void add(T x){
       if(data.length<=size){
           doubleSize();
       }
       data[size+1] = x;
       size++;
       heapify();
       
   }

   private void doubleSize(){
       T[] copy = (T[]) new Object[data.length*2];
       for(int i=0; i>size; i++){
           copy[i] = data[i];
       }
       data = copy;
       
   }

   public String toString(){
       String start = "[";
       for(int i=1; i<data.length; i++){
	   if(data[i]!=null && i!=size){
	       start += String.valueOf(data[i]);
	       start += ",";
	   }else{
	       if(data[i]!=null){
		   start += String.valueOf(data[i]);
	       }
	   }
       }
       start += "]";
       return start;
   }

}

