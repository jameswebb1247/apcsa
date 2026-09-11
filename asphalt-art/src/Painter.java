/**
 * Painter simulates the "Painter" class provided by the Code.org Java Lab
 * environment. It represents a robot that stands on one square of a
 * square grid, faces one of four directions, and can paint the square
 * it is standing on with a named color.
 *
 * This local copy exists only so the project compiles and can be run
 * from the command line to preview the artwork as an HTML grid. When
 * pasting the design back into Code.org's Java Lab, this file is not
 * needed there -- Java Lab already supplies its own Painter class.
 */
public class Painter
{
    public static final int NORTH = 0;
    public static final int EAST = 1;
    public static final int SOUTH = 2;
    public static final int WEST = 3;

    private final int gridSize;
    private int row;
    private int col;
    private int direction;
    private String currentColor;
    private final String[][] canvas;
    private int paintedCount;

    // Places the painter at the top-left corner (0,0), facing north.
    public Painter(int gridSize)
    {
        this(gridSize, 0, 0);
    }

    public Painter(int gridSize, int row, int col)
    {
        this.gridSize = gridSize;
        this.row = row;
        this.col = col;
        this.direction = NORTH;
        this.currentColor = "black";
        this.canvas = new String[gridSize][gridSize];
        this.paintedCount = 0;
    }

    // Moves one square forward in the current facing direction, if possible.
    public void move()
    {
        if (!canMove())
        {
            return;
        }
        if (direction == NORTH) row--;
        else if (direction == SOUTH) row++;
        else if (direction == EAST) col++;
        else if (direction == WEST) col--;
    }

    // Returns true if moving forward would stay on the grid.
    public boolean canMove()
    {
        int nextRow = row;
        int nextCol = col;
        if (direction == NORTH) nextRow--;
        else if (direction == SOUTH) nextRow++;
        else if (direction == EAST) nextCol++;
        else if (direction == WEST) nextCol--;
        return nextRow >= 0 && nextRow < gridSize && nextCol >= 0 && nextCol < gridSize;
    }

    // Jumps directly to a square without needing to move/turn there.
    public void moveTo(int row, int col)
    {
        if (row < 0 || row >= gridSize || col < 0 || col >= gridSize)
        {
            throw new IllegalArgumentException("Square (" + row + ", " + col + ") is off the grid.");
        }
        this.row = row;
        this.col = col;
    }

    public void turnLeft()
    {
        direction = (direction + 3) % 4;
    }

    public void turnRight()
    {
        direction = (direction + 1) % 4;
    }

    // Paints the square the painter currently occupies with the current color.
    public void paint()
    {
        if (canvas[row][col] == null)
        {
            paintedCount++;
        }
        canvas[row][col] = currentColor;
    }

    public boolean isPainted()
    {
        return canvas[row][col] != null;
    }

    public void changeColor(String color)
    {
        currentColor = color;
    }

    public String getColor()
    {
        return currentColor;
    }

    public int getRow()
    {
        return row;
    }

    public int getColumn()
    {
        return col;
    }

    public int getGridSize()
    {
        return gridSize;
    }

    public int getPaintedCount()
    {
        return paintedCount;
    }

    public boolean isFacingNorth()
    {
        return direction == NORTH;
    }

    public boolean isFacingSouth()
    {
        return direction == SOUTH;
    }

    public boolean isFacingEast()
    {
        return direction == EAST;
    }

    public boolean isFacingWest()
    {
        return direction == WEST;
    }

    // Returns the color painted at (row, col), or null if it hasn't been painted.
    public String colorAt(int row, int col)
    {
        return canvas[row][col];
    }
}
