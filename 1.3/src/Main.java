public class Main {
    public static void main(String[] args) {
        int n = 6; // Example, change n to generate W_n
        int[][] adjacencyMatrix = createWheelGraph(n);
        System.out.println("Adjacency Matrix of W" + n + ":");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] createWheelGraph(int n) {
        int[][] matrix = new int[n][n];

        // Nod central la toate nodurile
        for (int i = 1; i < n; i++) {
            matrix[0][i] = 1;
            matrix[i][0] = 1;
        }

        // Noduri exterioare
        for (int i = 1; i < n - 1; i++) {
            matrix[i][i + 1] = 1;
            matrix[i + 1][i] = 1;
        }

        // Ultimul nod la primul
        matrix[1][n - 1] = 1;
        matrix[n - 1][1] = 1;

        return matrix;
    }
}