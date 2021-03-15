public class MainClass {
    public static void main(String[] args) {
     JumpableRunnable[] members = {new Robot(3,2,432),new Robot(8,8,505) };

      Overcomable[] obstacles ={new RunningTrack(3),new RunningTrack(5),new Wall(4),new Wall(4)};

        for ( JumpableRunnable member : members){
            boolean winner = true;
            System.out.println("К прохождению препятствий приступает " + member);

            for ( Overcomable obstacle : obstacles){
                System.out.println( member + " пытается пройти препятствие " + obstacle);
               if (obstacle.toJump(member.getMaxHeight()) || obstacle.toRun(member.maxLengthOfRunning())){
                   System.out.println("И у него получается!");
               }
                else {
                    winner = false;
                    System.out.println("И у него не получается.");
                    break;

                }
            }

            if(winner) {
                System.out.println(member + " прошёл дистанцию!");
            } else {
                System.out.println(member + " проиграл.");
            }
            System.out.println();
        }
    }
}
