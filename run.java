import java.util.ArrayList;

public class run {

    


    public static void main(String[] args) {


        Graph graph = new Graph();

        int[][] adjacencyMatrix = {
            {0, 800, 600, 650, 260, 0, 0, 750, 60, 0, 0, 190, 400},
            {800, 0, 100, 0, 0, 0, 0, 50, 0, 0, 0, 0, 350},
            {600, 100, 0, 140, 0, 0, 0, 0, 0, 0, 0, 0, 300},
            {650, 0, 140, 0, 0, 0, 0, 0, 0, 0, 0, 0, 350},
            {260, 0, 0, 0, 0, 10, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 10, 0, 30, 0, 50, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 30, 0, 50, 0, 0, 0, 0, 0},
            {750, 50, 0, 0, 0, 0, 50, 0, 0, 0, 0, 0, 0},
            {60, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 110, 0, 80, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 80, 0, 150, 0},
            {190, 0, 0, 0, 0, 0, 0, 0, 0, 0, 150, 0, 500},
            {400, 350, 300, 350, 0, 0, 0, 0, 0, 0, 0, 500, 0}
        };

        char [] nodeValues = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'k', 'l', 'm', 'n'};

        // add nodes
        for (char nodeValue : nodeValues) {
            graph.addNode(new Node(nodeValue));
        }

        // put graph nodes in an arraylist
        ArrayList<Node> nodesList = graph.getNodes();

        // set edges
        for (int i = 0; i < nodeValues.length; i++) {
            for (int j = 0; j < nodeValues.length; j++) {
                if (adjacencyMatrix[i][j] != 0) {
                    graph.addEdge(new Edge(nodesList.get(i), nodesList.get(j), adjacencyMatrix[i][j]));
                }
            }
        }

        // add neighbours
        for (Node node : nodesList) {
            for (Edge edge : graph.getEdges()) {
                if (edge.getStart().getValue() == node.getValue()) {
                    node.addNeighbour(edge.getEnd());
                }
            }
        }



        // Node a = new Node('a');
        // Node b = new Node('b');
        // Node c = new Node('c');
        // Node d = new Node('d');
        // Node e = new Node('e');
        // Node f = new Node('f');

        // Graph graph = new Graph();

        // graph.addNode(a);
        // graph.addNode(b);
        // graph.addNode(c);
        // graph.addNode(d);
        // graph.addNode(e);
        // graph.addNode(f);

        // Edge ab = new Edge(a, b, 4);
        // Edge bd = new Edge(b, d, 5);
        // Edge df = new Edge(d, f, 6);
        // Edge ef = new Edge(e, f, 3);
        // Edge ce = new Edge(c, e, 10);
        // Edge cd = new Edge(c, d, 8);
        // Edge bc = new Edge(b, c, 1);
        // Edge ac = new Edge(a, c, 2);

        // graph.addEdge(ab);
        // graph.addEdge(bd);
        // graph.addEdge(df);
        // graph.addEdge(ef);
        // graph.addEdge(ce);
        // graph.addEdge(cd);
        // graph.addEdge(bc);
        // graph.addEdge(ac);

        // a.addNeighbour(b);
        // a.addNeighbour(c);
        // b.addNeighbour(d);
        // b.addNeighbour(c);
        // b.addNeighbour(a);
        // c.addNeighbour(d);
        // c.addNeighbour(e);
        // c.addNeighbour(b);
        // c.addNeighbour(a);
        // d.addNeighbour(f);
        // d.addNeighbour(b);
        // d.addNeighbour(c);
        // e.addNeighbour(c);
        // e.addNeighbour(f);
        // f.addNeighbour(e);
        // f.addNeighbour(d);

        
        run run = new run();



        System.out.println(run.algorithm(graph, nodesList.get(0)));
        
    }

    /**
     * Dijkstra's algorithm for finding the shortest path from a start node to all other nodes in a graph.
     * @param graph the graph to be traversed
     * @return String the shortest path from the start node to all other nodes
     */
    public String algorithm (Graph graph, Node start) {

        ArrayList<Edge> edges = graph.getEdges();

        Node current = start;

        ArrayList<Node> visited = new ArrayList<Node>();
        ArrayList<Node> unvisited = new ArrayList<Node>();

        // set prevNode of all Nodes to a node with value '-'
        for (Node node : graph.getNodes()) {
            node.setPrevNode(new Node());
        }


        for (Node node : graph.getNodes()) {
            unvisited.add(node);
        }

        // set weight of start node to zero
        for (Node node : graph.getNodes()) {
            if (node.equals(start)) {
                node.setWeight(0);
            }
        }

        while (!unvisited.isEmpty()) {
            visited.add(current);
            unvisited.remove(current);
            for (Node neighbour : current.getNeighbours()) {
                if (visited.contains(neighbour)) {
                    continue;
                } 
                else {
                    
                    for (Edge edge : edges) {
                        if ((edge.getStart().getValue() == current.getValue() && edge.getEnd().getValue() == neighbour.getValue()) || (edge.getStart().getValue() == neighbour.getValue() && edge.getEnd().getValue() == current.getValue())) {
                            int weight = current.getWeight() + edge.getWeight();
                            if (weight < neighbour.getWeight()) {
                                neighbour.setWeight(weight);
                                neighbour.setPrevNode(current);
                            }
                        }
                    }

                }  
            }

            // sort unvisited nodes in order of their weights
            // current = first node in unvisited nodes
            if (!unvisited.isEmpty()) {
                unvisited.sort((Node n1, Node n2) -> n1.getWeight() - n2.getWeight());
                current = unvisited.get(0);
            }      
            
        }

        return graph.toString();

    }



    


}