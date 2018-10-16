import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProblemMenager {

    private ArrayList<Problem> problemList = new ArrayList<>();



    public void readFromFile(String fileName){
        FileMenager menager = new FileMenager(fileName);
        problemList= menager.loadData();
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
            ArrayList <Instance> listOfInstance = new ArrayList<>();
            for (int i=0;i<1000000;i++) {
                Instance ix = new Instance(p, h);
                listOfInstance.add(ix);
            }
            InstanceCompare comparator= new InstanceCompare();
            Collections.sort(listOfInstance, comparator);

            Instance best = listOfInstance.get(0);
            System.out.println(best);

        }
    }


    class InstanceCompare implements Comparator<Instance> {
        public int compare(Instance a, Instance b){
            if (a.getGoalFunction()< b.getGoalFunction()) return -1;
            if (a.getGoalFunction()> b.getGoalFunction()) return 1;
            else return 0;
        }
    }


}
