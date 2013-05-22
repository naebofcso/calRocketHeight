package com.wolff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

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
}
