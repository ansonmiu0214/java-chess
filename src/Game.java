import java.util.Stack;

/**
 * Created by Anson on 9/7/2017.
 */
public class Game {

  private final Board board;
  private final Stack<Move> history;
  private Colour current;

  public Game(Board board) {
    assert(board != null);

    this.board = board;
    this.history = new Stack<>();
    this.current = Colour.WHITE;
  }

  public Board getBoard() {
    return board;
  }

  public Colour getCurrentPlayer() {
    return current;
  }

  public Move getLastMove() {
    return (history.isEmpty()) ? null : history.peek();
  }

  public void applyMove(Move move) {
    assert(move != null);

    // TODO optimise code for Game.applyMove

    Square from = move.getFrom();
    Square to = move.getTo();

    if (move.isCastle()) {
      // TODO implement Game.applyMove -- isCastle
    } else if (move.isCapture()) {

      to.setPiece(from.getPiece());
      from.clearPiece();

      if (move.isEnPassant()) {
        // TODO implement Game.applyMove -- isEnPassant

      }
    } else {
      // Normal movement

      to.setPiece(from.getPiece());
      from.clearPiece();

    }

    // Add move to history stack
    history.push(move);

    // Next colour
    current = current.getNext();

    // TODO implement Game.applyMove
  }

  public void unapplyMove() {
    Move move = getLastMove();

    if (move == null) {
      System.err.println("No more moves to unapply");
      return;
    }

    // TODO implement Game.unapplyMove

    // Indicate next player
    current = current.getNext();

    // Remove from history
    history.pop();
  }

  public boolean isFinished() {
    // TODO implement Game.isFinished
    return false;
  }

  public Colour getGameResult() {
    // TODO implement Game.getGameResult
    return null;
  }

  public Move parseMove(String san) {
    // TODO implement Game.parseMove
    return null;
  }

}
