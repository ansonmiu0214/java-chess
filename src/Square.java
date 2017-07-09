/**
 * Created by Anson on 9/7/2017.
 */
public class Square {

  private final int coord_x;
  private final int coord_y;
  private Piece piece;

  public Square(int coord_x, int coord_y, Piece piece) {
    this.coord_x = coord_x;
    this.coord_y = coord_y;
    this.piece = piece;
  }

  public Square(int coord_x, int coord_y) {
    this(coord_x, coord_y, null);
  }

  public int getCoord_x() {
    return coord_x;
  }

  public int getCoord_y() {
    return coord_y;
  }

  public Piece getPiece() {
    return piece;
  }

  public void setPiece(Piece piece) {
    this.piece = piece;
  }

  public void clearPiece() {
    setPiece(null);
  }

  public Colour occupiedBy() {
    assert(piece != null);

    return piece.getColour();
  }

}
