package Intento.src.models;

public class Node {
    private String name;
    private int value;

    public Node(String name, int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public String toString() {
        return this.name;
    }
    public Node copyNode(){
        return new Node(this.name, this.value);
    }

}
