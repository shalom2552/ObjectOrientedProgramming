package part1;

import java.util.ArrayList;
import exceptions.*;

// this is a utility class for cleaner and more efficient code
// it didn't came with the exercise files we added that
public final class Util {

    /** gets an customer and a customer list return true if the customer
     *  already exists in the list and false if customer isn't in the list
     *  @param newCustomer customer to look for
     *  @param customers customers list */
    public boolean customerExist(
            Customer newCustomer,
            ArrayList<Customer> customers )
    {
        boolean customerExist = false;
        for ( Customer customer : customers ){
            if ( customer.id == newCustomer.id ){
                customerExist = true;
                break;
            }
        }return customerExist;
    }

    /** util function to check if the input is correct
     * and executing "add" or "remove" commands only
     * @param command string "add or move + provider (internet or infra)"
     * @param state witch provider in */
    public void checkInput(String[] command, State state,String type)
            throws
            IllegalOperationRequest,
            CustomerTypeIllegalException,
            ProviderNotFoundException
    {
        if (command.length < 2 || command.length > 3){
            throw new IllegalOperationRequest("Command not legal");
        }
        if (!command[0].equals("add") && !command[0].equals("remove")){
            throw new IllegalOperationRequest("Command not legal");
        }
        if (command.length == 3 && !command[1].equals("infra")){
            throw new IllegalOperationRequest("Command not legal");
        }
        if (!type.equals("VIP") && !type.equals("Regular")
                && !type.equals("Government") ){ 
            throw new CustomerTypeIllegalException("customer type not legal");
        } // TODO post-submission: type should be customerType
        if (command.length == 3){
            if (state.getInfraStructureProvider(command[2]) == null){
                throw new ProviderNotFoundException("provider " +
                        "name given in command is not an infrastructure" +
                        " provider");
            }
        }else { // length = 2
            if (state.getInternetProvider(command[1]) == null){ 
                throw new ProviderNotFoundException("provider name" +
                        " given in command is not an internet provider");
            } // TODO post-submission: in exception messanges this soulde be with 
            //comand[1/2] to show the provider name given
        } 
    }
// TODO post-submission: 
// add provider, add infra provider
}
