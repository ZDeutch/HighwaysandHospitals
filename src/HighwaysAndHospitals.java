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
        int[] nodes = new int[n + 1];
        boolean[] visited = new boolean[n];

        for (int i = 1; i <= n; i++) {
            nodes[i] = i;
        }

        for (int edges = 0; edges < cities.length; edges++) {
            int root = cities[edges][0];
            int parent = cities[edges][1];
            int getParent = find(parent, nodes);
            int getRoot = find(parent, nodes);

            if(getParent != getRoot) {
                nodes[getRoot] = getParent;
            }


        }


        return 0;

    }

    public static int find(int n, int[] parent) {
        if(parent[n] != n) {
            parent[n] = find(parent[n],parent);
        }
        return parent[n];
    }
}