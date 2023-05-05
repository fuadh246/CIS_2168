import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseGraph;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        SparseGraph<Integer, String> g = new SparseGraph<>();
        g.addEdge("12", 1, 2);
        g.addEdge("23", 2, 3);
        g.addEdge("34", 3, 4);
        g.addEdge("46", 4, 6);
        g.addEdge("65", 6, 5);
        g.addEdge("59", 5, 9);
        g.addEdge("911", 9, 10);
        System.out.println(g);
        System.out.println("Breadth First Search: "+BFSearch(g,1));
        System.out.println("Depth First Search: "+DFSearch(g,1));

    }
    public static ArrayList<Integer> BFSearch(SparseGraph<Integer, String> g, int start){
        ArrayList<Integer> visited = new ArrayList<>();
        Queue<Integer> identified = new LinkedList<>();
        identified.add(start);
        while (!identified.isEmpty()){
            int current = identified.poll();
            visited.add(current);
            for (int neighbor: g.getNeighbors(current)) {
                if(!visited.contains(neighbor)&&!identified.contains(neighbor)){
                    identified.add(neighbor);
                }
            }
        }
        return visited;
    }
    public static ArrayList<Integer> DFSearch(SparseGraph<Integer, String> g, int start){
        ArrayList<Integer> finish_order = new ArrayList<>();
        Stack<Integer> visit = new Stack<>();
        visit.push(start);
        while (!visit.isEmpty()) {
            int current = visit.pop();
            for (int neighbor: g.getNeighbors(current)) {
                if (!finish_order.contains(neighbor) && !visit.contains(neighbor)) {
                    visit.push(neighbor);
                }
            }
            finish_order.add(current);
        }


        return finish_order;
    }
}