/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */


public class Solution {
    /*
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
          return null;
        }

        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        HashMap<UndirectedGraphNode , UndirectedGraphNode> mapping = new HashMap<>();
        for (UndirectedGraphNode n : nodes ) {
          mapping.put(n, new UndirectedGraphNode(n.label));
        }

        for (UndirectedGraphNode n : nodes) {
          UndirectedGraphNode newNode = mapping.get(n);
          for (UndirectedGraphNode neighbor : n.neighbors) {
            UndirectedGraphNode newNeighbor = mapping.get(neighbor);
            newNode.neighbors.add(newNeighbor);
          }
        }
        return mapping.get(node);
    }

    private ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node) {
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()) {
            UndirectedGraphNode head = queue.poll();
            for (UndirectedGraphNode neighbor : head.neighbors) {
                if(!set.contains(neighbor)){
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }

        return new ArrayList<UndirectedGraphNode>(set);
    }

}
