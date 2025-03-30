package Intento.src;

import Intento.src.models.Graph;
import Intento.src.models.Node;
import Intento.src.models.Edge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    List<Node> nodos = new ArrayList<Node>();
    Node nodo1 = new Node("nodo1", 1);
    Node nodo2 = new Node("nodo2", 2);
    Node nodo3 = new Node("nodo3", 3);
    Node nodo4 = new Node("nodo4", 4);
    nodos.add(nodo1);
    nodos.add(nodo2);
    
    Edge edge1 = new Edge(nodo1, nodo2);
    Edge edge2 = new Edge(nodo2, nodo3);
    Edge edge3 = new Edge(nodo3, nodo4);
    Edge edge4 = new Edge(nodo4, nodo1);

    Graph graph = new Graph(List.of(nodo1, nodo2, nodo3, nodo4), List.of(edge1, edge2, edge3, edge4));
}
