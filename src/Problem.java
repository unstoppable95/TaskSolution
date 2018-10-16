import java.util.ArrayList;
import java.util.List;

public class Problem {

    private List<Job> jobList = new ArrayList<>();

    private int numberOfJobs;

    public Problem(int x)
    {
        this.numberOfJobs=x;
    }

    public int getNumberOfJobs() {
        return numberOfJobs;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    public List<Job> getJobList() {
        return jobList;
    }
}
