import java.util.Arrays;

public class Week2InterviewQn4 {

    int[] a,b;

    public Week2InterviewQn4(int[] a, int[] b){
        this.a = a;
        this.b = b;
    }

    public boolean isPermutation() {
        ShellSort.sort(a);
        ShellSort.sort(b);

        return Arrays.compare(a, b) == 0;
    }

    public static void main(String[] args) {
        int[] a = { 4, 5, 3, 8, 2, 1, 0, 9};
        int[] b = { 4, 5, 3, 8, 2, 1, 0, 9};
        Week2InterviewQn4 w = new Week2InterviewQn4(a, b);
        System.out.println(w.isPermutation());
    }
}