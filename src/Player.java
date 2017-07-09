import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Anson on 9/7/2017.
 */
public class Player {

  private final Game game;
  private final Colour colour;
  private final boolean isComputer;

  public Player(Game game, Colour colour, boolean isComputer) {
    this.game = game;
    this.colour = colour;
    this.isComputer = isComputer;
  }

  public Colour getColour() {
    return colour;
  }

  public boolean isComputer() {
    return isComputer;
  }

  public Set<Square> getPieces() {
    return game.getBoard().getPieces(colour);
  }

  public Set<Move> getValidMoves() {
    return game.getBoard().getValidMoves(colour);
  }

  public void makeMove() {
    // TODO implement Player.makeMove
    Move move;
    if (isComputer) {
      // Find optimal moves
      MoveNode tree = new MoveNode(game.getBoard(), colour);
      List<Move> optimal = tree.getOptimal();

      move = optimal.get((int) (Math.random() * (optimal.size() - 1)));


    } else {
      // Read standard input
      String san = null;
      // Parse move

      move = game.parseMove(san);
    }

    game.applyMove(move);

  }

}
