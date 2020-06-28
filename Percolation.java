import java.util.ArrayList;
import java.util.Random;

public class Percolation {

    private QuickUnionWeighted grid;
    private boolean[] status;
    private ArrayList<Integer> closedSites = new ArrayList<>();
    private int n, actualSize;
    private final int vSite1, vSite2;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        this.n = n;
        actualSize = n * n;
        grid = new QuickUnionWeighted(actualSize);
        status = new boolean[actualSize];
        vSite1 = 0;
        vSite2 = actualSize - 1;

        for (int i = 0; i < actualSize; i++) {
            closedSites.add(i);
            status[i] = false;

            if (i < n)
                grid.union(i, vSite1);
            if (i > actualSize - n - 1)
                grid.union(i, vSite2);
        }
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        status[GetLocation(row, col)] = true;

        if (IsValidLocation(row - 1, col))
            if (isOpen(row - 1, col))
                grid.union(GetLocation(row - 1, col), GetLocation(row, col));

        if (IsValidLocation(row, col - 1))
            if (isOpen(row, col - 1))
                grid.union(GetLocation(row, col - 1), GetLocation(row, col));

        if (IsValidLocation(row + 1, col))
            if (isOpen(row + 1, col))
                grid.union(GetLocation(row + 1, col), GetLocation(row, col));

        if (IsValidLocation(row, col + 1))
            if (isOpen(row, col + 1))
                grid.union(GetLocation(row, col + 1), GetLocation(row, col));

    }

    // select a random site
    public int RandomSite() {
        Random rand = new Random();
        int random = 0;
        try {
            random = rand.nextInt(closedSites.size() - 1);
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        return closedSites.get(random);
    }

    public void OpenRandom() {
        int random = RandomSite();
        int[] sites = GetLocation(random);
        closedSites.remove(closedSites.indexOf(random));
        open(sites[0], sites[1]);
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        return status[GetLocation(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (isOpen(row, col) == true) {
            if (grid.root(GetLocation(row, col)) == vSite1)
                return true;
        }

        return false;
    }

    // returns the number of open sites
    public double numberOfOpenSites() {
        return actualSize - closedSites.size();
    }

    // does the system percolate?
    public boolean percolates() {
        if (grid.connected(vSite1, vSite2))
            return true;
        return false;
    }

    // checks if the location is valid
    public boolean IsValidLocation(int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= n)
            return false;
        return true;
    }

    // get location from row, col
    private int GetLocation(int row, int col) {
        return (n * (row)) + (col);
    }

    // get row, col from location
    private int[] GetLocation(int value) {
        int row = value / n;
        int col = value % n;
        return new int[] { row, col };
    }
}