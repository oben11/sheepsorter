// Oliver Benjamin CSE 146

public class Sheep implements Comparable<Sheep> {
    private String name;
    private int shearingTime;
    private int arrivalTime;

    public Sheep(String name, int shearingTime, int arrivalTime) {
        this.name = name;
        this.shearingTime = shearingTime;
        this.arrivalTime = arrivalTime;
    }

    // accessors
    public String getName() {
        return name;
    }

    public int getShearingTime() {
        return shearingTime;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }


    // compare and tostring
    @Override
    public int compareTo(Sheep other) {
        if (this.shearingTime == other.shearingTime) {
            return this.name.compareTo(other.name);
        }
        return Integer.compare(this.shearingTime, other.shearingTime);
    }

    @Override
    public String toString() {
        return name + " (Shearing: " + shearingTime + ", Arrival: " + arrivalTime + ")";
    }
}
