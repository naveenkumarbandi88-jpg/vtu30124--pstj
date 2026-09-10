class ParkingSystem {
    private int[] count;

    public ParkingSystem(int big, int medium, int small) {
        // Index 0 unused; index 1 = big, 2 = medium, 3 = small
        this.count = new int[]{0, big, medium, small};
    }
    
    public boolean addCar(int carType) {
        if (count[carType] > 0) {
            count[carType]--;
            return true;
        }
        return false;
    }
}


input
["ParkingSystem","addCar","addCar","addCar","addCar"]
[[1,1,0],[1],[2],[3],[1]]
Output
[null,true,true,false,false]
Expected
[null,true,true,false,false]
