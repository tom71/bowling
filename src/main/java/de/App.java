package de;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cristo on 16.04.17.
 */
public class App
{

	public static void main( String[] args )
	{
		System.out.println( "Ergebniseingabe (Werte mit , trennen. Strikes mit einer einzelnen 10 eingeben)" );

		List list = new ArrayList();

		// collect 10 rounds, every roll is separated by "," 
		for ( int i = 0; i < 10; i++ )
		{
			System.out.print( "Runde " + (i + 1) + ":" );
			Scanner in = new Scanner( System.in );
			String round = in.nextLine();
			String[] frameString = round.split( "," );
			
			Frame frame = new Frame( i + 1,
			                         frameString.length>0 && frameString[0] != null ? Integer.parseInt( frameString[0] ) : 0,
			                         frameString.length>1 && frameString[1] != null ? Integer.parseInt( frameString[1] ) : 0,
			                         frameString.length>2 && frameString[2] != null ? Integer.parseInt( frameString[2] ) : 0 );

			list.add( frame );
		}

		BowlingResults bowlingResults = new BowlingResults();

		System.out.println( "Du hast " + bowlingResults.computeResult( list ) + " Punkte erreicht!" );
	}
}
