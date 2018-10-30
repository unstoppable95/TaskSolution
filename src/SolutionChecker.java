import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class SolutionChecker {

    private FileMenager meneger = new FileMenager();

    public List<String> getFiles (String directoryName){
        List<String> fileNames = new ArrayList<>();
        File[] files = new File(directoryName).listFiles();
        for (File file : files) {
            if (file.isFile()) {
                fileNames.add(file.getName());
            }
        }
        return fileNames;
    }

    public void checkSolutions(List<String> files){
        for (String file : files){
            checkSolution(file);
        }
    }

    private void checkSolution(String solutionName){
        Vector<String[]> content=meneger.readSolutionFromFile(solutionName);
        double h=Double.parseDouble(content.get(0)[0])/10;
        double goalFunction = Double.parseDouble(content.get(1)[0]);
        int n = Integer.parseInt(content.get(2)[0]);
        int r = Integer.parseInt(content.get(3)[0]);
        List<Job> solutionJobs = new ArrayList<>();
        for (int i=4;i<content.size();i++){
            solutionJobs.add(new Job(Integer.parseInt(content.get(i)[0]), Integer.parseInt(content.get(i)[1]), Integer.parseInt(content.get(i)[2])));
        }
        Problem p= new Problem(n,h,solutionJobs);
        p.calculateGoalFunction(r);
        double goalFuntionCheck=p.getGoalFunction();
        if(goalFunction!=goalFuntionCheck) System.out.println("Wyniki w pliku " + solutionName + " się nie zgadzają");
    }

}
