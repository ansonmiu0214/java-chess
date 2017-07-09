import java.util.function.BiFunction;

/**
 * Created by Anson on 9/7/2017.
 */
public enum Colour {

  WHITE("White", (x, y) -> x + y),
  BLACK("Black", (x, y) -> x - y);

  private final String name;
  private final BiFunction<Integer, Integer, Integer> direction;
  private Colour next;

  static {
    WHITE.next = BLACK;
    BLACK.next = WHITE;
  }

  Colour(String name, BiFunction<Integer, Integer, Integer> direction) {
    this.name = name;
    this.direction = direction;
  }

  public Colour getNext() {
    return next;
  }

  public BiFunction<Integer, Integer, Integer> getDirection() {
    return direction;
  }

  @Override
  public String toString() {
    return name;
  }

}
