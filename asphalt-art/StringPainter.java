public class StringPainter extends PainterPlus {

  // starts below a balloon, facing south, with plenty of paint
  public StringPainter(int x, int y) {
    super(x, y, "South", 0);
    setPaint(100);
  }

  /* paints a solid line straight down so it reads as a taut
     string instead of a broken, dashed one */
  public void paintString(int length, String color) {
    for (int step = 0; step < length && canMove(); step++) {
      paintIfHasPaint(color);
      move();
    }
  }
}
