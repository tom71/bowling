package de;

import java.util.List;

/**
 * Created by cristo on 15.04.17.
 */
public class Computer {

    public int computeResult(List frames)
    {
        // check for null or empty frames list

        int result = 0;

        int val1 = 0;
        int val2 = 0;

        boolean hasStrike = false;
        boolean hasSpare = false;

        for (int i = 0; i < 10; i++) {

            System.out.println(i+ " Result "+ result);


            int [] frame = (int[]) frames.get(i);

            val1 = frame[0];

            if(hasSpare) {
                result += val1;
                hasSpare = false;
            }

            result+=val1;

            if(val1 == 10)
            {
                hasStrike = true;
                continue;
            }

            if(frame.length>0) {
                val2 = frame[1];
                if(hasStrike) {
                    result += val2;
                    hasStrike = false;
                }

                result+=val2;

                if( (val1 + val2) == 10)
                {
                    hasSpare = true;
                }
            }

            if(i == 9 && frame.length>1) // last round
            {
                int val3 = frame[2];

                result+=val3;

                if(hasSpare || hasStrike)
                    result+=val1;

            }
        }
        return result;

    }
}
