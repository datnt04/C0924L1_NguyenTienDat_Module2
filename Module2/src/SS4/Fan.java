package SS4;

public class Fan {
    // Các hằng số cho tốc độ quạt
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;

    private int speed;
    private boolean on;
    private double radius;
    private String color;

    public Fan() {
        this.speed = SLOW; // Mặc định là SLOW
        this.on = false;   // Mặc định là tắt
        this.radius = 5;   // Mặc định bán kính là 5
        this.color = "blue"; // Mặc định màu là blue
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        if (on) {
            return "Fan is on: speed=" + speed + ", color=" + color + ", radius=" + radius;
        } else {
            return "Fan is off: color=" + color + ", radius=" + radius;
        }
    }
    public static class Main {
        public static void main(String[] args) {
            Fan fan1 = new Fan();
            fan1.setSpeed(Fan.FAST);
            fan1.setRadius(10);
            fan1.setColor("yellow");
            fan1.setOn(true);

            Fan fan2 = new Fan();
            fan2.setSpeed(Fan.MEDIUM);
            fan2.setRadius(5);
            fan2.setColor("blue");
            fan2.setOn(false);

            System.out.println(fan1.toString());
            System.out.println(fan2.toString());
        }
    }
}