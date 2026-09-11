import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {
    World world = new World();

    // Paint the balloons: a solid row of color, starting wherever the
    // World editor places a BalloonPainter.
    BalloonPainter balloonPainter = new BalloonPainter();
    balloonPainter.paintRow();

    // Paint the strings: dashed lines hanging below the balloons,
    // starting wherever the World editor places a StringPainter.
    StringPainter stringPainter = new StringPainter();
    stringPainter.paintDashedLine(5);
  }
}
