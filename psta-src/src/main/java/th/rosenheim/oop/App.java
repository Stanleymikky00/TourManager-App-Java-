package th.rosenheim.oop;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App { public static void main(String[] args) {

    // Create participants
    Participants peter = new Participants("Stanley", 27);
    Participants max = new Participants("Jacob", 14);
    Participants otto = new Participants("kim", 4); // too young to carry

    // Add items to backpacks
    peter.addItem(new Item("Bottle of Water", 1.5));
    peter.addItem(new Item("Jacket", 1.0));

    max.addItem(new Item("Climbing Gear", 7.5));
    max.addItem(new Item("Sandwich", 0.5));

    otto.addItem(new Item("Teddy Bear", 0.3));

    // Create a tour guide
    TourGuide guide = new TourGuide("Josua", 35);

    // Create list of participants
    List<Participants> group = new ArrayList<>();
    group.add(peter);
    group.add(max);
    group.add(otto);

    // Create Tour
    TourImp tour = new TourImp("Munich tour", "Family Tour",LocalDate.now(), 10.0, 3, group, guide);

    // Run the redistribution algorithm
    tour.redistributeLuggage();

    try{
        tour.generateMarkdown();
    }
    catch(Exception e){
        System.out.println("Error writing Markdown" + e.getMessage());
    }
}
}

