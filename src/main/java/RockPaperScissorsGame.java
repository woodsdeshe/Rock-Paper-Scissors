import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        // Allows user to type in responses in console
        Scanner input = new Scanner(System.in);

        int numPlayers;
        do {
            // Prompts user to play with computer or another player
            System.out.println("Enter 1 to play against the computer or 2 to play against another human player");
            /*
             If user puts in invalid input, it will print an invalid input
             response and ask the user to select 1 or 2
            */
            while (!input.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1 or 2.");
                input.next();
            }
            // numPlayers takes in the int needed in order to pick which option the player wants to do
            numPlayers = input.nextInt();
        } while (numPlayers != 1 && numPlayers != 2);
        input.nextLine();

        // Declaring a player1 and player2 of Player type and gives it a value of null
        Player player1, player2;

        // player1 initializes a new HumanPlayer instance
        player1 = new HumanPlayer();

        // If numPlayers equals 1, the player2 initializes a new ComputerPlayer instance
        if (numPlayers == 1) {
            player2 = new ComputerPlayer();

            // If numPlayers equals 2, the player2 initializes a new HumanPLayer instance
        } else {
            player2 = new HumanPlayer();
        }

        while (true) {
            System.out.println("Player 1's turn:");
            // player1 uses chooseMove() method to grab player1's move
            player1.chooseMove();

            /*
             if numPLayers is 1, then this gives the computer an opportunity to
             choose a move and the chooseMove method grabs the choice of the
             computer
            */
            if (numPlayers == 1) {
                player2.chooseMove();

                // If numPlayers is 2, then this asserts the player2 as non-null and uses the chooseMove
                // to grab the choice of player2
            } else {
                System.out.println("Player 2's turn");
                player2.chooseMove();
            }

            /*
             Play method from Player class is used to determine who's the winner out
             of both players, whether computer or human
            */
            player1.play(player2);

            /*
             Prints out the choice of the first player and the second player and contains an Optional that
             will return an Optional<String> if getMove() is null
            */
            System.out.print("Player 1 chose " + player1.getMove()
                    .map(move -> move.getClass()
                            .getSimpleName())
                    .orElse("no move"));
            System.out.println();

            System.out.print("Player 2 chose " + player2.getMove()
                    .map(move -> move.getClass()
                            .getSimpleName())
                    .orElse("no move"));
            System.out.println();

            // Determines which player has won and prints it in the console
            if (player1.isWinner()) {
                System.out.println("Player 1 wins!");
            } else if (player2.isWinner()) {
                System.out.println("Player 2 wins");
            } else {
                System.out.println("it's a tie!");
            }

            // Prints out the score of the both players
            System.out.println("Player 1 score:" + player1.getScore());
            System.out.println("Player 2 score:" + player2.getScore());

            // Prompts the player to see if they want to play again
            System.out.println("Do you want to play again? (y/n)");
            String playAgain = input.nextLine().toLowerCase();

            // If the player chooses "n" then the console with stop
            if (playAgain.equals("n")) {
                break;
            }
        }

        input.close();
    }
}
