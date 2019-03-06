/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param nodes: a array of Undirected graph node
     * @return: a connected set of a Undirected graph
     */
    public List<List<Integer>> connectedSet(List<UndirectedGraphNode> nodes) {
        // write your code here
        Map<UndirectedGraphNode , Boolean> visited = new HashMap<>();

        List<List<Integer>> res = new ArrayList<>();

        for (UndirectedGraphNode node : nodes) {
            visited.put(node , false);
        }

        for (UndirectedGraphNode node : nodes) {
            if (visited.get(node) == false) {
                bfs(node,visited,res);
            }
        }
        return res;
    }

    private void bfs(UndirectedGraphNode node , Map<UndirectedGraphNode , Boolean> visited, List<List<Integer>> res) {
        List<Integer> row = new ArrayList<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        visited.put(node, true);
        queue.offer(node);

        while (!queue.isEmpty()) {
            UndirectedGraphNode n = queue.poll();
            row.add(n.label);
            for (UndirectedGraphNode m : n.neighbors) {
                if (visited.get(m) == false) {
                    visited.put(m , true);
                    queue.offer(m);
                }
            }

        }
        Collections.sort(row);
        res.add(row);
    }
}
