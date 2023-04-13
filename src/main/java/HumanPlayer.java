import java.util.Optional;
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

            /*
             Switch case takes in the player input and sets a new instance of a certain class based on if it matches
             the strings within the case, then breaks the code.
             The Optional.of creates an Optional instance with a non-null value if the player has made a move, if not,
             it returns an empty instance of Optional
            */
            switch (input) {
                case "rock" -> setMove(Optional.of(new Rock()));
                case "paper" -> setMove(Optional.of(new Paper()));
                case "scissors" -> setMove(Optional.of(new Scissors()));
            }

        } while (getMove().isEmpty());
    }
}
