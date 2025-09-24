import edu.princeton.cs.algs4.WeightedQuickUnionUF;


public class Percolation {
    private final int n;
    private final boolean[] open;
    private final WeightedQuickUnionUF uf;
    private final WeightedQuickUnionUF ufFull;
    private final int virtualTop;
    private final int virtualBottom;
    private int openCount;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("n must be > 0");
        this.n = n;
        int size = n * n;
        this.open = new boolean[n * n];
        this.uf = new WeightedQuickUnionUF(size + 2);
        this.ufFull = new WeightedQuickUnionUF(size + 1);
        this.virtualTop = size;
        this.virtualBottom = size + 1;
        this.openCount = 0;
    }

    // throws unless row/col inside
    private void validate(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= n)
            throw new IllegalArgumentException("\"row and/or col not in correct range");
    }

    // indexes row/col
    private int toIndex(int row, int col) {
        return row * n + col;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        validate(row, col);
        int i = toIndex(row, col);
        if (open[i]) return;
        open[i] = true;
        openCount++;

        // top and bottom connections
        if (row == 0) {
            uf.union(i, virtualTop);
            ufFull.union(i, virtualTop);
        }

        if (row == n - 1) {
            uf.union(i, virtualBottom);
        } // n/a ufFUll

        if (row > 0 && isOpen(row - 1, col)) {
            int j = toIndex(row - 1, col);
            uf.union(i, j);
            ufFull.union(i, j);
        }
        if (row < n - 1 && isOpen(row + 1, col)) {
            int j = toIndex(row + 1, col);
            uf.union(i, j);
            ufFull.union(i, j);
        }
        if (col > 0 && isOpen(row, col - 1)) {
            int j = toIndex(row, col - 1);
            uf.union(i, j);
            ufFull.union(i, j);
        }

        if (col < n - 1 && isOpen(row, col + 1)) {
            int j = toIndex(row, col + 1);
            uf.union(i, j);
            ufFull.union(i, j);
        }
    }

    // is  site (row, col) open?
    public boolean isOpen(int row, int col) {
        validate(row, col);
        return open[toIndex(row, col)];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        validate(row, col);
        if (!isOpen(row, col)) return false;
        return ufFull.find(toIndex(row, col)) == ufFull.find(virtualTop);
    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return openCount;
    }

    // does the system percolate?
    public boolean percolates() {
        return uf.find(virtualTop) == uf.find(virtualBottom);
    }

    // unit testing (optional for this class)
    public static void main(String[] args) {
        System.out.println("Percolation test:");
        Percolation percolation = new Percolation(3);
        System.out.println("Initially percolates? " + percolation.percolates());
        percolation.open(0, 1);
        percolation.open(1, 1);
        percolation.open(2, 1);
        System.out.println(
                "After opening a vertical path, percolates? " + percolation.percolates());
    }

}

