public class Shape3DApp {
    public static void main(String[] args) {
        Shape sphere = new Sphere(10);
        Shape Pyramid = new Pyramid(10, 10);
        Shape cubiod = new Cubiod(10, 10, 10);
        System.out.println("Sphere area: " + sphere.getArea());
        System.out.println("Pyramid area: " + Pyramid.getArea());
        System.out.println("Cubiod area: " + cubiod.getArea());
    }
}
