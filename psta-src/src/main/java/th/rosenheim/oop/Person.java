package th.rosenheim.oop;

public abstract class Person {
    private String name;
    private int age;


    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    // Abstract method to be implemented by subclasses like Participant
    public abstract boolean canCarry(Item item);

    @Override
    public String toString() {
        return name + " (" + age + ")";
    }

}
