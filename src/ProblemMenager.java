import java.util.ArrayList;

public class ProblemMenager {

    private ArrayList<Problem> problemList = new ArrayList<>();



    public void readFromFile(String fileName){
        FileMenager menager = new FileMenager(fileName);
        problemList= menager.loadData();

        for (Problem p : problemList){
            System.out.println("Problem w pliku "+fileName +" nr: " + problemList.indexOf(p));
            for( Job j : p.getJobList()){
                System.out.println(j);
            }
            System.out.println(p.calculateSumP() + " liczba zadan" + p.getNumberOfJobs());
            System.out.println();
        }
    }






}
