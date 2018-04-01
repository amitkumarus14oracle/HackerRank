package com.amit.hackerrank.datastructure.advanced;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

/*
 * Meera teaches a class of  students, and every day in her classroom is an adventure. Today is drawing day!

The students are sitting around a round table, and they are numbered from  to  in the clockwise direction. This means that the students are numbered , and students  and  are sitting next to each other.

After letting the students draw for a certain period of time, Meera starts collecting their work to ensure she has time to review all the drawings before the end of the day. However, some of her students aren't finished drawing! Each student  needs  extra minutes to complete their drawing.

Meera collects the drawings sequentially in the clockwise direction, starting with student ID , and it takes her exactly  minute to review each drawing. This means that student  gets  extra minutes to complete their drawing, student  gets  extra minute, student  gets  extra minutes, and so on. Note that Meera will still spend minute for each student even if the drawing isn't ready.

Given the values of , help Meera choose the best possible  to start collecting drawings from, such that the number of students able to complete their drawings is maximal. Then print  on a new line. If there are multiple such IDs, select the smallest one.

Input Format

The first line contains a single positive integer, , denoting the number of students in the class. 
The second line contains  space-separated integers describing the respective amounts of time that each student needs to finish their drawings (i.e., ).

Constraints

Subtasks

 for  of the maximum score.
Output Format

Print an integer denoting the ID number, , where Meera should start collecting the drawings such that a maximal number of students can complete their drawings. If there are multiple such IDs, select the smallest one.

Sample Input

3 
1 0 0
Sample Output

2
Explanation

Meera's class has  students:

If , then only two students will finish. 
The first student needs  extra minute to complete their drawing. If Meera starts collecting here, this student will never finish their drawing. Students  and 's drawings are already finished, so their drawings are ready when she collects them in the second and third minutes.
If , then all three students will finish. 
The second student needs  extra minutes, so the drawing is ready for Meera to collect. The next (third) student's drawing is also ready one minute later, as . Meera then proceeds to the next (first) student, who needed  extra minute. Because she already spent two minutes collecting the work of the other two students, the first student's drawing has already been completed for  minute.
If , then all three students will finish. 
The third student needs  extra minutes, so the drawing is ready for Meera to collect. The next (first) student's drawing is also ready one minute later, as  and  minute passed while Meera collected the third student's drawing. She then proceeds to the next (second) student, whose drawing was already completed (as )
Starting with student IDs  or  will result in a maximum number of completed drawings (i.e., ). Because there are two equally valid answers, we choose the smaller ID, , and print it as our answer.*/

public class KintergartenAdventure {

    /*
     * Complete the solve function below.
     */
    static int solve(int[] t) {
        /*
         * Return the ID
         */
         int maxPassCountValue = 0;
         int index = 0;
         int[] passCountArray = new int[t.length];
         for(int i=0;i<t.length;i++) {
            int count = t.length;
            int timeGetting = 0;
            int passCount = 0;
            for(int j=i,k=0;k<count;k++) {
                int timeRequired = t[j];
                if(timeGetting >= timeRequired) {
                    passCount++;
                }
                timeGetting = timeGetting+1;
                if((j+1)%count == 0) {
                    j=0;
                }
                else {
                    j++;
                }
            }
            passCountArray[i] = passCount;
            if(maxPassCountValue < passCount) {
                maxPassCountValue = passCount;
                index = i;
            }
         }
         System.out.println(index+1);
         return index+1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int tCount = Integer.parseInt(scanner.nextLine().trim());

        int[] t = new int[tCount];

        String[] tItems = scanner.nextLine().split(" ");

        for (int tItr = 0; tItr < tCount; tItr++) {
            int tItem = Integer.parseInt(tItems[tItr].trim());
            t[tItr] = tItem;
        }

        int id = solve(t);

        //bufferedWriter.write(String.valueOf(id));
        //bufferedWriter.newLine();

        //bufferedWriter.close();
    }
}
