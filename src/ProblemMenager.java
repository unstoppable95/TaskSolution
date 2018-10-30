import java.util.ArrayList;

public class ProblemMenager {

    private ArrayList<Problem> problemList = new ArrayList<>();
    private FileMenager meneger = new FileMenager();


    public void readFromFile(String fileName,double h){
        problemList= meneger.loadProblemData(fileName,h);
    }

    public void generateSchedulesForFile (){
        for (Problem p : problemList) {
            System.out.println("Uszeregowanie dla k=" + (problemList.indexOf(p)+1));
//          long startTime = System.currentTimeMillis();
            p.generateSchedule();
//          long estimatedTime = System.currentTimeMillis() - startTime;
//          System.out.println(estimatedTime + " seconds");
            System.out.println(p);
            meneger.saveInstance(String.valueOf(p.getNumberOfJobs()),String.valueOf(problemList.indexOf(p)+1),String.valueOf(Math.round(p.getH()*10)),(int)p.getGoalFunction(),p,String.valueOf(p.getR()));
        }
    }
}
