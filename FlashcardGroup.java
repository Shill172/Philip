import java.util.ArrayList;

public class FlashcardGroup {
    private String groupName;
    private ArrayList<Flashcard> flashcards;

    public FlashcardGroup(String groupName) {
        this.groupName = groupName;
        this.flashcards = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void addFlashcard(Flashcard flashcard) {
        flashcards.add(flashcard);
    }

}
