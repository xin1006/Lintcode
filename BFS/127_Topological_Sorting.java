/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */

public class Solution {
    /*
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
        HashMap<DirectedGraphNode, Integer> mapping = new HashMap<>();

        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (mapping.containsKey(neighbor)) {
                    mapping.put(neighbor, mapping.get(neighbor) + 1);
                }else {
                    mapping.put(neighbor, 1);
                }
            }
        }

        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for (DirectedGraphNode node : graph) {
            if (!mapping.containsKey(node)) {
                queue.offer(node);
                res.add(node);
            }
        }

        while (!queue.isEmpty()) {
            DirectedGraphNode node = queue.poll();
            for (DirectedGraphNode n : node.neighbors) {
                mapping.put(n, mapping.get(n) - 1);
                if (mapping.get(n) == 0) {
                    queue.offer(n);
                    res.add(n);
                }
            }
        }
        return res;
    }
}
