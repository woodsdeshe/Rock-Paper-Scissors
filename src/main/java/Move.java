public interface Move {
    /*  Interface declares the beats method that takes in a Move object and move parameter. It is used to determine
    which move has won.
    */
    boolean beats(Move move);
}
