package Intento.src.models;

import java.util.List;
import java.util.ArrayList;
public class DirectedGraph {
    //Disconnected Weighted Digraph
    private List<Node> nodes;
    private List<DirectedEdge> edges;

    public DirectedGraph(List<Node> nodes, List<DirectedEdge> edges) {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<DirectedEdge>();
        for (Node node : nodes) {
            if (checkNode(node)) {
                this.nodes.add(node);
            }
        }

        for (DirectedEdge edge : edges) {
            if (checkEdge(edge)) {
                this.edges.add(edge);
            }
        }
    }

    private boolean checkEdge(DirectedEdge edge) {
        boolean flagConectNode1 = false;
        boolean flagConectNode2 = false;
        for (Node nodo : nodes) {
            if (!flagConectNode1 && (nodo == edge.getDestination() || nodo == edge.getSource())) {
                flagConectNode1 = true;
            }else if (!flagConectNode2 && (nodo == edge.getSource() || nodo == edge.getDestination())) {
                flagConectNode2 = true;
            }
            if(flagConectNode1 && flagConectNode2) {
                return true;
            }
        }
        return false;
    }

    private boolean checkNode(Node node) {
        if (node == null) {
            return false;
        }else{
            for (Node graphNode : this.nodes) {
                if (node.getName() == graphNode.getName()) {
                    return false;
                }
            }
        }
        return true;

    }

    public List<Node> getNodes() {
        return nodes;
    }

    public List<DirectedEdge> getEdges() {
        return edges;
    }

    public void addNode(Node node) {
        if(checkNode(node)) {
            this.nodes.add(node);
        }else {
            System.out.println("No se puede agregar el nodo, ya que ya existe en el grafo o es nulo.");
        }
    }

    public void addEdge(DirectedEdge edge){
        addEdge(edge, false);
    }
    public void addEdge(DirectedEdge edge, boolean addNodes) {
        if(checkNode(edge.getSource())) {
            if(addNodes) addNode(edge.getSource());
            else{ 
                System.out.println("No se puede agregar la arista, ya que el inicio no existe en el grafo.");
                return;
            }
        }
        if(checkNode(edge.getDestination())) {
            if(addNodes) addNode(edge.getDestination());
            else {
                System.out.println("No se puede agregar la arista, ya que el destino no existe en el grafo.");
                return;
            }
        }
        this.edges.add(edge);
    }

    public String toString() {
        String result = "";
        result += "Grafo:\n";
        result += "Aristas:\n";;
        for (DirectedEdge edge : edges) {
            result += edge.toString() + "\n";
        }
        result += "Peso: " + getWeight();
        return result;
    }

    public int getWeight(){
        int weight = 0;
        for (Node node : this.nodes){
            weight += node.getValue();
        }
        return weight;
    }

    public boolean isCyclic() {
        List<DirectedEdge> edgesCopy = copyEdges();
        List<DirectedEdge> edgesVisited = new ArrayList<DirectedEdge>();
        for (DirectedEdge edge : edgesCopy) {
            if(checkCycles(edgesCopy, edge, edgesVisited)){
                return true;
            }
        }
        
        return false;
    }
    private boolean checkCycles(List<DirectedEdge> edgesCopy, DirectedEdge edge, List<DirectedEdge> edgesVisited){
        if(compareNodes(edge.getSource(), edge.getDestination())) return true;

        for (DirectedEdge edgeVisited : edgesVisited){
            if(compareNodes(edge.getDestination(),edgeVisited.getSource())){
                return true;
            } 
        }
        edgesVisited.add(edge);
        return false;
    }
    private boolean compareNodes(Node node1, Node node2){
        if(node1.getName() == node2.getName() && node1.getValue() == node2.getValue()) return true;
        return false;
    }

    private List<DirectedEdge> copyEdges(){
        List<DirectedEdge> copy = new ArrayList<DirectedEdge>();
        for(DirectedEdge edge : this.edges){
            copy.add(edge.copyEdge());
        }
        return copy;
    }
}
