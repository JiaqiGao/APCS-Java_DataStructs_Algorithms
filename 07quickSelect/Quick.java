import java.util.*;
import java.io.*;

public class Quick{
    
    private static int partition(int[]data, int left, int right){
        int test = (int)(Math.random()*(right-left+1))+left;
        /*first moves the randomly selected value to right so that we can move values less than selected to the left and do nothing if greater
         */
        swap(test,right,data);
        for (int i=left; i<right; i++){
            if (data[i] < data[right]){
                swap(i, left, data);
                left++;
                //right++;
                //System.out.println(data[i]);
            }
        }
	
        swap(left, right, data);
        return left;
    
    }

    public static void swap(int test, int right, int[] data){
        int temp = data[right];
        data[right] = data[test];
        data[test] = temp;
    }
    
    public static int quickselect(int[]data, int k){
        return quickselect(data,k-1,0,data.length-1);
    }

    private static int quickselect(int[]data, int k, int left, int right){
        if (left <= right) {
            int test = partition(data, left, right);
            if (test == k) {
                return data[k];
            }
            if (test > k) {
                return quickselect(data, k, left, test-1);
            }
            return quickselect(data, k, test+1, right);
        }
        return Integer.MIN_VALUE;
    }


        /*
        if (particition(data, left, right)==k){
            return test;
        }else{
            if(particition(data, test, left, right)>k){
                quickselect(data, k, left, right);
                        }
        }

        */
   

    public static void main(String[]args){
        int[] data = {2,7,5,-1,-2222,2};
        System.out.println(quickselect(data, 1, 4, 6));
    }
    
}
