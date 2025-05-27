package th.rosenheim.oop;

public class TourGuide extends Person{
    public TourGuide(String name, int age) {
        super(name, age);

    }

    @Override
    public boolean canCarry(Item item) {
        return false; //since tour guide does not carry anything. we return false
    }

    @Override
    public String toString() {
        return "Tour Guide: " + super.toString();
    }
}
