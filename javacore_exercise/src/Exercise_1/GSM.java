package Exercise_1;

import java.util.ArrayList;
import java.util.List;

public class GSM {
    //Fields
    private String model;
    private String manufacturer;
    private int price;
    private String owner;
    private Battery battery;
    private Display display;
    public ArrayList<Call> callHistory = new ArrayList<>();

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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        if(!manufacturer.isEmpty()){
            this.manufacturer = manufacturer;
        }
        else{
            throw new Error("Manufacturer can not be empty text");
        }
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if(price >=0){
            this.price = price;
        }
        else{
            throw new Error("Price can not be negative");
        }
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        if(!owner.isEmpty()){
            this.owner = owner;
        }
        else{
            throw new Error("Owner can not be empty text");
        }

    }

    public Battery getBattery() {
        return battery;
    }

    public void setBattery(Battery battery) {
        this.battery = battery;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public ArrayList<Call> getCallHistory() {
        return callHistory;
    }

    public void setCallHistory(ArrayList<Call> callHistory) {
        this.callHistory = callHistory;
    }

    //Constructer
    public GSM() {
    }

    public GSM(String model, String manufacturer, int price, String owner, Battery battery, Display display) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.owner = owner;
        this.battery = battery;
        this.display = display;
    }

    public GSM(String model, String manufacturer, int price, String owner, Battery battery) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.owner = owner;
        this.battery = battery;
    }

    public GSM(String model, String manufacturer, int price, String owner) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.price = price;
        this.owner = owner;
    }

    //displaying all information about GSM
    @Override
    public String toString() {
        return "GSM{" +
                "model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", owner='" + owner + '\'' +
                ", battery=" + battery +
                ", display=" + display +
                '}';
    }

    //Add a static field and a property IPhone4S
    // in the GSM class to hold the information about iPhone 4S.
    public static GSM iPhone4S = new GSM("IPhone4S","Iphone",1000,"Nam Hoang");

    //Add method to add call
    public void addCall(Call call){
        if(call != null){
            callHistory.add(call);
        }
        else{
            throw new Error("Call is not empty !");
        }
    }

    //Add method to delete call
    public void deleteCall(Call call){
        callHistory.remove(call);
    }

    //Add method to clear the call history
    public void clearCall(){
        callHistory.clear();
    }

    //Add a method
    // that calculates the total price of the calls in the call history
    public double calculateTotalPrice(double pricePerMinute){
        double result = 0;
        for(Call call : callHistory){
            result += (call.getDuration()/60)*pricePerMinute;
        }
        return result;
    }

    public Call findLongestCall(ArrayList<Call> callArrayList){
        Call result = callArrayList.get(0);
        for(int i=1; i<callArrayList.size(); i++){
            if(callArrayList.get(i).getDuration()>result.getDuration()){
                result = callArrayList.get(i);
            }
        }
        return result;
    }

}
