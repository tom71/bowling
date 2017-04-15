package de;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.testng.AssertJUnit.assertEquals;

/**
 * Created by cristo on 15.04.17.
 */
public class ComputerTest {

    @DataProvider
    public static Object[][] data() {
        int [] frame1= {1,4};
        int [] frame2= {4,5};
        int [] frame3= {6,4};
        int [] frame4= {5,5};
        int [] frame5= {10};
        int [] frame6= {0,1};
        int [] frame7= {7,3};
        int [] frame8= {6,4};
        int [] frame9= {10};
        int [] frame10= {2,8,6};

        List frames = new ArrayList();
        frames.add(frame1);
        frames.add(frame2);
        frames.add(frame3);
        frames.add(frame4);
        frames.add(frame5);
        frames.add(frame6);
        frames.add(frame7);
        frames.add(frame8);
        frames.add(frame9);
        frames.add(frame10);

        return new Object[][] {
                { frames, 133 }
        };
    }

    @Test(dataProvider = "data")
    public void testComputeResult(List frames, int expectedResult) throws Exception {
        Computer computer = new Computer();
        int result = computer.computeResult(frames);
        assertEquals(expectedResult,result);
    }

}