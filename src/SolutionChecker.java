import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SolutionChecker {

    private FileMenager meneger = new FileMenager();

    public void checkSolution(String solutionName){
        Vector<String[]> content=meneger.readSolutionFromFile(solutionName);
        double h=Double.parseDouble(content.get(0)[0])/10;
        double goalFunction = Double.parseDouble(content.get(1)[0]);
        int n = Integer.parseInt(content.get(2)[0]);
        int r = Integer.parseInt(content.get(3)[0]);
        Problem p= new Problem(n);
        List<Job> solutionJobs = new ArrayList<>();
        for (int i=4;i<content.size();i++){
            solutionJobs.add(new Job(Integer.parseInt(content.get(i)[0]), Integer.parseInt(content.get(i)[1]), Integer.parseInt(content.get(i)[2])));
        }
        p.setJobList(solutionJobs);
        Instance tmp=new Instance(p,h);
        tmp.calculateGoalFunction(r);
        double goalFuntionCheck=tmp.getGoalFunction();
        if(goalFunction==goalFuntionCheck) System.out.println("Wyniki się zgadzają");
        else System.out.println("Wyniki się nie zgadzają");

    }
}
