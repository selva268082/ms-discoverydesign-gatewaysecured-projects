package com.java.coding.interview;

import java.util.Scanner;

public class PrimeNumberCheck {

	public static void main(String[] args) {
		int temp;
		boolean isPrime=true;
		Scanner scan= new Scanner(System.in);
		System.out.println("Enter any number:");
		//capture the input in an integer
		double num=scan.nextDouble();
	        scan.close();
			   System.out.println(num/2 + " is a Prime Number");
		for(int i=2;i<=num/2;i++)
		{
	           temp=(int) (num%i);
		   if(temp==0)
		   {
		      isPrime=false;
		      break;
		   }
		}
		//If isPrime is true then the number is prime else not
		if(isPrime)
		   System.out.println(num + " is a Prime Number");
		else
		   System.out.println(num + " is not a Prime Number");
	   }

 

}
