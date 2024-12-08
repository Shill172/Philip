import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx. scene. image.Image;

import java.util.ArrayList;


public class Main extends Application {

    private ArrayList<FlashcardGroup> collections = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
// Scene 1 - Main Menu
        VBox mainMenu = new VBox(10);
        mainMenu.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: #008b8b;");

        Label mainLabel = new Label("Main Menu");
        Button addCollection = new Button("Add Collection");
        Button viewCollection = new Button("View Collections");

        mainMenu.getChildren().addAll(mainLabel, viewCollection, addCollection);
        Scene mainMenuScene = new Scene(mainMenu,400, 400);

// Scene 2 - Flashcard Collections
        VBox collectionMenu = new VBox(10);
        collectionMenu.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: #f0f0f0;");

        Label collectionLabel = new Label("Collection Menu");
        ListView<String> collectionListView = new ListView<>();
        Button backButton = new Button("Back");

        collectionMenu.getChildren().addAll(collectionLabel, collectionListView, backButton);
        Scene collectionMenuScene = new Scene(collectionMenu, 400, 400);

//Scene 3 - Add Collections
        VBox addCollectionMenu = new VBox(10);
        addCollectionMenu.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-background-color: #f0f0f0;");

        Label addCollectionLabel = new Label("Add Collection");
        TextField collectionNameInput = new TextField();
        collectionNameInput.setPromptText("Enter collection Name");
        Button saveCollectionButton = new Button("Save Collection");
        Button cancelButton = new Button("Cancel");

        addCollectionMenu.getChildren().addAll(addCollectionLabel, collectionNameInput, saveCollectionButton, cancelButton);
        Scene addCollectionScene = new Scene(addCollectionMenu, 400, 400);

//Button actions
        viewCollection.setOnAction(e -> {
            collectionListView.getItems().clear();
            for(FlashcardGroup g : collections) {
                collectionListView.getItems().add(g.getGroupName());
            }
            primaryStage.setScene(collectionMenuScene);
        });

        backButton.setOnAction(e -> primaryStage.setScene(mainMenuScene));

        addCollection.setOnAction(e -> primaryStage.setScene(addCollectionScene));

        saveCollectionButton.setOnAction(e -> {
            String collectionName = collectionNameInput.getText();
            if (!collectionName.isEmpty()) {
                FlashcardGroup newCollection = new FlashcardGroup(collectionName);
                collections.add(newCollection);
                collectionNameInput.clear();
                Alert successAlert = new Alert(Alert.AlertType.INFORMATION, "Collection Added Successfully");
                successAlert.showAndWait();
                primaryStage.setScene(mainMenuScene);
            } else {
                Alert errorAlert = new Alert(Alert.AlertType.ERROR, "Please enter a valid collection name");
                errorAlert.showAndWait();
            }
        });

        cancelButton.setOnAction(e -> {
            collectionNameInput.clear();
            primaryStage.setScene(mainMenuScene);
        });

//configurations
        Image icon = new Image("PhilipLogo.png");
        primaryStage.getIcons().add(icon);

        primaryStage.setTitle("Philip");
        primaryStage.setScene(mainMenuScene);
        primaryStage.show();

    }
}
