Percolation simulates percolation on an NxN grid ot model the way fluid flows through a porous material. Each site is either open or blocked, and the system percolates if there's a connected path of open sites from the top row to the bottom row.

Percolation.java: 
Here is where the Percolation grid logic is being applied, where an NxN grid is being managed of open and closed sites. In this, we use a Weighted-Quick Union-Find to track the connected sites, and this determines whether or not the system percolates.

PercolationStats.java: 
Here is where the program runs multiple simulations to estimate the threshold of percolation, where the program computes: mean threshold, std deviation, and 95% confidence interval.

PercolationVisualizer.java:
This program creates a graphical visualization of the percolation process, modeling an NxN grid and coloring each grid by open and closed sites to give a full visualization of the percolaiton process in real time.

Overall, the goal of the project is to determine the percolation threshold when sites are randomly opened.  The simulation combines concepts of object-orientation design, efficient connectivity algorithms, visualization methods, etc. to model and analyze this behavior.
