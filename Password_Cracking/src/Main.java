import edu.uci.ics.jung.graph.DirectedSparseGraph;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        DirectedSparseGraph<Integer, String> g = new DirectedSparseGraph<>();
        try {
            Scanner in = new Scanner(new File("src/p079_keylog.txt"));
            while (in.hasNextLine()) {
                String line = in.nextLine();
                int index1 = Integer.parseInt(String.valueOf(line.charAt(0)));
                int index2 = Integer.parseInt(String.valueOf(line.charAt(1)));
                int index3 = Integer.parseInt(String.valueOf(line.charAt(2)));
                g.addEdge(index1+""+index2,index1,index2);
                g.addEdge(index2+""+index3,index2,index3);
            }
            in.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(g);
        String password = "";
        while (g.getEdgeCount() != 1) {
            for (int vertex : g.getVertices()) {
                if (g.inDegree(vertex) == 0) {
                    password += vertex;
                    break;
                }
            }
            g.removeVertex(Integer.parseInt(password.substring(password.length() - 1)));
        }
        password += g.getEdges().toArray()[0];
        System.out.println(password);
    }
}