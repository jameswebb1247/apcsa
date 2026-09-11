import org.code.neighborhood.*;

/*
 * PainterPlus adds a couple of general-purpose helper moves that any
 * painter in the neighborhood might need, no matter what part of the
 * mural it ends up painting. Design-specific work belongs in the
 * subclasses (BalloonPainter, StringPainter), not here.
 */
public class PainterPlus extends Painter {

  // Creates the PainterPlus object
  public PainterPlus() {
    super();
  }

  // The Neighborhood API only gives us turnLeft(), so turn right by
  // turning left three times (a quarter turn short of a full circle).
  public void turnRight() {
    turnLeft();
    turnLeft();
    turnLeft();
  }

  // Picks up paint repeatedly while standing on a bucket, so the
  // painter leaves the bucket completely full instead of stopping
  // after just one takePaint() call.
  public void takeAllPaint() {
    while (isOnBucket()) {
      takePaint();
    }
  }
}
