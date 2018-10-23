public class ProjectMain {

    public static void main(String[] args){
        long startTime = System.currentTimeMillis();
        ProblemMenager problems = new ProblemMenager();
        problems.readFromFile("sch10.txt");
        problems.generateSchedule(0.8);
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(estimatedTime + " seconds");

    }
}
