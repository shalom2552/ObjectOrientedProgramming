package part1;

import java.util.ArrayList;
import exceptions.*;


public class InfraStructureProvider {
    private String name;
    private double baseCharge;
    private ArrayList<Customer> customers;
    Util util = new Util();

    public InfraStructureProvider(String name, double baseCharge){
        this.name = name;
        this.baseCharge = baseCharge;
        customers = new ArrayList<>();
    }

    public ArrayList<Customer> getCustomersList(){ return customers; }

    public String getName(){ return this.name; }

    public double getBaseCharge(){ return baseCharge; }

    /** gets a customer and adding him to the customer list
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
                    this.getName() + " as infra provider");
        throw new CustomerNotListedException("Customer " + customer.id +
                " is not listed in " + this.name + " customer list");
        } this.customers.remove(customer);
    }
}
