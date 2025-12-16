public class TaskBatch {
    private Task[] tasks;
    private int taskCount;
    public int getTaskCount() {
        return taskCount;
    }
    public Task getTasksArray(int i){
        return tasks[i];
    }

    public TaskBatch() {
        this.tasks = new Task[5];
        this.taskCount = 0;
    }
    public void addTask(Task t){
        if(taskCount<5){
            tasks[taskCount]=t;
            taskCount++;
        }else{
            System.out.println("Failure: Task batch is full.");
        }
    }
    public int getTotalEnergyCost(){
        int totalEnergyCost=0;
        if(taskCount==0){
            totalEnergyCost=0;
        }else {
            for (int i = 0; i < taskCount; i++) {
                totalEnergyCost=totalEnergyCost +tasks[i].getBatteryCost();
            }
        }
        return totalEnergyCost;
    }
    public void getTasks(){
        if(taskCount==0){
            System.out.println("Failure");
        }else {
            for (int i = 0; i < taskCount; i++) {
                System.out.print(tasks[i]+" ");
            }
        }
    }
    public void printBatchInfo(){
        if(taskCount==0){
            System.out.println("Failure");
        }else {
            for (int i = 0; i < taskCount; i++) {
                System.out.println("Task: "+tasks[i].getTaskName()+" Energy cost: "+tasks[i].getBatteryCost());
            }
        }
    }
}