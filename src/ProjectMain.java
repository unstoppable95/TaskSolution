

public class ProjectMain {

    public static void main(String[] args){

        ProblemMenager problems = new ProblemMenager();
        problems.readFromFile("sch10.txt",0.2);
        problems.generateSchedulesForFile();


        SolutionChecker sol = new SolutionChecker();
        sol.checkSolutions(sol.getFiles("Results"));

    }
}
