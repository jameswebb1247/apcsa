import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {
    BalloonPainter balloon = new BalloonPainter(2, 0);
    balloon.paintBalloon(4, "green");

    StringPainter string = new StringPainter(3, 4);
    string.paintCurvedString(4, "white");
  }
}
