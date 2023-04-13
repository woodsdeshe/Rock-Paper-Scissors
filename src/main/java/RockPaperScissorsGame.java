import java.util.Scanner;

public class RockPaperScissorsGame {
    public static void main(String[] args) {
        // Allows user to type in responses in console
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 1 to play against the computer or 2 to play against another human player");

        // numPlayers takes in the int needed in order to pick which option the player wants to do
        int numPlayers = input.nextInt();

        Player player1, player2;

        if (numPlayers == 1) {
            player1 = new HumanPlayer();
            player2 = new ComputerPlayer();
        } else {
            player1 = new HumanPlayer();
            player2 = new HumanPlayer();
        }

        while (true){
            System.out.println("Player 1's turn:");
            player1.chooseMove();

            if (numPlayers == 1) {
                player2.chooseMove();
            } else {
                System.out.println("Player 2's turn");
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
        }




    }
}
