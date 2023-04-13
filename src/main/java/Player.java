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

    public void play(Player opponenet) {
        // playerMove & opponentMove utilizes getMove to retrieve the player and opponent moves
        Optional<Move> playerMove = getMove();
        Optional<Move> opponentMove = opponenet.getMove();

        // First if statement checks to see if player and their opponent have made moves
        if (playerMove.isPresent() && opponentMove.isPresent()) {

            /** If both players have made moves, and the player beats opponent, player wins, opponent loses, and the
            player score gets increases by 1
             **/
            if (playerMove.get().beats(opponentMove.get())) {
                setWinner(true);
                opponenet.setWinner(false);
                setScore(getScore() + 1);

                /** If both players have made moves, and the opponent beats player, opponent wins, player loses, and the
                 opponent score gets increases by 1
                 **/
            } else if (opponentMove.get().beats(playerMove.get())) {
                opponenet.setWinner(true);
                setWinner(false);
                opponenet.setScore(opponenet.getScore() + 1);

                 // If it's a tie, both players setWinner equals false
            } else {
                setWinner(false);
                opponenet.setWinner(false);
            }
        }
    }
    public abstract void chooseMove();
}
