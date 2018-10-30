public class ProjectMain {

    public static void main(String[] args){
//      long startTime = System.currentTimeMillis();
//        ProblemMenager problems = new ProblemMenager();
//        problems.readFromFile("sch500.txt");
//        problems.generateScheduleForFile(0.2);
//      long estimatedTime = System.currentTimeMillis() - startTime;
//      System.out.println(estimatedTime + " seconds");

        SolutionChecker sol = new SolutionChecker();
        sol.checkSolutions(sol.getFiles("Results"));

    }
}
