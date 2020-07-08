/*
Union-find with specific canonical element. 

Add a method find() to the union-find data type so that find(i) returns 
the largest element in the connected component containing i. The operations,
 union(),connected(), and find() should all take logarithmic time or better.

For example, if one of the connected components is {1,2,6,9}, then the find()
method should return 999 for each of the four elements in the connected components. 
*/

import java.util.Arrays;

class Week1InterviewQn2 {

    int[] id, sz, max;

    Week1InterviewQn2(int n) {
        id = new int[n];
        sz = new int[n];
        max = new int[n];
        Arrays.fill(sz, 1);
        for (int i = 0; i < n; i++) {
            id[i] = i;
            max[i] = i;
        }
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        int maxp = max[i];
        int maxq = max[j];
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];

            if(maxp < maxq)
                max[i] = max[j];
        } else {
            id[j] = i;
            sz[i] += sz[j];

            if(maxp < maxq)
                max[i] = max[j];
        }
    }

    public int root(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public int Largest(int i){
        return max[i];
    }

    public void printSet(int p) {
        while (p != id[p]) {
            System.out.print(p + " ");
            p = id[p];
        }
        System.out.print(p + "\n");
    }

    public static void main(String[] args) {
        Week1InterviewQn2 uf = new Week1InterviewQn2(10);
        double startTime = System.nanoTime();
        uf.union(1, 3);
        uf.union(1, 5);
        uf.union(1, 7);
        uf.union(1, 9);
        uf.union(2, 0);
        double lap =  ((double)(System.nanoTime() - startTime))/ 1000000000;
        System.out.println(lap);
        System.out.println(uf.Largest(1));
    }
}