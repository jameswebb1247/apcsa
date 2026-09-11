/**
 * MuralPainter is a new subclass of PainterPlus that paints one
 * component of the neighborhood asphalt art: a "Community Compass"
 * mural on an 8x8 grid.
 *
 * ----- Problem-solving process -----
 * 1. Understand the problem: the art should feel welcoming, work as a
 *    real safety-oriented street mural (bright, high-contrast border),
 *    and symbolize the neighborhood coming together from every
 *    direction toward a shared center.
 * 2. Plan / decompose: break the mural into three independent
 *    components, each handled by its own method (decomposition):
 *      a) a bright safety border around the whole grid
 *      b) a two-color woven/checkered field representing many
 *         different people crossing paths
 *      c) a solid "hub" of color at the very center representing the
 *         community meeting point
 * 3. Algorithm for each component combines:
 *      - sequencing:  paintCommunityMural() runs the three components
 *                     in a fixed order so later layers (the hub) sit on
 *                     top of the earlier ones.
 *      - iteration:   nested for loops walk every (row, col) square of
 *                     the grid (or the relevant sub-region of it).
 *      - selection:   if/else logic decides, per square, whether it is
 *                     part of the border, the hub, or which of the two
 *                     weave colors it should get.
 * 4. Implement, then test by running MuralPainter on an 8x8 grid and
 *    inspecting the printed / exported grid.
 */
public class MuralPainter extends PainterPlus
{
    public MuralPainter(int gridSize)
    {
        super(gridSize);
    }

    /**
     * Paints the whole mural by running each component in sequence.
     * The hub is painted last so it is not overwritten by the weave.
     */
    public void paintCommunityMural(String borderColor, String weaveColorA, String weaveColorB, String hubColor)
    {
        paintSafetyBorder(borderColor);
        paintWeaveField(weaveColorA, weaveColorB);
        paintCommunityHub(hubColor);
    }

    /**
     * Component 1: paints a solid border around the outside edge of the
     * grid, the way real crosswalk / intersection asphalt art uses a
     * bright frame for visibility.
     *
     * Iteration: nested loops visit every square on the grid.
     * Selection: a square is only painted if it lies on the outer edge.
     */
    public void paintSafetyBorder(String color)
    {
        changeColor(color);
        int size = getGridSize();
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                boolean onBorder = (row == 0 || row == size - 1 || col == 0 || col == size - 1);
                if (onBorder)
                {
                    moveTo(row, col);
                    paint();
                }
            }
        }
    }

    /**
     * Component 2: fills the interior of the grid (excluding the border
     * and the center hub) with a two-color woven pattern.
     *
     * Iteration: nested loops walk the interior squares.
     * Selection: (row + col) % 2 alternates between the two colors,
     * and a second check skips the squares reserved for the hub.
     */
    public void paintWeaveField(String colorA, String colorB)
    {
        int size = getGridSize();
        int mid = size / 2;
        for (int row = 1; row < size - 1; row++)
        {
            for (int col = 1; col < size - 1; col++)
            {
                boolean isHubSquare = (row == mid - 1 || row == mid) && (col == mid - 1 || col == mid);
                if (!isHubSquare)
                {
                    if ((row + col) % 2 == 0)
                    {
                        changeColor(colorA);
                    }
                    else
                    {
                        changeColor(colorB);
                    }
                    moveTo(row, col);
                    paint();
                }
            }
        }
    }

    /**
     * Component 3: paints the 2x2 block of squares at the exact center
     * of the grid, symbolizing the neighborhood's shared meeting point.
     *
     * Iteration: a small nested loop over the 2x2 center block.
     */
    public void paintCommunityHub(String color)
    {
        changeColor(color);
        int size = getGridSize();
        int mid = size / 2;
        for (int row = mid - 1; row <= mid; row++)
        {
            for (int col = mid - 1; col <= mid; col++)
            {
                moveTo(row, col);
                paint();
            }
        }
    }
}
