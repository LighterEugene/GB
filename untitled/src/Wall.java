public class Wall implements Overcomable {
    int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean toRun(int anything) {
        return false;
    }

    @Override
    public boolean toJump(int maxHeight) {
        return maxHeight >= this.height;
    }

    @Override
    public String toString() {
        return "Стена высотой " + height + " м";
    }
}