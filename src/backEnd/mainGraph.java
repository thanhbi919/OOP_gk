package backEnd;

import org.graphstream.graph.Graph;

public class mainGraph {
    private Graph graph;

    public void create(String fileName) {
        graph = openFile.readfile(fileName);
    }

    public Graph getGraph() {
        return graph;
    }
}
