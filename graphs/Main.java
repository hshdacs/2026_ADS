package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {

    private static String showPQ(PriorityQueue<int[]> pq) {
        Iterator<int[]> itPQ = pq.iterator();
       
        StringBuffer output = new StringBuffer();
        while (itPQ.hasNext()) {
            int[] elements = itPQ.next();
            output.append("(");
            output.append(elements[0]);
            output.append(",");
            output.append(elements[1]);
            output.append(")");
        }
        return output.toString();
    }

    // by Dijkstra
    private static ArrayList<Integer> shortest_path(
        ArrayList< ArrayList< ArrayList<Integer> >> adj, int src) {
            int V = adj.size();

            // auto sorted queue for storing {distance, vertex}
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
            );

            ArrayList<Integer> dist = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                dist.add(Integer.MAX_VALUE);
            }

            dist.set(src, 0);
            pq.offer( new int[]{0, src} );

            while (!pq.isEmpty()) {
                // info
                System.out.println(dist + ":" + showPQ(pq));

                // consume next element in our queue
                int distance = pq.peek()[0];
                int vertex = pq.peek()[1];
                pq.poll();

                // we already found a shorter path to this vertex
                if (distance > dist.get(vertex))
                    continue;

                // iterate all target vertex that can be reached via this vertex
                for (ArrayList<Integer> x : adj.get(vertex)) {
                    int curr_vertex = x.get(0);
                    int curr_weight = x.get(1);

                    // if we found some shorter path, store it
                    if (dist.get(curr_vertex) > distance + curr_weight) {
                        dist.set(curr_vertex, distance + curr_weight);
                        // and enter in our queue because
                        pq.offer( new int[]{dist.get(curr_vertex), curr_vertex} );
                    }
                }
            }

            return dist;
        }

    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // node 0
        adj.add( new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(1, 4)),
            new ArrayList<>(Arrays.asList(2, 8))
        )));
        // node 1
        adj.add( new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(0, 4)),
            new ArrayList<>(Arrays.asList(2, 3)),
            new ArrayList<>(Arrays.asList(4, 6))
        )));
        // node 2
        adj.add( new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(0, 8)),
            new ArrayList<>(Arrays.asList(1, 3)),
            new ArrayList<>(Arrays.asList(3, 2))
        )));
        // node 3
        adj.add( new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(2, 2)),
            new ArrayList<>(Arrays.asList(4, 10))
        )));
        // node 4
        adj.add( new ArrayList<>(Arrays.asList(
            new ArrayList<>(Arrays.asList(1, 6)),
            new ArrayList<>(Arrays.asList(3, 10))
        )));

        ArrayList<Integer> shortestPath = shortest_path(adj, 2);
        System.out.println(shortestPath);
    }
}
