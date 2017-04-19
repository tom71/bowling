package de;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cristo on 15.04.17.
 */
public class BowlingResults {

    public int computeResult(List allFrames)
    {
        
        int result = 0;
        
        List <Frame> framesList = new ArrayList<Frame>(  ); 
        
        for ( int i = 0; i < 10; i++ )
        {
            int roll1 = 0;
            int roll2 = 0;
            int roll3 = 0;
            
            int[] frames = (int[]) allFrames.get(i); // current frame
            
            if (frames.length > 0)
                roll1 = frames[0];

            if (frames.length > 1)
                roll2  = frames[1];

            if (frames.length > 2)
                roll3  = frames[2];

            Frame frame = new Frame(( i +1) ,roll1,roll2,roll3);
            framesList.add( frame );
        }
        
        int count = 0;
        for ( Frame frame: framesList )
        {
            if(count>0) // not first
            {
                Frame previous = framesList.get( count-1 );
                if(previous.isSpare())
                    previous.addTotal( frame.getFirst());
                
                if(previous.isStrike())
                    previous.addTotal( frame.getPins() );
                
                if(count>1){
                    Frame prePrevious = framesList.get( count-2 );
                    if(prePrevious.isStrike() && previous.isStrike())
                        prePrevious.addTotal( frame.getPins() );
                }
                
            }
            count ++;
        }
        
        Frame last = framesList.get( 9 );
        last.addTotal( last.getThird() );

        Frame previous = framesList.get( 8 );
        if(previous.isStrike()&& last.isStrike())
            previous.addTotal( last.getSecond() );
        
        for ( Frame frame: framesList )
        {
            result+=frame.getTotal();
            System.out.println( frame +" ->" + result);
        }
        
        return result;
    }
    
}
