import java.io.*;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Vector;

public  class FileMenager {

    public ArrayList<Problem> loadProblemData(String fileName){
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


    public  void saveInstance(String n,String k,String h,int F,Instance b,String r){
        String nameInstance="Results/sch"+n+"_"+k+"_"+h+".txt";
        try {
            File file = new File(nameInstance);
            file.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(h);
            writer.newLine();
            writer.write(String.valueOf(F));
            writer.newLine();
            writer.write(String.valueOf(n));
            writer.newLine();
            writer.write(String.valueOf(r));
            writer.newLine();
            for (int i =1; i<b.getMyProblem().getJobList().size()+1 ;i++){
                writer.write(b.getMyProblem().getJobList().get(i-1).toString());
                writer.newLine();
            }
            writer.flush();
            writer.close();
        }
        catch(IOException e){
            System.out.println("Wystąpił błąd przy zapisie pliku "+nameInstance);
        }
    }

    public Vector<String[]> readSolutionFromFile(String fileName){
        Vector<String []> fileContent = new Vector<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Results/"+fileName))) {
            String currentLine;
            while ((currentLine = br.readLine()) != null) {
                fileContent.add(currentLine.trim().split("\t"));
            }
        } catch (IOException e) {
            System.out.println("Wystapił błąd z odczytem rozwiązania "  +fileName);
        }
        return fileContent;
    }




}
