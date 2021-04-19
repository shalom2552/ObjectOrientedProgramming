package part2;

public class RegularCustomer extends Customer{
    public RegularCustomer(int id){ super(id); }

    /** calculate the amount the customer needs to pay each month
     @return payment per month */
    public double calculateMonthlyPayment(){
        double sum = sumPayment(this);
        sum = sum*Constants.TAX;
        return sum;
    }

}

