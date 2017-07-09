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

  public Colour getCurrentPlayer() {
    return current;
  }

  public Move getLastMove() {
    return (history.isEmpty()) ? null : history.pop();
  }

  public void applyMove(Move move) {
    assert(move != null);

    // Add move to history stack
    history.push(move);

    // Next colour
    current = current.getNext();

    // TODO implement Game.applyMove
  }

  public void unapplyMove() {
    Move move = getLastMove();

    if (move == null) {
      System.err.println("No more moves to unaply");
      return;
    }

    current = current.getNext();

    // TODO implement Game.unapplyMove
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
