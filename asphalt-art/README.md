# Community Compass Mural — 8x8 Asphalt Art

An AP CSA "Painter" project that designs a neighborhood asphalt art mural
on an 8x8 grid, built around `PainterPlus` (the Code.org starter class
imported from the Backpack).

## Files

- `src/Painter.java` — local stand-in for the Code.org-provided `Painter`
  engine class (grid, position, direction, color, paint). Not needed
  inside Code.org's Java Lab, which already supplies its own; it's here
  so this project compiles and runs from the command line.
- `src/PainterPlus.java` — the imported starter class (extends `Painter`)
  with general-purpose helper methods (`turnAround`, `moveAndPaint`,
  `paintEntireRow`, `paintEntireColumn`).
- `src/MuralPainter.java` — **new subclass of `PainterPlus`** written for
  this project. It implements the actual mural design as three
  decomposed components (border, weave field, center hub).
- `src/AsphaltArtDriver.java` — builds an 8x8 `MuralPainter`, paints the
  mural, prints a text preview, and exports `mural.html` so the result
  can be viewed in a browser.

## Design

A "Community Compass": a bright orange safety border (like a real
crosswalk mural), a teal/gold woven interior representing many different
people crossing paths, and a red 2x2 hub at the exact center
representing the neighborhood's shared meeting point.

## Problem-solving process

1. **Understand**: the mural should be visually striking, safety-minded
   (high-contrast border), and symbolize community members converging
   from every direction.
2. **Decompose**: split the design into three independent components,
   one method each — `paintSafetyBorder`, `paintWeaveField`,
   `paintCommunityHub` — combined in `paintCommunityMural`.
3. **Algorithm**: each component uses
   - **sequencing** — the three components are painted in a fixed order
     so the hub is layered on top last;
   - **iteration** — nested `for` loops walk the grid (or the relevant
     sub-region);
   - **selection** — `if`/`else` logic decides, per square, whether it's
     on the border, part of the center hub, or which of two weave
     colors it gets.
4. **Test**: run `AsphaltArtDriver`, check the printed grid and the
   exported `mural.html`.

## Run it

```
cd asphalt-art/src
javac *.java
java AsphaltArtDriver
```

Open the generated `mural.html` in a browser to see the finished mural.

## Using this in Code.org Java Lab

Only `PainterPlus.java` and `MuralPainter.java` need to be copied into
your Code.org project — Java Lab already provides its own `Painter`
class and canvas, so skip this repo's `Painter.java`. Create a `Painter`
(or however your project's canvas/painter is instantiated) with an 8x8
grid, then call:

```java
MuralPainter painter = new MuralPainter(8);
painter.paintCommunityMural("orange", "teal", "gold", "red");
```
