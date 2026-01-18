module com.mycompany.colafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.colafx.controller to javafx.fxml;
    exports com.mycompany.colafx;
    exports com.mycompany.colafx.controller;
    exports com.mycompany.colafx.model;
    exports com.mycompany.colafx.view;

}
