import java.util.ArrayList;

public class Node {

    private int weight;
    private char value;
    private ArrayList<Node> neighbours;
    private Node prevNode;

    
    public Node(int weight, char value) {
        this.weight = weight;
        this.value = value;
        this.neighbours = new ArrayList<Node>();
    }

    public Node(char value) {
        this.weight = Integer.MAX_VALUE;
        this.value = value;
        this.neighbours = new ArrayList<Node>();
    }

    public Node() {
        this.weight = 0;
        this.value = '-';
    }

    /**
     * adds a neighbour to the node
     * @param neighbour the neighbour to add
     */
    public void addNeighbour(Node neighbour) {
        this.neighbours.add(neighbour);
    } 

    /**
     * @return ArrayList<Node> returns the neighbours of the node
     */
    public ArrayList<Node> getNeighbours() {
        return this.neighbours;
    }

    /**
     * @return weight of the node
    */
    public int getWeight() {
        return this.weight;
    }

    /**
     * @return value of the node
     */
    public char getValue() {
        return this.value;
    }

    /**
     * Sets the weight of the node
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight; 
    }

    /**
     * Sets the value of the node
     * @param value the value to set
     */
    public void setValue(char value) {
        this.value = value;
    }

    /**
     * @return Node returns the neighbour with the minimum weight
     */
    public Node getNeighbourWithMinimumWeight() {
        int minimumWeight = Integer.MAX_VALUE;
        Node minimumWeightNode = null;
        for (Node neighbour : this.neighbours) {
            if (neighbour.getWeight() < minimumWeight) {
                minimumWeight = neighbour.getWeight();
                minimumWeightNode = neighbour;
            }
        }
        return minimumWeightNode;
    }

    /**
     * Sets the previous node of the node
     * @param prevNode the previous node to set
     */
    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    /**
     * @return Node returns the previous node of the node
     */
    public Node getPrevNode() {
        return this.prevNode;
    }

    /**
     * @return String returns the node as a string.
     * The string contains the value, weight and neighbours of the node.
     */
    public String toString() {
        String output = "";
        output += "Node: " + this.value + "\n";
        output += "Weight: " + this.weight + "\n";
        output += "Neighbours: ";
        for (Node neighbour : this.neighbours) {
            output += neighbour.getValue() + " ";
        }
        output += "\n";
        return output;
    }

    
}
