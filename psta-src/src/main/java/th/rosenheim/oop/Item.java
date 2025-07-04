package th.rosenheim.oop;

public class Item {
    private String name;
    private double weight;

    public Item(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }
    public Item(){
        this.name = "";
        this.weight = 0;
    }
    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }


    @Override
    public String toString() {
        return name + " (" + weight + " kg)";
    }
}
