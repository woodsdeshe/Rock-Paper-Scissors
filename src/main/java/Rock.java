public class Rock implements Move{

    @Override
    public boolean beats(Move move) {
        /*
         beats method checks if the move argument passed in is an instance of the Scissors
         class. If so, then it'll return true and make Rock beat Scissors
        */
        return move instanceof Scissors;
    }
}
