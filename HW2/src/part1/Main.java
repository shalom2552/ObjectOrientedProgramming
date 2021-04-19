package part1;

import csv.CSVRecord;
import csv.SEFileUtil;
import exceptions.*;

import java.util.ArrayList;

public class Main {
    public Main(){ super();}

    public static void main(String[] args) {
        Main m = new Main();
        State state = new State("IL");
        state.init();
        m.parseData(args[0], state);
        ArrayList<Customer> partnerCustomers = state.getInternetProvider(Constants.partner).getCustomersList();
        System.out.println("First 10 customers of Partner are: ");
        for(int i=0 , count=0 ; i< partnerCustomers.size() && count<10; i++, count++){
            System.out.print(partnerCustomers.get(i).getId() + " ");
        }
        ArrayList<Customer> hotCustomers = state.getInfraStructureProvider(Constants.hot).getCustomersList();
        System.out.println("\n First 10 customers of Hot are: ");
        for(int i=0, count=0; i<hotCustomers.size() && count<10; i++ , count++){
            System.out.print(hotCustomers.get(i).getId()+ " ");
        }
    }

    /** checks for each line in csv file whether the customer is new or
     * old, what is the customer type and what to do with this data
     * @param path path to csv file
     * @param state object of state */
    public void parseData( String path, State state ){
        SEFileUtil seFileUtil = new SEFileUtil(path);
        for (CSVRecord record : seFileUtil.getCSVParser()) {
            // store values
            try {
                Integer.parseInt(record.get(0));
            }catch (Exception e){
                System.out.println("id is not conform");
                continue;
            }
            int id = Integer.parseInt(record.get(0));
            String customerType = record.get(1);
            String[] command1 = record.get(2).split(" ");
            String[] command2 = record.get(3).split(" ");
            Util util = new Util();
            // check input
            try {
                util.checkInput(command1, state, customerType);
                handle(id, command1, customerType, state);
            } catch (
                    IllegalOperationRequest |
                    CustomerTypeIllegalException |
                    ProviderNotFoundException e)
            { System.out.println(e.getMessage()); }
            try {
                util.checkInput(command2, state, customerType);
                handle(id, command2, customerType, state);
            } catch (
                    IllegalOperationRequest |
                    CustomerTypeIllegalException |
                    ProviderNotFoundException e)
            { System.out.println(e.getMessage()); }
        }
    }

    /** gets a conform command and checks which type of command it is
     * */
    public void handle(int id, String[] command, String customerType,
                      State state){
        if (command.length == 2) {
            handleInternet(customerType, state, command, id);
        }else {
            handleInfraStructure(customerType, state, command, id);
        }
    } // TODO post-submission: this could be in Util class (?)

    /** getting a customer type, a state, a string of command and an id,
     * the function will create a customer's type and id and call to the
     * right function based on customer's type.
     * @param customerType to create a customer
     * @param state to get the provider
     * @param command string with command add or remove
     * @param id of customer*/
    public static void handleInternet(String customerType, State state ,
                                      String[] command, int id){
        switch (customerType) {
            case "Regular" -> {
                Customer regularCustomer = new RegularCustomer(id);
                regularCustomer.handleInternetProvider(command[0],
                        state.getInternetProvider(command[1]));
            }
            case "Government" -> {
                Customer governmentCustomer = new GovernmentCustomer(id);
                governmentCustomer.handleInternetProvider(command[0],
                        state.getInternetProvider(command[1]));
            }
            case "VIP" -> {
                Customer VipCustomer = new VIPCustomer(id);
                VipCustomer.handleInternetProvider(command[0],
                        state.getInternetProvider(command[1]));
            }
        } 
    } // TODO post-submission: this should be in Util class

    /** getting a customer type, a state, a string of command and an id,
     * the function will create a customer's type and id and call to the
     * right function based on customer's type.
     * @param customerType to create a customer
     * @param state to get the provider
     * @param command string with command add or remove
     * @param id of customer*/
    public static void handleInfraStructure(String customerType, State state ,
                                            String[] command, int id){
        switch (customerType) {
            case "Regular" -> {
                Customer regularCustomer = new RegularCustomer(id);
                regularCustomer.handleInfraStructureProviders(command[0],
                        state.getInfraStructureProvider(command[2]));
            }
            case "Government" -> {
                Customer governmentCustomer = new GovernmentCustomer(id);
                governmentCustomer.handleInfraStructureProviders(command[0],
                        state.getInfraStructureProvider(command[2]));
            }
            case "VIP" -> {
                Customer VipCustomer = new VIPCustomer(id);
                VipCustomer.handleInfraStructureProviders(command[0],
                        state.getInfraStructureProvider(command[2]));
            }
        }
    }// TODO post-submission: this should be in Util class

}
