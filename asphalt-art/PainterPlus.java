import org.code.neighborhood.*;

public class PainterPlus extends Painter {

  public PainterPlus() {
    super();
  }

  // no turnRight() built in, so just turn left 3 times instead
  public void turnRight() {
    turnLeft();
    turnLeft();
    turnLeft();
  }

  /* grabs paint from a bucket until it's empty instead of
     just taking one unit and moving on */
  public void takeAllPaint() {
    while (isOnBucket()) {
      takePaint();
    }
  }

  // grabs paint if standing on a bucket, shared by every subclass below
  public void checkForBucket() {
    if (isOnBucket()) {
      takeAllPaint();
    }
  }

  // paints the current space if there is paint left to use
  public void paintIfHasPaint(String color) {
    if (hasPaint()) {
      paint(color);
    }
  }
}
