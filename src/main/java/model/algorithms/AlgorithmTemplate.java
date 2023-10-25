package model.algorithms;

import model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * An abstract class representing a template for various algorithms to solve puzzles.
 */
public abstract class AlgorithmTemplate {
    int dimension;

    /**
     * Checks if a given move is valid within the puzzle board.
     *
     * @param x The X-coordinate of the move.
     * @param y The Y-coordinate of the move.
     * @return true if the move is valid, false otherwise.
     */
    public final boolean isValidMove(int x, int y) {
        return (x >= 0 && x < dimension && y >= 0 && y < dimension);
    }

    /**
     * Retrieves the coordinates of value 0 within the puzzle board.
     *
     * @param board The puzzle board represented as a 2D array.
     * @return An array containing the X and Y coordinates of the value.
     */
    public final int[] getCoordinates(byte[][] board) {
        for(int y = 0; y < dimension;y++)
            for(int x = 0; x < dimension; x++)
                if (board[y][x] == 0) {
                    return new int[]{x, y};
                }
        return null;
    }

    /**
     * Calculates the heuristic value for a given puzzle node.
     *
     * @param node The puzzle node for which to calculate the heuristic.
     * @return The calculated heuristic value.
     */
    public final int getHeuristic(Node node) {
        int manhattanDistanceSum = 0;

        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {
                int value = node.getBoard()[x][y];
                if (value != 0) {
                    // 1 2 3
                    // 4 5 6
                    // 7 8 0
                    int targetX = (value - 1) / dimension;
                    int targetY = (value - 1) % dimension;
                    int dx = x - targetX;
                    int dy = y - targetY;

                    // 0 1 2
                    // 3 4 5
                    // 6 7 8
//                    int targetX = value % dimension;
//                    int targetY = value / dimension;
//                    int dx = y - targetX;
//                    int dy = x - targetY;
                    manhattanDistanceSum += Math.abs(dx) + Math.abs(dy);
                }
            }
        }
        return manhattanDistanceSum;
    }

    /**
     * Generates a list of successor nodes for a given puzzle node.
     *
     * @param node The puzzle node for which to generate successors.
     * @return A list of successor nodes.
     */
    public final List<Node> getSuccessors(Node node) {
        List<Node> successors = new ArrayList<>();
        int x = node.getX();
        int y = node.getY();

        int[][] moves = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int[] move : moves) {
            int newX = x + move[0];
            int newY = y + move[1];

            if (isValidMove(newX, newY)) {
                Node successorNode = new Node(node.getBoard(), x, y, newX, newY, node.getDepth() + 1, node);
                successorNode.setCost(getHeuristic(successorNode));
                successors.add(successorNode);
            }
        }
        return successors;
    }

    /**
     * Prints the path from the start (root) to goal node
     *
     * @param root The root node of the path.
     */
    public final void printBacktrackPath(Node root) {
        Stack<Node> nodeStack = new Stack<>();

        while (root != null) {
            nodeStack.add(root);
            root = root.getParent();
        }

        while (!nodeStack.empty()) {
            System.out.println(nodeStack.pop());
        }
    }

    public final void printResults(Node node, long time, int iterations) {
        StringBuilder stringBuilder = new StringBuilder();

        printBacktrackPath(node);

        stringBuilder.append("/***********/\n")
                .append("Depth: " + node.getDepth() + "\n")
                .append("Time: " + time + " ms" + "\n")
                .append("Iterations: " + iterations + "\n")
                .append("/***********/\n");

        System.out.println(stringBuilder);
    }
}
