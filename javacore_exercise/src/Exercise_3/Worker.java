package Exercise_3;

import java.util.Comparator;

public class Worker extends Human{
    private double weekSalary;
    private float workHourPerDay;
    public double getWeekSalary() {
        return weekSalary;
    }
    public void setWeekSalary(double weekSalary) {
        this.weekSalary = weekSalary;
    }
    public float getWorkHourPerDay() {
        return workHourPerDay;
    }
    public void setWorkHourPerDay(float workHourPerDay) {
        this.workHourPerDay = workHourPerDay;
    }

    public Worker(String firstName, String lastName, double weekSalary,
                  float workHourPerDay) {
        super(firstName, lastName);
        this.weekSalary = weekSalary;
        this.workHourPerDay = workHourPerDay;
    }

    public Worker() {};
    public Double calculateMoneyPerHour() {
        double moneyPerDay = weekSalary / 5;
        return moneyPerDay / 8;
    }

    @Override
    public String toString() {
        return "Worker [firstName: " + this.getFirstName() + " lastName: " + this.getLastName() + " weekSalary=" + weekSalary + ", workHourPerDay="
                + workHourPerDay + ", calculateMoneyPerHour()="
                + calculateMoneyPerHour() + "]";
    }
}
