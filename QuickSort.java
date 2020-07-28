import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class QuickSort {
    static int partition(int arr[], int low, int high) {
    
    int i = low;
    int j = high + 1;

    while(true){
      while(arr[low] > arr[++i]){
        if(i == high) break;
      }
      while(arr[low] < arr[--j]){
        if(j == low) break;
      }
      if(i >= j) break;
      swap(arr, i, j);
    }

    swap(arr, low, j);
    return j;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  static void sort(int arr[]){
    KnuthShuffle.shuffle(arr);
    sort(arr, 0, arr.length - 1);
  }

  static void sort(int arr[], int low, int high) {
    if (low >= high) return;

      int k = partition(arr, low, high);
      sort(arr, low, k - 1);
      sort(arr, k + 1, high);
  }

    public static void main(String[] args) {
        int[] a;
        String line = "";
        try (BufferedReader br = new BufferedReader(new FileReader("./" + args[0]))) {
            line = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] ss = line.split(",");
        a = new int[ss.length];
        for (int i = 0; i < ss.length; i++) {
            a[i] = Integer.parseInt(ss[i]);
        }
        Stopwatch w = new Stopwatch();
        QuickSort.sort(a);
        System.out.println(w.elapsedTime());
    }
}