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

    // Apply move on board
    board.applyMove(move);

    // Add move to history stack
    history.push(move);

    // Next colour
    current = current.getNext();
  }

  public void unapplyMove() {
    Move move = getLastMove();

    // Move validation
    if (move == null) {
      System.err.println("No more moves to unapply");
      return;
    }

    // Unapply move on board
    board.unapplyMove(move);

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
