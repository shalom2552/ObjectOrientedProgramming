package part1;

import java.util.Random;

public class VIPCustomer extends Customer{
    public VIPCustomer(int id){ super(id); }

    /** calculate the amount this customer needs to pay each month
    @return payment per month */
    public double calculateMonthlyPayment(){
        double sum = sumPayment(this);
        Random r = new Random();
        return sum*r.nextDouble();
    }

}

