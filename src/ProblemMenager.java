import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProblemMenager {

    private ArrayList<Problem> problemList = new ArrayList<>();
    private FileMenager meneger = new FileMenager();


    public void readFromFile(String fileName){
        problemList= meneger.loadProblemData(fileName);
        //System.out.println("Dane dla pliku: " +fileName);
    }

    public void generateScheduleForFile (double h){

        for (Problem p : problemList) {
            System.out.println("Uszeregowanie dla k=" + (problemList.indexOf(p)+1));
            Instance myInstance = new Instance(p,h);
            myInstance.generateSchedule();
            System.out.println(myInstance);
            meneger.saveInstance(String.valueOf(p.getNumberOfJobs()),String.valueOf(problemList.indexOf(p)+1),String.valueOf(Math.round(h*10)),(int)myInstance.getGoalFunction(),myInstance,String.valueOf(myInstance.getR()));
        }
    }


//    class InstanceCompare implements Comparator<Instance> {
//        public int compare(Instance a, Instance b){
//            if (a.getGoalFunction()< b.getGoalFunction()) return -1;
//            if (a.getGoalFunction()> b.getGoalFunction()) return 1;
//            else return 0;
//        }
//    }


}
