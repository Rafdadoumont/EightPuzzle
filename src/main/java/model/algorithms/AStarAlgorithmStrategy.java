package model.algorithms;

import model.Node;

import java.util.HashSet;
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
    public void solve(byte[][] board) {
        super.dimension = board.length;
        AStarComparator aStarComparator = new AStarComparator();
        PriorityQueue<Node> openSetQueue = new PriorityQueue<>(aStarComparator);
        HashSet<Node> closedSet = new HashSet<>();

        int[] coordinates = getCoordinates(board);
        assert coordinates != null;
        int x = coordinates[0];
        int y = coordinates[1];

        Node root = new Node(board, x, y, x, y, 0, null);
        root.setCost(getHeuristic(root));
        openSetQueue.add(root);
        int iteration = 0;
        long ms = System.currentTimeMillis();

        while (!openSetQueue.isEmpty()) {
            Node minNode = openSetQueue.poll();
            ++iteration;
            if (minNode != null && minNode.getCost() == 0) {
                ms = (System.currentTimeMillis() - ms);
                printResults(minNode, ms, iteration);
                return;
            }

            closedSet.add(minNode);

            List<Node> successors = getSuccessors(minNode);

            for (Node node : successors) {
                if (!closedSet.contains(node) && !openSetQueue.contains(node)) {
                    node.setCost(getHeuristic(node));
                    openSetQueue.add(node);
                }
            }
        }
    }
}
