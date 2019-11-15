module test {
    requires javafx.fxml;
    requires javafx.controls;
    exports sample;

    opens sample to javafx.fxml;

}