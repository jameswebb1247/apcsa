import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {
    BalloonPainter balloon = new BalloonPainter(0, 0);
    balloon.paintBalloon("green");

    StringPainter string = new StringPainter(0, 2);
    string.paintString(4, "white");
  }
}
