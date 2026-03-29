package main.java.entity;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

public class Snake {
    private Deque<Point> body;
    private Set<Point> bodySet;

    public Snake(Point startPosition) {
        this.body = new ArrayDeque<>();
        this.bodySet = new HashSet<>();
        body.addFirst(startPosition);
        bodySet.add(startPosition);
    }

    public void move(Point newHead, boolean grow) {
        body.addFirst(newHead);
        bodySet.add(newHead);

        if (!grow) {
            Point tail = body.removeLast();
            bodySet.remove(tail);
        }
    }

    public Point getHead() { return body.peekFirst(); }
    public boolean checkSelfCollision(Point p) { return bodySet.contains(p); }

    public List<Point> getBodyList() { return new ArrayList<>(body); }
    public void rebuildFromList(List<Point> newBody) {
        this.body = new ArrayDeque<>(newBody);
        this.bodySet = new HashSet<>(newBody);
    }
}