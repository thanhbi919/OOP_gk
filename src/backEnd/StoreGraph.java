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
        List<Edge> edges = node.leavingEdges().toList();
        for (Edge edge : edges) {
            nodes.add(edge.getNode1());
        }
        return nodes;
    }

    public static List<Edge> getAdjacencyEdges(Node node) {
        return node.leavingEdges().toList();
    }

    public static List<Node> getAdjacency(String node) {
        return getAdjacency(MainGraph.getNode(node));
    }

}
