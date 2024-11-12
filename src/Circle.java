public class Circle implements Figures {
    private double radius;
    private String borderСolor;
    private String backgroundСolor;

    Circle(double radius, String borderСolor, String backgroundСolor) {
        this.radius = radius;
        this.borderСolor = borderСolor;
        this.backgroundСolor = backgroundСolor;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getBorderСolor() {
        return borderСolor;
    }

    @Override
    public void setBorderСolor(String color) {
        this.borderСolor = color;
    }

    @Override
    public String getBackgroundСolor() {
        return backgroundСolor;
    }

    @Override
    public void setBackgroundСolor(String color) {
        this.backgroundСolor = color;
    }
}
