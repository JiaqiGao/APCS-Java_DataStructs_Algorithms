import java.util.*;
import java.io.*;

public class Quick{
    
    private static int partition(int[]data, int left, int right){
        int test = data[(int)(Math.random()*(right-left))+left];
        /*first moves the randomly selected value to right so that we can move values less than selected to the left and do nothing if greater
         */
        swap(test,right,data);
        
	
    
    
    }

    public static void swap(int test, int right, int[] data){
        int temp = data[test];
        data[test] = data[right];
        data[right] = temp;
    }
    
    public static int quickselect(int[]data, int k){
        return quickselect(data,k-1,0,data.length-1);
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
