import java.util.ArrayList;

public class Problem {

    private ArrayList<Job> jobList = new ArrayList<>();
    private int sumP=0;
    private int numberOfJobs;


    public Problem(int x){
        this.numberOfJobs=x;
    }

    public int calculateSumP(){
        for(Job j: jobList){
            sumP+=j.getP();
        }
        return sumP;
    }

    public int getNumberOfJobs() {
        return numberOfJobs;
    }

    public void setJobList(ArrayList<Job> jobList) {
        this.jobList = jobList;
    }

    public ArrayList<Job> getJobList() {
        return jobList;
    }
}
