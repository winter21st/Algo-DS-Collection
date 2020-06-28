class QuickUnion {

    int[] idArray;

    QuickUnion(int n) {
        idArray = new int[n];
        for (int i = 0; i < n; i++) {
            idArray[i] = i;
        }
    }

    public void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        idArray[i] = j;
    }

    public int root(int p) {
        while (p != idArray[p])
            p = idArray[p];
        return p;

    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void printSet(int p) {
        while (p != idArray[p]) {
            System.out.print(p + " ");
            p = idArray[p];
        }
        System.out.print(p + "\n");
    }

    public static void main(String[] args) {
        QuickUnion uf = new QuickUnion(10);
        double startTime = System.nanoTime();
        uf.union(1, 3);
        uf.union(1, 5);
        uf.union(1, 7);
        uf.union(1, 9);
        uf.union(2, 0);
        uf.printSet(1);
        double lap =  ((double)(System.nanoTime() - startTime))/ 1000000000;
        System.out.println(lap);
    }
}