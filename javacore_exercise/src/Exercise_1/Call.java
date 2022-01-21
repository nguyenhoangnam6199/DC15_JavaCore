package Exercise_1;

import java.time.LocalDate;
import java.util.Date;

public class Call {
    private LocalDate date;
    private String phoneNumber;
    private int duration;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Call() {
    }

    public Call(LocalDate date, String phoneNumber, int duration) {
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Call{" +
                "date=" + date +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", duration=" + duration +
                '}';
    }
}
