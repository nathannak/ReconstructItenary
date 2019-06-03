import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

//        Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
//        Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]

//        List<List<String>> list = new ArrayList<>();
//
//        List<String> list1 = new ArrayList<String>(){{
//            add("MUC");
//            add("LHR");
//        }};
//
//        list.add(new ArrayList<>(list1));
//
//        list1 = new ArrayList<String>(){{
//            add("JFK");
//            add("MUC");
//        }};
//
//        list.add(new ArrayList<>(list1));
//
//        list1 = new ArrayList<String>(){{
//            add("SFO");
//            add("SJC");
//        }};
//
//        list.add(new ArrayList<>(list1));
//
//        list1 = new ArrayList<String>(){{
//            add("LHR");
//            add("SFO");
//        }};
//
//        list.add(new ArrayList<>(list1));

//        System.out.println(findItinerary(list));


//      Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
//      Output1: ["JFK","ATL","JFK","SFO","ATL","SFO"]
//      Output2: ["JFK","SFO","ATL","JFK","ATL","SFO"].

        List<List<String>> list = new ArrayList<>();

        List<String> list1 = new ArrayList<String>(){{
            add("JFK");
            add("SFO");
        }};

        list.add(new ArrayList<>(list1));

        list1 = new ArrayList<String>(){{
            add("JFK");
            add("ATL");
        }};

        list.add(new ArrayList<>(list1));

        list1 = new ArrayList<String>(){{
            add("SFO");
            add("ATL");
        }};

        list.add(new ArrayList<>(list1));

        list1 = new ArrayList<String>(){{
            add("ATL");
            add("JFK");
        }};

        list.add(new ArrayList<>(list1));

        list1 = new ArrayList<String>(){{
            add("ATL");
            add("SFO");
        }};

        list.add(new ArrayList<>(list1));

        System.out.println(findItinerary(list));

    }

    public static List<String> findItinerary(List<List<String>> tickets) {

        boolean[] visited = new boolean[tickets.size()];

        //find jfk
        int start=0;

        for(int i =0 ; i < tickets.size();i++){
            if(tickets.get(i).get(0).equals("JFK")){
                start=i;
                break;
            }
        }

        //add index to Queue
        Queue<List<String>> q = new LinkedList<>();
        List<String> res = new ArrayList<>();

        q.add(tickets.get(start));
        visited[start]=true;

        res.add("JFK");
        res.add(tickets.get(start).get(1));

        while(!q.isEmpty()){

            //pop and get dest
            List<String> list = q.poll();
            String dest = list.get(1);

            //navigate the original itenary look for items which start with dest
            for(int i =0 ; i < tickets.size(); i++){

                if(!visited[i] && tickets.get(i).get(0).equals(dest) ) {
                    q.add(tickets.get(i));
                    visited[i]=true;
                    res.add(tickets.get(i).get(1));
                    break;
                }
            }
        }

        return res;

    }

}
