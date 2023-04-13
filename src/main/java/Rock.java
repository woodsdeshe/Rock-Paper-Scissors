public class Rock implements Move{

    @Override
    public boolean beats(Move move) {
        return move instanceof Scissors;
    }
}
