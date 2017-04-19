package de;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by cristo on 15.04.17.
 */
public class BowlingResultsTest
{

	// create different rounds with strikes, spares and without extra points

	@DataProvider
	public static Object[][] data()
	{
		int[] frame1 = { 1, 4 };
		int[] frame2 = { 4, 5 };
		int[] frame3 = { 6, 4 };
		int[] frame4 = { 5, 5 };
		int[] frame5 = { 10 };
		int[] frame6 = { 0, 1 };
		int[] frame7 = { 7, 3 };
		int[] frame8 = { 6, 4 };
		int[] frame9 = { 10 };
		int[] frame10 = { 2, 8, 6 };
		int[] frame11 = { 10, 10, 10 };
		int[] frame12 = { 10, 10, 2 };
		int[] frame13 = { 10, 0, 0 };
		int[] frame14 = { 2, 4 };
		int[] frame15 = { 2, 0 };
		int[] frame16 = { 2, 4 };
		int[] frame17 = { 2, 4 };
		int[] frame18 = { 4, 6, 2 };

		List frames1 = new ArrayList();
		frames1.add( frame1 );
		frames1.add( frame2 );
		frames1.add( frame3 );
		frames1.add( frame4 );
		frames1.add( frame5 );
		frames1.add( frame6 );
		frames1.add( frame7 );
		frames1.add( frame8 );
		frames1.add( frame9 );

		List frames2 = new ArrayList();
		frames2.addAll( frames1 );
		List frames3 = new ArrayList();
		frames3.addAll( frames1 );
		List frames4 = new ArrayList();
		frames4.addAll( frames1 );
		List frames5 = new ArrayList();
		frames5.addAll( frames1 );
		List frames6 = new ArrayList();
		frames6.addAll( frames1 );

		List frames7 = new ArrayList();
		frames7.addAll( frames1 );
		frames7.remove( 8 );

		List frames8 = new ArrayList();
		frames8.addAll( frames1 );

		List frames9 = new ArrayList();
		frames9.addAll( frames1 );

		frames1.add( frame10 );
		frames2.add( frame11 );
		frames3.add( frame12 );
		frames4.add( frame13 );
		frames5.add( frame14 );
		frames6.add( frame15 );

		frames7.add( frame16 );
		frames7.add( frame17 );

		frames8.add( frame18 );
		frames9.add( frame9 );

		List frames10 = new ArrayList();
		for ( int i = 0; i < 10; i++ )
		{
			frames10.add( frame9 );
		}

		List frames11 = new ArrayList();
		for ( int i = 0; i < 9; i++ )
		{
			frames11.add( frame9 );
		}

		frames11.add( frame11 );

		return new Object[][] {
			{ frames1, 133 },
			{ frames2, 157 },
			{ frames3, 149 },
			{ frames4, 127 },
			{ frames5, 119 },
			{ frames6, 111 },
			{ frames7, 101 },
			{ frames8, 129 },
			{ frames9, 127 },
			{ frames10, 270 },
			{ frames11, 300 }
		};
	}

	@Test( dataProvider = "data" )
	public void testComputeResult( List allFrames, int expectedResult ) throws Exception
	{
		BowlingResults computer = new BowlingResults();

		List<Frame> framesList = new ArrayList<Frame>();

		for ( int i = 0; i < 10; i++ )
		{
			int roll1 = 0;
			int roll2 = 0;
			int roll3 = 0;

			int[] frames = ( int[] ) allFrames.get( i ); // current frame

			if ( frames.length > 0 )
			{
				roll1 = frames[0];
			}

			if ( frames.length > 1 )
			{
				roll2 = frames[1];
			}

			if ( frames.length > 2 )
			{
				roll3 = frames[2];
			}

			Frame frame = new Frame( i + 1, roll1, roll2, roll3 );

			framesList.add( frame );
		}

		int result = computer.computeResult( framesList );
		assertEquals( expectedResult, result );
	}
}