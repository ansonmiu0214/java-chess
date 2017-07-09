import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Anson on 9/7/2017.
 */
public class MoveNode {

  private final Board board;
  private final Colour original;
  private final Colour current;
  private Move move;
  private int score;

  public MoveNode(Move move, Board board, Colour original, Colour current) {
    this.move = move;
    this.board = board;
    this.original = original;
    this.current = current;
    this.score = 0;
  }

  public MoveNode(Board board, Colour original) {
    this(null, board, original, original);
  }

  public MoveNode(Move move) {
    this(move, null, null, null);
  }

  public Move getMove() {
    return move;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public List<Move> getOptimal() {

    Set<Move> validMoves = board.getValidMoves(current);
    Set<MoveNode> options = new HashSet<>();

    for (Move move : validMoves) {
      options.add(explore(move, board, original, current));
    }

    setScore(options.stream().map(MoveNode::getScore).reduce(0, Math::max));

    return options.stream()
            .filter(x -> x.getScore() == score)
            .map(MoveNode::getMove)
            .collect(Collectors.toList());
  }

  private MoveNode explore(Move move, Board board, Colour original, Colour current) {
    MoveNode node = new MoveNode(move);

    board.applyMove(move);
    Colour next = current.getNext();

    if (board.isFinished() != null) {
      node.setScore(board.getResult(original));
    } else {
      Set<Move> validMoves = board.getValidMoves(next);
      Set<MoveNode> options = new HashSet<>();
      for (Move nextMove : validMoves) {
        options.add(explore(nextMove, board, original, next));
      }

      node.setScore(options.stream().map(MoveNode::getScore).reduce(0, (x, y) -> x + y));
    }

    return node;
  }

}
