public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of layers: ");
        int layers = scanner.nextInt();

        int[] nodesInEachLayer = new int[layers];
        for (int i = 0; i < layers; i++) {
            System.out.print("Enter the number of nodes in layer " + i + ": ");
            nodesInEachLayer[i] = scanner.nextInt();
        }

        NeuralNetwork neuralNetwork = new NeuralNetwork(layers, nodesInEachLayer);

        System.out.print("Enter layer from: ");
        int layerFrom = scanner.nextInt();
        System.out.print("Enter node from: ");
        int nodeFrom = scanner.nextInt();
        System.out.print("Enter layer to: ");
        int layerTo = scanner.nextInt();
        System.out.print("Enter node to: ");
        int nodeTo = scanner.nextInt();

        double weight = neuralNetwork.getWeight(layerFrom, nodeFrom, layerTo, nodeTo);
        System.out.println("Weight for edge (" + layerFrom + ", " + nodeFrom + ") to (" + layerTo + ", " + nodeTo + "): " + weight);
    }
}