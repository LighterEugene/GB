public class Human implements JumpableRunnable {
    private int maxHeight;
    private int maxLengthOfRunning;
    private String name;

    public Human(int maxHeight, int maxLengthOfRunning, String name) {
        this.maxHeight = maxHeight;
        this.maxLengthOfRunning = maxLengthOfRunning;
        this.name = name;
    }
    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    @Override
    public int maxLengthOfRunning() {
        return maxLengthOfRunning;
    }

    public void setMaxLengthOfRunning(int maxLengthOfRunning) {
        this.maxLengthOfRunning = maxLengthOfRunning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void jump() {
        System.out.println("Человек прыгнул!");
    }




    @Override
    public void run() {
        System.out.println("Человек побежал!");
    }
    @Override
    public String toString() {
        return "Человек по имени " + name;
    }
}
