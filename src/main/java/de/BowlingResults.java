package de;

import java.util.List;

/**
 * Created by cristo on 15.04.17.
 */
public class BowlingResults {

    public int computeResult(List frames) {
        // check for null or empty frames list

        int result = 0;

        int roll1 = 0;
        int roll2 = 0;
        int roll3 = 0;

        boolean hasStrike = false;
        boolean hasSpare = false;

        for (int i = 0; i < 10; i++) {

            roll1 = 0;
            roll2 = 0;

            int[] frame = (int[]) frames.get(i); // current frame

            if (frame.length > 0)
                roll1 = frame[0];

            if (frame.length > 1)
                roll2 = frame[1];

            result += roll1;
            result += roll2;

            // previous round was an also an strike
            if (roll1 == 10 && hasStrike) {
                hasStrike = true;
                result+=20;
                continue;
            }

            if (hasSpare) { // previous round was an spare ?
                result += roll1;
                hasSpare = false;
            }

            if (hasStrike) { // previous round was an strike ?
                result += (roll1 + roll2);
                hasStrike = false;
            }

            // this round was an strike or spare ?
            if (roll1 == 10) {
                hasStrike = true;
            }
            else if ((roll1 + roll2) == 10) {
                hasSpare = true;
            }

        }

        // compute last round
        int[] frame = (int[]) frames.get(9);

        if (frame.length > 2)
            roll3 = frame[2];

        if (hasSpare || hasStrike)
            result += roll3;

        if(roll2 == 10)
            result += 10;

        return result;

    }

    public int computeResult2(List frames) {
        int result = 0;

        int roll1 = 0;
        int roll2 = 0;
        int roll3 = 0;

        int countNext = 0;

        for (int i = 0; i < 10; i++) {

            roll1 = 0;
            roll2 = 0;

            int[] frame = (int[]) frames.get(i); // current frame

            if (frame.length > 0)
                roll1 = frame[0];

            if (frame.length > 1)
                roll2 = frame[1];


            result += roll1;


            if (roll1 == 10) {
                result += roll1;
                countNext  = 2;
                continue;
            }

            result += roll2;

            if (countNext > 0) { // previous round was an spare ?
                result += roll1;
                countNext = 1;
            }

            if(countNext > 1)
            { // previous round was an spare ?
                result += roll2;
                countNext = 0;
            }

            if ((roll1 + roll2) == 10) {
                countNext = 1;
            }
        }


        // compute last round
        int[] frame = (int[]) frames.get(9);

        if (frame.length > 2)
            roll3 = frame[2];

        result += roll3;

        if(countNext>0)
            result += roll3;

        //if (roll2 == 10)
        //    result += 10;

        return result;
    }
}
