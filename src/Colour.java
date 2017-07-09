import java.util.function.BiFunction;

/**
 * Created by Anson on 9/7/2017.
 */
public enum Colour {
  WHITE((x, y) -> x + y),
  BLACK((x, y) -> x - y),
  NONE(null);

  private final BiFunction<Integer, Integer, Integer> direction;
  private Colour next;

  static {
    WHITE.next = BLACK;
    BLACK.next = WHITE;
    NONE.next = NONE;
  }

  Colour(BiFunction<Integer, Integer, Integer> direction) {
    this.direction = direction;
  }

  public Colour getNext() {
    return next;
  }

  public BiFunction<Integer, Integer, Integer> getDirection() {
    return direction;
  }
}
