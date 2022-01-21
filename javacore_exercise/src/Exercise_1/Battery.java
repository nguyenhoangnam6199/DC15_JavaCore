package Exercise_1;

public class Battery {
    //Fields
    private String model;
    private int hoursIdle;
    private int hoursTalk;
    private BatteryType batteryType;

    //Getter and Setter
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        if(!model.isEmpty()){
            this.model = model;
        }
        else{
            throw new Error("Model can not be empty text");
        }
    }

    public int getHoursIdle() {
        return hoursIdle;
    }

    public void setHoursIdle(int hoursIdle) {
        if(hoursIdle>=0){
            this.hoursIdle = hoursIdle;
        }
        else{
            throw new Error("HoursIdle can not be negative");
        }

    }

    public int getHoursTalk() {
        return hoursTalk;
    }

    public void setHoursTalk(int hoursTalk) {
        if(hoursTalk>=0){
            this.hoursTalk = hoursTalk;
        }
        else{
            throw new Error("Hours Talk can not be negative");
        }
    }

    public BatteryType getBatteryType() {
        return batteryType;
    }

    public void setBatteryType(BatteryType batteryType) {
        this.batteryType = batteryType;
    }

    //Constructer
    public Battery() {
    }

    public Battery(String model, int hoursIdle, int hoursTalk, BatteryType batteryType) {
        this.model = model;
        this.hoursIdle = hoursIdle;
        this.hoursTalk = hoursTalk;
        this.batteryType = batteryType;
    }

    public Battery(int hoursIdle, int hoursTalk) {
        this.hoursIdle = hoursIdle;
        this.hoursTalk = hoursTalk;
    }

    @Override
    public String toString() {
        return "Battery{" +
                "model='" + model + '\'' +
                ", hoursIdle=" + hoursIdle +
                ", hoursTalk=" + hoursTalk +
                ", batteryType=" + batteryType +
                '}';
    }
}
