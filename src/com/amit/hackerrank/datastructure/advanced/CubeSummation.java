package com.amit.hackerrank.datastructure.advanced;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * You are given a 3-D Matrix in which each block contains 0 initially. The first block is defined by the coordinate (1,1,1) and the last block is defined by the coordinate (N,N,N). There are two types of queries.

UPDATE x y z W
updates the value of block (x,y,z) to W.

QUERY x1 y1 z1 x2 y2 z2
calculates the sum of the value of blocks whose x coordinate is between x1 and x2 (inclusive), y coordinate between y1 and y2 (inclusive) and z coordinate between z1 and z2 (inclusive).

Input Format 
The first line contains an integer T, the number of test-cases. T testcases follow. 
For each test case, the first line will contain two integers N and M separated by a single space. 
N defines the N * N * N matrix. 
M defines the number of operations. 
The next M lines will contain either

 1. UPDATE x y z W
 2. QUERY  x1 y1 z1 x2 y2 z2 
Output Format 
Print the result for each QUERY.

Constrains 
1 <= T <= 50 
1 <= N <= 100 
1 <= M <= 1000 
1 <= x1 <= x2 <= N 
1 <= y1 <= y2 <= N 
1 <= z1 <= z2 <= N 
1 <= x,y,z <= N 
-109 <= W <= 109

Sample Input

2
4 5
UPDATE 2 2 2 4
QUERY 1 1 1 3 3 3
UPDATE 1 1 1 23
QUERY 2 2 2 4 4 4
QUERY 1 1 1 3 3 3
2 4
UPDATE 2 2 2 1
QUERY 1 1 1 1 1 1
QUERY 1 1 1 2 2 2
QUERY 2 2 2 2 2 2
Sample Output

4
4
27
0
1
1
Explanation 
First test case, we are given a cube of 4 * 4 * 4 and 5 queries. Initially all the cells (1,1,1) to (4,4,4) are 0. 
UPDATE 2 2 2 4 makes the cell (2,2,2) = 4 
QUERY 1 1 1 3 3 3. As (2,2,2) is updated to 4 and the rest are all 0. The answer to this query is 4. 
UPDATE 1 1 1 23. updates the cell (1,1,1) to 23. QUERY 2 2 2 4 4 4. Only the cell (1,1,1) and (2,2,2) are non-zero and (1,1,1) is not between (2,2,2) and (4,4,4). So, the answer is 4. 
QUERY 1 1 1 3 3 3. 2 cells are non-zero and their sum is 23+4 = 27.*/

public class CubeSummation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc =  new Scanner(System.in);
        int testcases = Integer.parseInt(sc.nextLine());
        for(int i=0;i<testcases;i++) {
            String []testcase = sc.nextLine().split(" ");
            int n = Integer.parseInt(testcase[0]);
            int operations = Integer.parseInt(testcase[1]);
            int[][][] arr = new int[n][n][n];
            for(int j=0;j<operations;j++) {
                String operation[] = sc.nextLine().split(" ");
                if(operation[0].equals("UPDATE")) {
                    int x = Integer.parseInt(operation[1]);
                    int y = Integer.parseInt(operation[2]);
                    int z = Integer.parseInt(operation[3]);
                    int w = Integer.parseInt(operation[4]);
                    arr[x-1][y-1][z-1] = w;
                }
                else {
                    int x1 = Integer.parseInt(operation[1]);
                    int y1 = Integer.parseInt(operation[2]);
                    int z1 = Integer.parseInt(operation[3]);
                    int x2 = Integer.parseInt(operation[4]);
                    int y2 = Integer.parseInt(operation[5]);
                    int z2 = Integer.parseInt(operation[6]);
                    findQueryResult(arr,x1,y1,z1,x2,y2,z2);
                }
            }
        }
    }
    
    public static void findQueryResult(int arr[][][],int x1,int y1,int z1,int x2,int y2,int z2) {
        long sum = 0;
        for(int i=x1-1;i<x2;i++) {
            for(int j=y1-1;j<y2;j++) {
                for(int k=z1-1;k<z2;k++) {
                    sum += arr[i][j][k];
                }
            }
        }
        System.out.println(sum);
    }
}