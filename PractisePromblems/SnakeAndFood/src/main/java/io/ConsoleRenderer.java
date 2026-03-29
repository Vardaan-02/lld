package main.java.io;

import main.java.consumable.Consumable;
import main.java.entity.Point;
import main.java.state.GameState;

public class ConsoleRenderer implements Renderer {

    private static final String CLEAR_SCREEN = "\033[H\033[2J";
    private static final String RESET_COLOR = "\033[0m";
    private static final String GREEN_COLOR = "\033[32m";
    private static final String RED_COLOR = "\033[31m";

    @Override
    public void render(GameState state) {
        StringBuilder sb = new StringBuilder();
        sb.append(CLEAR_SCREEN);
        sb.append("Score: ").append(state.getScore()).append("\n");

        int width = state.getConfig().width();
        int height = state.getConfig().height();

        sb.append("+").append("-".repeat(width)).append("+\n");

        for (int y = 0; y < height; y++) {
            sb.append("|"); 
            for (int x = 0; x < width; x++) {
                Point p = new Point(x, y);

                if (state.getSnake().getHead().equals(p)) {
                    sb.append(GREEN_COLOR).append("O").append(RESET_COLOR);
                } else if (state.getSnake().checkSelfCollision(p)) {
                    sb.append(GREEN_COLOR).append("o").append(RESET_COLOR); 
                } else if (state.getActiveItems().containsKey(p)) {
                    Consumable item = state.getActiveItems().get(p);
                    sb.append(RED_COLOR).append(item.getRenderIcon()).append(RESET_COLOR);
                } else {
                    sb.append(" "); 
                }
            }
            sb.append("|\n"); 
        }

        sb.append("+").append("-".repeat(width)).append("+\n");

        System.out.print(sb.toString());
        System.out.flush();
    }

    @Override
    public void showGameOver(int score) {
        System.out.println(CLEAR_SCREEN);
        System.out.println("===========================");
        System.out.println("        GAME OVER          ");
        System.out.println("===========================");
        System.out.println("Final Score: " + score);
        System.out.println("Press Ctrl+C to exit.");
    }
}