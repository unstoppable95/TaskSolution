import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Instance {

    private Problem myProblem;
    private double h;
    private int d;
    private int sumP = 0;
    private double goalFunction;
    private int r;

    public int getR() {
        return r;
    }

    public Instance(Problem p, double h) {
        this.myProblem = p;
        this.h = h;
        this.sumP = calculateSumP();
        this.d = (int) Math.floor(sumP * h);
        //this.goalFunction = calculateGoalFunction(r);
    }

    public Problem getMyProblem() {
        return myProblem;
    }

    public void generateSchedule() {
        List<Job> newJobList = myProblem.getJobList();
        InstanceCompare sort = new InstanceCompare();
        Collections.sort(newJobList, sort);
        this.r=5;
        calculateGoalFunction(r);
        myProblem.setJobList(newJobList);
    }


    public double getGoalFunction() {
        return goalFunction;
    }

    public void calculateGoalFunction(int r) {
        List<Integer> endTimeJob = new ArrayList<>();
        int currentTime = r;
        int result = 0;
        for (Job j : myProblem.getJobList()) {
            int jobEndTime = currentTime + j.getP();
            endTimeJob.add(jobEndTime);
            currentTime = currentTime + j.getP();
        }
        for (int i = 0; i < endTimeJob.size(); i++) {
            result += myProblem.getJobList().get(i).getA() * Math.max(d - endTimeJob.get(i), 0) + myProblem.getJobList().get(i).getB() * Math.max(endTimeJob.get(i) - d, 0);
        }
        goalFunction=result;
    }


    private int calculateSumP() {
        for (Job j : myProblem.getJobList()) {
            sumP += j.getP();
        }
        return sumP;
    }

    public String toString() {
        return "Funkcja celu " + goalFunction + " h=" + h + " d=" + d + " sumP=" + sumP;
    }

    class InstanceCompare implements Comparator<Job> {
        public int compare(Job a, Job b) {
            if (a.getDifferencePunishment() < b.getDifferencePunishment()) return 1;
            if (a.getDifferencePunishment() > b.getDifferencePunishment()) return -1;
            else return 0;
        }
    }
}
