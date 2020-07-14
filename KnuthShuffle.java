public class KnuthShuffle {
    
    public static void shuffle(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int r = StdRandom.uniform(i + 1);
            int temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }
    
    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        KnuthShuffle.shuffle(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }

}