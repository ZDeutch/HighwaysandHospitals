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
        for (int i = 0; i < cities.length; i++) {
            int[] group = new int[cities.length + cities[0].length];
            boolean inGroup = false;
            for (int j = 0; i < group.length; j++) {
                if (cities[i][1] == group[j]) {
                    inGroup = true;
                }
            }
            if(!inGroup) {
                group[i] = cities[i][1];
            } else {
                group[i + 1] = cities[i][0];
            }

        }


        return 0;
    }
}
