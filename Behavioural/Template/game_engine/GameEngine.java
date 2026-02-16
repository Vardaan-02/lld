package Behavioural.Template.game_engine;

public abstract class GameEngine {
    public final void run(){
        initialize();
        start();

        while (isRunning()) {
            System.out.println();
            System.out.println("Frame number:" + frameCount);
            processInput();
            update();
            render();
        }

        shutdown();
    }

    private void initialize() {
        System.out.println("Engine initializing...");
    }

    private void shutdown() {
        System.out.println("Engine shutting down...");
    }

    protected boolean isRunning(){
        return frameCount++ < maxFrames;
    }

    protected abstract void start();
    protected abstract void processInput();
    protected abstract void update();
    protected abstract void render();

    private int frameCount = 0;
    private int maxFrames = 5;
}
