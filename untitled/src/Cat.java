public class Cat {
    private String name;
    private int appetite;
    private boolean Satiety;//3) поля сытость

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    @Override
    public String toString() {
        return "Состояние сытости" +
                " кота по кличке " + name +
                ", равняется " + Satiety;
    }

    public void eat(Plate p) {
        if (p.getFood() - this.appetite < 0){//2. если еды меньше, чем надо коту, он её не трогает и остаётся голоден

        }
        else {
            p.decreaseFood(appetite);
            Satiety = true;
        }
    }
}
