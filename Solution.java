import java.io.*;

public class Solution {

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
     int min = getMin(arr);   
     return sort(arr, min);
    }

    static int sort(int[] arr,int min){
        int i =0, count = 0;
        while(i< arr.length){
            if(arr[i] - min != i){
                swap(arr, i, arr[i] - min);
                count++;
            }
            else{
                i++;
            }
        }
        return count;
    }

    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] < min) min = arr[i];
        }
        return min;
    }

    public static void main(String[] args) throws IOException {
        int[] a = {7,1,3,2,4,5,6};
        System.out.println(minimumSwaps(a));
    }
}
