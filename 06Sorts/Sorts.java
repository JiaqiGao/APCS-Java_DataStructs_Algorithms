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
    
    static int[] mergeSort(int[]ary){
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
	return merge(mergeSort(left), mergeSort(right));
     }
    
    static int[] merge(int[]left, int[]right){
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
	
	

    
    public static void main(String[]args){
	int[] tried = {2,7,5,-1,-2222};
        int[] tried2 = {2,-12, 99};
	System.out.println(Arrays.toString(mergeSort(tried)));
	/*
        int[] tried3 = {2,3,4,2,1,7,5,-1,2222};
        selectionSort(tried);
	bubbleSort(tried3);
        insertionSort(tried2);	
    }
    */
    }
}
