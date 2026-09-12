public class BalloonPainter extends PainterPlus {

  public BalloonPainter() {
    super();
  }

  /* fills a whole row solid so it reads as one balloon
     instead of a bunch of separate squares */
  public void paintRow() {
    while (canMove()) {
      paintHere();
      move();
    }
    paintHere(); // the loop stops one square short of the edge
  }

  // refills paint if it's on a bucket, then paints if it has any
  private void paintHere() {
    if (isOnBucket()) {
      takeAllPaint();
    }
    if (canPaint()) {
      paint();
    }
  }
}
