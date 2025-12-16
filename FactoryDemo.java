import java.util.Scanner;
public class FactoryDemo {
    public static void main(String[]args){
        Robot r1=new Robot("Kadriye",93,"Active");
        Robot r2=new Robot("Remzi",78,"Active");
        r1.displayRobotInfo();
        r2.displayRobotInfo();
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the battery level to consume");
        int bl=sc.nextInt();
        r1.consumeBattery(bl);
        r1.displayRobotInfo();
        Task t1=new Task("Task 1",1);
        if(r1.isBatteryEnough(t1.getBatteryCost())){
            System.out.println("Enough battery");
        }else{
            System.out.println("Not enough battery");
        }
        r1.displayRobotInfo();
        r1.performTask(t1);
        r1.displayRobotInfo();
        Task t2=new Task("Task 2",23);
        Task t3=new Task("Task 3",17);
        Task t4=new Task("Task 4",11);
        Task t5=new Task("Task 5",31);
        TaskBatch batch = new TaskBatch();
        batch.addTask(t1);
        batch.addTask(t2);
        batch.addTask(t3);
        batch.addTask(t4);
        batch.addTask(t5);
        batch.printBatchInfo();
        System.out.println("Total Energy Cost: " + batch.getTotalEnergyCost());
        System.out.println("Battery: "+r1.getBatteryLevel());
        r1.performTaskBatches(batch);
        System.out.println("Battery: "+r1.getBatteryLevel());
    }
}
