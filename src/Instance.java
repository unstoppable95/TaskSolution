import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Instance {

    private Problem myProblem;
    private double h;
    private int d;
    private int sumP=0;
    private double goalFunction;

    public Instance(Problem p,double h){
        this.myProblem=generateSchedule(p);
        this.h=h;
        this.sumP=calculateSumP();
        this.d=(int)Math.floor(sumP*h);
        this.goalFunction=calculateGoalFunction();
    }

    public Problem getMyProblem() {
        return myProblem;
    }

    private Problem generateSchedule(Problem p){
        List<Job> newJobList =p.getJobList();
        Collections.shuffle(newJobList);
        p.setJobList(newJobList);
        return  p;
    }

    public double getGoalFunction() {
        return goalFunction;
    }

    private int calculateGoalFunction(){
        List<Integer> endTimeJob = new ArrayList<>();
        int currentTime=0;
        int result=0;
        for (Job j:myProblem.getJobList()){
            int jobEndTime=currentTime+j.getP();
            endTimeJob.add(jobEndTime);
            currentTime=currentTime+j.getP();
        }

        for (int i=0; i<endTimeJob.size(); i++){
            result+=myProblem.getJobList().get(i).getA() *Math.max(d-endTimeJob.get(i),0) + myProblem.getJobList().get(i).getB() *Math.max(endTimeJob.get(i)-d,0);
        }

        return result;
    }


    private int calculateSumP(){
        for(Job j: myProblem.getJobList()){
            sumP+=j.getP();
        }
        return sumP;
    }

   public String toString(){
        return "Funkcja celu " + goalFunction + " h=" +h + " d="+d +" sumP=" +sumP;
   }


}
