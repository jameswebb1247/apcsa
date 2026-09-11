/**
 * PainterPlus extends Painter with a few general-purpose helper methods
 * that are useful no matter what design is being painted (they don't
 * belong to any one component of the mural). Design-specific behavior
 * belongs in further subclasses of PainterPlus, such as MuralPainter.
 *
 * This is the class described in the assignment as coming from the
 * Backpack / studio.code.org starter project.
 */
public class PainterPlus extends Painter
{
    public PainterPlus(int gridSize)
    {
        super(gridSize);
    }

    public PainterPlus(int gridSize, int row, int col)
    {
        super(gridSize, row, col);
    }

    // Turns the painter 180 degrees by turning right twice.
    public void turnAround()
    {
        turnRight();
        turnRight();
    }

    // Moves forward one square and paints it, only if a move is possible.
    public void moveAndPaint()
    {
        if (canMove())
        {
            move();
            paint();
        }
    }

    // Paints every square in the given row, from column 0 to the last column.
    public void paintEntireRow(int row, String color)
    {
        changeColor(color);
        for (int col = 0; col < getGridSize(); col++)
        {
            moveTo(row, col);
            paint();
        }
    }

    // Paints every square in the given column, from row 0 to the last row.
    public void paintEntireColumn(int col, String color)
    {
        changeColor(color);
        for (int row = 0; row < getGridSize(); row++)
        {
            moveTo(row, col);
            paint();
        }
    }
}
