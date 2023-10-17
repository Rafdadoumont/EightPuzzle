package model;

import java.util.Arrays;
import java.util.Objects;

/**
 * Represents a node in a puzzle-solving algorithm.
 */
public class Node {
    private final Node parent;
    private final int[][] board;
    private final int x;
    private final int y;
    private final int depth;
    private int cost;

    /**
     * Constructs a new node with the specified parameters.
     *
     * @param board  The puzzle board represented as a 2D array.
     * @param x      The X-coordinate of the empty space (0).
     * @param y      The Y-coordinate of the empty space (0).
     * @param newX   The new X-coordinate of the empty space after the move.
     * @param newY   The new Y-coordinate of the empty space after the move.
     * @param depth  The depth of the node in the search tree.
     * @param parent The parent node of the current node.
     */
    public Node(int[][] board, int x, int y, int newX, int newY, int depth, Node parent) {
        this.parent = parent;
        this.board = new int[board.length][];
        for (int i = 0; i < board.length; i++) {
            this.board[i] = board[i].clone();
        }

        // Swap values
        int temp = this.board[y][x];
        this.board[y][x] = this.board[newY][newX];
        this.board[newY][newX] = temp;

        this.cost = Integer.MAX_VALUE;
        this.depth = depth;
        this.x = newX;
        this.y = newY;
    }

    /**
     * Gets the parent node of this node.
     *
     * @return The parent node.
     */
    public Node getParent() {
        return parent;
    }

    /**
     * Gets the puzzle board of this node.
     *
     * @return The puzzle board as a 2D array.
     */
    public int[][] getBoard() {
        return board;
    }

    /**
     * Gets the X-coordinate of the empty space in the puzzle board.
     *
     * @return The X-coordinate of the empty space.
     */
    public int getX() {
        return x;
    }

    /**
     * Gets the Y-coordinate of the empty space in the puzzle board.
     *
     * @return The Y-coordinate of the empty space.
     */
    public int getY() {
        return y;
    }

    /**
     * Gets the depth or depth of this node in the search tree.
     *
     * @return The depth of the node.
     */
    public int getDepth() {
        return depth;
    }

    /**
     * Gets the cost associated with this node.
     *
     * @return The cost of the node.
     */
    public int getCost() {
        return cost;
    }

    /**
     * Sets the cost associated with this node.
     *
     * @param cost The cost of the node.
     */
    public void setCost(int cost) {
        this.cost = cost;
    }

    /**
     * Returns a string representation of the node, including the board state, depth, and cost.
     *
     * @return A string representation of the node.
     */
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] row : board) {
            for (int tile : row) {
                stringBuilder.append(tile).append(" ");
            }
            stringBuilder.append('\n');
        }
        stringBuilder.append("Depth: ").append(depth).append('\n');
        stringBuilder.append("Cost: ").append(cost).append('\n');
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(parent, x, y, depth, cost);
        result = 31 * result + Arrays.deepHashCode(board);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Node other)) {
            return false;
        }

        for (int i = 0; i < this.board.length; i++) {
            if (!Arrays.equals(this.board[i], other.getBoard()[i])) {
                return false;
            }
        }
        return true;
    }
}