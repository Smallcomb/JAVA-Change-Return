// Generate a cost and then the amount of money given. 
// The program will figure out the amount and denominations of change given.

import java.util.concurrent.ThreadLocalRandom;
import java.lang.Double;
import java.lang.Math.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;
public class ChangeReturn {
	
	public static NumberFormat cash = new DecimalFormat("#.00"); 
	
	int hundreds = 0;
	int twenties = 0;
	int tens = 0;
	int fives = 0;
	int ones = 0;
	
	int quarters = 0;
	int dimes = 0;
	int nickels = 0;
	int pennies = 0;
	
	public static double genPrice()
	{
		double genprice = ThreadLocalRandom.current().nextDouble(.01, 999.99);
		//double genprice = Math.round(genprice*100.0)/100.0;
		return genprice;
	}
	
	public static double genPayment(double price)
	{
		double genpayment = ThreadLocalRandom.current().nextDouble(price, (price+999.99));
		return genpayment;
	}
	
	public static void giveChange(double change)
	{
		
		int hundreds = 0;
		int twenties = 0;
		int tens = 0;
		int fives = 0;
		int ones = 0;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		int pennies = 0;
		
		// round change to cent values after every subtraction 
		// to avoid floating point error
		change = (Math.round(change * 100.0)/100.0);
		
		// give change starting with largest denomination
		while(change >= 100)
		{

			change = change - 100;
			change = (Math.round(change * 100.0)/100.0);
			hundreds++;
			System.out.println(change);
		}
		while(change >= 20)
		{
			change = change - 20.00;
			change = (Math.round(change * 100.0)/100.0);
			twenties++;
			System.out.println(change);
		}
		while(change >= 10.00)
		{
			change = change - 10;
			change = (Math.round(change * 100.0)/100.0);
			tens++;
			System.out.println(change);
		}
		while(change >= 5)
		{
			change = change - 5;
			change = (Math.round(change * 100.0)/100.0);
			fives++;
			System.out.println(change);
		}
		while(change >= 1)
		{
			change = change - 1;
			change = (Math.round(change * 100.0)/100.0);
			ones++;
			System.out.println(change);
		}
		while(change >= .25)
		{
			change = change - .25;
			change = (Math.round(change * 100.0)/100.0);
			quarters++;
			System.out.println(change);
		}
		while(change >= .10)
		{
			change = change - .10;
			change = (Math.round(change * 100.0)/100.0);
			dimes++;
			System.out.println(change);
		}
		while(change >= .05)
		{
			change = change - .05;
			change = (Math.round(change * 100.0)/100.0);
			nickels++;
			System.out.println(change);
		}
		while(change >= .01)
		{
			change = change - .01;
			change = (Math.round(change * 100.0)/100.0);
			pennies++;
			System.out.println(change);
		}
			
		System.out.println("HUNDEREDS: " + hundreds);
		System.out.println("TWENTIES: " + twenties);
		System.out.println("TENS: " + tens);
		System.out.println("FIVES: " + fives);
		System.out.println("ONES: " + ones);
		System.out.println("QUARTERS: " + quarters);
		System.out.println("DIMES: " + dimes);
		System.out.println("NICKELS: " + nickels);
		System.out.println("PENNIES: " + pennies);
	}

	public static void main(String[] args) 
	{
		// randomly generate values, format to two decimal string, convert to double
		double price = Double.parseDouble(cash.format(genPrice()));
		System.out.println("PRICE: $" + price);
		
		double payment = Double.parseDouble(cash.format(genPayment(price)));
		System.out.println("PAYMENT: $" + payment);
		
		double change = (Double.parseDouble(cash.format(payment - price)));
		System.out.println("CHANGE: $" + change);
		
		giveChange(change);
	}

}
