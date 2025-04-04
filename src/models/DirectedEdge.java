package Intento.src.models;

public class DirectedEdge {
    private Node source;
    private Node destination;

    public DirectedEdge(Node source, Node destination) {
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
                "source=" + source +
                ", destination=" + destination +
                '}';
    }

    public DirectedEdge copyEdge(){
        DirectedEdge copy = new DirectedEdge(this.source.copyNode(), this.destination.copyNode());
        return copy;
    }
}
