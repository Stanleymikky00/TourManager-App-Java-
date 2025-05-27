package th.rosenheim.oop;

import java.io.IOException;

public interface Tour {
    void redistributeLuggage(); // logic for greedy redistribution
    void generateMarkdown() throws IOException; // WRITE Markdown output
}
