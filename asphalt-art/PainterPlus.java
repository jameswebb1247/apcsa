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
}
