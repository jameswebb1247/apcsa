# Balloon Neighborhood Runner — Asphalt Art

An AP CSA "Neighborhood" project (`org.code.neighborhood`) that paints
one big green balloon, roughly centered, with a white string that
curves gently as it hangs down. Built for Code.org's Java Lab. Needs
a grid at least 8 columns wide by 8 rows tall.

## Files

- `PainterPlus.java` — the starter class (extends `Painter`) with
  shared helpers used by every painter below: `turnRight()` (there's
  only `turnLeft()` in the base API), `takeAllPaint()` (refill fully
  from a bucket instead of one unit at a time), `checkForBucket()`
  (refill only if standing on a bucket), `paintIfHasPaint(color)`
  (paint only if there's paint left to use), and a constructor that
  takes a starting `(x, y, direction, paint)` so subclasses can pick
  their own spot instead of always starting at (0, 0).
- `BalloonPainter.java` — **new subclass of `PainterPlus`**. Takes an
  `(x, y)` starting spot, faces east with 100 units of paint, and
  fills a `size x size` square by snaking back and forth row by row
  (like mowing a lawn), so the balloon can be as big as you want.
  Method: `paintBalloon(int size, String color)`.
- `StringPainter.java` — **second new subclass of `PainterPlus`**.
  Takes an `(x, y)` starting spot, faces south with 100 units of
  paint, and paints straight down but nudges a step sideways every
  other move, alternating left and right, so the string comes out
  with a bit of a wave instead of a perfectly straight line. Method:
  `paintCurvedString(int length, String color)`.
- `NeighborhoodRunner.java` — creates one 4x4 `BalloonPainter` (green)
  centered near the top of the grid and one `StringPainter` (white)
  hanging below it. No `World` object needed in code.

Two separate subclasses of `PainterPlus` — rather than one subclass
extending another — because the balloon and the string are
independent components, each with its own starting position and
direction, not a specialization of one another. Both take their
`(x, y)` as constructor arguments instead of hardcoding one spot, so
`NeighborhoodRunner` can place either one wherever it wants.

Both start with `setPaint(100)` in their constructor instead of
relying only on paint buckets, since a fresh `Painter` starts with 0
paint and `hasPaint()` would otherwise stay false forever.

## Problem-solving process

1. **Understand**: a bigger balloon means more than 4 cells, so the
   old "trace the 4 corners" trick doesn't scale — it needed a real
   fill algorithm. A grid can't draw an actual curve either, since a
   Painter only moves in the 4 cardinal directions, so "a bit of a
   curve" has to be faked with small sideways steps.
2. **Decompose**: pull the two moves every painter needs — grab paint
   from a bucket, paint only if there's paint to use — up into
   `PainterPlus`. Inside `BalloonPainter`, pull "step down to the next
   row and flip direction" into its own `dropDownARow` method so the
   main loop just describes rows, not turns.
3. **Algorithms** (two distinct ones, each combining sequencing,
   selection, and iteration):
   - `BalloonPainter.paintBalloon(size, color)` — nested loops fill
     every row of the square, alternating the direction each row
     (a boustrophedon/"lawnmower" pattern) so the painter never has to
     walk back over painted ground.
   - `StringPainter.paintCurvedString(length, color)` — a `for` loop
     moves south, and every other step calls `nudgeSideways` to step
     one space east or west (alternating which side) before
     continuing south, faking a curve out of straight-line moves.
4. **Test**: run in Code.org's Java Lab and check the preview; adjust
   the starting coordinates, `size`, colors, or `paintCurvedString`'s
   length as needed. This layout was also checked against a local
   simulation of the documented API before handing it off.

## Using it

In Java Lab, make sure each file below fully replaces whatever is
already in the matching tab — select-all and delete the old content
before pasting, don't paste on top of it. The filename has to match
the class name exactly (`BalloonPainter.java`, not `Ballonpainter.java`
or similar), or you'll get a wall of "class, interface, or enum
expected" errors.

- `PainterPlus.java`
- `BalloonPainter.java`
- `StringPainter.java`
- `NeighborhoodRunner.java`

Note: `org.code.neighborhood` is Code.org's own library, so this code
can only be compiled and run inside Java Lab — it isn't available to
compile from the command line here.
