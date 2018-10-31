
public class ProjectMain {

    public static void main(String[] args){
        String dirForOutputFiles="Results";

        ProblemManager problems = new ProblemManager();
        problems.readFromFile("sch1000.txt",0.8);
        problems.generateSchedulesForFile(dirForOutputFiles);


        SolutionChecker sol = new SolutionChecker();
        sol.checkSolutions(sol.getFiles(dirForOutputFiles));

    }
}
