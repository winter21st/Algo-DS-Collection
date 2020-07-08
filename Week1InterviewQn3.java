public class Week1InterviewQn3 {

    private int id[];
    private int sz[];
    private int actualList[];
    private int N;

    public Week1InterviewQn3(int N) {
        this.N = N;
        id = new int[N];
        sz = new int[N];
        actualList = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
            sz[i] = 1;
            actualList[i] = i;
        }
    }

    // returns the root of the component the integer is in
    private int root(int i) {
        while (id[i] != i) {

            i = id[i];
        }
        return i;
    }

    // weighted quick union
    public void union(Integer p, Integer q) {
        int i = root(p);
        int j = root(q);
        if (i == j)
            return;
        if (sz[i] <= sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
            actualList[i] = j;
        } else {
            id[j] = i;
            sz[i] += sz[j];
            actualList[i] = j;
        }
    }

    public void remove(int x) {
        if (x + 1 < N)
            union(x, x + 1);
        else if (x - 1 >= 0)
            while (x - 1 >= 0) {
                if (actualList[x - 1] == x - 1) {
                    union(x, x - 1);
                    return;
                }
                x -= 1;
            }
        else
            System.out.println("Nothing to remove");
    }

    public String successor(int x) {
        if (actualList[root(x)] == x)
            return x + "";
        else if (x + 1 >= N)
            return "No successor";
        else
            return actualList[(root(x + 1))] + "";
    }

    public static void main(String[] args) {
        Week1InterviewQn3 uf = new Week1InterviewQn3(10);
        double startTime = System.nanoTime();
        uf.remove(4);
        uf.remove(5);
        uf.remove(7);
        uf.remove(6);
        uf.remove(9);
        uf.remove(0);
        double lap = ((double) (System.nanoTime() - startTime)) / 1000000000;
        System.out.println(lap);
        System.out.println(uf.successor(0));
    }
}
