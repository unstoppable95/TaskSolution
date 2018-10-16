public class Job {

    private int p; //time
    private int b; //punishment for earlier execution
    private int c; //punishment for later execution

    public Job(int p,int b,int c){
        this.p=p;
        this.b=b;
        this.c=c;
    }

    public int getP() {
        return p;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public String toString(){
        return "Job: P="+getP() +" B=" +getB() +" C="+ getC();
    }
}
