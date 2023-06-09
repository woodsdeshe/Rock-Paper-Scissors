import java.util.Optional;

public abstract class Player {
    private int score;
    private boolean isWinner;
    // Optional move allows for the possibility that a player has not picked an option yet
    private Optional<Move> move;

    // Getters and Setters for score, isWinner, and move
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isWinner() {
        return isWinner;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public Optional<Move> getMove() {
        return move;
    }

    public void setMove(Optional<Move> move) {
        this.move = move;
    }

    // play method takes in both players moves and determines who is the winner
    public void play(Player opponent) {
        // playerMove & opponentMove utilizes getMove to retrieve the player and opponent moves
        Optional<Move> playerMove = getMove();
        Optional<Move> opponentMove = opponent.getMove();

        // First if statement checks to see if player and their opponent have made moves
        if (playerMove.isPresent() && opponentMove.isPresent()) {

            /* If both players have made moves, and the player beats opponent, player wins, opponent loses, and the
            player score gets increases by 1
             */
            if (playerMove.get().beats(opponentMove.get())) {
                setWinner(true);
                opponent.setWinner(false);
                setScore(getScore() + 1);

                /* If both players have made moves, and the opponent beats' player, opponent wins, player loses, and the
                 opponent score gets increases by 1
                 */
            } else if (opponentMove.get().beats(playerMove.get())) {
                opponent.setWinner(true);
                setWinner(false);
                opponent.setScore(opponent.getScore() + 1);

                 // If it's a tie, both players setWinner equals false
            } else {
                setWinner(false);
                opponent.setWinner(false);
            }
        } else {
            // If no move is chosen then there is no winner
            setWinner(false);
            opponent.setWinner(false);
        }
    }

    // chooseMove() is an abstract method that grabs the move of the current player, whether human or computer
    public abstract void chooseMove();
}
