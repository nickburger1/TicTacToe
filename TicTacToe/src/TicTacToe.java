import java.util.*;

public class TicTacToe {
    /*
    This program allows users to play TicTacToe against the computer
    The user picks a number 1-9 that represents the square they would like to place their character
    If either the user or the computer get 3 in a row the game ends
    If neither get 3 in a row, the game ends in a draw
     */
    static void displaySelection(String[] row1, String[] row2, String[] row3){
        //display board for user to follow along with
        System.out.println("-----------");
        System.out.println(row1[0] + "\t" + row1[1] + "\t" + row1[2]);
        System.out.println(row2[0] + "\t" + row2[1] + "\t" + row2[2]);
        System.out.println(row3[0] + "\t" + row3[1] + "\t" + row3[2]);
        System.out.println("-----------");
    }

    static String[] populateArray(String[] row, String character, int selection){
        //keep a running talley of every selection to make sure computer does not select a space that as already been selected
        switch (selection){
            case 1, 4, 7 -> row[0] = character;
            case 2, 5, 8 -> row[1] = character;
            case 3, 6, 9 -> row[2] = character;
        }
        return row;
    }

    static boolean checkWin(String[] row1, String[] row2, String[] row3){
        //check to see if there are 3 of the same characters that appear in a row, if so there has been a winner
        boolean won = false;
        if(row1[0].equals("x") && row2[0].equals("x") && row3[0].equals("x") || row1[0].equals("o") && row2[0].equals("o") && row3[0].equals("o")){
            System.out.println("WINNER");
            won = true;
        }else if(row1[1].equals("x") && row2[1].equals("x") && row3[1].equals("x") || row1[1].equals("o") && row2[1].equals("o") && row3[1].equals("o")){
            System.out.println("WINNER");
            won = true;
        }else if(row1[2].equals("x") && row2[2].equals("x") && row3[2].equals("x") || row1[2].equals("o") && row2[2].equals("o") && row3[2].equals("o")){
            System.out.println("WINNER");
            won = true;
        }else if(row1[0].equals("x") && row1[1].equals("x") && row1[2].equals("x") || row1[0].equals("o") && row1[1].equals("o") && row1[2].equals("o")){
            System.out.println("WINNER");
            won = true;
        }else if(row2[0].equals("x") && row2[1].equals("x") && row2[2].equals("x") || row2[0].equals("o") && row2[1].equals("o") && row2[2].equals("o")){
            System.out.println("WINNER");
            won = true;
        }else if(row3[0].equals("x") && row3[1].equals("x") && row3[2].equals("x") || row3[0].equals("o") && row3[1].equals("o") && row3[2].equals("o")){
            System.out.println("WINNER");
            won = true;
        }else if(row1[0].equals("x") && row2[1].equals("x") && row3[2].equals("x") || row1[0].equals("o") && row2[1].equals("o") && row3[2].equals("o")){
            System.out.println("WINNER");
            won = true;
        }else if(row1[2].equals("x") && row2[1].equals("x") && row3[0].equals("x") || row1[2].equals("o") && row2[1].equals("o") && row3[0].equals("o")){
            System.out.println("WINNER");
            won = true;
        }else{ //if no one wins game ends in a draw
            System.out.println("DRAW");
        }
        return won;
    }

    static void play(String character, String character2){
        //user selects a space first, then the computer, until either the game ends in a draw or someone wins
        Scanner s = new Scanner(System.in);
        String[] row1 = new String[]{" ", " ", " "};
        String[] row2 = new String[]{" ", " ", " "};
        String[] row3 = new String[]{" ", " ", " "};
        int[] selections = new int[]{0,0,0,0,0,0,0,0,0};
        Random rand = new Random();
        int randomNum = 0;
        int numOfSelections = 0;
        int selection = 0;
        boolean won = false;
        while(numOfSelections < 9 && !won){
            boolean taken = true;
            System.out.print("Please Choose a Square [1-9]: ");
            selection = s.nextInt();
            switch (selection){
                case 1, 2, 3 -> {
                    row1 = populateArray(row1, character, selection);
                    selections[selection-1] = 1;
                    won = checkWin(row1, row2, row3);
                }
                case 4, 5, 6 -> {
                    row2 = populateArray(row2, character, selection);
                    selections[selection-1] = 1;
                    won = checkWin(row1, row2, row3);
                }
                case 7, 8, 9 -> {
                    row3 = populateArray(row3, character, selection);
                    selections[selection-1] = 1;
                    won = checkWin(row1, row2, row3);
                }
            }

            while(taken && !won){
                randomNum = rand.nextInt((9 - 1) + 1) + 1;
                if(selections[randomNum-1] == 0){
                    taken = false;
                }
            }

            selections[randomNum-1] = 1;
            switch (randomNum){
                case 1, 2, 3 -> {
                    row1 = populateArray(row1, character2, randomNum);
                    won = checkWin(row1, row2, row3);
                }
                case 4, 5, 6 -> {
                    row2 = populateArray(row2, character2, randomNum);
                    won = checkWin(row1, row2, row3);
                }
                case 7, 8, 9 -> {
                    row3 = populateArray(row3, character2, randomNum);
                    won = checkWin(row1, row2, row3);
                }
            }

            displaySelection(row1, row2, row3);
            numOfSelections++;
        }
    }

    public static void main(String[] args){
        //get user input on their desired character, assign opposite character to computer
        Scanner s = new Scanner(System.in);
        System.out.print("Choose x or o: ");
        String character = s.next();
        String character2 = " ";

        if(character.equals("x")){
            character2 = "o";
        }else{
            character2 = "x";
        }
        play(character, character2);
    }
}
