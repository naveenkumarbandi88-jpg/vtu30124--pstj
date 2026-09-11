import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {
    
    // Tracks ongoing trips: id -> (stationName, time)
    private Map<Integer, Pair<String, Integer>> checkInMap;
    
    // Tracks aggregated route stats: "startStation->endStation" -> (totalTime, count)
    private Map<String, Pair<Double, Integer>> routeMap;

    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        routeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Pair<>(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> checkInInfo = checkInMap.remove(id);
        String startStation = checkInInfo.getKey();
        int startTime = checkInInfo.getValue();
        
        String routeKey = startStation + "->" + stationName;
        double travelTime = t - startTime;
        
        Pair<Double, Integer> routeStats = routeMap.getOrDefault(routeKey, new Pair<>(0.0, 0));
        routeMap.put(routeKey, new Pair<>(routeStats.getKey() + travelTime, routeStats.getValue() + 1));
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String routeKey = startStation + "->" + endStation;
        Pair<Double, Integer> routeStats = routeMap.get(routeKey);
        return routeStats.getKey() / routeStats.getValue();
    }
}


Input
["UndergroundSystem","checkIn","checkIn","checkIn","checkOut","checkOut","checkOut","getAverageTime","getAverageTime","checkIn","getAverageTime","checkOut","getAverageTime"]
[[],[45,"Leyton",3],[32,"Paradise",8],[27,"Leyton",10],[45,"Waterloo",15],[27,"Waterloo",20],[32,"Cambridge",22],["Paradise","Cambridge"],["Leyton","Waterloo"],[10,"Leyton",24],["Leyton","Waterloo"],[10,"Waterloo",38],["Leyton","Waterloo"]]
Output
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
Expected
[null,null,null,null,null,null,null,14.00000,11.00000,null,11.00000,null,12.00000]
