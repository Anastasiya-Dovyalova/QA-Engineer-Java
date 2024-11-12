public class Rectangle implements Figures {
    private double width;
    private double height;
    private String borderСolor;
    private String backgroundСolor;

    Rectangle(double width, double height, String borderСolor, String backgroundСolor) {
        this.width = width;
        this.height = height;
        this.borderСolor = borderСolor;
        this.backgroundСolor = backgroundСolor;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getArea() {
        return width * height;
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
