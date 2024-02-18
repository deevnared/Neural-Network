
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class NeurNet {
    private int layers;
    private int[] nodesInEachLayer;
    private Map<Edge, Double> weights;

    public NeuralNetwork(int layers, int[] nodesInEachLayer) {
        this.layers = layers;
        this.nodesInEachLayer = nodesInEachLayer;
        this.weights = new HashMap<>();

        // Initialize weights based on user input
        initializeWeights();
    }

    private void Weights() {
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < layers - 1; i++) {
            for (int node1 = 0; node1 < nodesInEachLayer[i]; node1++) {
                for (int node2 = 0; node2 < nodesInEachLayer[i + 1]; node2++) {
                    System.out.print("Enter weight for edge (" + i + ", " + node1 + ") to (" + (i + 1) + ", " + node2 + "): ");
                    double weight = scanner.nextDouble();
                    weights.put(new Edge(i, node1, i + 1, node2), weight);
                }
            }
        }
    }

    public double getWeight(int layerFrom, int nodeFrom, int layerTo, int nodeTo) {
        Edge edge = new Edge(layerFrom, nodeFrom, layerTo, nodeTo);
        return weights.getOrDefault(edge, 0.0);
    }
}

class Edge {
    private int layerFrom, nodeFrom, layerTo, nodeTo;

    public Edge(int layerFrom, int nodeFrom, int layerTo, int nodeTo) {
        this.layerFrom = layerFrom;
        this.nodeFrom = nodeFrom;
        this.layerTo = layerTo;
        this.nodeTo = nodeTo;
    }

    @Override
    public int hashCode() {
        return (layerFrom * 31 + nodeFrom) * 31 + (layerTo * 31 + nodeTo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Edge edge = (Edge) obj;
        return layerFrom == edge.layerFrom && nodeFrom == edge.nodeFrom && layerTo == edge.layerTo && nodeTo == edge.nodeTo;
    }
}
