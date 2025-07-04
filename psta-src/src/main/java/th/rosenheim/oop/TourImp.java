package th.rosenheim.oop;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.charset.StandardCharsets;

public class TourImp implements Tour {
    private String tourType;
    private String TourName;
    private List<Item> allItems;
    private LocalDate date;
    private double lengthKm;
    private int durationHour;
    private List<Participants> participants;
    private TourGuide tourGuide;
    private Map<Participants, List<Item>> itemsBefore;
    private Map<Participants, List<Item>> itemsAfter;

    public TourImp(String tourName,String tourType,LocalDate date, double lengthKm, int durationHour, List<Participants> participants, TourGuide tourGuide) {
        this.TourName = tourName;
        this.date = date;
        this.lengthKm = lengthKm;
        this.durationHour = durationHour;
        this.participants = participants;
        this.tourGuide = tourGuide;
        itemsBefore = new HashMap<>();
        itemsAfter = new HashMap<>();
        allItems = new ArrayList<>();
        this.tourType = tourType;

    }

    @Override
    public void redistributeLuggage() {
        System.out.println("Redistributing luggage");
        //Backing up all items before emptying backpacks
        for (int i = 0; i < participants.size(); i++) {
            Participants p = participants.get(i);

            //Backing up items before clearing
            List<Item> original = new ArrayList<Item>();
            List<Item> pBackpack = p.getBackpack();

            for (int j = 0; j < pBackpack.size(); j++) {
                original.add(pBackpack.get(j));

            }
            itemsBefore.put(p, original); //Save before state




            allItems.addAll(original); // Add shared item
            p.clearBackpack(); // Empty backpack for redistribution
        }

        //sort all weight by the heaviest first
        // creating an anonymous inner class implementing the Comparator Interface
        Collections.sort(allItems, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return Double.compare(b.getWeight(), a.getWeight());
            } // result in descending order from max to min
        });

        //for each item we assign it using the greedy principle (to the lightest eligible participant)

        for (int i = 0; i< allItems.size(); i++){
            Item currentItem = allItems.get(i);

            // Sort participants by their current backpack weight (lightest first)
            Collections.sort(participants, new Comparator<Participants>() {
                @Override
                public int compare(Participants a, Participants b) {
                    return Double.compare(a.getCurrentWeight(), b.getCurrentWeight());
                }
            });

            //assigning current item to the first participant who can carry it
            for (int j=0; j< participants.size(); j++){
                Participants p = participants.get(j);
                if(p.canCarry(currentItem)){
                    p.addItem(currentItem);
                    break; //item successfully assigned
                }
            }
        }
        //saving itemAfter state
        for (int i = 0; i < participants.size(); i++) {
            Participants p = participants.get(i);
            List<Item> afterList = new ArrayList<Item>();

            List<Item> backpack = p.getBackpack();
            for (int j = 0; j < backpack.size(); j++) {
                afterList.add(backpack.get(j));
            }
            itemsAfter.put(p, afterList);
        }
        //print summary of distribution
        System.out.println("✅ Redistribution Completed:");
        for (int i = 0; i < participants.size(); i++) {
            Participants p = participants.get(i);
            if (p.getBackpack().size() > 0) {
                System.out.println("Items distributed to "+ p.getName() + " (" + p.getAge() + ") " + p.getBackpack());
            } else {
                System.out.println(p.getName() +  " (" + p.getAge() + ") " +" no item distributed");
            }
        }
    }

    //with Mark-down we´ll be formatting text using plain characters and later convert to HTML
    @Override
    public void generateMarkdown() throws IOException {

            String tourTitle = "Tour on " + date.toString();
            String fileName = "tour_" + date.toString() + ".md";  // Example: tour_2025-08-15.md

            List<String> lines = new ArrayList<>();

            // Title and general info
            lines.add("# " + tourType + " " + tourTitle);
            lines.add("\n");
            lines.add("**Name:** " + TourName);
            lines.add("\n");
            lines.add("**Duration:** " + durationHour + " hours");
            lines.add("\n");
            lines.add("**Length:** " + lengthKm + " km");
            lines.add("\n");
            lines.add("**Guide:** " + tourGuide.getName());
            lines.add("\n");

            // Participants summary
            lines.add("## Participants and Their Luggage");
            lines.add("");

            for (Participants p : participants) {
                lines.add("### " + p.getName() + " (" + p.getAge() + ")");

                List<Item> items = itemsAfter.get(p);


                if (items == null || items.isEmpty()) {
                    lines.add("⬜️⬜️⬜️⬜️⬜️⬜️⬜️⬜️⬜️⬜️⬜️");
                } else {
                    for (Item item : items) {
                        lines.add("- " + item.getName() + " (" + item.getWeight() + " kg)");
                    }
                    lines.add("🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩🟩");
                }

                double total = p.getCurrentWeight();
                lines.add("- **Total weight:** " + String.format("%.2f", total) + " kg");

                // Family tour rules
                if (p.getAge() < 5 && total > 0) {
                    lines.add("- ⚠️ Too young to carry anything!");
                } else if (p.getAge() <= 14 && total > 5) {
                    lines.add("- ⚠️ Exceeds 5 kg limit for children.");
                }
                lines.add("");
            }

            // Write to file
            Path output = Paths.get(fileName);
            Files.write(output, lines, StandardCharsets.UTF_8);
            System.out.println("📄 Markdown file generated: " + fileName);
    }


}

