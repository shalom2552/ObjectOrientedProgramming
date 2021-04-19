package part1;

import java.util.ArrayList;
import exceptions.*;

public abstract class Customer {
    protected int id;
    protected ArrayList<InfraStructureProvider> infraStructureProviders;
    protected ArrayList<InternetProvider> internetProviders;
    Util util = new Util();
    // TODO post-submission: did we used:
    //      infraStructureProviders , internetProviders ?
    //      it could be the duplicated exceptions was in the output reference
    //      "customer id is not in provider customer list"
    //      "provider is not in customer list"

    public Customer( int id ){ this.id = id; }

    public int getId() { return id; }

    /** given a "add" or "remove" command and a provider, this function will add
     *  or remove the relevant customer from customer list
     *  @param command add or remove
     *  @param provider internet provider */
    public void handleInternetProvider(String command,
                                       InternetProvider provider){
        if ( command.equals("add") ){
            provider.addCustomer(this);
        } else {
            try {
            provider.removeCustomer(this);
            } catch (CustomerNotListedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /** given a "add" or "remove" command and a provider, this function will add
     *  or remove the relevant customer from customer list
     *  @param command add or remove
     *  @param provider infra structure provider */
    public void handleInfraStructureProviders (String command,
                                              InfraStructureProvider provider){
        if ( command.equals("add") ){
            provider.addCustomer(this);
        } else{
            try {
                provider.removeCustomer(this);
            } catch (CustomerNotListedException e){
                System.out.println(e.getMessage());
            }
        }
    }

    /** calculate the monthly amount, the customer have to pay
     @return payment per month */
    abstract double calculateMonthlyPayment();

    /** sum total amount the customer have to pay to all the providers
     * @param customer to sum for*/
    public double sumPayment(Customer customer){
        double sum = 0;
        for (InfraStructureProvider prov : infraStructureProviders) {
            if (util.customerExist(customer, prov.getCustomersList()) ) {
                sum += prov.getBaseCharge();
            }
        }
        for (InternetProvider prov : internetProviders) {
            if (util.customerExist(customer, prov.getCustomersList()) ) {
                sum += prov.getBaseCharge();
            }
        } return sum;
    }

}

