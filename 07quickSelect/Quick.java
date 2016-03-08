
private static int partition(int[]data, int left, int right){
//end if left == right or it equals k 
}
//choose a random partition element  at a location from left to right inclusive.
//partition the array such that the randomly chosen element divides all values smaller and larger than it.
//smaller elements on the left side of the partition, larger on the right side
//return the index of the partition element.
//    this allows your quickselect method to decide where to go next.

//Quick Select will now give the kth smallest value, so the k corresponds to the index of the array! Save you one subtraction!


public static int quickselect(int[]data, int k);
//return the kth smallest value.
// when k = 0 return the smallest.
// 0 <= k < data.length





//If you make quickselect recursive, you need a helper method:
private static int quickselect(int[]data, int k, int left, int right);
//return the kth smallest value in the given left/right range
// left <= k <= right
//start by calling the helper as follows:
//    quickselect(data,k,0,data.length-1)
