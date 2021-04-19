package part1;

public class GovernmentCustomer extends Customer{
    static final double INFRA = 200;
    static final double INTERNET = 150;

    public GovernmentCustomer(int id){ super(id); }

    /** calculate the amount the customer needs to pay each month
     @return payment per month */
    public double calculateMonthlyPayment(){
        double sum = 0;
        sum -= infraStructureProviders.size()*INTERNET;
        sum -= internetProviders.size()*INFRA;
        sum += sumPayment(this);
        return sum;
    }
}
