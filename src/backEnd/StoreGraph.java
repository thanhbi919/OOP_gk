package backEnd;

import java.util.ArrayList;
import java.util.List;

import org.graphstream.graph.Edge;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;

public final class StoreGraph {
    public static Graph MainGraph;

    public static void create(String fileName) {
        if (fileName != null)
            MainGraph = OpenFile.readfile(fileName);
        MainGraph.setAttribute("ui.quality");
        MainGraph.setAttribute("ui.antialias");
        MainGraph.setAttribute("ui.stylesheet",
                "url(https://raw.githubusercontent.com/ducvuongpham/OOP_gk/master/styling.css)");
        System.gc();
    }

    public static Graph getGraph() {
        return MainGraph;
    }

    public static List<Node> getAdjacency(Node node) {
        List<Node> nodes = new ArrayList<>();
        Object[] edges;
        // List<Edge>
        edges = node.leavingEdges().toArray();
        for (Object edge : edges) {
            nodes.add(((Edge) edge).getNode1());
        }
        return nodes;
    }

    public static List<Edge> getAdjacencyEdges(Node node) {
        Object[] edges = node.leavingEdges().toArray();
        List<Edge> returnEdges = new ArrayList<>();
        for (Object edge : edges) {
            returnEdges.add((Edge) edge);
        }
        return returnEdges;
    }

    public static List<Node> getAdjacency(String node) {
        return getAdjacency(MainGraph.getNode(node));
    }

}
