import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double STDCONST = 1.96;
    private final double[] testResults;
    private final int trials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        testResults = new double[trials];
        this.trials = trials;
        for (int i = 1; i <= trials; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates())
                perc.open(StdRandom.uniform(1, n + 1), StdRandom.uniform(1, n + 1));
            testResults[i - 1] = (double) perc.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(testResults);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(testResults);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        var stddev = stddev();
        var mean = mean();
        return mean - ((STDCONST * stddev) / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        var stddev = stddev();
        var mean = mean();
        return mean + ((STDCONST * stddev) / Math.sqrt(trials));

    }

    // test client (see below)
    public static void main(String[] args) {
        PercolationStats percStats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("mean : " + percStats.mean());
        System.out.println("stddev : " + percStats.stddev());
        System.out.println("95% confidence : [" + percStats.confidenceHi() + ", " + percStats.confidenceLo() + "]");
    }

}
