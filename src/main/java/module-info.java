module eightpuzzle {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens application to javafx.fxml;
    opens controller to javafx.fxml;
    exports application;
    exports controller;
}