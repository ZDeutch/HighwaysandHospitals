/**
 * Highways & Hospitals
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 * <p>
 * Completed by: Zander Deutch
 */

public class HighwaysAndHospitals {

    /**
     * TODO: Complete this function, cost(), to return the minimum cost to provide
     *  hospital access for all citizens in Menlo County.
     */
    public static long cost(int n, int hospitalCost, int highwayCost, int cities[][]) {
        // Create array representing all cities from 1 to n
        int[] nodes = new int[n + 1];

        // Used for weight balancing and tracking the size of each component
        int[] sizes = new int[n + 1];

        // Make sure that the hospitals are more than the highways
        if (hospitalCost <= highwayCost) {
            return (long) n * hospitalCost;
        }

        // Initialize each city to hold their original value
        for (int i = 1; i <= n; i++) {
            nodes[i] = i;
        }

        // For each edge in the cities array
        for (int edges = 0; edges < cities.length; edges++) {

            // Make the root and the parent
            int root = cities[edges][0];
            int parent = cities[edges][1];

            // Run your recursive step by calling the find method
            int getParent = find(parent, nodes);
            int getRoot = find(root, nodes);

            // After you have your vales, if they aren't the same then set the first term to be the root of the second
            if (getParent != getRoot) {

                // For weight balancing, check which tree is bigger
                if (sizes[getRoot] < sizes[getParent]) {
                    // Switch the root and parent if the root is smaller
                    int temp = getRoot;
                    getRoot = getParent;
                    getParent = temp;
                }

                // set the first as the root of the second
                nodes[getParent] = nodes[getRoot];

                // Adjust the size of the tree to encompass the smaller one
                sizes[getRoot] += sizes[getParent];
            }


        }

        for (int i = 1; i <= n; i++) {
            // Find the root for that city
            int root = find(i, nodes);

            // Keeps track of how many components whose root is the root
            sizes[root]++;
        }


        // For each city
        long total = 0;
        for (int i = 0; i <= n; i++) {

            // If the degree is greater than 0
            if (sizes[i] > 0) {
                // This city is a disconnected component and thus needs a hospital
                // And however many other cities in that subgraph highways
                total += (long) hospitalCost + (long) (sizes[i] - 1) * highwayCost;
            }
        }
        // Return your total cost
        return total;

    }

    // Helper method for recursively finding the roots
    public static int find(int n, int[] parent) {
        // If the index and value aren't equal
        if (parent[n] != n) {
            // Recursively find the root by going down a node
            // This is the path compression
            parent[n] = find(parent[n], parent);
        }
        // Return the original root
        return parent[n];
    }
}