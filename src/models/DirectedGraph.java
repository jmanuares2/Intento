package Intento.src.models;

import java.util.List;
import java.util.ArrayList;
public class DirectedGraph {
    private List<Node> nodes;
    private List<Edge> edges;

    public DirectedGraph(List<Node> nodes, List<Edge> edges) {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
        for (Node nodo : nodes) {
            if (verificarNodos(nodo)) {
                this.nodes.add(nodo);
            }
        }

        for (Edge edge : edges) {
            if (verificarPertenencia(edge)) {
                this.edges.add(edge);
            }
        }
    }

    private boolean verificarPertenencia(Edge edge) {
        boolean flagExisteConexionNodo1 = false;
        boolean flagExisteConexionNodo2 = false;
        for (Node nodo : nodes) {
            if (!flagExisteConexionNodo1 && (nodo == edge.getDestination() || nodo == edge.getSource())) {
                flagExisteConexionNodo1 = true;
            }else if (!flagExisteConexionNodo2 && (nodo == edge.getSource() || nodo == edge.getDestination())) {
                flagExisteConexionNodo2 = true;
            }
            if(flagExisteConexionNodo1 && flagExisteConexionNodo2) {
                return true;
            }
        }
        return false;
    }

    private boolean verificarNodos(Node nodo) {
        if (nodo == null) {
            return false;
        }else{
            for (Node nodoExistente : this.nodes) {
                if (nodo.getName() == nodoExistente.getName()) {
                    return false;
                }
            }
        }
        return true;

    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<Edge> getEdges() {
        return edges;
    }

    public void addNode(Node node) {
        if(verificarNodos(node)) {
            this.nodes.add(node);
        }else {
            System.out.println("No se puede agregar el nodo, ya que ya existe en el grafo o es nulo.");
        }
    }

    public void addEdge(Edge edge) {
        if(!verificarNodos(edge.getSource())) {
            System.out.println("No se puede agregar la arista, ya que el inicio no existe en el grafo.");
        }else if(!verificarNodos(edge.getDestination())) {
            System.out.println("No se puede agregar la arista, ya que el destino no existe en el grafo.");
        }else{
            this.edges.add(edge);
        }
        
    }

    public String toString() {
        String resultado = "";
        resultado += "Grafo:\n";
        resultado += "Aristas:\n";;
        for (Edge edge : edges) {
            resultado += edge.toString() + "\n";
        }
        return resultado;
    }
}
