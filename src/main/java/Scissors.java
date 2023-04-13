public class Scissors implements Move{
    @Override
    public boolean beats(Move move) {
        return move instanceof Paper;
    }
}
