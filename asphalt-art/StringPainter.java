public class StringPainter extends PainterPlus {

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
