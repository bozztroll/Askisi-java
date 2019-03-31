package javaapplication17;

import java.util.Scanner;

/**
 *
 * @author 
 */

public class JavaApplication17 {

   public static int[][] board = new int[3][3];
   public static int currentState; 
   public static int currentPlayer; 
   public static int currntRow, currentCol;
 
   public static Scanner scn = new Scanner(System.in); 
 
   public static void main(String[] args) {
      
      initGame();
  
      do {
         playerMove(currentPlayer); 
         updateGame(currentPlayer, currntRow, currentCol); 
         printBoard();
        
         if (currentState == 2) {
            System.out.println("'X' won!");
         } else if (currentState == 3) {
            System.out.println("'O' won!");
         } else if (currentState == 1) {
            System.out.println("It's a Draw!");
         }
         
         if (currentPlayer == 1 ){
             currentPlayer = 2;
         }
         else {
         currentPlayer = 1;
         }
      } while (currentState == 0); 
   }
 
   
   public static void initGame() {
      for (int row = 0; row < 3; ++row) {
         for (int col = 0; col < 3; ++col) {
            board[row][col] = 0; 
         }
      }
      currentState = 0; 
      currentPlayer = 1;  
   }
 
   public static void playerMove(int theSeed) {
      boolean validInput = false;  
      do {
         if (theSeed == 1) {
            System.out.print("Player 'X', enter move (row[1-3] col[1-3]): ");
         } else {
            System.out.print("Player 'O', enter move (row[1-3] col[1-3]): ");
         }
         int row = scn.nextInt() - 1;  
         int col = scn.nextInt() - 1;
         if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == 0) {
            currntRow = row;
            currentCol = col;
            board[currntRow][currentCol] = theSeed;  
            validInput = true;  
         } else {
            System.out.println("This move (" + (row + 1) + "," + (col + 1)
                  + ") is not valid. Try again...");
         }
      } while (!validInput);  
   }
 
   public static void updateGame(int theSeed, int currentRow, int currentCol) {
      if (hasWon(theSeed, currentRow, currentCol)) { 
          if (currentState == 1){
             currentState = 2; 
          }
          else{
              currentState = 3;
          } 
      } else if (isDraw()) {  
         currentState = 1;
      }
      
   }
 
   public static boolean isDraw() {
      for (int row = 0; row < 3; ++row) {
         for (int col = 0; col < 3; ++col) {
            if (board[row][col] == 0) {
               return false;  
            }
         }
      }
      return true;  
   }
 
   public static boolean hasWon(int theSeed, int currentRow, int currentCol) {
      return (board[currentRow][0] == theSeed         
                   && board[currentRow][1] == theSeed
                   && board[currentRow][2] == theSeed
              || board[0][currentCol] == theSeed      
                   && board[1][currentCol] == theSeed
                   && board[2][currentCol] == theSeed
              || currentRow == currentCol           
                   && board[0][0] == theSeed
                   && board[1][1] == theSeed
                   && board[2][2] == theSeed
              || currentRow + currentCol == 2  
                   && board[0][2] == theSeed
                   && board[1][1] == theSeed
                   && board[2][0] == theSeed);
   }
 
   public static void printBoard() {
      for (int row = 0; row < 3; ++row) {
         for (int col = 0; col < 3; ++col) {
            printCell(board[row][col]); 
            if (col != 2) {
               System.out.print("|");   
            }
         }
         System.out.println();
         if (row != 2) {
            System.out.println("-----------"); 
         }
      }
      System.out.println();
   }
 
   public static void printCell(int content) {
      switch (content) {
         case 0:  System.out.print("   "); break;
         case 2: System.out.print(" O "); break;
         case 1:  System.out.print(" X "); break;
      }
   }
}
