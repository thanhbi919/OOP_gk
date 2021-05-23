package App;

import javax.swing.JFrame;
import javax.swing.JPanel;


import org.graphstream.graph.Graph;
import org.graphstream.ui.view.Viewer;
import org.graphstream.ui.view.ViewerListener;
import org.graphstream.ui.view.ViewerPipe;

import backEnd.FindAction;
import backEnd.StoreGraph;
import frontEnd.AppUI;

import java.awt.*;
import org.graphstream.ui.swing_viewer.SwingViewer;
import org.graphstream.ui.swing_viewer.ViewPanel;

public class App implements ViewerListener {
    protected boolean loop = true;
    JFrame frame;
     JPanel mainpanel;
     JPanel body;
    JPanel waysPath;
    ViewPanel viewPanel;
    ViewerPipe fromViewer;

    public static void main(String args[]) {
        StoreGraph.create("graph.txt");
        new App(StoreGraph.getGraph());
    }

    public App(Graph graph) {
        mainpanel = new JPanel();
        body = new JPanel();
        waysPath = new JPanel();
        frame = new AppUI(this);

        loadGraph(graph);
        while (loop) {
            fromViewer.pump();
        }
    }

    public void loadGraph(Graph graph) {
        // create body
        body.setLayout(new java.awt.BorderLayout());
        body.add(mainpanel,BorderLayout.CENTER);
        mainpanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Graph", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); 

        body.add(waysPath,BorderLayout.SOUTH);
        waysPath.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ways", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Times New Roman", 1, 14))); 
        waysPath.setPreferredSize(new java.awt.Dimension(0, 155));





        if (viewPanel != null)
            mainpanel.remove(viewPanel);
        Viewer viewer;
        viewer = new SwingViewer(graph, Viewer.ThreadingModel.GRAPH_IN_GUI_THREAD);
        viewer.enableAutoLayout();

        viewPanel = (ViewPanel) viewer.addDefaultView(false);

        mainpanel.add(viewPanel);
        mainpanel.setLayout(new GridLayout());

        frame.add(body);

        fromViewer = viewer.newViewerPipe();
        fromViewer.addViewerListener(this);
        fromViewer.addSink(graph);
        frame.revalidate();
    }

    public void viewClosed(String id) {
        loop = false;
    }

    // From here is about mouse click to Node
    java.awt.Point mouseLocation;

    public void buttonPushed(String id) {
        if (FindAction.isFinding == false)
            return;
        mouseLocation = MouseInfo.getPointerInfo().getLocation();
    }

    public void buttonReleased(String id) {
        if (MouseInfo.getPointerInfo().getLocation().equals(mouseLocation))
            if (StoreGraph.getGraph().getNode(id).getAttribute("ui.class") != null)
                if (StoreGraph.getGraph().getNode(id).getAttribute("ui.class").toString().equals("dekiru"))
                    FindAction.findNext(id);
    }

    public void mouseOver(String id) {
        System.out.println("Need the Mouse Options to be activated");
    }

    public void mouseLeft(String id) {
        System.out.println("Need the Mouse Options to be activated");
    }

}