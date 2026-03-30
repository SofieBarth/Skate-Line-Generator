module dein.projektname {
    requires javafx.controls;
    requires javafx.fxml;

    // Erlaube JavaFX den Zugriff auf deine UI-Klassen
    opens UI to javafx.graphics, javafx.fxml;

    // Falls deine Infrastructure.Main-Klasse in einem anderen Package liegt,
    // musst du das auch für javafx.graphics öffnen.
}