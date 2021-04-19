package part1;

import java.net.CookieStore;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
// TODO post-submission: do we use all of them?

public class State {
    private final String stateName;
    private static ArrayList<InfraStructureProvider> infraStructureProviders;
    private static ArrayList<InternetProvider> internetProviders;

    public State ( String stateName ){
        this.stateName = stateName;
        infraStructureProviders = new ArrayList<>();
        internetProviders = new ArrayList<>();
    }

    public void setInfraStructureProviders( List<InfraStructureProvider> lst ){
        infraStructureProviders.addAll( lst );
    }


    public void setInternetProviders( List<InternetProvider> lst ){
        internetProviders.addAll( lst );
    }

    public InternetProvider getInternetProvider( String name ){
        for ( InternetProvider provider : internetProviders) {
            if ( provider.getName().equals(name) ){
                return provider;
            }
        } return null;
    }

    public InfraStructureProvider getInfraStructureProvider( String name ){
        for ( InfraStructureProvider provider : infraStructureProviders) {
            if ( provider.getName().equals(name) ){
                return provider;
            }
        } return null;
    }

    /** initializing state, including internet and infra structure providers */
    public void init() {
        ArrayList<InternetProvider> internetProvidersList = new ArrayList<>();
        ArrayList<InfraStructureProvider> infraProvidersList =new ArrayList<>();
        // add providers to lists
        internetProvidersList.add( new InternetProvider(
                Constants.cellcom, Constants.cellcomCharge ));
        internetProvidersList.add( new InternetProvider(
                Constants.benleumi, Constants.benleumiCharge ));
        internetProvidersList.add( new InternetProvider(
                Constants.partner, Constants.partnerCharge ));
        infraProvidersList.add( new InfraStructureProvider(
                Constants.bezeq, Constants.bezeqCharge ));
        infraProvidersList.add( new InfraStructureProvider(
                Constants.hot, Constants.hotCharge ));
        // set providers lists
        setInternetProviders(internetProvidersList);
        setInfraStructureProviders(infraProvidersList);
    
        // TODO post-submission: 
        // base charges is now in Constants class
        // code clean
    }


}
