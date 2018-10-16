public class ProjectMain {

    public static void main(String[] args){

        ProblemMenager problems = new ProblemMenager();
        problems.readFromFile("sch20.txt");
        problems.generateSchedule(0.6);
    }
}
