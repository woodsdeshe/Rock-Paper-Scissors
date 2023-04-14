import java.util.Optional;
import java.util.Scanner;

public class HumanPlayer extends Player{

    private Move move;
    private int score;

    @Override
    public void chooseMove() {
        Scanner scanner = new Scanner(System.in);
        Optional<Move> moveOptional = Optional.empty();

        while (!moveOptional.isPresent()) {
            // The while loop runs the player options while getMove returns empty
            System.out.println("Please choose one of the following moves: rock, paper, or scissors");

            /*
             input variable is declared that takes in the players option while handling case sensitivity by making
             input lowercase
            */
            String input = scanner.nextLine().toLowerCase();

            /*
             Switch case takes in the player input and sets a new instance of a certain class based on if it matches
             the strings within the case, then ends the loop.
             The Optional.of creates an Optional instance with a non-null value if the player has made a move, if not,
             it returns an empty instance of Optional
            */
            switch (input) {
                case "rock" -> moveOptional = Optional.of(new Rock());
                case "paper" -> moveOptional = Optional.of(new Paper());
                case "scissors" -> moveOptional = Optional.of(new Scissors());
                default -> System.out.println("Invalid input.");
            }

        }
        // Retrieves the value of the current moveOptional and stores it in the move variable
        move = moveOptional.get();
    }

    @Override
    public Optional<Move> getMove() {
        return Optional.ofNullable(move);
    }

}
