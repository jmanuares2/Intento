package Intento.src;

import Intento.src.models.DirectedGraph;
import Intento.src.models.Node;
import Intento.src.models.DirectedEdge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodos = new ArrayList<Node>();
        List<DirectedEdge> aristas = new ArrayList<DirectedEdge>();
        Node nodo1 = new Node("nodo1", 1);
        Node nodo2 = new Node("nodo2", 2);
        Node nodo3 = new Node("nodo3", 3);
        Node nodo4 = new Node("nodo4", 4);
        Node nodo5 = new Node("nodo5", 5);
        Node nodo6 = new Node("nodo6", 6);

        
        DirectedEdge directedEdge1 = new DirectedEdge(nodo1, nodo2);
        DirectedEdge directedEdge2 = new DirectedEdge(nodo2, nodo3);
        DirectedEdge directedEdge3 = new DirectedEdge(nodo3, nodo4);
        DirectedEdge directedEdge4 = new DirectedEdge(nodo4, nodo1);
        DirectedEdge directedEdge5 = new DirectedEdge(nodo5, nodo6);

        nodos.add(nodo1);
        nodos.add(nodo2);
        nodos.add(nodo3);
        nodos.add(nodo4);
        nodos.add(nodo1);
        nodos.add(null);

        aristas.add(directedEdge1);
        aristas.add(directedEdge2);
        aristas.add(directedEdge3);
        aristas.add(directedEdge4);
        aristas.add(directedEdge5);

        DirectedGraph directedGraph = new DirectedGraph(nodos, aristas);
        System.out.println(directedGraph);

        directedGraph.addEdge(directedEdge5);
        System.out.println(directedGraph);
    }
}