package com.example.lifecounter.player;

public class Player {

	int life_counter;
	int poison_counter;
	String player_name;
	
	public Player(int startingLife, String player_name) 
	{
		this.player_name    = player_name;
		this.life_counter   = startingLife;
		this.poison_counter = 0;
	}
	
	public void incrementLife(int value)
	{
		this.life_counter += value;
	}
	
	public void decrementLife(int value)
	{
		this.life_counter -= value;
	}
	
	public void incrementPoison(int value)
	{
		this.poison_counter += value;
	}
	
	public void decrementPoison(int value)
	{
		this.poison_counter -= value;
	}
		
	public int getLifeCounter()
	{
		return this.life_counter;
	}
	
	public int getPoisonCounter()
	{
		return this.poison_counter;
	}
	
	public String getName()
	{
		return this.player_name;
	}
	
	public void reset()
	{
		this.life_counter   = 20;
		this.poison_counter = 0;
	}
	
}
