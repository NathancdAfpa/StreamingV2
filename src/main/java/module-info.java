module com.streaming2.streaming2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.streaming2.streaming2 to javafx.fxml;
    exports com.streaming2.streaming2;
}