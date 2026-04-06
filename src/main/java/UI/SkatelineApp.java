package UI;

import data.Tricklist;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Direction;
import model.SkateTrick;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static logic.LineGeneration.addTricktoNewList;
import static logic.LineGeneration.generateSkateLine;

public class SkatelineApp extends Application {
    private StackPane root;

    @Override
    public void start(Stage primaryStage) {

        // main-layout (Container)
        root = new StackPane();
        root.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // first button to start into line generation
        Button startBtn = new Button("Skateline generieren");
        startBtn.setPrefSize(400, 100);
        startBtn.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // choose tricklist for line generation
        startBtn.setOnAction(e -> {

            VBox layout = new VBox(15);
            layout.setAlignment(Pos.CENTER);

            Button existinglistsBtn = new Button("Choose existing Trick-List");
            existinglistsBtn.setPrefSize(400, 80);
            existinglistsBtn.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

            existinglistsBtn.setOnAction(f -> {
                useExistingList();
            });

            Button createNewListBtn = new Button("Create your own Trick-List");
            createNewListBtn.setPrefSize(400, 80);
            createNewListBtn.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

            Tricklist list = new Tricklist();
            SkateTrick[] trickListAll = list.trickListAll;

            createNewListBtn.setOnAction(g -> {
                createNewList(trickListAll);
            });

            layout.getChildren().addAll(existinglistsBtn, createNewListBtn);
            root.getChildren().setAll(layout);
        });

        root.getChildren().add(startBtn);

        Scene scene = new Scene(root, 1000, 800);

        primaryStage.setTitle("Skateline Generator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void useExistingList() {

        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);

        Button listBtn = new Button("Choose a tricklist for your skate-line");
        listBtn.setDisable(true);
        listBtn.setPrefSize(600, 100);
        listBtn.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        Button allTricksBtn = new Button("all tricks");
        allTricksBtn.setPrefSize(400, 80);
        allTricksBtn.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        allTricksBtn.setOnAction(f -> {
            Tricklist list = new Tricklist();
            SkateTrick[] trickList = list.trickListAll;

            // function for further steps
            makeSkateLine(trickList);
        });
        Button beginnerTricksBtn = new Button("beginner tricks");
        beginnerTricksBtn.setPrefSize(400, 80);
        beginnerTricksBtn.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        beginnerTricksBtn.setOnAction(g -> {
            Tricklist list = new Tricklist();
            SkateTrick[] tricklist = list.beginnerTricks;

            makeSkateLine(tricklist);
        });
        Button intermediateTricksBtn = new Button("intermediate tricks");
        intermediateTricksBtn.setPrefSize(400, 80);
        intermediateTricksBtn.setStyle("-fx-font-size: 22px; -fx-font-weight: bold;");

        intermediateTricksBtn.setOnAction(h -> {
            Tricklist list = new Tricklist();
            SkateTrick[] tricklist = list.intermediateTricks;

            makeSkateLine(tricklist);
        });

        layout.getChildren().addAll(listBtn, allTricksBtn, beginnerTricksBtn, intermediateTricksBtn);
        root.getChildren().setAll(layout);
    }

    public void createNewList(SkateTrick[] allTricks) {
        VBox trickListeContainer = new VBox(10);// 10px distance between boxes
        trickListeContainer.setPadding(new Insets(20));
        trickListeContainer.setAlignment(Pos.CENTER);

        Button nextStepBtn = new Button("Go to Next Step");
        StackPane.setAlignment(nextStepBtn, Pos.BOTTOM_RIGHT);
        StackPane.setMargin(nextStepBtn, new Insets(20)); //distance to edge
        nextStepBtn.setPrefSize(250, 80);
        nextStepBtn.setStyle(
                "-fx-font-size: 22px; " +
                        "-fx-font-weight: bold; " +
                        "-fx-border-color: red; " +
                        "-fx-border-width: 2px; " +
                        "-fx-border-radius: 5px; " +
                        "-fx-background-radius: 5px;");
        nextStepBtn.setDisable(true);

        List<SkateTrick> newList = new ArrayList<>();

        //declaration of flags, so that there are enough compatible tricks to generate a Skate-Line
        AtomicBoolean fromRegular = new AtomicBoolean(false);
        AtomicBoolean fromFakie = new AtomicBoolean(false);
        AtomicBoolean fromRegularToRegular = new AtomicBoolean(false);
        AtomicBoolean fromFakieToRegular = new AtomicBoolean(false);

        // tricks added to boxes
        for (SkateTrick trick : allTricks) {
            Button trickBox = new Button(trick.getName());

            // Styling for boxes
            trickBox.setStyle(
                    "-fx-background-color: #f4f4f4; " +
                            "-fx-border-color: #cccccc; " +
                            "-fx-border-radius: 5; " +
                            "-fx-background-radius: 5; " +
                            "-fx-padding: 10 20 10 20; " +
                            "-fx-font-size: 16px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: black;"
            );
            // align boxes and text in boxes in the center and align box size with text
            trickBox.setAlignment(Pos.CENTER);
            trickBox.setMinWidth(Region.USE_PREF_SIZE);
            trickBox.setMaxWidth(Region.USE_PREF_SIZE);
            VBox.setMargin(trickBox, new Insets(5, 0, 5, 0));

            trickBox.setOnAction(e -> {
                addTricktoNewList(newList, trick);
                trickBox.setDisable(true);

                // check which flag the trick sets on true
                if (nextStepBtn.isDisable()) {
                    if (trick.from == Direction.REGULAR) {
                        fromRegular.set(true);
                        if (trick.to == Direction.REGULAR) {
                            fromRegularToRegular.set(true);
                        }
                    } else {
                        fromFakie.set(true);
                        if (trick.to == Direction.REGULAR) {
                            fromFakieToRegular.set(true);
                        }
                    }
                }
                // check if all flags are set on true, so the nextStepButton is not disabled anymore
                if (fromRegular.get() && fromFakie.get() && fromRegularToRegular.get() && fromFakieToRegular.get()) {
                    nextStepBtn.setDisable(false);
                }
            });

            trickListeContainer.getChildren().add(trickBox);
            trickListeContainer.setAlignment(Pos.CENTER);
        }

        // ScrollPane if there are more tricks than fit on the page
        ScrollPane scrollPane = new ScrollPane(trickListeContainer);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        trickListeContainer.setStyle("-fx-background-color: transparent;");
        scrollPane.setFitToWidth(true); // no horizontal scrolling possible

        // new layout
        root.getChildren().setAll(scrollPane);

        root.getChildren().add(nextStepBtn);

        nextStepBtn.setOnAction(g -> {
            SkateTrick[] newTrickArray = newList.toArray(SkateTrick[]::new);

            makeSkateLine(newTrickArray);
        });
    }

    public void makeSkateLine(SkateTrick[] tricklist) {
        VBox layout = new VBox(15);
        layout.setAlignment(Pos.CENTER);

        Button trickBtn = new Button("Enter the amount of tricks for the skate-line");
        trickBtn.setDisable(true);
        trickBtn.setPrefSize(600, 100);
        trickBtn.setStyle("-fx-background-color: white; -fx-font-size: 24px; -fx-font-weight: bold;");

        TextField inputField = new TextField();
        inputField.setPromptText("Enter number..."); // grey info-text in textfield
        inputField.setPrefSize(150, 40);
        inputField.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
        inputField.setMaxWidth(150);

        // button for line-generation
        Button goBtn = new Button("Generate now!");
        goBtn.setPrefSize(400, 90);
        goBtn.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");

        // add to VBox
        layout.getChildren().addAll(trickBtn, inputField, goBtn);
        // emty layout and add new
        root.getChildren().setAll(layout);

        goBtn.setOnAction(e -> {
            String eingabe = inputField.getText();

            try {
                // change data type from string to int
                int numberOfTricks = Integer.parseInt(eingabe);

                // check if negative value was entered
                if (numberOfTricks <= 0) {
                    inputField.setStyle("-fx-border-color: red;"); // visual feedback
                    inputField.clear();
                    inputField.setPrefSize(150, 40);
                    inputField.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
                    inputField.setPromptText("Numbers >0 only!");
                    return;
                }

                List<SkateTrick> result = generateSkateLine(tricklist, numberOfTricks);
                showResultScreen(root, result);

            } catch (NumberFormatException ex) {
                // Check if anything else than a number was entered
                inputField.setStyle("-fx-border-color: red;"); // visuel feedback
                inputField.clear();
                inputField.setPrefSize(150, 40);
                inputField.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");
                inputField.setPromptText("Numbers only!");
            }
        });
    }

    private void showResultScreen(StackPane root, List<SkateTrick> result) {
        VBox trickListeContainer = new VBox(10);// 10px distance between boxes
        trickListeContainer.setPadding(new Insets(20));
        trickListeContainer.setAlignment(Pos.CENTER);

        // tricks added to boxes
        for (SkateTrick trick : result) {
            Label trickBox = new Label(trick.getName());

            // Styling for boxes
            trickBox.setStyle(
                    "-fx-background-color: #f4f4f4; " +
                            "-fx-border-color: #cccccc; " +
                            "-fx-border-radius: 5; " +
                            "-fx-background-radius: 5; " +
                            "-fx-padding: 10 20 10 20; " +
                            "-fx-font-size: 16px;" +
                            "-fx-font-weight: bold;" +
                            "-fx-text-fill: black;"
            );
            // align boxes and text in boxe in the center and align box size with text
            trickBox.setAlignment(Pos.CENTER);
            trickBox.setMinWidth(Region.USE_PREF_SIZE);
            trickBox.setMaxWidth(Region.USE_PREF_SIZE);
            VBox.setMargin(trickBox, new Insets(5, 0, 5, 0));

            trickListeContainer.getChildren().add(trickBox);
            trickListeContainer.setAlignment(Pos.CENTER);
        }

        // ScrollPane if there are more tricks than fit on the page
        ScrollPane scrollPane = new ScrollPane(trickListeContainer);
        scrollPane.setStyle("-fx-background: transparent; -fx-background-color: transparent;");
        trickListeContainer.setStyle("-fx-background-color: transparent;");
        scrollPane.setFitToWidth(true); // no horizontal scrolling possible

        // new layout
        root.getChildren().setAll(scrollPane);
    }
}







