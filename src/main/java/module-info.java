module com.example.testshapes {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.testshapes to javafx.fxml;
    exports com.example.testshapes;
}