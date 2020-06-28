
// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class SSolution {
    public int solution(int[] H) {
        temp = new int[H.length];


        if (H.length == 0)
            return 0;

        int sum = Integer.MAX_VALUE;

        for (int i = 0; i < H.length; i++) {
            int temp = CalculateBanner(H, 0, i) + CalculateBanner(H, i + 1, H.length - 1);
            if (temp < sum)
                sum = temp;
        }
        return sum;
    }

    int temp[];

    private int CalculateBanner(int[] H, int start, int end) {
        int high = 0;
        for (int i = start; i <= end; i++) {
            if(H[i] > high){
                high = H[i];
            }
        }
        return high*(end-start + 1);
    }
}

class Equilibriumtest {
    public static void main(String[] args) {
        int[] n = new int[1000];
        for (int i = 0; i < 1000; i++) {
            n[i] = 1000-i;
        }
        SSolution ss = new SSolution();
        double startTime = System.nanoTime();
        int f = ss.solution(n);
        System.out.println(f);
        double lap =  ((double)(System.nanoTime() - startTime))/ 1000000000;
        System.out.println(lap);
    }
}
