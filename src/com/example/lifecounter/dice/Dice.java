package com.example.lifecounter.dice;

import java.util.Random;

public class Dice {

	int result;
	
	public int rollDice(int sides)
	{
		Random randomGenerator = new Random();	
		
		int minimum = 1;
		int maximum = sides;

		int range = maximum - minimum + 1;
		this.result = randomGenerator.nextInt(range) + minimum;	
		
		return this.result;
	}
	
	public int getResult()
	{
		return this.result;
	}
	
	public void reset()
	{
		result = 0;
	}
}
