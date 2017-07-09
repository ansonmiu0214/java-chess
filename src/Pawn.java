import java.util.Set;

/**
 * Created by Anson on 9/7/2017.
 */
public class Pawn extends Piece {

  public Pawn(Colour colour) {
    super(colour);
  }

  @Override
  public Set<Move> getValidMoves(Board board, Square square) {
    // TODO implement Pawn.getValidMoves(Board , Square )
    return null;
  }

  @Override
  public String toString() {
    return "Pawn";
  }

}
