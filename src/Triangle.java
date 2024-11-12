public class Triangle implements Figures {
    private double a;
    private double b;
    private double c;
    private String borderСolor;
    private String backgroundСolor;

    Triangle(double a, double b, double c, String borderСolor, String backgroundСolor) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.borderСolor = borderСolor;
        this.backgroundСolor = backgroundСolor;
    }

    @Override
    public double getPerimeter() {
        return a + b + c;
    }

    @Override
    public double getArea() {
        double p = getPerimeter() / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
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
