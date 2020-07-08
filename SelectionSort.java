public class SelectionSort {

    public static void sort(int[] arr) {
        int size = arr.length;
        for (int i = 0; i < size - 1; ++i) {
            int min = i;
            for (int j = i + 1; j < size; ++j) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = { 4, 1, 5, 2, 6, 3 };
        SelectionSort.sort(a);
        for (int i : a) {
            
        System.out.print(i);
        };
    }
}