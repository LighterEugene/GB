import Competitors.*;
import obstacles.*;

public class MainClass {
    public static void main(String[] args) {

        Competitor[] competitors = {new Human("Боб",2000,1.5f,500,true), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] obstacles = {new Cross(400), new Wall(1), new Water(1)};

        Team team = new Team("Победители", competitors);

        System.out.println("Команда создана");
        System.out.println(team.getTeamName());

        System.out.println("Приветствуем членов команды");
        team.showResults();

        // new Course
        Course course = new Course(obstacles);

        System.out.println("============team goes to course============");
        course.doIt(team);

        System.out.println("Результаты");
        team.showResults();

        System.out.println("Показ тех, кто закончил забег");
        team.showMembersFinishedCourse();
    }
}

