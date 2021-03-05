public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void decreaseFood(int n) {
        food -= n;
    }
    public void addFood(int n) {//6.  добавляет еду в тарелку
        food += n;
    }
    public void info() {
        System.out.println("plate: " + food);
    }
}
