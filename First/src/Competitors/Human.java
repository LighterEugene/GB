package Competitors;

public class Human implements Competitor{
    String name;
    int maxRunDistance;
    float maxJumpHeight;
    int maxSwimDistance;
    boolean onDistance;

    public boolean isOnDistance() {
        return onDistance;
    }

    public Human(String name) {
        this.name = name;
        this.maxRunDistance = 5000;
        this.maxJumpHeight = 2.0F;
        this.maxSwimDistance = 500;
        this.onDistance = true;
    }

    public Human(String name, int maxRunDistance, float maxJumpHeight, int maxSwimDistance, boolean onDistance) {
        this.name = name;
        this.maxRunDistance = maxRunDistance;
        this.maxJumpHeight = maxJumpHeight;
        this.maxSwimDistance = maxSwimDistance;
        this.onDistance = true;
    }

    public void run(int distance){
        if (maxRunDistance >= distance ){
            System.out.println(name + " " + " успешно справился с кроссом");
        } else {
            System.out.println(name + " " + " не смог преодолеть кросс");
            onDistance = false;
        }
    }

    public void jump(int height){
        if (maxJumpHeight >= height ){
            System.out.println(name + " " + " успешно справился с препятствием");
        } else {
            System.out.println(name + " " + " не смог преодолеть препятствие");
            onDistance = false;
        }
    }

    public void swim(int distance){
        if (maxSwimDistance >= distance ){
            System.out.println(name + " " + " успешно проплыл дистанцию");
        } else {
            System.out.println(name + " " + " не смог проплыть дистанцию");
            onDistance = false;
        }
    }

    public void showResult(){
        System.out.println(name + ": " + onDistance);
    }

}
