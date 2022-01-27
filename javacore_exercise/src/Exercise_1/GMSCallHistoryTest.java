package Exercise_1;

import java.time.LocalDate;
import java.util.Date;

public class GMSCallHistoryTest {

    public static void main(String[] args) {
        Battery battery = new Battery("ABC",45,47,BatteryType.LiIon);
        Display display = new Display(15,1234);

        GSM gsm = new GSM("ADS","AGF",7450,"Nam Hoang",battery,display);

        //Add few calls.
        gsm.addCall(new Call(LocalDate.now(),"19001023",3250));
        gsm.addCall(new Call(LocalDate.now(),"18891023",4650));
        gsm.addCall(new Call(LocalDate.now(),"17751533",9650));

        //Display the information about the calls.
        System.out.println("List of call history: ");
        for(Call call : gsm.callHistory){
            System.out.println(call.toString());
        }

        //Assuming that the price per minute is 0.37 calculate and
        // print the total price of the calls in the history.
        double pricePerMinute = 0.37;
        System.out.println("The total price of the call history: "+gsm.calculateTotalPrice(pricePerMinute));

        //Remove the longest call from the history and calculate the total price again
        Call longestCall = gsm.findLongestCall(gsm.callHistory);
        gsm.deleteCall(longestCall);
        System.out.println("The total price after delete longest call is: "+gsm.calculateTotalPrice(pricePerMinute));

        //Finally clear the call history and print it.
        gsm.clearCall();
        if(gsm.callHistory.size()==0){
            System.out.println("Call History is empty");
        }
    }


}
