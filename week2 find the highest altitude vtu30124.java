class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int maxAltitude = 0;
        for (int i = 0; i < gain.length; i++) {
            altitude += gain[i];
            if (altitude > maxAltitude) {
                maxAltitude = altitude;
            }
        }
        return maxAltitude;
    }
}
OUTPUT:
Case 1
Input
gain =
[-5,1,5,0,-7]
Output
1
Expected
1
Case 2
Input
gain =
[-4,-3,-2,-1,4,3,2]
Output
0
Expected
0