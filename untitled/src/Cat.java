public class Cat implements JumpableRunnable{
    private int maxHeight;
    private int maxLengthOfRunning;
    private String name;

    public Cat(int maxHeight, int maxLengthOfRunning, String name) {
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
   public void jump(){
        System.out.println("Кот прыгнул!");
    }
    @Override
      public void run(){
        System.out.println("Кот побежал!");

    }
    @Override
    public String toString() {
        return "Кот по кличке " + name;
    }
}
