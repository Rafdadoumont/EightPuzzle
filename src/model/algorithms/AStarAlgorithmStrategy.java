package model.algorithms;

import model.Node;

import java.util.*;

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
        PriorityQueue<Node> priorityQueue = new PriorityQueue<Node>(1000, Comparator.comparingInt(a -> (a.getCost() + a.getDepth())));

        int[] coordinates = getCoordinates(board);
        assert coordinates != null;
        int x = coordinates[0];
        int y = coordinates[1];

        Node root = new Node(board, x, y, x, y, 0, null);
        root.setCost(getHeuristic(root));
        priorityQueue.add(root);
        int iteration = 0;
        long ms = System.currentTimeMillis();
        HashSet<Node> closedSet = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            System.out.println(++iteration);
            Node minNode = priorityQueue.poll();
            if (minNode.getCost() == 0) {
                printBacktrackPath(minNode);
                ms = (System.currentTimeMillis() - ms);
                printResults(minNode, ms, iteration);
                return;
            }

            closedSet.add(minNode);

            List<Node> successors = getSuccessors(minNode);

            for (Node node : successors) {
                boolean isExplored = false;
                for (Node closedSetNode : closedSet) {
                    if (node.equals(closedSetNode)) {
                        isExplored = true;
                    }
                }
                if (!isExplored) {
                    node.setCost(getHeuristic(node));
                    priorityQueue.add(node);
                }
            }
        }
    }
}
