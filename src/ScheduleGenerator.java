import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ScheduleGenerator {

    private Problem problem;
    private double h;
    private int d;


    public ScheduleGenerator(Problem p, double h, int d ){
        this.problem=p;
        this.h=h;
        this.d=d;
    }

    public void makeSchedule(){
        List<Job> newJobList = problem.getJobList();
        InstanceCompare sort = new InstanceCompare();
        Collections.sort(newJobList, sort);
        InstanceCompareA sortA = new InstanceCompareA();
        Collections.sort(newJobList.subList(0,newJobList.size()/2), sortA);

        int firstHalfLength=0;
        for (int i=0;i<newJobList.size()/2;i++){
            firstHalfLength+=newJobList.get(i).getP();
        }

        InstanceCompareB sortB = new InstanceCompareB();
        Collections.sort(newJobList.subList((newJobList.size()/2),newJobList.size()), sortB);

        int r =Math.max(d-firstHalfLength,0);
        problem.setR(r);
        problem.setGoalFunction(problem.calculateGoalFunction(r));
        problem.setJobList(new ArrayList<>(newJobList));

    }

    private class InstanceCompare implements Comparator<Job> {
        public int compare(Job a, Job b) {
            if (a.getDifferencePunishment() < b.getDifferencePunishment()) return 1;
            if (a.getDifferencePunishment() > b.getDifferencePunishment()) return -1;
            else return 0;
        }
    }

    private class InstanceCompareB implements Comparator<Job> {
        public int compare(Job a, Job b) {
            if (a.getB() < b.getB()) return 1;
            if (a.getB() > b.getB()) return -1;
            else return 0;
        }
    }

    private class InstanceCompareA implements Comparator<Job> {
        public int compare(Job a, Job b) {
            if (a.getA() < b.getA()) return -1;
            if (a.getA() > b.getA()) return 1;
            else return 0;
        }
    }

}
