package model;

public class Pet {
    private double x, y;
    private double targetX, targetY;
    private final double speed;

    public Pet(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    // Getters and update logic
    public void updatePosition() {
        double dx = targetX - x;
        double dy = targetY - y;
        double distance = Math.sqrt(dx*dx + dy*dy);

        if(distance > 0) {
            double move = Math.min(speed, distance);
            x += dx * (move / distance);
            y += dy * (move / distance);
        }
    }

    // Setters for target position
    public void setTarget(double x, double y) {
        this.targetX = x;
        this.targetY = y;
    }

    // Getters for current position
    public double getX() { return x; }
    public double getY() { return y; }
}