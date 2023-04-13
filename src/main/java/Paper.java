public class Paper implements Move{
    @Override
    public boolean beats(Move move) {
        return move instanceof Rock;
    }
}
