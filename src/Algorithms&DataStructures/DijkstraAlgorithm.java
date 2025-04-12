import java.util.*;

public class DijkstraAlgorithm {
    static class Edge {
        String target;
        int weight;

        Edge(String target, int weight) {
            this.target = target;
            this.weight = weight;
        }
    }


    static class Graph {
        private final Map<String, List<Edge>> adjacencyList = new HashMap<>();

        public void addEdge(String source, String target, int weight) {
            adjacencyList.putIfAbsent(source, new ArrayList<>());
            adjacencyList.get(source).add(new Edge(target, weight));
            adjacencyList.putIfAbsent(target, new ArrayList<>());
        }

        public Map<String, Integer> dijkstra(String start) {
            Map<String, Integer> distances = new HashMap<>();
            PriorityQueue<Edge> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(edge -> edge.weight));
            Set<String> visited = new HashSet<>();
            for (String vertex : adjacencyList.keySet()) {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            distances.put(start, 0);
            priorityQueue.add(new Edge(start, 0));

            while (!priorityQueue.isEmpty()) {
                Edge currentEdge = priorityQueue.poll();
                String currentVertex = currentEdge.target;

                if (visited.contains(currentVertex)) {
                    continue;
                }
                visited.add(currentVertex);

                for (Edge edge : adjacencyList.getOrDefault(currentVertex, new ArrayList<>())) {
                    if (!visited.contains(edge.target)) {
                        int newDist = distances.get(currentVertex) + edge.weight;
                        if (newDist < distances.get(edge.target)) {
                            distances.put(edge.target, newDist);
                            priorityQueue.add(new Edge(edge.target, newDist));
                        }
                    }
                }
            }
            return distances;
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("A", "B", 2);
        graph.addEdge("A", "C", 6);
        graph.addEdge("A", "D", 4);
        graph.addEdge("B", "C", 3);
        graph.addEdge("C", "D", 3);
        graph.addEdge("C", "E", 2);

        Map<String, Integer> distances = graph.dijkstra("A");

        System.out.println("Кратчайшее расстояние от A до E: "+distances.get("E"));
    }
}
