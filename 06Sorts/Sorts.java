import java.util.Arrays;

public class Sorts{
    static void selectionSort(int[] ary){
	int min = ary[0];
	int minSwitch = 0;
	for (int index=0; index<ary.length-1; index++){
            min = ary[index];
	    for (int i=index; i<ary.length; i++){
		if (ary[i]<min){
		    min=ary[i];
		    minSwitch = i;
		}
	    }
	    ary[minSwitch]=ary[index];
	    ary[index]=min;
            System.out.println(Arrays.toString(ary));
	}
    }
    //-------------------------------------------------------
    
    static void insertionSort(int[]ary) {
	for(int i=1; i<ary.length; i++){
            int temp = ary[i];
            int k;
            for(k=i-1; k>=0 && temp<ary[k]; k--){
                ary[k+1] = ary[k];
            }
            ary[k+1] = temp;
            System.out.println(Arrays.toString(ary));
        }
   
    }

    //----------------------------------------------------------

    static void bubbleSort(int[]ary){
        int numleft = ary.length;
        int temp = 0;
        for(int i=0; i<numleft; i++){
            for(int j=1; j<(numleft-i); j++){             
                if(ary[j-1] > ary[j]){
                    temp = ary[j-1];
                    ary[j-1] = ary[j];
                    ary[j] = temp;
                }                
            }
            System.out.println(Arrays.toString(ary));
        }
    }
    
    //------------------------------------------------------------
    
    public static String name(){
    	return "6,Gao,JiaQi";     //  or    "6,Last,First"
    }

    //----------------------------------------------------------
    
    static void mergesort(int[]ary){
        System.out.println(Arrays.toString(merge(ary)));
    }
    
    static int[] merge(int[]ary){
	if(ary.length <= 1){
	    return ary;
	}
	int[] left = new int[ary.length/2];
	for(int i=0; i<ary.length/2; i++){
	    left[i] = ary[i];
	}
	int[] right = new int [ary.length-ary.length/2];
	int count = 0;
	for(int i=ary.length/2; i<ary.length; i++){
	    right[count] = ary[i];
	    count++;
	}
	return mergeh(merge(left), merge(right));
     }
    
    static int[] mergeh(int[]left, int[]right){
	int[] acc = new int[left.length+right.length];
	int leftcount = 0;
	int rightcount = 0;
	int aco = 0;
	
	while(leftcount < left.length && rightcount < right.length){
  
	    if(left[leftcount]<=right[rightcount]){
		acc[aco] = left[leftcount];
		leftcount++;
	    }else{
		acc[aco] = right[rightcount];
		rightcount++;
	    }
	    aco++; 
	    
	}
	if(leftcount >= left.length){
	    for(int i=rightcount; i<right.length; i++){
		acc[aco]=right[i];
		aco++;
	    }
	}else{
	    for(int i=leftcount; i<left.length; i++){
		acc[aco]=left[i];
		aco++;
	    }
	}
	return acc; 
	
    }
    
    //--------------------------------------------------------
    private static int partitionOld(int[]data, int left, int right){
        int test = (int)(Math.random()*(right-left+1))+left;
        swapOld(test,right,data);
        for (int i=left; i<right; i++){
            if (data[i] < data[right]){
                swapOld(i, left, data);
                left++;
            }
        }
	
        swapOld(left, right, data);
        return left;
    
    }

    public static void swapOld(int test, int right, int[] data){
        int temp = data[right];
        data[right] = data[test];
        data[test] = temp;
    }

    static void quickSortOld(int[] data){
        quickSortOld(data, 0, data.length-1);
        //System.out.println(Arrays.toString(data));
    }

    static void quickSortOld(int[] data, int left, int right){
        if(right-left > 0){
            int index = partitionOld(data, left, right);
            quickSortOld(data, left, index-1);
            quickSortOld(data, index+1, right);
            
        }
       
    }
    //--------------------------------------------------------

    private static int[] partition(int[]data, int left, int right){
        int test = (int)(Math.random()*(right-left+1))+left;
	swap(data,test,right);

	int f = left;
	int t = right-1;
	while(f < t){
	    if(data[f] < data[right]){
		f++;
	    }else{
		swap(data,f,t);
		t--;
	    }
	}

	int[] index = new int[2];
	if(data[f] < data[right]){
	    f++;
	}
	swap(data,f,right);
	    
	
	index[0] = f;
        index[1] = f;
	
	int stored=data[f];
	for(int i=f; i<right; i++){
	    if(data[i] == stored){
		swap(data,i,f);
		index[1] = f;
		f++;
	    }
	}
	return index;
       
        
    }
    
    public static void swap(int[]data, int a, int b){
	int store = data[a];
	data[a]=data[b];
	data[b]=store;
    }
    
    static void quickSort(int[] data){
        quickSort(data, 0, data.length-1);
        //d(data);
    }

    static void quickSort(int[] data, int left, int right){
        if(right-left+1>1 && left>=0 && right<data.length){
            int[] index = partition(data, left, right);
            quickSort(data, left, index[0]-1);
            quickSort(data, index[1]+1, right);
            
        }
       
    }
    
    

    
    public static void main(String[]args){
        int[]a = new int [4000000];
        int[]b = new int [a.length];
        
        
        for(int i = 0; i < a.length; i++){
	    a[i] = (int)(Math.random()*3);
            b[i] =(int)(Math.random()*Integer.MAX_VALUE)+(int)(Math.random()*Integer.MIN_VALUE);
        
	}
        Arrays.sort(a);
        /*
        quickSortOld(a);
        quickSort(a);
        Arrays.sort(b);
        quickSortOld(b);
        quickSort(b);
        */
        /*
        int[] d = new int [400000];
	int[] c = new int [d.length];
	for(int i = 0; i < d.length; i++){
	    d[i]= (int)(Math.random()*Integer.MAX_VALUE);
	    c[i]= d[i];
	}
	quickSortOld(d); //or even your old quicksort!!!
	Arrays.sort(c);
	System.out.println("Done: Sorted="+Arrays.equals(d,c));
        */
    }
}
