package de;

import java.util.List;

/**
 * Created by cristo on 15.04.17.
 */
public class BowlingResults {

    public int computeResult(List frames) {
        // check for null or empty frames list

        int result = 0;

        int roll1;
        int roll2;
        int roll3;

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

        roll3 = 0;

        if (frame.length > 2)
            roll3 = frame[2];

        if (hasSpare || hasStrike)
            result += roll3;

        return result;

    }
}
