public class Solution {
    /**
     * @param n: An integer
     * @param edges: a list of undirected edges
     * @return: true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // write your code here
        if (n == 0 || edges.length != n - 1) {
            return false;
        }
        Map<Integer , Set<Integer>> graph = initializedGraph(n , edges);

        Queue<Integer> queue = new LinkedList<Integer>();
        Set<Integer> set = new HashSet<>();

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            for (Integer neighbor : graph.get(node)) {
                if (set.contains(neighbor)) {
                    continue;
                }
                queue.offer(neighbor);
                set.add(neighbor);
            }
        }
        return (set.size() == n);


    }

    private Map<Integer , Set<Integer>> initializedGraph (int n , int[][] edges) {
        Map<Integer , Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<Integer>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        return graph;
    }
}
