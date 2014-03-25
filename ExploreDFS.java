package tap.lab04.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Clasa ce contine metoda de explorea a grafului in adancime.
 */
public class ExploreDFS implements ExplorerAlgorithm {

	@Override
	public void explore(Graph g, Function f) {
		Stack<Node> stack= new Stack<Node>();
		HashMap<Node, Integer> visited = new HashMap<>();
		Node root = g.getNode(0);
		stack.push(root);
		f.visit(root);
		visited.put(root, 1);
		while(!stack.isEmpty()) {
			Node n = stack.peek();
			ArrayList<Node> neighbors = g.getNeightbors(n);
			
			// parcurg nodurile vizitate
			int i = 0;
			while(i < neighbors.size() && visited.get(neighbors.get(i)) != null) {
				i++;
			}
			// daca mai am noduri vecini nevizitate 
			if(i != neighbors.size() && neighbors.get(i) != null) {
				visited.put(neighbors.get(i), 1);
				f.visit(neighbors.get(i));
				stack.push(neighbors.get(i));
			} else {
				// am terminat cu nodul parinte
				stack.pop();
			}
		}
		f.results();
	}

}
