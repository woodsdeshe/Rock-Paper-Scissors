public class Paper implements Move{
    @Override
    public boolean beats(Move move) {
        /*
         beats method checks if the move argument passed in is an instance of the Rock
         class. If so, then it'll return true and make Paper beat Rock
        */
        return move instanceof Rock;
    }
}
