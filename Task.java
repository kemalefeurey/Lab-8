public class Task {
    private String taskName;
    private int batteryCost;
    public Task(String taskName,int batteryCost){
        this.batteryCost=batteryCost;
        this.taskName=taskName;
    }

    public String getTaskName() {
        return taskName;
    }
    public int getBatteryCost() {
        return batteryCost;
    }
    public void describeTask(){
        System.out.println(getTaskName());
        System.out.println(getBatteryCost());
    }
}
