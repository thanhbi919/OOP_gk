package frontEnd;

import java.awt.*;

import javax.swing.*;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;

public class graphPanel extends JPanel {
    public graphPanel(Graph graph) {
        initgraphPanel(graph);
    }

    private void initgraphPanel(Graph graph) {
        graph = new SingleGraph("Tutorial", false, true);

        graph.addEdge("AB'", "A", "B");
        Node a = graph.getNode("A");
        a.setAttribute("xy", 1, 1);
        Node b = graph.getNode("B");
        b.setAttribute("xy", -1, -1);

        Viewer viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();

        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false);

        setLayout(new GridLayout());
        add(viewPanel);
    }
}
