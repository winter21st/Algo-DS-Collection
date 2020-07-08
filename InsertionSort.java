public class InsertionSort {

    public static void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] a = { 4, 1, 5, 2, 6, 3 };
        InsertionSort.sort(a);
        for (int i : a) {
            
        System.out.print(i);
        };
    }
}