package part2;

import java.util.ArrayList;
import exceptions.*;

public class InternetProvider {
    private String name;
    private double baseCharge;
    private ArrayList<Customer> customers;
    Util util = new Util();

    public InternetProvider(String name, Double baseCharge ){
        this.name = name;
        this.baseCharge = baseCharge;
        customers = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Customer> getCustomersList(){ return customers; }

    public double getBaseCharge(){ return baseCharge; }

    /** gets a customer and adding him it to the customer list
     * if customer is already exist print a message
     * @param customer to add to list */
    public void addCustomer(Customer customer){
        if ( util.customerExist(customer, customers) ){
            System.out.println("Customer " + customer.id + " already " +
                    "connected to " + this.name);
            return;
        } this.customers.add(customer);
    }

    /** gets a customer and removing him from the customer list
     * if customer not exist throw Exception
     * @param customer to remove to list */
    public void removeCustomer(Customer customer) throws CustomerNotListedException{
        boolean customerExist = util.customerExist(customer, customers);
        if (!customerExist){
            System.out.println("Customer "+ customer.id + " does not have " +
                    this.getName() + " as internet provider");
            throw new CustomerNotListedException("Customer " + customer.id +
                    " is not listed in " + this.name + " customer list");
        } this.customers.remove(customer);
    }

    /** given "add" or "remove" command and a provider the function will add
     *  or remove the relevant customer from the customer list
     *  @param command add or remove
     *  @param provider infra structure provider */
    public void handleInfraStructureProvidersForCustomer (
            String command, InfraStructureProvider provider, Customer customer){
        if ( command.equals("add") ){
            provider.addCustomer(customer);
        } else{
            try {
                provider.removeCustomer(customer);
            } catch (CustomerNotListedException e){
                System.out.println(e.getMessage());
            }
        }
    }

}