public class Shape2DApp {
    public static void main(String[] args) {
        Shape cir = new Circle(10);
        Shape tri = new Triangle(20, 25);
        Shape rec = new Rectangle(50, 20);
        System.out.println("Circle area: " + cir.getArea());
        System.out.println("Triangle area: " + tri.getArea());
        System.out.println("Rectangle area: " + rec.getArea());
    }
}
