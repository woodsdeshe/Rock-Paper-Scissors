import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        // Allows user to type in responses in console
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 1 to play against the computer or 2 to play against another human player");

        // numPlayers takes in the int needed in order to pick which option the player wants to do
        int numPlayers = input.nextInt();
        input.nextLine();

        // Declaring a player1 and player2 of Player type and gives it a value of null
        Player player1, player2 = null;

        // player1 initializes a new HumanPlayer instance
        player1 = new HumanPlayer();

        // If numPlayers equals 1, the player2 initializes a new ComputerPlayer instance
        if (numPlayers == 1) {
            player2 = new ComputerPlayer();
        } else if (numPlayers == 2){
            // If numPlayers equals 2, the player2 initializes a new HumanPLayer instance
            player2 = new HumanPlayer();
        } else {
            //If neither number is pressed, it will prompt the player to choose 1 or 2
            System.out.println("Please enter 1 or 2");
        }

        while (true){
            System.out.println("Player 1's turn:");
            player1.chooseMove();

            if (numPlayers == 1) {
                player2.chooseMove();
            } else {
                System.out.println("Player 2's turn");
                assert player2 != null;
                player2.chooseMove();
            }

            player1.play(player2);

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

            if (player1.isWinner()) {
                System.out.println("Player 1 wins!");
            } else if (player2.isWinner()) {
                System.out.println("Player 2 wins");
            } else {
                System.out.println("it's a tie!");
            }
            System.out.println("Player 1 score:" + player1.getScore());
            System.out.println("Player 2 score:" + player2.getScore());

            System.out.println("Do you want to play again? (y/n)");
            String playAgain = input.nextLine().toLowerCase();

            if (playAgain.equals("n")){
                break;
            }
        }

        input.close();




    }
}
