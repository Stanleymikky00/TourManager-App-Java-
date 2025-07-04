package th.rosenheim.oop;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App { public static void main(String[] args) {

    // Create participants
    th.rosenheim.oop.Participants peter = new Participants("Stanley", 27);
    th.rosenheim.oop.Participants max = new Participants("Jacob", 14);
    Participants sabine = new Participants("Sabine", 10);
    th.rosenheim.oop.Participants gerda = new th.rosenheim.oop.Participants("Gerda", 26);
    Participants otto = new th.rosenheim.oop.Participants("otto", 4); // too young to carry

    // Add items to backpacks
    peter.addItem(new Item("Bottle of Water", 1.5));
    peter.addItem(new Item("Jacket", 1.0));
    peter.addItem(new Item("Sausage Sandwich", 5.0));

    max.addItem(new Item("Climbing Gear", 7.5));
    max.addItem(new Item(" Cheese Sandwich", 7.0));
    max.addItem(new Item("Chocolate", 3.0));
    max.addItem(new Item("Bottle of water", 1.5));
    max.addItem(new Item("Bottle of water", 1.5));
    max.addItem(new Item("jacket", 1.0));

    gerda.addItem(new Item("banana", 5.0));
    gerda.addItem(new Item("frisbee", 2.0));
    gerda.addItem(new Item("apple spritzer", 1.5));
    gerda.addItem(new Item("picnic Basket", 3.5));
    gerda.addItem(new Item("Bottle of water", 1.5));
    gerda.addItem(new Item("Bottle of water", 1.5));
    gerda.addItem(new Item("jacket", 7.0));

    sabine.addItem(new Item("apple", 5.0));
    sabine.addItem(new Item("Bottle of water", 1.5));
    sabine.addItem(new Item("Bottle of water", 1.5));
    sabine.addItem(new Item("blanket", 2.0));
    sabine.addItem(new Item("tent", 8.0));
    sabine.addItem(new Item("jacket", 7.0));

    //brought nothing.
    otto.addItem(new Item());

    // Create a tour guide
    TourGuide guide = new TourGuide("Josua", 35);

    // Create list of participants
    List<Participants> group = new ArrayList<>();
    group.add(peter);
    group.add(max);
    group.add(otto);
    group.add(gerda);
    group.add(sabine);

    //Extreme Tour
    Participants lena = new Participants("Lena", 27);
    Participants mila = new Participants("Mila", 30);
    Participants sam = new Participants("Sam", 43);
    Participants ludwig = new Participants("Ludwig", 43);

    lena.addItem(new Item("Bottle of water", 1.5));
    lena.addItem(new Item("blanket", 2.0));
    lena.addItem(new Item("tent", 8.0));
    lena.addItem(new Item("jacket", 7.0));

    mila.addItem(new Item("banana", 5.0));
    mila.addItem(new Item("frisbee", 2.0));
    mila.addItem(new Item("apple spritzer", 1.5));
    mila.addItem(new Item("picnic Basket", 3.5));

    sam.addItem(new Item("Bottle of water", 1.5));
    sam.addItem(new Item("Bottle of water", 1.5));
    sam.addItem(new Item("jacket", 1.0));

    ludwig.addItem(new Item("Bottle of Water", 1.5));
    ludwig.addItem(new Item("Jacket", 1.0));
    ludwig.addItem(new Item("Sausage Sandwich", 5.0));

    List<Participants> group2 = new ArrayList<>();
    group2.add(mila);
    group2.add(sam);
    group2.add(ludwig);
    group2.add(lena);

    TourGuide guide2 = new TourGuide("Stanley", 35);








    // Creating Tour
    TourImp tour1 = new TourImp("Kampenwand-Tour", "Family Hiking Tour",LocalDate.now(), 20.0, 4, group, guide);
    TourImp tour2 = new TourImp("Simsee-Tour","Extreme",LocalDate.now(), 45.0, 3, group2, guide2);
    // Run the redistribution algorithm
    tour1.redistributeLuggage();
    tour2.redistributeLuggage();



    try{
        tour1.generateMarkdown();
        tour2.generateMarkdown();
    }
    catch(Exception e){
        System.out.println("Error writing Markdown" + e.getMessage());
    }
}
}

