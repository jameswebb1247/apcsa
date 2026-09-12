public class BalloonPainter extends PainterPlus {

  // starts wherever it's placed, facing east, with plenty of paint
  public BalloonPainter(int x, int y) {
    super(x, y, "East", 0);
    setPaint(100);
  }

  /* fills a size x size square by snaking back and forth across each
     row, like mowing a lawn, so the balloon can be any size */
  public void paintBalloon(int size, String color) {
    boolean headingEast = true;
    for (int row = 0; row < size; row++) {
      for (int col = 0; col < size; col++) {
        paintIfHasPaint(color);
        if (col < size - 1 && canMove()) {
          move();
        }
      }
      if (row < size - 1) {
        dropDownARow(headingEast);
        headingEast = !headingEast;
      }
    }
  }

  // steps down to the next row and flips to face the opposite direction
  public void dropDownARow(boolean wasHeadingEast) {
    if (wasHeadingEast) {
      turnRight(); // now facing south
      if (canMove()) {
        move();
      }
      turnRight(); // now facing west, ready for the next row
    } else {
      turnLeft(); // now facing south
      if (canMove()) {
        move();
      }
      turnLeft(); // now facing east, ready for the next row
    }
  }
}
