public class BalloonPainter extends PainterPlus {

  public BalloonPainter() {
    super();
  }

  /* fills a whole row with one color so it reads as one balloon
     instead of a bunch of separate squares */
  public void paintRow(String color) {
    while (canMove()) {
      paintHere(color);
      move();
    }
    paintHere(color); // the loop stops one square short of the edge
  }

  // refills paint if it's on a bucket, then paints if it has any
  private void paintHere(String color) {
    if (isOnBucket()) {
      takeAllPaint();
    }
    if (hasPaint()) {
      paint(color);
    }
  }
}
