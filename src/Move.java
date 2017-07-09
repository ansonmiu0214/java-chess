/**
 * Created by Anson on 9/7/2017.
 */
public class Move {

  private final Square from;
  private final Square to;
  private final boolean isCapture;
  private final boolean isEnPassant;
  private final boolean isCastle;

  public Move(Square from, Square to, boolean isCapture, boolean isEnPassant, boolean isCastle) {
    assert(from != null && to != null);

    this.from = from;
    this.to = to;
    this.isCapture = isCapture;
    this.isEnPassant = isEnPassant;
    this.isCastle = isCastle;
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

  public String getSAN() {
    // TODO implement Move.getSAN
    return null;
  }
}
