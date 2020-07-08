import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private final WeightedQuickUnionUF grid;
    private boolean[] status;
    private int openCount = 0;
    private final int n;
    private final int vSite1, vSite2;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.n = n;
        int actualSize = n * n;
        grid = new WeightedQuickUnionUF(actualSize);
        status = new boolean[actualSize];
        vSite1 = 0;
        vSite2 = actualSize - 1;

        for (int i = 0; i < actualSize; i++) {
            status[i] = false;

            if (i < n)
                grid.union(i, vSite1);
            if (i > actualSize - n - 1)
                grid.union(i, vSite2);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (row < 0 || col < 0)
            throw new IllegalArgumentException();
        if (isOpen(row, col))
            return;
        openCount++;
        status[getLocation(row - 1, col - 1)] = true;

        if (isValidLocation(row - 1 - 1, col - 1))
            if (isOpen(row - 1, col))
                grid.union(getLocation(row - 1 - 1, col - 1), getLocation(row - 1, col - 1));

        if (isValidLocation(row - 1, col - 1 - 1))
            if (isOpen(row, col - 1))
                grid.union(getLocation(row - 1, col - 1 - 1), getLocation(row - 1, col - 1));

        if (isValidLocation(row + 1 - 1, col - 1))
            if (isOpen(row + 1, col))
                grid.union(getLocation(row + 1 - 1, col - 1), getLocation(row - 1, col - 1));

        if (isValidLocation(row - 1, col - 1 + 1))
            if (isOpen(row, col + 1))
                grid.union(getLocation(row - 1, col - 1 + 1), getLocation(row - 1, col - 1));

    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (row < 0 || col < 0)
            throw new IllegalArgumentException();
        return status[getLocation(row - 1, col - 1)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (row < 0 || col < 0)
            throw new IllegalArgumentException();
        if (isOpen(row - 1, col - 1)) {
            if (grid.find(getLocation(row - 1, col - 1)) == vSite1)
                return true;
        }

        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        if (grid.find(vSite1) == grid.find(vSite2))
            return true;
        return false;
    }

    // checks if the location is valid
    private boolean isValidLocation(int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n)
            return false;
        return true;
    }

    // get location from row, col
    private int getLocation(int row, int col) {
        if (row < 0 || col < 0)
            throw new IllegalArgumentException();
        return (n * (row)) + (col);
    }
}