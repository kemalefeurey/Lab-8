public class Robot{
    private String modelName;
    private int batteryLevel;
    private String status;
    public Robot(String modelName,int batteryLevel,String status){
        this.batteryLevel=batteryLevel;
        this.modelName=modelName;
        this.status=status;
    }

    public String getModelName() {
        return modelName;
    }
    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }
    public void setBatteryLevel(int batteryLevel) {
        this.batteryLevel = batteryLevel;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void displayRobotInfo(){
        System.out.println("Robot Name: "+getModelName()+" Battery Level: "+getBatteryLevel()+" Status: "+getStatus());
    }
    public boolean isBatteryEnough(int requiredAmount){
        if (requiredAmount<=getBatteryLevel()){
            return true;
        }else {
            return false;
        }
    }
    public void consumeBattery(int amount){
        if(amount>getBatteryLevel()){
            System.out.println("Entered amount is more than battery "+getModelName()+" has.");
        }else{
            setBatteryLevel(getBatteryLevel()-amount);
        }
    }
    public void chargeBattery(int amount){
        setBatteryLevel(getBatteryLevel() + amount);
        if(getBatteryLevel() >= 100){
            setBatteryLevel(100);
            setStatus("Active");
        }else{
            setStatus("Charging");
        }
    }
    public void performTask(Task t){
        System.out.println("Robot "+getModelName()+" is performing the task");
        if(getStatus().equals("Charging")){
            System.out.println("Failure");
        }
        if( isBatteryEnough(t.getBatteryCost()) ){
            consumeBattery(t.getBatteryCost());
            System.out.println("Robot has completed the task: "+t.getTaskName());
        }else{
            System.out.println("Failure");
        }
    }
    public void performTaskBatches(TaskBatch batch){
        if(batch.getTaskCount()==0){
            System.out.println("Failure");
            return;
        }
        int totalEnergyCost=batch.getTotalEnergyCost();
        if(totalEnergyCost>getBatteryLevel()){
            System.out.println("Failure");
        }else{
            System.out.println("Robot " + getModelName() + " is processing the task batch...");
            for (int i=0;i<batch.getTaskCount();i++){
                performTask(batch.getTasksArray(i));
            }
            displayRobotInfo();
        }
    }
}