Programming Assignment 1: Percolation


Answer these questions after you implement your solution.

/* *****************************************************************************
 *  What computer science and programming background do you have?
 *  Check all that apply.
 **************************************************************************** */
 [ X ]  COS 126
 [ ]  COS 217 
 [ X ]  COS 226 (started, but did not complete)
 [ ]  ECE 115
 [ ]  AP Computer Science A
 [ ]  AP Computer Science Principles 
 [ ]  Passed COS placement exam
 [ ]  Algorithms, Part I on Coursera
 [ ]  Algorithms, Part II on Coursera
 [ ]  Competed in programming contests


/* *****************************************************************************
 *  What Java programming environment are you using?
 *  Check all that apply.
 **************************************************************************** */
 [ X ]  macOS
 [ ]  Windows
 [ ]  Linux
 [ X ]  IntelliJ
 [ ]  Eclipse
 [ ]  Visual Studio
 [ ]  Other (please specify) __________________________________


/* *****************************************************************************
 *  Describe the data structures (i.e., instance variables) you used to
 *  implement the Percolation API.
 **************************************************************************** */

    private final int n - grid dimensions to index rows/columns;
    private final boolean[] open - true/false statement for site opening;
    private final WeightedQuickUnionUF uf - main uf dealing with virtual top/bottom;
    private final WeightedQuickUnionUF ufFull; - UF only dealing w virtual top
    private final int virtualTop; - index n*n in both UF structures
    private final int virtualBottom; index in uf only
    private int openCount; total number of open sites at the time of calling

/* *****************************************************************************
 *  Briefly describe the algorithms you used to implement the constructor
 *  and each method in the Percolation API.
 **************************************************************************** */

Percolation():
checks for n > 0, all paths initially blocked, creates for union finds (uf). also
declares variables.

open():
if row/col isn't in range throw error. if passes and isn't open, mark open and
increment openCount. if row = 0, union w/ virtualtop in uf and ufFull. if row =
n-1, union w/ virtualbottom in uf. for each touching side. if range/open = true, union
with ufFull and uf.

isOpen():
validates indices and returns the boolean statement indicating if site opened up

isFull():
validates indices and returns false statement if site is closed. return if site in ufFull is associated
w/ virtual top

numberOfOpenSites():
return # associated with running counter

percolates():
returns if virtual top/bottom in uf are connected.

/* *****************************************************************************
 *  First, implement Percolation using QuickFindUF.
 *  What is the largest value of n that PercolationStats can handle in
 *  less than one minute on your computer when performing T = 100 trials?
 *
 *  Fill in the table below to show the values of n that you used and the
 *  corresponding running times. Use at least 5 different values of n.
 **************************************************************************** */

 T = 100

 n          time (seconds)
--------------------------
2 0.001
4 0.002
8 0.003
16 0.008
32 0.035
64 0.337
128 5.303
256 88.609 // in between n 128 and 256

/* *****************************************************************************
 *  Describe the strategy you used for selecting the values of n.
 **************************************************************************** */

Started with small n and doubled

/* *****************************************************************************
 *  Next, implement Percolation using WeightedQuickUnionUF.
 *  What is the largest value of n that PercolationStats can handle in
 *  less than one minute on your computer when performing T = 100 trials?
 *
 *  Fill in the table below to show the values of n that you used and the
 *  corresponding running times. Use at least 5 different values of n.
 **************************************************************************** */

 T = 100

 n          time (seconds)
--------------------------
20 0.006
40 0.013
80 0.034
160 0.084
320 0.306
640 1.363
1280 9.798
2560 54.033 // around n

/* *****************************************************************************
 *  Describe the strategy you used for selecting the values of n.
 *  If it's the same strategy as for QuickFindUF, just write "same".
 **************************************************************************** */

Same answer as above.

/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */

N/A

/* *****************************************************************************
 *  Describe any serious problems you encountered.                    
 **************************************************************************** */

Confused on the bounds to set for rows/columns for some of the loop
statements and how to set up Percolation.java constructor.

/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it.                                             
 **************************************************************************** */

N/A