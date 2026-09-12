# Balloon Neighborhood Runner — Asphalt Art

An AP CSA "Neighborhood" project (`org.code.neighborhood`) that paints a
balloon-themed mural: a solid balloon row across the top with a dashed
string hanging down from it. Built for Code.org's Java Lab.

## Files

- `PainterPlus.java` — the starter class (extends `Painter`) with
  shared helpers used by every painter below: `turnRight()` (there's
  only `turnLeft()` in the base API), `takeAllPaint()` (refill fully
  from a bucket instead of one unit at a time), `checkForBucket()`
  (refill only if standing on a bucket), `paintIfHasPaint(color)`
  (paint only if there's paint left to use), and a constructor that
  takes a starting `(x, y, direction, paint)` so subclasses can pick
  their own spot instead of always starting at (0, 0).
- `BalloonPainter.java` — **new subclass of `PainterPlus`**. Starts at
  (0, 0) facing east with 100 units of paint, and paints the
  "balloons": a solid row of color, refilling from any bucket it
  crosses. Method: `paintRow(String color)`.
- `StringPainter.java` — **second new subclass of `PainterPlus`**.
  Starts at (0, 1) — one row below the balloons — facing south with
  100 units of paint, and paints the "strings": a dashed line (every
  other square) hanging down. Method:
  `paintDashedLine(int length, String color)`.
- `NeighborhoodRunner.java` — creates one of each painter and runs
  them. No `World` object needed in code.

Two separate subclasses of `PainterPlus` — rather than one subclass
extending another — because balloons and strings are independent
components, each with its own starting position and direction, not a
specialization of one another.

Both start with `setPaint(100)` in their constructor instead of
relying only on paint buckets, since a fresh `Painter` starts with 0
paint and `hasPaint()` would otherwise stay false forever.

They also start at different coordinates and face different
directions (balloon painter heads east across a row, string painter
heads south down a column) — earlier both defaulted to the same spot
facing the same way, so they retraced the same path on top of each
other instead of painting two separate parts of the mural.

## Problem-solving process

1. **Understand**: a balloon reads as solid color; a string reads as a
   thin, broken line hanging below it — and the two need to be in
   different places or they'll paint over each other.
2. **Decompose**: pull the two moves every painter needs — grab paint
   from a bucket, paint only if there's paint to use — up into
   `PainterPlus`, so each subclass's method only has to describe its
   own pattern, not repeat that bookkeeping.
3. **Algorithms** (two distinct ones, each combining sequencing,
   selection, and iteration):
   - `BalloonPainter.paintRow(color)` — loops with `while (canMove())`,
     refilling and painting every space, moving forward each pass.
   - `StringPainter.paintDashedLine(length, color)` — loops a fixed
     number of times with a `for` loop, painting only on even steps
     (`step % 2 == 0`) to create the dashed pattern.
4. **Test**: run in Code.org's Java Lab and check the preview; adjust
   the starting coordinates, colors, or `paintDashedLine`'s length as
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
compile from the command line here.
