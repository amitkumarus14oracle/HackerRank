package com.amit;
import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class MaxWithContinuousIncr {

    /*
     * Complete the arrayManipulation function below.
     */
    static long arrayManipulation(int n, int[][] queries) {
        /*
         * Write your code here.
         */
        if(n<3 && n>10000000)
            return 0;
        if(queries.length<1 && queries.length>200000)
            return 0;
        int finalArray[] = new int[n];
        long max = 0;
        /*for(int i=0;i<finalArray.length;i++) {
            System.out.println("values : "+finalArray[i]);
        }*/
        for(int i=0; i< queries.length;i++) {
            //System.out.println("values : "+addOns);
            int addOns=queries[i][queries[i].length-1];
            int beginIndex = queries[i][0]-1;
            int endIndex = queries[i][1]-1;
            if(beginIndex < 0 || endIndex > n)
                return 0;
            //System.out.println("values : "+addOns);
            finalArray[beginIndex]+=addOns;
            if(endIndex+1<n)  finalArray[endIndex+1]-=addOns;
            
        }
        long sum = 0;
        for(int j =0;j< n;j++) {
                sum = sum+ finalArray[j];
                if(sum > max) max =sum;
            }
        System.out.println("max values is : "+max);
        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0].trim());

        int m = Integer.parseInt(nm[1].trim());

        int[][] queries = new int[m][3];
        
        System.out.println("into main method");

        for (int queriesRowItr = 0; queriesRowItr < m; queriesRowItr++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            if(queriesRowItr==49998){
            	System.out.println("printing addons1111 : "+queriesRowItr);
            }
            System.out.println("printing addons : "+queriesRowItems[2]);
            for (int queriesColumnItr = 0; queriesColumnItr < 3; queriesColumnItr++) {
                int queriesItem = Integer.parseInt(queriesRowItems[queriesColumnItr].trim());
                queries[queriesRowItr][queriesColumnItr] = queriesItem;
            }
        }
        System.out.println("about to call function");
        long result = arrayManipulation(n, queries);

        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
    }
    
    //public static void main(String[] args) {}
}
