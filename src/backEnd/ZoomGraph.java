package backEnd;

import org.graphstream.ui.swing_viewer.ViewPanel;

import java.awt.*;
import java.awt.event.MouseWheelEvent;

public class ZoomGraph{

    public ZoomGraph(){
    }
    //the methode that will zoom the graph
    public static void zoomGraphMouseWheelMoved(MouseWheelEvent mwe, ViewPanel view_panel){
        if (Event.ALT_MASK != 0) {
            if (mwe.getWheelRotation() > 0) {
                double new_view_percent = view_panel.getCamera().getViewPercent() + 0.05;
                view_panel.getCamera().setViewPercent(new_view_percent);
            } else if (mwe.getWheelRotation() < 0) {
                double current_view_percent = view_panel.getCamera().getViewPercent();
                if(current_view_percent > 0.05){
                    view_panel.getCamera().setViewPercent(current_view_percent - 0.05);
                }
            }
        }
    }


} 
