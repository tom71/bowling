package de;

import java.util.List;

/**
 * Created by cristo on 15.04.17.
 */
public class BowlingResults {

    public int computeResult(List<Frame> framesList)
    {
        
        int result = 0;
        int count = 0;
        
        // compute results with extra points, reward
        for ( Frame currentFrame: framesList )
        {
            if(count>0) // first frame has no previous frame
            {
                Frame previous = framesList.get( count-1 );
                if(previous.isSpare())
                    previous.addTotal( currentFrame.getFirst());
                
                if(previous.isStrike())
                    previous.addTotal( currentFrame.getPins() );
                
                if(count>1){ // after second frame
                    Frame prePrevious = framesList.get( count-2 );
                    if(prePrevious.isStrike() && previous.isStrike())
                        prePrevious.addTotal( currentFrame.getPins() );
                }
                
            }
            count ++;
        }
        
        // handle last Frame
        Frame last = framesList.get( 9 );
        last.addTotal( last.getThird() );
        
        Frame previous = framesList.get( 8 );
        if(previous.isStrike()&& last.isStrike())
            previous.addTotal( last.getSecond() );
        
        // collect all results
        for ( Frame currentFrame: framesList )
        {
            result+=currentFrame.getTotal();
        }
        
        return result;
    }
    
}
