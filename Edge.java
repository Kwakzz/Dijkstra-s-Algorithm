public class Edge {

    private Node start;
    private Node end;
    private int weight;

    public Edge(Node start, Node end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    

    /**
     * @return Node return the start
     */
    public Node getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(Node start) {
        this.start = start;
    }

    /**
     * @return Node return the end
     */
    public Node getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(Node end) {
        this.end = end;
    }

    /**
     * @return int return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * @param weight the weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }


        

}
