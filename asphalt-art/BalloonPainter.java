public class BalloonPainter extends PainterPlus {

  // starts wherever it's placed, facing east, with plenty of paint
  public BalloonPainter(int x, int y) {
    super(x, y, "East", 0);
    setPaint(100);
  }

  /* traces a small 2x2 square so it reads as one round balloon
     instead of a stripe across the whole grid */
  public void paintBalloon(String color) {
    paintIfHasPaint(color);       // top-left corner
    if (canMove()) {
      move();
      paintIfHasPaint(color);     // top-right corner
    }
    turnRight();
    if (canMove()) {
      move();
      paintIfHasPaint(color);     // bottom-right corner
    }
    turnRight();
    if (canMove()) {
      move();
      paintIfHasPaint(color);     // bottom-left corner
    }
  }
}
