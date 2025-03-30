package Intento.src.models;

public class Edge {
    private Node source;
    private Node destination;

    public Edge(Node source, Node destination) {
        this.source = source;
        this.destination = destination;
    }

    public Node getSource() {
        return source;
    }
    public Node getDestination() {
        return destination;
    }
    public String toString() {
        return "{" +
                "inicio=" + source +
                ", destino=" + destination +
                '}';
    }
}
