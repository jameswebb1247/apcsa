public class StringPainter extends PainterPlus {

  public StringPainter() {
    super();
  }

  /* paints every other square so it looks like a dashed
     string instead of a solid bar */
  public void paintDashedLine(int length) {
    if (isOnBucket()) {
      takeAllPaint();
    }
    for (int step = 0; step < length && canMove(); step++) {
      if (step % 2 == 0 && canPaint()) {
        paint(); // only paint on the even steps
      }
      move();
    }
  }
}
