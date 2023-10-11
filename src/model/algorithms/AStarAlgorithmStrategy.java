package model.algorithms;

import model.Node;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * An implementation of the A* algorithm for solving puzzles.
 */
public class AStarAlgorithmStrategy extends AlgorithmTemplate implements AlgorithmStrategy{

    /**
     * Solves the puzzle using the A* algorithm.
     *
     * @param board The initial puzzle board to solve.
     */
    @Override
    public void solve(int[][] board) {
        super.dimension = board.length;
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(1000, Comparator.comparingInt(a -> (a.getCost() + a.getLevel())));

        int[] coordinates = getCoordinates(board);
        assert coordinates != null;
        int x = coordinates[0];
        int y = coordinates[1];

        Node root = new Node(board, x, y, x, y, 0, null);
        root.setCost(getHeuristic(root));
        priorityQueue.add(root);
        int iteration = 0;

        while (!priorityQueue.isEmpty()) {
            Node minNode = priorityQueue.poll();
            System.out.println("Iteration: " + ++iteration);
            if (minNode.getCost() == 0) {
                printBacktrackPath(minNode);
                return;
            }

            List<Node> successors = getSuccessors(minNode);
            for (Node node: successors) {
                node.setCost(getHeuristic(node));
                priorityQueue.add(node);
            }
        }
    }
}
