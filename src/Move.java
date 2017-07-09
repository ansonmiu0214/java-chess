/**
 * Created by Anson on 9/7/2017.
 */
public class Move {

  private final Square from;
  private final Square to;
  private final boolean isCapture;
  private final boolean isEnPassant;
  private final boolean isCastle;
  private final Piece piece;

  public Move(Square from, Square to) {
    this(from, to, false, false, false, null);
  }

  public Move(Square from, Square to, boolean isCapture, boolean isEnPassant, boolean isCastle, Piece piece) {
    assert(from != null && to != null);

    this.from = from;
    this.to = to;
    this.isCapture = isCapture;
    this.isEnPassant = isEnPassant;
    this.isCastle = isCastle;
    this.piece = piece;
  }

  public Square getFrom() {
    return from;
  }

  public Square getTo() {
    return to;
  }

  public boolean isCapture() {
    return isCapture;
  }

  public boolean isEnPassant() {
    return isEnPassant;
  }

  public boolean isCastle() {
    return isCastle;
  }

  public Piece getPiece() {
    return piece;
  }

  public String getSAN() {
    StringBuilder sb = new StringBuilder();

    if (isCastle()) {

    } else if (isEnPassant()) {
      // TODO implement Move.getSAN -- isEnPassant

    } else if (isCapture()) {
      sb.append(from.toString().charAt(0));
      sb.append('x');
      sb.append(to.toString());

    } else {
      sb.append(from.toString());
      sb.append(to.toString());

    }

    return sb.toString();
  }
}
