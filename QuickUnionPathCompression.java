import java.util.Arrays;

class QuickUnionPathCompression {

    int[] id, sz;

    QuickUnionPathCompression(int n) {
        id = new int[n];
        sz = new int[n];
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

    public void printSet(int p) {
        while (p != id[p]) {
            System.out.print(p + " ");
            p = id[p];
        }
        System.out.print(p + "\n");
    }

    public static void main(String[] args) {
        QuickUnionPathCompression uf = new QuickUnionPathCompression(10);
        double startTime = System.nanoTime();
        uf.union(1, 3);
        uf.union(1, 5);
        uf.union(1, 7);
        uf.union(1, 9);
        uf.union(2, 0);
        double lap =  ((double)(System.nanoTime() - startTime))/ 1000000000;
        System.out.println(lap);
        System.out.println(uf.sz[1]);
    }
}