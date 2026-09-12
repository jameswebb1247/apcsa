public class BalloonPainter extends PainterPlus {

  // starts at the top-left corner, facing east, with plenty of paint
  public BalloonPainter() {
    super(0, 0, "East", 0);
    setPaint(100);
  }

  /* walks forward across the row, grabbing paint from any bucket
     it crosses, and fills in the balloon color as it goes */
  public void paintRow(String color) {
    while (canMove()) {
      checkForBucket();
      paintIfHasPaint(color);
      move();
    }
    checkForBucket();
    paintIfHasPaint(color); // the loop stops one space short of the wall
  }
}
