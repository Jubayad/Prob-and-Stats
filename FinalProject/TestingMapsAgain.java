import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class TestingMapsAgain {
    
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        //TreeMap<String, Integer> hm = new TreeMap<>();

        hm.put("Tom", 1);
        hm.put("Brandom", 22);
        hm.put("Lisa", 3);
        hm.put("Brandom", 2);
        hm.put("Jerry", 3);

        //Sometimes helpful to have a "super" data structure
        HashMap<String, ArrayList<String>> smh = new HashMap<>();


        System.out.println("The size of my map is: " + hm.size());
        System.out.println("What is List? " + hm.get("Lisa"));


        for(String singleValue: hm.keySet()){
            System.out.println(singleValue);
        }
    }
}
