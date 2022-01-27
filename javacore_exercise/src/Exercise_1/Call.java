package Exercise_1;

import java.time.LocalDate;
import java.util.Date;

public class Call {
    private LocalDate date;
    private String dialedPhoneNumber;
    private int duration;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDialedPhoneNumber() {
        return dialedPhoneNumber;
    }

    public void setDialedPhoneNumber(String dialedPhoneNumber) {
        this.dialedPhoneNumber = dialedPhoneNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Call() {
    }

    public Call(LocalDate date, String dialedPhoneNumber, int duration) {
        this.date = date;
        this.dialedPhoneNumber = dialedPhoneNumber;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Call{" +
                "date=" + date +
                ", dialedPhoneNumber='" + dialedPhoneNumber + '\'' +
                ", duration=" + duration +
                '}';
    }
}
