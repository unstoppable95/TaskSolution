import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileMenager {

    private String fileName;

    public FileMenager(String name){
        this.fileName=name;
    }

    public ArrayList<Problem> loadData(){

        ArrayList<Problem> listProblems=new ArrayList<>();
        try{
            File file =new File("ProblemFiles/"+fileName);
            Scanner scanner = new Scanner(file);
            int numOfProblems = Integer.parseInt(scanner.nextLine().replace(" ", ""));

            for (int i = 0; i < numOfProblems; i++) {
                int numJobs = Integer.parseInt(scanner.nextLine().replace(" ", ""));


                ArrayList<Job> listJobs=new ArrayList<>();
                for (int j = 0; j < numJobs; j++) {
                    String line = scanner.nextLine();
                    String[] parts = line.trim().split("\\s+");

                    Job job = new Job(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                    listJobs.add(job);
                }
                Problem problem = new Problem(numJobs);
                problem.setJobList(listJobs);
                listProblems.add(problem);

            }

            scanner.close();
        }catch (FileNotFoundException ex){
            System.out.println("Nie znaleziono pliku "+fileName);
        }

        return listProblems;
    }

}
