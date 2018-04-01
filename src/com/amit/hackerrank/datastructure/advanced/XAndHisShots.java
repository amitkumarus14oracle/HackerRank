package com.amit.hackerrank.datastructure.advanced;


import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
 * A cricket match is going to be held. The field is represented by a 1D plane. A cricketer, Mr. X has  favorite shots. Each shot has a particular range. The range of the  shot is from i to i. That means his favorite shot can be anywhere in this range. Each player on the opposite team can field only in a particular range. Player  can field from i to i. You are given the  favorite shots of Mr. X and the range of  players.

 represents the strength of each player i.e. the number of shots player  can stop. 
Your task is to find:

.

Game Rules: A player can stop the  shot if the range overlaps with the player's fielding range.

For more clarity about overlapping, study the following figure:

L.png

Input Format

The first line consists of two space separated integers,  and .
Each of the next  lines contains two space separated integers. The  line contains  and .
Each of the next  lines contains two integers. The  line contains integers  and .

Output Format

You need to print the sum of the strengths of all the players: .

Constraints:

 

Sample Input

4 4                
1 2 
2 3
4 5
6 7
1 5
2 3
4 7
5 7   
Sample Output

9
Explanation

Player 1 can stop the 1st, 2nd and 3rd shot so the strength is 3 .
Player 2 can stop the 1st and 2nd shot so the strength is 2.
Player 3 can stop the 3rd and 4th shot so the strength is 2.
Player 4 can stop the 3rd and 4th shot so the strength is 2.

The sum of the strengths of all the players is 9. 	*/

public class XAndHisShots {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc =  new Scanner(System.in);
        String nm[] = sc.nextLine().split(" ");
        int n= Integer.parseInt(nm[0]);
        int m= Integer.parseInt(nm[1]);
        long sum = 0;
        String abs[] =  new String[n];
        String cds[] =  new String[m];
        for(int i=0;i<n;i++) {
            abs[i]= sc.nextLine(); 
        }
        for(int i=0;i<m;i++) {
            cds[i]= sc.nextLine(); 
        }
        for(int i=0;i<n;i++) {
            String ab[] = abs[i].split(" ");
            int a= Integer.parseInt(ab[0]);
            int b= Integer.parseInt(ab[1]);
            int noSolCount = 0;
            long solCount = 0;
            for(int j=0;j<m;j++) {
                String cd[] = cds[j].split(" ");
                int c= Integer.parseInt(cd[0]);
                int d= Integer.parseInt(cd[1]);
                /*if(b<c) {
                    noSolCount++;
                }
                else if(d<a) {
                    noSolCount++;
                }*/
                if(b>=c && d>=a) {
                    solCount++;
                }
                //System.out.println("selected count : "+ (noSolCount));
            }
            //sum += (m-noSolCount);
            sum += (solCount);
        }
        System.out.println(sum);
    }
}