import org.code.neighborhood.*;

public class NeighborhoodRunner {
  public static void main(String[] args) {
    BalloonPainter balloon1 = new BalloonPainter(0, 0);
    balloon1.paintBalloon("red");
    StringPainter string1 = new StringPainter(0, 2);
    string1.paintString(4, "black");

    BalloonPainter balloon2 = new BalloonPainter(3, 0);
    balloon2.paintBalloon("yellow");
    StringPainter string2 = new StringPainter(3, 2);
    string2.paintString(4, "black");

    BalloonPainter balloon3 = new BalloonPainter(6, 0);
    balloon3.paintBalloon("blue");
    StringPainter string3 = new StringPainter(6, 2);
    string3.paintString(4, "black");
  }
}
