import java.util.ArrayList;

public class ProblemManager {

    private ArrayList<Problem> problemList = new ArrayList<>();
    private FileManager manager = new FileManager();


    public void readFromFile(String fileName,double h){
        problemList= manager.loadProblemData(fileName,h);
    }

    public void generateSchedulesForFile (String directory){
        for (Problem p : problemList) {
            System.out.println("Uszeregowanie dla k=" + (problemList.indexOf(p)+1));
            long startTime = System.nanoTime();
            p.generateSchedule();
            long estimatedTime = System.nanoTime() - startTime;
            System.out.println(estimatedTime*Math.pow(10,-9) +" seconds");
            System.out.println(p);
            manager.saveInstance(String.valueOf(p.getNumberOfJobs()),String.valueOf(problemList.indexOf(p)+1),String.valueOf(Math.round(p.getH()*10)),(int)p.getGoalFunction(),p,String.valueOf(p.getR()), directory);
        }
    }
}
