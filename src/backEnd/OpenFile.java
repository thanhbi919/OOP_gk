package backEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class OpenFile {
    public static Graph readfile(String filename) {
        Graph graph = new SingleGraph("Graph", false, true);
        String line;
        String edges;
        try {
            File Object = new File(filename);
            Scanner Reader = new Scanner(Object);

            while (Reader.hasNextLine()) {
                line = Reader.nextLine().trim();
                String[] word = line.split("\\s+");
                graph.addNode(word[0]);
                for (int i = 1; i < word.length; i++) {
                    if (word[0].equals(word[i]) == false) {
                        // graph.addNode(word[i]);
                        edges = word[0] + word[i];
                        graph.addEdge(edges, word[0], word[i], true);
                    }
                }
            }
            Reader.close();
            for (Node node : graph) {
                node.setAttribute("ui.label", node.getId());
            }
            return graph;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }
}