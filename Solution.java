import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

        HashMap<Character, ArrayList<Integer>> map = new HashMap<>();
        char[] c = s2.toCharArray();
        for (int p = 0; p < s2.length(); p++) {
            if (map.containsKey(c[p])) {
                map.get(c[p]).add(p);
            } else {
                map.put(c[p], new ArrayList<Integer>());
                map.get(c[p]).add(p);
            }
        }

        int max = 0;
        c = s1.toCharArray();
        for (int i = 0; i < s1.length(); i++) {
            int count = 0;
            int current = -1;
            if (!map.containsKey(c[i]))
                continue;
            for (int j = i; j < s1.length(); j++) {
                if (!map.containsKey(c[j]))
                    continue;
                int pos = -1;
                for (int k : map.get(c[j])) {
                    if (k > current) {
                        pos = k;
                        break;
                    }
                }
                if (pos > current) {
                    current = pos;
                    count++;
                }
            }
            if (count > max)
                max = count;
                System.out.println(max);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {

        System.out.println(commonChild("ELGGYJWKTDHLXJRBJLRYEJWVSUFZKYHOIKBGTVUTTOCGMLEXWDSXEBKRZTQUVCJNGKKRMUUBACVOEQKBFFYBUQEMYNENKYYGUZSP", "FRVIFOVJYQLVZMFBNRUTIYFBMFFFRZVBYINXLDDSVMPWSQGJZYTKMZIPEGMVOUQBKYEWEYVOLSHCMHPAZYTENRNONTJWDANAMFRX"));
    }
}
