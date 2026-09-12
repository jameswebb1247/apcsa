import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {
    BalloonPainter balloonPainter = new BalloonPainter();
    balloonPainter.paintRow("red");

    StringPainter stringPainter = new StringPainter();
    stringPainter.paintDashedLine(5, "brown");
  }
}
