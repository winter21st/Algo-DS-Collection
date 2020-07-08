/*
Social network connectivity. Given a social network containing n members 
and a log file containing m timestamps at which times pairs of members 
formed friendships, design an algorithm to determine the earliest time at 
which all members are connected (i.e., every member is a friend of a 
friend of a friend ... of a friend). Assume that the log file is sorted 
by timestamp and that friendship is an equivalence relation. The running 
time of your algorithm should be mlog⁡nm \log nmlogn or better and use 
extra space proportional to n.
*/

import java.util.Arrays;

class Week1InterviewQn1 {

    private int[] id, sz;
    private int count;

    Week1InterviewQn1(int n) {
        id = new int[n];
        sz = new int[n];
        count = n;
        Arrays.fill(sz, 1);
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        } else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count--;
    }

    public int root(int p) {
        while (p != id[p]) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int Count(){
        return count;
    }

    public void printSet(int p) {
        while (p != id[p]) {
            System.out.print(p + " ");
            p = id[p];
        }
        System.out.print(p + "\n");
    }

    public static void main(String[] args) {
        int count = 10;
        Week1InterviewQn1 uf = new Week1InterviewQn1(count);
        String[] timestamp = new String[count - 1];
        timestamp[0] = "1 3 01:00";
        timestamp[1] = "1 5 02:00";
        timestamp[2] = "1 7 03:00";
        timestamp[3] = "1 9 04:00";
        timestamp[4] = "2 0 05:00";
        timestamp[5] = "2 1 06:00";
        timestamp[6] = "2 4 07:00";
        timestamp[7] = "2 6 08:00";
        timestamp[8] = "8 0 09:00";
        for (int i = 0; i < timestamp.length; i++) {
            String[] temp = timestamp[i].split(" ");
            uf.union(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
            if(uf.Count() == count){
                System.out.println(temp[3]);
            }
        }
    }
}