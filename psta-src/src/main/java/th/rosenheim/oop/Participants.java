package th.rosenheim.oop;
import java.util.ArrayList;
import java.util.List;



public class Participants extends Person {
    private List<Item> backpack;
    private double currentWeight;

    public Participants(String name, int age) {
        super(name, age);
        this.backpack = new ArrayList<>();
        this.currentWeight = 0;
    }
    //add item if allowed
    public boolean addItem(Item item) {
        if(canCarry(item)) {
            backpack.add(item);
            currentWeight += item.getWeight();
            return true;
        } else {
            return false;
        }
    }

    //return backpack content
    public List<Item> getBackpack() {
        return backpack;
    }
    //clear backpack and reset current weight
    public void clearBackpack() {
        backpack.clear();
        currentWeight = 0;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    @Override
    public boolean canCarry(Item item) {
        if(getAge() < 5) {
            return false;
        } else if (getAge() <= 14) {
            return (currentWeight + item.getWeight() <= 5); //max 5kg
        }
        //try to impliment a comparator here to check age
        else{
            return true;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        if(backpack.isEmpty()) {
            sb.append(" only brings an empty backpack");
        }
        else{
            for(Item item : backpack) {
                sb.append(" brings " + item.toString()).append(", ");
            }
        }
       return sb.toString();
    }
}
