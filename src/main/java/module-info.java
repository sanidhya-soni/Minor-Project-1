module com.saho.minor_1_fx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.saho.minor_1_fx to javafx.fxml;
    exports com.saho.minor_1_fx;
}