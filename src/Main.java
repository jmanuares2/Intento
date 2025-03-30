package Intento.src;

import Intento.src.models.Graph;
import Intento.src.models.Node;
import Intento.src.models.Edge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Node> nodos = new ArrayList<Node>();
        List<Edge> aristas = new ArrayList<Edge>();
        Node nodo1 = new Node("nodo1", 1);
        Node nodo2 = new Node("nodo2", 2);
        Node nodo3 = new Node("nodo3", 3);
        Node nodo4 = new Node("nodo4", 4);

        
        Edge edge1 = new Edge(nodo1, nodo2);
        Edge edge2 = new Edge(nodo2, nodo3);
        Edge edge3 = new Edge(nodo3, nodo4);
        Edge edge4 = new Edge(nodo4, nodo1);

        nodos.add(nodo1);
        nodos.add(nodo2);
        nodos.add(nodo3);
        nodos.add(nodo4);

        aristas.add(edge1);
        aristas.add(edge2);
        aristas.add(edge3);
        aristas.add(edge4);

        Graph graph = new Graph(nodos, aristas);
        System.out.println(graph);
    }
}