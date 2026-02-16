package Behavioural.Template;

import Behavioural.Template.game_engine.GameEngine;
import Behavioural.Template.game_engine.impl.RacingGame;
import Behavioural.Template.game_engine.impl.ShootingGame;

public class Main {
    public static void main(String[] args) {

        GameEngine racing = new RacingGame();
        racing.run();

        System.out.println();
        System.out.println();
        System.out.println();

        GameEngine shooting = new ShootingGame();
        shooting.run();
    }
}
