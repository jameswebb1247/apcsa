import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {
    World world = new World();

    BalloonPainter balloonPainter = new BalloonPainter();
    balloonPainter.paintRow("red");

    StringPainter stringPainter = new StringPainter();
    stringPainter.paintDashedLine(5, "brown");
  }
}
