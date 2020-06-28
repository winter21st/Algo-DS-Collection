// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int[] T) {
        int height = 0, maxHeight = 0;
        for (int i : T) {
            height = HeightFinder(i, T);
            if (height > maxHeight && height != -1)
                maxHeight = height;
        }
        return maxHeight;
    }

    public int HeightFinder(int p, int[] arr) {
        int height = 0;
        boolean isOdd = false;
        while (p != arr[p]) {
            if(p % 3 == 0){
                if(isOdd){
                    return -1;
                }
                else{
                    isOdd = true;
                }
            }
            height++;
            p = arr[p];
        }
        if (p == 0 && height > 0)
            height++;

        return height;

    }
}
