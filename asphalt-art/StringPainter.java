/*
 * StringPainter paints the "strings" component of the mural: a dashed
 * line hanging below a balloon, made of every other square instead of
 * a solid fill. This is a different algorithm from BalloonPainter's
 * solid row, even though both are simple loops.
 *
 * Problem-solving process:
 *  1. Understand: a string should look thin and broken, not solid, so
 *     it reads as a line rather than another balloon.
 *  2. Decompose: reuse takeAllPaint() from PainterPlus instead of
 *     duplicating that logic here.
 *  3. Plan the algorithm (paintDashedLine):
 *       - iteration: count moves with a for loop instead of moving
 *         until the edge, since a string only needs to be so long.
 *       - selection: only paint on every other square (step % 2 == 0),
 *         which is what turns a solid fill into a dashed pattern.
 *       - sequencing: check/paint happens before the move each pass,
 *         so the starting square is included in the pattern.
 *  4. Test with a few different lengths in the World editor.
 */
public class StringPainter extends PainterPlus {

  // Creates the StringPainter object
  public StringPainter() {
    super();
  }

  // Paints a dashed line "length" squares long: paint, skip, paint, skip...
  public void paintDashedLine(int length) {
    if (isOnBucket()) {
      takeAllPaint();
    }
    for (int step = 0; step < length && canMove(); step++) {
      // Only paint on even steps so the line comes out dashed, not solid.
      if (step % 2 == 0 && canPaint()) {
        paint();
      }
      move();
    }
  }
}
