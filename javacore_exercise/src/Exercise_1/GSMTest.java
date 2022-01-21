package Exercise_1;

import java.util.ArrayList;

public class GSMTest {
    public static void main(String[] args) {
        //Create an array of few instances of the GSM class.
        ArrayList<GSM> gsmList = new ArrayList<>();
        Battery battery = new Battery("ABC",45,47,BatteryType.LiIon);
        Display display = new Display(15,1234);

        gsmList.add(new GSM("ADS","AGF",7450,"Nam Hoang",battery,display));
        gsmList.add(new GSM("AFG","AHJ",8750,"Nam Hoang",battery,display));

        //Display the information about the GSMs in the array.
        System.out.println("List of GSM: ");
        for(GSM i : gsmList){
            System.out.println(i.toString());
        }

        //Display the information about the static property IPhone4S.
        System.out.println(GSM.iPhone4S);
    }
}
