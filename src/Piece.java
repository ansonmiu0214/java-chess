import java.util.Set;

/**
 * Created by Anson on 9/7/2017.
 */
public abstract class Piece {

  private final Colour colour;

  public Piece(Colour colour) {
    assert(colour != Colour.NONE);
    this.colour = colour;
  }

  public Colour getColour() {
    return colour;
  }

  public abstract Set<Move> getValidMoves();

}
