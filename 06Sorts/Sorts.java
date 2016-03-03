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
    /*
    public static void main(String[]args){
	int[] tried = {2,3,4,2,1,7,5,-1,2222};
        int[] tried2 = {2,3,4,2,1,7,5,-1,2222};
        int[] tried3 = {2,3,4,2,1,7,5,-1,2222};
        selectionSort(tried);
	bubbleSort(tried3);
        insertionSort(tried2);	
    }
    */
}
