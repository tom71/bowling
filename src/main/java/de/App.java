package de;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by cristo on 16.04.17.
 */
public class App {

    public static void main(String []args)
    {
        System.out.println("Ergebniseingabe (Werte mit , trennen. Strikes mit einer einzelnen 10 eingeben)");

        List list = new ArrayList();


        for( int i = 0; i< 10; i++)
        {
            System.out.print("Runde "+ (i+1)+":");
            Scanner in = new Scanner(System.in);
            String round  = in.nextLine();
            String [] frame = round.split(",");
            int length = frame.length;
            int [] results = new int [length];
            for (int j=0; j<length;j++) {
                results[j] = Integer.parseInt(frame[j]);
            }
            list.add(results);
        }

        BowlingResults bowlingResults = new BowlingResults();

        System.out.println("Du hast "+ bowlingResults.computeResult(list)+ " Punkte erreicht!");
    }
}
