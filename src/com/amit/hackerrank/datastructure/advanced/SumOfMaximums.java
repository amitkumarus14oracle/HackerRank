package com.amit.hackerrank.datastructure.advanced;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * Alexey is playing with an array, , of  integers. His friend, Ivan, asks him to calculate the sum of the maximum values for all subsegments of . More formally, he wants Alexey to find .

Alexey solved Ivan's challenge faster than expected, so Ivan decides to add another layer of difficulty by having Alexey answer  queries. The  query contains subsegment , and he must calculate the sum of maximum values on all subsegments inside subsegment .

More formally, for each query , Alexey must calculate the following function:

.

Can you help Alexey solve this problem?

Input Format

The first line contains  space-separated positive integers,  (the length of array ) and  (number of queries), respectively. 
The second line contains  space-separated integers,  describing each element  (where ) in array . 
Each of the  subsequent lines contains  space-separated positive integers describing the respective values for and  in query  (where ).

Constraints

Output Format

For each query  (where ), print its answer on a new line.*/

public class SumOfMaximums {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        String first = sc.nextLine();
        String[] sizes = first.split(" ");
        int a[] = new int[Integer.parseInt(sizes[0])];
        int queriesSize = Integer.parseInt(sizes[1]);
        String arrayLine = sc.nextLine();
        String[] arrayLineValues = arrayLine.split(" ");
        for(int i=0;i<a.length;i++) {
            try{
            	a[i]=Integer.parseInt(arrayLineValues[i]);
                //System.out.println("value : "+a[i]);
            }
        	catch(Exception e) {
        		//System.out.println("in exception");
        		e.printStackTrace();
        	}
        }
        int c[][] = new int[a.length][a.length];    
        for(int i=0;i<a.length;i++) {
            for(int j=i;j<a.length;j++) {
                if(j==i) {
                	c[i][j] = a[i];
                }
                else {
                	c[i][j] = (a[j]>c[i][j-1] ? a[j] : c[i][j-1]);
                }
            }
            
        }
        //System.out.println("ruk jao");
        for(int i=0;i<queriesSize;i++) {
            String query = sc.nextLine();
            String quesryArray[] =  query.split(" ");
            int strtIndex = Integer.parseInt(quesryArray[0]);
            int endIndex = Integer.parseInt(quesryArray[1]);
            sumOfMaximums(c, strtIndex, endIndex);
        } 
    }
    public static void sumOfMaximums(int a[][], int strt, int end) {
        int count = 1;
        long sum = 0; 
        for(int i=strt-1;i<end;i++) {
        	for(int j=i;j<end;j++) {
        		sum = sum + a[i][j];
            }
        }
        
        System.out.println(sum);
    }
}
