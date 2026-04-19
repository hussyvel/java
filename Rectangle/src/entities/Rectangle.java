package entities;

import java.util.Locale;

public class Rectangle {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        requirePositive(width, "Width");
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        requirePositive(height, "Height");
        this.height = height;
    }

    private static void requirePositive(double value, String name) {
        if (value <= 0) {
            throw new IllegalArgumentException(name + " must be positive");
        }
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public double diagonal() {
        return Math.sqrt(width * width + height * height);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Rectangle [width=%.1f, height=%.1f]", width, height);
    }
}
