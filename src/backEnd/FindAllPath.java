package backEnd;

import java.util.ArrayList;

import org.graphstream.graph.Node;

public class FindAllPath {
    public static void printAllPaths(String s, String d) {
        if (StoreGraph.PathLists != null)
            StoreGraph.PathLists.clear();
        System.gc();

        StoreGraph.PathLists = new ArrayList<ArrayList<String>>();
        for (Node node : StoreGraph.MainGraph) {
            node.removeAttribute("isVisited");
        }
        ArrayList<String> pathList = new ArrayList<>();
        pathList.add(s);

        printAllPathsUtil(s, d, pathList);
        System.out.println("\nAll printed! :D");
        System.out.println(StoreGraph.PathLists);
        System.out.println("\n\n");

    }

    private static ArrayList<ArrayList<String>> printAllPathsUtil(String u, String d, ArrayList<String> localPathList) {
        if (u.equals(d)) {
            StoreGraph.PathLists.add((ArrayList<String>) localPathList.clone());
            return StoreGraph.PathLists;
        }
        StoreGraph.MainGraph.getNode(u).setAttribute("isVisited", "true");
        for (Node node : StoreGraph.getAdjacency(u)) {
            String i = node.getId();
            if (node.hasAttribute("isVisited") == false) {
                localPathList.add(i);
                printAllPathsUtil(i, d, localPathList);
                localPathList.remove(i);
            }
        }
        StoreGraph.MainGraph.getNode(u).removeAttribute("isVisited");
        return StoreGraph.PathLists;
    }
}