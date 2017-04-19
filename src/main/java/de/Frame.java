package de;

/**
 * Created on 19.04.2017.
 */
public class Frame
{
	
	
	public Frame(int round, int first, int second, int third)
	{
		this.round = round;
		this.first = first;
		this.second = second;
		this.third = third;
		this.pins = first+second;
		this.total = pins;
	}

	private int round = 0;

	private int first = 0;

	private int second = 0;

	private int third = 0;
	
	private int pins = 0;
	
	int total = 0;
	
	public boolean isSpare()
	{
		
		return !isStrike() && (first + second) == 10;	
	}

	public boolean isStrike()
	{
		return first  == 10;
	}
	
	public int getPins()
	{
		if(pins>10)
			return 10;
		else 
			return pins;
	}

	public int getFirst()
	{
		return first;
	}

	public int getSecond()
	{
		return second;
	}

	public int getThird()
	{
		return third;
	}

	public void addTotal( int total )
	{
		this.total += total;
	}

	public int getTotal()
	{
		return total;
	}

	@Override
	public String toString()
	{
		return "Frame{" +
		       "round=" + round +
		       ", first=" + first +
		       ", second=" + second +
		       ", third=" + third +
		       ", pins=" + getPins() +
		       ", total=" + getTotal() +
		       '}';
	}
}
