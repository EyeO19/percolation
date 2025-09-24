import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.Stopwatch;

public class PercolationStats {
    private final double[] thresholds;
    private static final double CONFIDENCE_95 = 1.96;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException("n and trial # must be greater than 0");
        }
        thresholds = new double[trials];
        int total = n * n;

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);

            // pick until percolation while skipping opened sites
            while (!p.percolates()) {
                int row = StdRandom.uniformInt(n);
                int col = StdRandom.uniformInt(n);
                if (!p.isOpen(row, col)) {
                    p.open(row, col);
                }
            }
            thresholds[i] = p.numberOfOpenSites() / (double) total;
        }

    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(thresholds);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(thresholds);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLow() {
        return mean() - (stddev() * CONFIDENCE_95) / Math.sqrt(thresholds.length);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHigh() {
        return mean() + (stddev() * CONFIDENCE_95) / Math.sqrt(thresholds.length);
    }

    // test client (see below)
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: PercolationStats <n> <trials>");
            return;
        }
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);

        Stopwatch stopwatch = new Stopwatch();
        PercolationStats stats = new PercolationStats(n, trials);
        double elapsed = stopwatch.elapsedTime();

        System.out.println("mean: " + stats.mean());
        System.out.println("stddev: " + stats.stddev());
        System.out.println("confidenceLow: " + stats.confidenceLow());
        System.out.println("confidenceHigh: " + stats.confidenceHigh());
        System.out.println("elapsed: " + elapsed);

    }

}
