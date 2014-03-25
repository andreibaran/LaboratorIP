package tap.lab04.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clasa ce contine metoda de explorea a grafului in latime.
 */
public class ExploreBFS implements ExplorerAlgorithm {

	@Override
	public void explore(Graph g, Function f) {
		HashMap<Node, Integer> visited = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		Node root = g.getNode(0);
		// adaugam nodul in coada
		queue.add(root);
		
		f.visit(root);
		// setez ca am vizitat radacina
		visited.put(root, 1);
		while(!queue.isEmpty()) {
			Node n = queue.remove();
			ArrayList<Node> neighbors = g.getNeightbors(n);
			for(Node node: neighbors) {
				if(visited.get(node) == null && node != null) {
					visited.put(node, 1);
					f.visit(node);
					queue.add(node);
				}
			}
		}
		f.results();
	}

}
