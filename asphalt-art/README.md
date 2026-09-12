# Balloon Neighborhood Runner — Asphalt Art

An AP CSA "Neighborhood" project (`org.code.neighborhood`) that paints
one green balloon — a small colored square with a solid white string
hanging straight down. Built for Code.org's Java Lab. Needs a grid at
least 2 columns wide by 6 rows tall.

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
  paints one "balloon": a solid 2x2 square instead of a stripe across
  the whole grid. Method: `paintBalloon(String color)`.
- `StringPainter.java` — **second new subclass of `PainterPlus`**.
  Takes an `(x, y)` starting spot, faces south with 100 units of
  paint, and paints a "string": a solid line straight down for a
  given number of spaces. Method:
  `paintString(int length, String color)`.
- `NeighborhoodRunner.java` — creates one `BalloonPainter` (green) and
  one `StringPainter` (white) hanging below it. No `World` object
  needed in code.

Two separate subclasses of `PainterPlus` — rather than one subclass
extending another — because the balloon and the string are
independent components, each with its own starting position and
direction, not a specialization of one another. Both take their
`(x, y)` as constructor arguments instead of hardcoding one spot,
so `NeighborhoodRunner` can place either one wherever it wants (or
add more of each without them landing on top of one another).

Both start with `setPaint(100)` in their constructor instead of
relying only on paint buckets, since a fresh `Painter` starts with 0
paint and `hasPaint()` would otherwise stay false forever.

## Problem-solving process

1. **Understand**: a full-width painted row reads as a banner, not a
   balloon, and a dashed line looks like broken blocks rather than a
   string on a grid this size — the shapes themselves needed to
   change, not just the bug that made nothing paint.
2. **Decompose**: pull the two moves every painter needs — grab paint
   from a bucket, paint only if there's paint to use — up into
   `PainterPlus`, so each subclass's method only has to describe its
   own shape, not repeat that bookkeeping.
3. **Algorithms** (two distinct ones, each combining sequencing,
   selection, and/or iteration):
   - `BalloonPainter.paintBalloon(color)` — a fixed sequence of
     paint/move/turn calls that traces the four corners of a 2x2
     square, each move guarded by `if (canMove())` (sequencing +
     selection).
   - `StringPainter.paintString(length, color)` — a `for` loop that
     paints and moves south a fixed number of times (iteration +
     selection, since `paintIfHasPaint` only paints when there's still
     paint left).
4. **Test**: run in Code.org's Java Lab and check the preview; adjust
   the starting coordinates, colors, or `paintString`'s length as
   needed.

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
compile from the command line here. The layout was checked with a
local simulation of the documented API instead.
