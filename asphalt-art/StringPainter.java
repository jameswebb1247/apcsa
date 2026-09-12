public class StringPainter extends PainterPlus {

  // starts below a balloon, facing south, with plenty of paint
  public StringPainter(int x, int y) {
    super(x, y, "South", 0);
    setPaint(100);
  }

  /* paints down but nudges a step sideways every other move,
     alternating sides, so the string comes out with a bit of a
     curve instead of a perfectly straight line */
  public void paintCurvedString(int length, String color) {
    boolean nudgeRight = true;
    for (int step = 0; step < length && canMove(); step++) {
      paintIfHasPaint(color);
      move();
      if (step % 2 == 1) {
        nudgeSideways(nudgeRight, color);
        nudgeRight = !nudgeRight;
      }
    }
  }

  // steps one space east or west, paints it, then turns back to face south
  public void nudgeSideways(boolean toTheRight, String color) {
    if (toTheRight) {
      turnLeft(); // south -> east
    } else {
      turnRight(); // south -> west
    }
    if (canMove()) {
      move();
      paintIfHasPaint(color);
    }
    if (toTheRight) {
      turnRight(); // back to facing south
    } else {
      turnLeft(); // back to facing south
    }
  }
}
