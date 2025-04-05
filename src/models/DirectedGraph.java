package Intento.src.models;

import java.util.*;

public class DirectedGraph {
    //Disconnected Weighted Digraph
    private List<Node> nodes;
    private List<DirectedEdge> edges;
    private HashMap<Node, HashSet<Node>> adjacencyList;


    public DirectedGraph(List<Node> nodes, List<DirectedEdge> edges) {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<DirectedEdge>();
        this.adjacencyList = new HashMap<Node, HashSet<Node>>();
        for (Node node : nodes) {
            addNode(node);
        }

        for (DirectedEdge edge : edges) {
            addEdge(edge);
        }
    }

    public List<Node> getNodes() {
        return this.nodes;
    }

    public List<DirectedEdge> getEdges() {
        return this.edges;
    }

    public HashMap<Node, HashSet<Node>> getAdjacencyList(){
        return this.adjacencyList;
    }

    public void addNode(Node node) {
        if (node == null) {
            return;
        }else{
            for (Node graphNode : this.nodes) {
                if (node.getName() == graphNode.getName()) {
                    return;
                }
            }
        }
        
        this.nodes.add(node);
        this.adjacencyList.putIfAbsent(node, new HashSet<Node>());
        
        return;
    }

    public void addEdge(DirectedEdge edge) {
        addNode(edge.getSource());
        addNode(edge.getDestination());
        
        this.adjacencyList.get(edge.getSource()).add(edge.getDestination());
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
        List<DirectedEdge> edgesVisited = new ArrayList<DirectedEdge>();
        for (DirectedEdge edge : this.edges) {
            if(checkCycles(edge, edgesVisited)){
                return true;
            }
        }
        
        return false;
    }
    private boolean checkCycles(DirectedEdge edge, List<DirectedEdge> edgesVisited){
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

    public boolean isCyclicDFS(){
        //A completar
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
