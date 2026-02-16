package Behavioural.Template.game_engine.impl;

import Behavioural.Template.game_engine.GameEngine;

public class RacingGame extends GameEngine {
    protected void start() {
        System.out.println("Racing Game Starting...");
    }

    protected void processInput() {
        System.out.println("Processing steering input");
    }

    protected void update() {
        System.out.println("Updating car physics");
    }

    protected void render() {
        System.out.println("Rendering race track");
    }
}
