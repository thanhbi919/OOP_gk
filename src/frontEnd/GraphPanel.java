package frontEnd;

import java.awt.*;

import javax.swing.*;

import org.graphstream.graph.Graph;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerPipe;

import backEnd.StoreGraph;

public class GraphPanel extends JPanel {
    private static Viewer viewer;

    public static JPanel create(Graph graph) {
        return initgraphPanel(graph);
    }

    private static JPanel initgraphPanel(Graph graph) {
        graph.setAttribute("ui.stylesheet", "url(file://" + System.getProperty("user.dir") + "/styling.css" + ")");
        viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.EXIT);

        ViewPanel viewPanel = (ViewPanel) viewer.addDefaultView(false);

        JPanel mainpanel = new JPanel();
        mainpanel.setLayout(new GridLayout());
        mainpanel.add(viewPanel);
        return mainpanel;
    }

    public static void addClickListener() throws InterruptedException {
        ViewerPipe fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(new ClickListener(viewer, fromViewer));
        fromViewer.blockingPump();
        fromViewer.addSink(StoreGraph.getGraph());
    }
}
