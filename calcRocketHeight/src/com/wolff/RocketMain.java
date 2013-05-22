package com.wolff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

public class RocketMain 
{
	private int distanceFromLaunch;
	
	public RocketMain()
	{}
	
	public static void main(String[] args)
	{
		System.out.println("Please enter the distance from the launch site");
		String distance = readLine();
		System.out.println("Pleas enter the number of rockets to be launched");
		String students = readLine();
		int numStudents = Integer.parseInt(students);
		
		for(int i = 0; i < numStudents; i++)
		{
		System.out.println("Please enter the height at which the angle reading will be taken");
		String height = readLine();
		int rocketHeight = Integer.parseInt(height);
		System.out.println("Enter the name of the student");
		String studentName = readLine();
		System.out.println("Enter the angle achieved at max height");
		String angle = readLine();
		double rocketAngle = Double.parseDouble(angle);
		}
	}
	
	public int calcHeight(int dist)
	{
		
		return;
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
}
