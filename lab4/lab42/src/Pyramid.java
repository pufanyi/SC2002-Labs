public class Pyramid implements Shape {
    private final Square base;
    private final Triangle side;

    public Pyramid(double baseWidth, double sideHeight) {
        this.base = new Square(baseWidth);
        this.side = new Triangle(baseWidth, sideHeight);
    }

    @Override
    public double getArea() {
        return base.getArea() + 4 * side.getArea();
    }
}
