package com.wolff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class RocketMain 
{
	private static int distanceFromLaunch;
	
	public RocketMain()
	{}
	
	public static void main(String[] args)
	{
		System.out.println("Please enter the distance from the launch site");
		String distance = readLine();
		distanceFromLaunch = Integer.parseInt(distance);
		System.out.println("Please enter the number of rockets to be launched");
		String students = readLine();
		int numStudents = Integer.parseInt(students);
		String[] studentNames = new String[numStudents];
		int[] rocketHeights = new int[numStudents];
		for(int i = 0; i < numStudents; i++)
		{
		System.out.println("Please enter the height at which the angle reading will be taken");
		String height = readLine();
		int rocketHeight = Integer.parseInt(height);
		System.out.println("Enter the name of the student");
		String studentName = readLine();
		studentNames[i] = studentName;
		System.out.println("Enter the angle achieved at max height");
		String angle = readLine();
		int rocketAngle = Integer.parseInt(angle);
		rocketHeights[i] = calcHeight(distanceFromLaunch, rocketHeight, rocketAngle);
		}
		String[] newArray = sortHeights(rocketHeights, studentNames);
		writeLines(newArray);
		printHeights(studentNames, rocketHeights);
	}
	
	public static int calcHeight(int dist, int measureHeight, int angle)
	{
		int height = 0;
		int distance = (int) (dist + measureHeight/Math.tan(Math.toRadians(angle)));
		height = (int) (Math.tan(Math.toRadians(angle))*distance);
		return height;
	}
	
	public static String readLine()
	{
		String myString = "";
		try
		{
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			myString = bufferRead.readLine();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return myString;
	}
	
	public static void printHeights(String[] array1, int[] array2)
	{
		for(int i = 0; i < array1.length; i++)
		{
			System.out.println(array1[i] + " " + array2[i]);
		}
	}
	
	public static void sortArrays(String[] array1, int[] array2)
	{
		
	}
	public static void writeLines(String[] array1)
	{
		String fileName = "rocketHeightRecord.txt";
        try{
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for(int i = 0; i < array1.length; i = i +2)
            {
            bufferedWriter.write(array1[i] + " " + array1[i+1]);
            bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }
            catch(IOException ex)
            {
            	System.out.println("Error writing to file");
            }
           
	}
	 public static String[] sortHeights(int[] unsorted, String[] names)
	  {
		for(int i = 1; i<unsorted.length; i++)
		{
		 int initial = unsorted[i];
		 String initialStr = names[i];
	         int test = i-1;
	         while(test>=0)
	         {
	          if(initial < unsorted[test])
	          {
	           unsorted[test + 1] = unsorted[test];
	           names[test + 1] = names[test];
	           unsorted[test] = initial;
	           names[test] = initialStr;
	           test--;
	          }
	          else
	          {
	           break;
	          }
	         }
		}
		String[] newArray = new String[unsorted.length*2];
		for(int i = 0; i < unsorted.length*2; i = i +2)
		{
			newArray[i] = names[i];
			Integer temp = new Integer(unsorted[i]);
			newArray[i+1] = temp.toString();
		}
		return newArray;
	  }
}

