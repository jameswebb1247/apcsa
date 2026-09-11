import java.io.FileWriter;
import java.io.IOException;

/**
 * Driver program: builds an 8x8 MuralPainter, paints the community
 * mural, prints a text preview to the console, and exports an HTML
 * file so the finished design can be viewed in a browser.
 */
public class AsphaltArtDriver
{
    public static void main(String[] args) throws IOException
    {
        final int GRID_SIZE = 8;
        MuralPainter painter = new MuralPainter(GRID_SIZE);

        painter.paintCommunityMural("#ff8c00", "#12897c", "#f4c542", "#d62828");

        printTextPreview(painter);
        exportHtml(painter, "mural.html");
        System.out.println("Exported mural.html - open it in a browser to view the mural.");
    }

    private static void printTextPreview(Painter painter)
    {
        int size = painter.getGridSize();
        for (int row = 0; row < size; row++)
        {
            for (int col = 0; col < size; col++)
            {
                String color = painter.colorAt(row, col);
                System.out.print(color == null ? "[ blank ]" : "[" + color + "]");
            }
            System.out.println();
        }
    }

    private static void exportHtml(Painter painter, String filename) throws IOException
    {
        int size = painter.getGridSize();
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html><html><head><title>Community Mural</title>");
        html.append("<style>body{background:#222;display:flex;justify-content:center;padding:40px;}");
        html.append("table{border-collapse:collapse;box-shadow:0 0 20px rgba(0,0,0,0.6);}");
        html.append("td{width:48px;height:48px;border:1px solid #111;}</style></head><body><table>");
        for (int row = 0; row < size; row++)
        {
            html.append("<tr>");
            for (int col = 0; col < size; col++)
            {
                String color = painter.colorAt(row, col);
                String cellColor = (color == null) ? "#e5e5e5" : color;
                html.append("<td style=\"background:").append(cellColor).append("\"></td>");
            }
            html.append("</tr>");
        }
        html.append("</table></body></html>");

        FileWriter writer = new FileWriter(filename);
        writer.write(html.toString());
        writer.close();
    }
}
