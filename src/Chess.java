import java.util.List;

/**
 * Created by Anson on 9/7/2017.
 */
public class Chess {

  public static void main(String[] args) {
    Game game = new Game(new Board());

    Player white = new Player(game, Colour.WHITE, false);
    Player black = new Player(game, Colour.BLACK, true);

    if (!game.isFinished()) {
      System.out.println(game.getBoard());

      MoveNode node = new MoveNode(game.getBoard(), Colour.WHITE);
      List<Move> optimal = node.getOptimal();
    }
  }

}
