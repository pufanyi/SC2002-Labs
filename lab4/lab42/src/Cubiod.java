public class Cubiod implements Shape {
    private final double width, height, depth;

    public Cubiod(double width, double height, double depth) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    @Override
    public double getArea() {
        return 2 * (width * height + width * depth + height * depth);
    }
}
