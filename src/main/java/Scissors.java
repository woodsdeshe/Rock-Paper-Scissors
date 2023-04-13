public class Scissors implements Move{
    @Override
    public boolean beats(Move move) {
        /*
         beats method checks if the move argument passed in is an instance of the Paper
         class. If so, then it'll return true and make Scissors beat Paper
        */
        return move instanceof Paper;
    }
}
