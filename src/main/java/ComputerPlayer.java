import java.util.Optional;

public class ComputerPlayer extends Player{
    @Override
    public void chooseMove() {
        //  The random variable picks a random number between 0 and 2
        int random = (int)(Math.random()*3);

        /*
         Switch case takes in random input and sets a new instance of a certain class based on if it
         matches the ints within the case, then ends to loop.
        The Optional.of creates an Optional instance with a non-null value if the computer has made a move, and
         if not, returns an empty instance of Optional
        */
        switch (random) {
            case 0 -> setMove(Optional.of(new Rock()));
            case 1 -> setMove(Optional.of(new Paper()));
            case 2 -> setMove(Optional.of(new Scissors()));
            default -> setMove(Optional.empty());
        }
    }
}
