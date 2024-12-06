package SS4;

public class StopWatch {
    private long startTime;
    private long endTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return this.endTime - this.startTime;
    }

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        System.out.println("Bắt đầu đo thời gian...");

        for (int i = 0; i < 1000000; i++) {
            Math.sqrt(i);
        }
        stopWatch.stop();
        System.out.println("Thời gian bắt đầu: " + stopWatch.getStartTime());
        System.out.println("Thời gian kết thúc: " + stopWatch.getEndTime());
        System.out.println("Thời gian đã trôi qua: " + stopWatch.getElapsedTime() + " millisecond");
    }
}
