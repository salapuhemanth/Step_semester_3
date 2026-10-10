import java.util.ArrayList;
import java.util.List;

/**
 * Problem 1: Garden Plot Area Report
 * Category C - Class Practice Problem 1
 *
 * Models community garden plots using an abstract base class so new shapes can be added
 * without altering the reporting engine.
 */
public class GardenPlotAreaReport {

    public abstract static class Plot {
        protected String owner;
        protected String shape;

        public Plot(String owner, String shape) {
            this.owner = owner;
            this.shape = shape;
        }

        public String getOwner() {
            return owner;
        }

        public String getShape() {
            return shape;
        }

        public abstract double getArea();
    }

    public static class CirclePlot extends Plot {
        private double radius;

        public CirclePlot(String owner, double radius) {
            super(owner, "CIRCLE");
            this.radius = radius;
        }

        @Override
        public double getArea() {
            return Math.PI * radius * radius;
        }
    }

    public static class RectanglePlot extends Plot {
        private double length;
        private double width;

        public RectanglePlot(String owner, double length, double width) {
            super(owner, "RECTANGLE");
            this.length = length;
            this.width = width;
        }

        @Override
        public double getArea() {
            return length * width;
        }
    }

    public static class TrianglePlot extends Plot {
        private double base;
        private double height;

        public TrianglePlot(String owner, double base, double height) {
            super(owner, "TRIANGLE");
            this.base = base;
            this.height = height;
        }

        @Override
        public double getArea() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        List<Plot> plots = new ArrayList<>();
        plots.add(new CirclePlot("Asha", 5));
        plots.add(new RectanglePlot("Ravi", 4, 6));
        plots.add(new TrianglePlot("Neha", 10, 3));

        double totalArea = 0.0;
        for (Plot p : plots) {
            double area = p.getArea();
            totalArea += area;
            System.out.println(String.format("%s (%s): %.2f", p.getOwner(), p.getShape(), area));
        }
        System.out.println(String.format("Total Area: %.2f", totalArea));
    }
}