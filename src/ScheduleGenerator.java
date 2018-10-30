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
        int r=0;


        problem.setR(r);
        problem.calculateGoalFunction(r);
        problem.setJobList(new ArrayList<>(newJobList));
    }

    class InstanceCompare implements Comparator<Job> {
        public int compare(Job a, Job b) {
            if (a.getDifferencePunishment() < b.getDifferencePunishment()) return 1;
            if (a.getDifferencePunishment() > b.getDifferencePunishment()) return -1;
            else return 0;
        }
    }
}
