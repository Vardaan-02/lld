package main.java.state;

import java.util.List;
import java.util.Map;

import main.java.entity.Point;

public record GameStateMemento(
    List<Point> snakeBody,
    Map<Point, String> activeItems, 
    int score,
    long currentTickDelay
) {}