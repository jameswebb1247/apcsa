import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {
    BalloonPainter balloonPainter = new BalloonPainter();
    balloonPainter.setPaint(100); // starts with plenty of paint so it can paint right away
    balloonPainter.paintRow("red");

    StringPainter stringPainter = new StringPainter();
    stringPainter.setPaint(100); // same deal, no bucket needed to start painting
    stringPainter.paintDashedLine(5, "brown");
  }
}
