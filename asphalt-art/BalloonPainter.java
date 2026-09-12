public class BalloonPainter extends PainterPlus {

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
