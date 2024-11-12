public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(3.5, 4.0, "Зеленый", "Желтый");
        Circle circle = new Circle(5.0, "Черный", "Белый");
        Triangle triangle = new Triangle(4.5, 6.7, 8.0, "Розовый", "Серый");
        rectangle.info();
        circle.info();
        triangle.info();
    }
}