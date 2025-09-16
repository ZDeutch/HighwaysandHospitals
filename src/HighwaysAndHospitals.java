import java.util.*;

/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 * <p>
 * Completed by: [YOUR NAME HERE]
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Create a boolean array to see if you have visited the city
        boolean[] visited = new boolean[cities.length + cities[0].length];
        int totalCost = 0;

        // Create your adjacency list to make a map of the cities and turn it into clusters
        Graph adjList = new Graph();

        // Create a queue in order to perform BFS on each city
        Queue<Integer> q = new LinkedList<Integer>();

        // For each city
        for(int i = 0; i < n; i++) {
            // If you haven't already visited it
            if (!visited[i]) {
                // Add it to your queue
                q.add(i);
                visited[i] = true;
            }
        }

        // Go through the cities and add them as edges to your BFS search
        for(int i = 0; i < cities.length; i++) {
            adjList.addEdge(cities[i][0], cities[i][1]);
        }

        // Set the first element to be the first vertex
        adjList.addVertex(q.remove());

        // Begin your BFS Search
        while(!q.isEmpty()) {
            adjList.getNeighbors(q.remove());
            // From here I need to figure out how to find the amount of clusters using the graph class
            // I also need to know how many cities are in each cluster
            // I think I am close but I want to go to tutorial and walk through it

        }

        // Once I have the amount of clusters and how many are in each I simply have to iterate through each cluster
        // Then multiply cities - 1 by highway cost
        // lastly add amount of clusters * hospital cost to the total cost variable
        // Return cost



        return 0;
    }
}

