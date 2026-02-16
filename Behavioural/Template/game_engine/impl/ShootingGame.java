package Behavioural.Template.game_engine.impl;

import Behavioural.Template.game_engine.GameEngine;

public class ShootingGame extends GameEngine{
    protected void start() {
        System.out.println("Shooting Game Starting...");
    }

    protected void processInput() {
        System.out.println("Processing shooting controls");
    }

    protected void update() {
        System.out.println("Updating enemy AI");
    }

    protected void render() {
        System.out.println("Rendering battlefield");
    }
}
