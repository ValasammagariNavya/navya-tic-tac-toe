package tic.tac.toe;

import java.awt.List;
import java.lang.reflect.Array;
import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import javax.naming.ldap.SortControl;

public class TicTacToe_Factory {
public static boolean startTicTacToe = true;
    
    public static void main(String[] args) {
//    	int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    		// int[] a = { 1, 2, 3 };
    		// int[] b = { 4, 5, 6 };
    		// int[] c = { 7, 8, 9 };
    	/*		System.out.println("---------");
		for (int index = 0; index < a.length - 6; index++) {

			System.out.print(a[index] + " ");

		}
		System.out.println("");
		for (int index1 = 3; index1 < a.length - 3; index1++) {

			System.out.print(a[index1] + " ");

		}
		System.out.println("");

		for (int index2 = 6; index2 <= a.length - 1; index2++) {

			System.out.print(a[index2] + " ");

		}
		*/
    	
        int[][] a = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        
        Set<Integer> consoleInput = new HashSet<Integer>();
        for (int i = 0; i < a.length; i++) {
        	
            for (int j = 0; j < a[i].length; j++) {
            	
                System.out.print(a[i][j] + "|");
            }
            System.out.println("");
        }
        
        Scanner sc = new Scanner(System.in);
        while (startTicTacToe) {
        	
            System.out.println(" Enter Player position ---");
            int input = sc.nextInt();
            consoleInput.add(input);
            System.out.println(" Track manual input" + input);
            System.out.println("Console stores" + consoleInput);
            // when ever human enters some position then system to give some random position
            int random2 = (int) (Math.random() * (1 - 9));
            System.out.println("Track system input" + random2);
            
            /*	
			if(input == a[0][0] && input == a[0][1] && input == a[0][2])
		{
		System.out.println(" Player wins by Top row");
		}
		else if (input == a[1][0] && input == a[1][1] && input == a[1][2]) {
			System.out.println("Player wins by middle row");
		}	
		else if (input == 7 && input == 8 && input == 9) {
			System.out.println("Player wins by bottom row");
		}
	
		*/

            if (consoleInput.size() >= 3) {
                boolean isPlayerWon = TicTacToe_Factory.compareHorizontal(a, consoleInput);
               // System.out.println("Player won");
            
               if(!isPlayerWon) {
                    isPlayerWon = TicTacToe_Factory.compareVertical(a, consoleInput);
                 //   System.out.println("Player won");
                }
              if(!isPlayerWon) {
                  isPlayerWon = TicTacToe_Factory.compareDiagonals(a, consoleInput);
                 // System.out.println("Player won");
                }
            //    if(consoleInput.size() >=3){
              //  	isPlayerWon = TicTacToe_Factory.compareVertical(a, consoleInput);
                	//System.out.println("Player won");
             //   }
                
            
            if(isPlayerWon)
            {
            	System.out.println("Player won");
            }
        }
    }
    }
   public static boolean compareDiagonals(int[][] a, Set<Integer> consoleInput) {
        boolean isPlayerWon = false;
        int matchedCount = 0;
        for (int i = 0; i < a[0].length; i++) {
            if (consoleInput.contains(a[i][i])) {
                matchedCount++;
            }
            if (matchedCount == 3) {
                isPlayerWon = true;
                startTicTacToe = false;
            //   consoleInput = new HashSet<Integer>();
            //    break;
            }
        }
     matchedCount = 0;
        for (int i = 0; i < a[0].length; i++) {
            if (consoleInput.contains(a[i][a[0].length-(i+1)])) {
                matchedCount++;
            }
            if (matchedCount == 3) {
                isPlayerWon = true;
                startTicTacToe = false;
               // consoleInput = new HashSet<Integer>();
              //  break;
            }
        }
        return isPlayerWon;
    }
    
    public static boolean compareVertical(int[][] a, Set<Integer> consoleInput) {
        boolean isPlayerWon = false;
        for (int i = 0; i < a[0].length; i++) {
            int matchedCount = 0;
            for (int j = 0; j < a[1].length; j++) {
                if (consoleInput.contains(a[j][i])) {
                    matchedCount++;
                }
                if (matchedCount == 3) {
                    isPlayerWon = true;
                    startTicTacToe = false;
                  //  consoleInput = new HashSet<Integer>();
                 //   break;
                }
            }
        }
        return isPlayerWon;
    }
    
    public static boolean compareHorizontal(int[][] a, Set<Integer> consoleInput) {
        boolean isPlayerWon = false;
        for (int i = 0; i < a[0].length; i++) {
            int matchedCount = 0;
            for (int j = 0; j < a[1].length; j++) {
                if (consoleInput.contains(a[i][j])) {
                    matchedCount++;
                }
                
                if (matchedCount == 3) {
                    isPlayerWon = true;
                    startTicTacToe = false;
                 //  consoleInput = new HashSet<Integer>();
                  //  break;
                }
            }
        }
        return isPlayerWon;
    }
}
