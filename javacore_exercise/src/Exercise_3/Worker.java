package Exercise_3;

import java.util.Comparator;

public class Worker extends Human implements Comparator<Worker>{
//    public static final Comparator<Worker> SalaryPerDayComparator = new SalaryComparator();
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


    @Override
    public int compare(Worker o1, Worker o2) {
        return (int) (o2.calculateMoneyPerHour()-o1.calculateMoneyPerHour());
    }
}
