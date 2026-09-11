/*
 * BalloonPainter paints the "balloons" component of the mural: solid
 * bands of color that read as round balloons from a distance.
 *
 * Problem-solving process:
 *  1. Understand: a balloon reads clearly if its whole row is filled
 *     in solid color, with no gaps.
 *  2. Decompose: separate "getting paint" from "painting a row" so
 *     each idea is its own small method instead of one long block.
 *  3. Plan the algorithm (paintRow):
 *       - iteration: keep moving forward one square at a time until
 *         the edge of the world is reached (while canMove()).
 *       - selection: at each square, only refill paint if standing on
 *         a bucket, and only paint if there is paint left to use.
 *       - sequencing: refill, then paint, then move, in that order,
 *         repeated by the loop.
 *  4. Test in the World editor and adjust bucket placement if a
 *     square is skipped.
 */
public class BalloonPainter extends PainterPlus {

  // Creates the BalloonPainter object
  public BalloonPainter() {
    super();
  }

  // Fills an entire row solid, refilling from any bucket it passes.
  public void paintRow() {
    // Loop until the painter reaches the edge of the world (iteration).
    while (canMove()) {
      paintHere();
      move();
    }
    // The loop above stops one square before the far edge, so handle
    // the last square in the row separately (sequencing).
    paintHere();
  }

  // Refills paint if needed, then paints the current square if possible.
  // Pulled out as its own method so paintRow() stays easy to read.
  private void paintHere() {
    if (isOnBucket()) {
      takeAllPaint();
    }
    if (canPaint()) {
      paint();
    }
  }
}
