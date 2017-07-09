import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;

/**
 * Created by Anson on 9/7/2017.
 */
public class Pawn extends Piece {

  public Pawn(Colour colour) {
    super(colour);
  }

  @Override
  public Set<Move> getValidMoves(Board board, Square square) {

    Set<Move> moves = new HashSet<>();
    int curr_x = square.getCoord_x();
    int curr_y = square.getCoord_y();
    BiFunction<Integer, Integer, Integer> direction = getColour().getDirection();

    Square adv_1 = board.getSquare(curr_x, direction.apply(curr_y, 1));
    Square adv_2 = board.getSquare(curr_x, direction.apply(curr_y, 2));
    Square capt_l = board.getSquare(curr_x - 1, direction.apply(curr_y, 1));
    Square capt_r = board.getSquare(curr_x + 1, direction.apply(curr_y, 1));

    // 1-step forward
    if (adv_1 != null) {
      if (adv_1.occupiedBy() == null) {
        moves.add(new Move(square, adv_1));
      }
    }

    // 2-step forward
    if (adv_2 != null) {
      if (adv_2.occupiedBy() == null) {
        moves.add(new Move(square, adv_2));
      }
    }

    // TODO implement Pawn.getValidMoves(Board , Square ) -- captures and en passant

    return moves;
  }

  @Override
  public String toString() {
    return "Pawn";
  }

}
