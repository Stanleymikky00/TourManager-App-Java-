package th.rosenheim.oop;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.*;

public class AppTest {
    @Test
    void testRedistributeLuggage() {
        //creating participants
        Participants peter = new Participants("Peter",30);
        Participants max = new Participants("Max", 14);     // teen
        Participants otto = new Participants("Otto", 4);

        //giving items
        peter.addItem(new Item("Jacket", 1.5));
        peter.addItem(new Item("Shirt", 0.5));
        max.addItem(new Item("sunglasses", 0.5));
        max.addItem(new Item("Snack", 0.5));
        otto.addItem(new Item("Teddy Bear", 0.3));

        TourGuide guide = new TourGuide("Sarah", 35);
        List<Participants> group = Arrays.asList(peter, max, otto);

        //checking the redistribution Algorithm
        TourImp tour = new TourImp("kimsee tour", "Family Tour",LocalDate.now(), 10.0, 3, group, guide);
        tour.redistributeLuggage();

        //assertion
        assertEquals(0.0, otto.getCurrentWeight(), "Otto should carry nothing");
        assertTrue(max.getCurrentWeight() <= 5.0, "max should carry not less then 5.0");
        assertTrue(peter.getCurrentWeight() >= max.getCurrentWeight(), "peter should carry more than max");

    }

}
