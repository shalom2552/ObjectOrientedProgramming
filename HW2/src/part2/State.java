package part2;

import java.net.CookieStore;
import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class State {
    private String stateName;
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

    public ArrayList<InternetProvider> getInternetProvidersList(){
        return new ArrayList<>(internetProviders);
    }

    /** initializing state, including internet and infra structure providers */
    public void init() {
        InternetProvider Cellcom = new InternetProvider(
                Constants.cellcom,100.00);
        InternetProvider Benleumi = new InternetProvider(
                Constants.benleumi,150.00);
        InternetProvider Partner = new InternetProvider(
                Constants.partner,90.00);
        InfraStructureProvider Bezeq = new InfraStructureProvider(
                Constants.bezeq, 70.00);
        InfraStructureProvider HOT = new InfraStructureProvider(
                Constants.hot,100.00);
        ArrayList<InternetProvider> netList = new ArrayList<>();
        ArrayList<InfraStructureProvider> infraList = new ArrayList<>();
        netList.add(Cellcom);
        netList.add(Benleumi);
        netList.add(Partner);
        setInternetProviders(netList);
        infraList.add(Bezeq);
        infraList.add(HOT);
        setInfraStructureProviders(infraList);
    }

}
