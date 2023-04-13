import java.util.Scanner;

public class HumanPlayer extends Player{

    @Override
    public void chooseMove() {
        Scanner scanner = new Scanner(System.in);

        // The while loop runs the player options while getMove returns empty
        do {
            System.out.println("Please choose one of the following moves: rock, paper, or scissors");

            /*
             input variable is declared that takes in the players option while handling case sensitivity by making
             input lowercase
            */
            String input = scanner.nextLine().toLowerCase();

        } while (getMove().isEmpty());
    }
}
