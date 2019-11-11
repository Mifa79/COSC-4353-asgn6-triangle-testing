public class Point {
    private double x, y;

    public Point(double theX, double theY) {
        x = theX;
        y = theY;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass())
            return false;

        Point point = (Point) obj;
        return (point.x == this.x && point.y == this.y);
    }
}
