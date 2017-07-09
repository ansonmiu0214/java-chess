import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Anson on 9/7/2017.
 */
public class Board {

  public static final int PAWN_WHITE = 1;
  public static final int PAWN_BLACK = 6;
  static final int NUM_OF_ROWS = 8;

  private final Square[][] board;

  public Board() {
    this.board = new Square[NUM_OF_ROWS][NUM_OF_ROWS];

    for (int row = 0; row < NUM_OF_ROWS; ++row) {
      for (int col = 0; col < NUM_OF_ROWS; ++col) {

        // TODO optimise Board constructor

        if (row == 1) {
          // White pawns
          board[col][row] = new Square(col, row, new Pawn(Colour.WHITE));

        } else if (row == 6) {
          // Black pawns
          board[col][row] = new Square(col, row, new Pawn(Colour.BLACK));

        } else {
          // Blank
          board[col][row] = new Square(col, row, null);
        }

      }
    }

  }

  public Square getSquare(int coord_x, int coord_y) {
    return (isInBound(coord_x, coord_y)) ? board[coord_y][coord_x] : null;
  }

  public void applyMove(Move move) {
    assert(move != null);

    Square from = move.getFrom();
    Square to = move.getTo();

    if (move.isCastle()) {

      // TODO implement Board.applyMove -- isCastle

    } else {
      // Move pieces

      to.setPiece(from.getPiece());
      from.clearPiece();

      if (move.isEnPassant()) {
        // TODO implement Board.applyMove -- isEnPassant
      }
    }
  }

  public void unapplyMove(Move move) {
    assert(move != null);

    Square from = move.getFrom();
    Square to = move.getTo();

    if (move.isCastle()) {

      // TODO implement Board.unapplyMove -- isCastle

    } else {
      // Move pieces

      if (move.isCapture()) {
        // Restore piece
        Piece piece = move.getPiece();

        // TODO implement Board.unapplyMove -- isCapture

        if (move.isEnPassant()) {
          // TODO implement Board.unapplyMove -- isEnPassant
        }

      }
    }
  }

  private boolean isInBound(int coord_x, int coord_y) {
    return 0 <= coord_x && coord_x < NUM_OF_ROWS
            && 0 <= coord_y && coord_y < NUM_OF_ROWS;
  }

  public boolean isFinished() {
    // TODO implement Board.isFinished()
    return false;
  }

  public int getResult(Colour colour) {
    assert(colour != null);

    // TODO implement Board.getResult
    return 0;
  }

  public Set<Move> getValidMoves(Colour colour) {
    assert(colour != null);

    return getPieces(colour).stream()
            .flatMap(x -> x.getPiece().getValidMoves(this, x).stream())
            .collect(Collectors.toSet());
  }

  public Set<Square> getPieces(Colour colour) {
    assert(colour != null);

    Set<Square> pieces = new HashSet<>();
    for (int row = 0; row < NUM_OF_ROWS; ++row) {
      for (int col = 0; col < NUM_OF_ROWS; ++col) {
        Square square = board[row][col];
        if (square.getPiece().getColour() == colour) {
          pieces.add(square);
        }
      }
    }

    return pieces;
  }

}
