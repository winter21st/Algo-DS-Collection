import java.io.*;
import java.util.Arrays;

public class Solution {

    // Complete the activityNotifications function below.
    public static double findMedian(int a[]) {
        int n = a.length;
        if (n % 2 != 0)
            return (double) a[n / 2];

        return (double) (a[(n - 1) / 2] + a[n / 2]) / 2.0;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int activityNotifications(int[] expenditure, int d) {
        if (d >= expenditure.length) return 0;

        int numNotifications = 0;
        int[] trailingArr = new int[d];
        for (int i = 0; i < trailingArr.length; i++) {
            trailingArr[i] = expenditure[i];
        }
        Arrays.sort(trailingArr);
        for (int i = d; i < expenditure.length; i++) {
            double median = findMedian(trailingArr);
            if (expenditure[i] >= 2.0 * median) {
                numNotifications += 1;
            }
            int nextToRemoveElement = expenditure[i - d];
            int toInsertElement = expenditure[i];
            adjustTrailingArray(trailingArr, nextToRemoveElement, toInsertElement);
        }
        return numNotifications;
    }

    //This whole thing is O(d) time. Note that we are not sorting again as trailing array was already sorted
    // as preprocessing and now only one new element has to find its position in sorted array.

    private static void adjustTrailingArray(int[] trailingArr, int elementToRemove, int elementToInsert) {
        if (elementToInsert == elementToRemove) return;
        int foundIndex = 0;

        //The first element of unsorted trailing array will move out of the sliding window
        //Since the trailing array was sorted by us, we have lost the position of its first element in original array.
        //Hence, I search linearly for it and replace it with the new element.

        while (foundIndex < trailingArr.length) {
            if (trailingArr[foundIndex] != elementToRemove) {
                foundIndex++;
            } else {
                trailingArr[foundIndex] = elementToInsert;
                break;
            }
        }

        //Now we bubble the new element just inserted using bubble sort to left/right based on whether it was bigger
        //or smaller than the element that got removed.

        if (elementToInsert > elementToRemove) {
            int i = foundIndex;
            while (i < trailingArr.length - 1) {
                if (trailingArr[i] > trailingArr[i + 1]) {
                    swap(trailingArr, i, i + 1);
                    i += 1;
                } else break;
            }
        } else {
            int i = foundIndex;
            while (i > 0) {
                if (trailingArr[i] < trailingArr[i - 1]) {
                    swap(trailingArr, i, i - 1);
                    i -= 1;
                } else break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int d = 5;

        int[] expenditure = {2, 3, 4, 2, 3, 6, 8, 4, 5};

        Stopwatch w = new Stopwatch();
        System.out.println(activityNotifications(expenditure, d));
        System.out.println(w.elapsedTime());
    }
}
