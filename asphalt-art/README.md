# Balloon Neighborhood Runner — Asphalt Art

An AP CSA "Neighborhood" project (`org.code.neighborhood`) that paints a
balloon-themed mural: solid balloon rows with dashed strings hanging
below them. Built for Code.org's Java Lab / World editor.

## Files

- `PainterPlus.java` — the starter class (extends `Painter`) with two
  general-purpose helpers used by every painter: `turnRight()` (there's
  only `turnLeft()` in the base API) and `takeAllPaint()` (refill fully
  from a bucket instead of one unit at a time).
- `BalloonPainter.java` — **new subclass of `PainterPlus`**. Paints the
  "balloons": a solid row of color, refilling from any bucket it
  crosses. Method: `paintRow()`.
- `StringPainter.java` — **second new subclass of `PainterPlus`**.
  Paints the "strings": a dashed line (every other square) hanging
  below a balloon. Method: `paintDashedLine(int length)`.
- `NeighborhoodRunner.java` — creates the `World` and one of each
  painter, then runs both.

Two separate subclasses of `PainterPlus` — rather than one subclass
extending another — because balloons and strings are independent
components with their own start position (set per-class in the World
editor), not a specialization of one another.

## Problem-solving process

1. **Understand**: a balloon reads as solid color; a string reads as a
   thin, broken line hanging below it.
2. **Decompose**: one class per visual component (`BalloonPainter`,
   `StringPainter`), each with its own small helper method, instead of
   one long method doing everything.
3. **Algorithms** (two distinct ones, each combining sequencing,
   selection, and iteration):
   - `BalloonPainter.paintRow()` — loops with `while (canMove())`,
     refilling paint only when `isOnBucket()` and painting only when
     `canPaint()`, moving forward each pass.
   - `StringPainter.paintDashedLine(length)` — loops a fixed number of
     times with a `for` loop, painting only on even steps
     (`step % 2 == 0`) to create the dashed pattern.
4. **Test**: run in Code.org's Java Lab against the World you've laid
   out (balloon painter start squares, string painter start squares,
   and paint buckets), and adjust bucket placement/colors or
   `paintDashedLine`'s length as needed.

## Using it

Paste these four files into your Code.org Java Lab project (they
replace whatever `PainterPlus.java` / `NeighborhoodRunner.java` you
already have there), place a `BalloonPainter` and a `StringPainter` in
the World editor with paint buckets nearby, and run.

Note: `org.code.neighborhood` is Code.org's own library, so this code
can only be compiled and run inside Java Lab — it isn't available to
compile from the command line here.
