public class Robot implements JumpableRunnable {
    private int maxHeight;
    private int maxLengthOfRunning;
    private int serialNumber;

    public Robot(int maxHeight, int maxLength, int serialNumber) {
        this.maxHeight = maxHeight;
        this.maxLengthOfRunning = maxLength;
        this.serialNumber = serialNumber;
    }



    @Override
    public void jump() {
        System.out.println("Робот прыгнул");
    }
    @Override
    public void run() {
        System.out.println("Робот бежит");
    }

    public void setMaxHeight(int maxHeight) {
        this.maxHeight = maxHeight;
    }

    public void setMaxLengthOfRunning(int maxLengthOfRunning) {
        this.maxLengthOfRunning = maxLengthOfRunning;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public int maxLengthOfRunning() {
        return maxLengthOfRunning;
    }

    public int getSerialNumber() {
        return serialNumber;
    }



    @Override
    public String toString() {
        return "Робот с серийным номером " + serialNumber;
    }
}