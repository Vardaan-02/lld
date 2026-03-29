package main.java.entity;

public enum Direction {
    RIGHT,
    LEFT,
    DOWN,
    UP;

    public boolean isOpposite(Direction other) {
        return (this == RIGHT && other == LEFT) ||
               (this == LEFT && other == RIGHT) ||
               (this == UP && other == DOWN) ||
               (this == DOWN && other == UP);
    }

    public Point applyTo(Point p){
        return switch (this) {
            case RIGHT -> new Point(p.x() + 1, p.y());
            case LEFT  -> new Point(p.x() - 1, p.y());
            case DOWN  -> new Point(p.x(), p.y() + 1); 
            case UP    -> new Point(p.x(), p.y() - 1);
        };
    }
}
