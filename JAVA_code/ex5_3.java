
class Worker {
    private String name;
    private double salaryRate;
    public Worker(String name, double salaryRate) {
        this.name = name;
        this.salaryRate = salaryRate;
    }
    public double computePay(int hours) {
        return salaryRate * hours;
    }
    public String getName() {
        return name;
    }
}
class DailyWorker extends Worker {
    public DailyWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }
    @Override
    public double computePay(int daysWorked) {
        return super.computePay(daysWorked);
    }
}
class SalariedWorker extends Worker {
    public SalariedWorker(String name, double salaryRate) {
        super(name, salaryRate);
    }
    @Override
    public double computePay(int hours) {
        return super.computePay(40);
    }
}
public class ex5_3 {
    public static void main(String[] args) {
        DailyWorker dailyWorker = new DailyWorker("Soorya", 10.0);
        SalariedWorker salariedWorker = new SalariedWorker("hari", 15.0);
        int dailyHoursWorked = 5;
        int salariedHoursWorked = 50; 
        double dailyPay = dailyWorker.computePay(dailyHoursWorked);
        double salariedPay = salariedWorker.computePay(salariedHoursWorked);
        System.out.println("Weekly pay for " + dailyWorker.getName() + ": $" + dailyPay);
        System.out.println("Weekly pay for " + salariedWorker.getName() + ": $" + salariedPay);
    }
}


