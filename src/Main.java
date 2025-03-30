package Intento.src;

import Intento.src.models.DirectedGraph;
import Intento.src.models.Node;
import Intento.src.models.DirectedEdge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<Node>();
        List<DirectedEdge> aristas = new ArrayList<DirectedEdge>();
        Node node1 = new Node("node1", 1);
        Node node2 = new Node("node2", 2);
        Node node3 = new Node("node3", 3);
        Node node4 = new Node("node4", 4);
        Node node5 = new Node("node5", 5);
        Node node6 = new Node("node6", 6);

        
        DirectedEdge directedEdge1 = new DirectedEdge(node1, node2);
        DirectedEdge directedEdge2 = new DirectedEdge(node2, node3);
        DirectedEdge directedEdge3 = new DirectedEdge(node3, node4);
        DirectedEdge directedEdge4 = new DirectedEdge(node4, node1);
        DirectedEdge directedEdge5 = new DirectedEdge(node5, node6);

        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node1);
        nodes.add(null);

        aristas.add(directedEdge1);
        aristas.add(directedEdge2);
        aristas.add(directedEdge3);
        aristas.add(directedEdge4);
        aristas.add(directedEdge5);

        DirectedGraph directedGraph = new DirectedGraph(nodes, aristas);
        System.out.println(directedGraph);

        directedGraph.addEdge(directedEdge5, true);
        System.out.println(directedGraph);
    }
}