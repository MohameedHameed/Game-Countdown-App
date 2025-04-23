module com.mycompany.game_countdown {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    opens com.mycompany.game_countdown to javafx.fxml;
    exports com.mycompany.game_countdown;
}
