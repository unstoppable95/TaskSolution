import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProblemMenager {

    private ArrayList<Problem> problemList = new ArrayList<>();
    private FileMenager menager = new FileMenager();


    public void readFromFile(String fileName){
        problemList= menager.loadData(fileName);
        System.out.println("Dane dla pliku: " +fileName);
/*        for (Problem p : problemList){
           System.out.println("Problem w pliku "+fileName +" nr: " + problemList.indexOf(p));
            for( Job j : p.getJobList()){
                System.out.println(j);
            }
            System.out.println("Liczba zadan " + p.getNumberOfJobs());
            System.out.println();
        }*/

    }

    public void generateSchedule (double h){

        for (Problem p : problemList) {
            System.out.println("Uszeregowanie dla k=" + problemList.indexOf(p));
            //ArrayList <Instance> listOfInstance = new ArrayList<>();
            Instance best = new Instance(p,h);
            Instance ix ;
            for (int i=0;i<1000000;i++) {
                ix = new Instance(p, h);
                //listOfInstance.add(ix);
                if (ix.getGoalFunction()<best.getGoalFunction()){
                    best=ix;
                }
            }
//            InstanceCompare comparator= new InstanceCompare();
//            Collections.sort(listOfInstance, comparator);
//
//            Instance best = listOfInstance.get(0);
            System.out.println(best);
            menager.saveInstance(String.valueOf(p.getNumberOfJobs()),String.valueOf(problemList.indexOf(p)+1),String.valueOf(Math.round(h*10)),(int)best.getGoalFunction(),best,"5");
        }
    }


/*    class InstanceCompare implements Comparator<Instance> {
        public int compare(Instance a, Instance b){
            if (a.getGoalFunction()< b.getGoalFunction()) return -1;
            if (a.getGoalFunction()> b.getGoalFunction()) return 1;
            else return 0;
        }
    }*/


}
