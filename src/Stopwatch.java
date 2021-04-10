public class Stopwatch {
    private long startTime;
    private int added;
    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void startAtTime(int x) {
        added = x;
    }

    public int getElapsedTimeSeconds() {
        return (Math.round((System.currentTimeMillis() - startTime) / 1000f) + added);
    }
}