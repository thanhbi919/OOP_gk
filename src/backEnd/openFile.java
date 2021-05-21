package backEnd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;

public class openFile {
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
                        edges = word[0] + " " + word[1];
                        graph.addEdge(edges, word[0], word[i], true);
                    }
                }
            }
            Reader.close();
            return graph;
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
    }

    // public static void main(String[] args) {
    // System.setProperty("org.graphstream.ui", "swing");
    // readfile("/home/vuong/graph.txt");
    // }
}