public class PercolationStats {

    double[] testResults;
    int trials, n;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        testResults = new double[n];
        this.n = n;
        this.trials = trials;
        for (int i = 0; i < trials; i++) {
            Percolation perc = new Percolation(n);
            while (!perc.percolates())
                perc.OpenRandom();
            testResults[i] = perc.numberOfOpenSites() / (n*n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        double m = 0d;
        for (double i : testResults) {
            m += i;
        }
        m /= trials;
        return m;
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        double dev = 0d;
        var mean = mean();
        for (double i : testResults) {
            dev += (i - mean) * (i - mean);
        }
        dev /=  trials - 1;
        return Math.sqrt(dev);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        var stddev = stddev();
        var mean = mean();
        return mean - ((1.96 * stddev) / Math.sqrt(trials));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        var stddev = stddev();
        var mean = mean();
        return mean + ((1.96 * stddev) / Math.sqrt(trials));

    }

    // test client (see below)
    public static void main(String[] args) {
        Stopwatch s = new Stopwatch();
        PercolationStats percStats = new PercolationStats(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        System.out.println("Elapsed time : " + s.elapsedTime());
        System.out.println("mean : " + percStats.mean());
        System.out.println("stddev : " + percStats.stddev());
        System.out.println("95% confidence : [" + percStats.confidenceHi() + ", " + percStats.confidenceLo() + "]");
    }

}