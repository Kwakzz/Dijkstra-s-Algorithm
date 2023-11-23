import java.util.ArrayList;

public class Graph {

    private ArrayList<Node> nodes;
    private ArrayList<Edge> edges;

    public Graph() {
        this.nodes = new ArrayList<Node>();
        this.edges = new ArrayList<Edge>();
    }

    /**
     * @return ArrayList<Node> return the nodes in the graph
     */
    public ArrayList<Node> getNodes() {
        return nodes;
    }

    /**
     * @param node the node to add to the graph
     */
    public void addNode(Node node) {
        this.nodes.add(node);
    }

    /**
     * @param edge the edge to add to the graph
     */
    public void addEdge(Edge edge) {
        this.edges.add(edge);
    }

    /**
     * @return ArrayList<Edge> return the edges in the graph
     */
    public ArrayList<Edge> getEdges() {
        return edges;
    }

    /**
     * @return String return the graph as a string. The string contains all the nodes, their previous nodes and their weight. The weight is the distance of the shortest path from the start node to the node in question.
     */
    public String toString() {
        String output = "";
        for (Node node : this.nodes) {
            output +=  node.getValue() + ": " + "(" + node.getPrevNode().getValue() +", " + node.getWeight() + ")" + "\n";
        }
        return output;
    }

}
