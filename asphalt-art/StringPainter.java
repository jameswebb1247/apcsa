public class StringPainter extends PainterPlus {

  // starts one row below the balloons, facing south, with plenty of paint
  public StringPainter() {
    super(0, 1, "South", 0);
    setPaint(100);
  }

  /* paints every other space so the string hanging off a
     balloon looks dashed instead of a solid bar */
  public void paintDashedLine(int length, String color) {
    checkForBucket();
    for (int step = 0; step < length && canMove(); step++) {
      if (step % 2 == 0) {
        paintIfHasPaint(color);
      }
      move();
    }
  }
}
