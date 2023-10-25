package model.algorithms;


import model.Node;

import java.util.Comparator;


public class AStarComparator implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		return (o1.getDepth() + o1.getCost()) - (o2.getDepth() + o2.getCost());
	}
}
