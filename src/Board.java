/**
 * Created by Anson on 9/7/2017.
 */
public class Board {

  public static final int NUM_OF_ROWS = 8;

  private final Square[][] board;

  public Board() {
    this.board = new Square[NUM_OF_ROWS][NUM_OF_ROWS];

  }

  public Square getSquare(int coord_x, int coord_y) {
    return board[coord_y][coord_x];
  }

  public void applyMove(Move move) {
    assert(move != null);

    // TODO implement Board.applyMove
  }

  public void unapplyMove(Move move) {
    assert(move != null);

    // TODO implement Board.unapplyMove
  }

  public boolean isInBound(int coord_x, int coord_y) {
    return 0 <= coord_x && coord_x < NUM_OF_ROWS
            && 0 <= coord_y && coord_y < NUM_OF_ROWS;
  }

}
