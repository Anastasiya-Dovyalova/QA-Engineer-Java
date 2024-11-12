public interface Figures {

    double getPerimeter();

    double getArea();

    String getBorderСolor();

    void setBorderСolor(String color);

    String getBackgroundСolor();

    void setBackgroundСolor(String color);

    default void info() {
        System.out.println("[" + "Площадь: " + getArea() + "; " +
                "Периметр: " + getPerimeter() + "; " +
                "Цвет заливки: " + getBorderСolor() + "; " +
                "Цвет границы: " + getBackgroundСolor() + "]");
    }
}
