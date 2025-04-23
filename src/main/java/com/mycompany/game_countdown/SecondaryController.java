package com.mycompany.game_countdown;

import java.io.File;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
public class SecondaryController {
    private String buttonId;
        @FXML
    private Button btn_pause;

    @FXML
    private Button btn_play;

    @FXML
    private Button btn_reset;

    @FXML
    private MediaView mediaview;
    
    private File file;
    
    private MediaPlayer mediaplayer;
    private Media media;
    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
    Parent root = loader.load();

    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
    stage.setTitle("show screen");
    stage.setScene(new Scene(root));
    stage.setMaximized(true);
    stage.show(); 
    
    }


    
    

    void setButtonId(String id) {
        this.buttonId = id;
        playfirst();
    }
       @FXML
    public void initialize() {
        
        

    }
    
    private void playfirst(){
        if("btn1".equals(this.buttonId)){
         media = new Media(getClass().getResource("/Videos/1.mp4").toExternalForm());

        }
        else if("btn2".equals(this.buttonId)){
           media = new Media(getClass().getResource("/Videos/2.mp4").toExternalForm());

        }
        else if("btn3".equals(this.buttonId)){
            media = new Media(getClass().getResource("/Videos/3.mp4").toExternalForm());

        }
      else if("btn4".equals(this.buttonId)){
            media = new Media(getClass().getResource("/Videos/4.mp4").toExternalForm());

        }
         else if("btn5".equals(this.buttonId)){
            media = new Media(getClass().getResource("/Videos/5.mp4").toExternalForm());

        }
         else if("btn6".equals(this.buttonId)){
            media = new Media(getClass().getResource("/Videos/6.mp4").toExternalForm());

        }
        
        mediaview.setPreserveRatio(false);

  mediaplayer=new MediaPlayer(media);
  mediaview.setMediaPlayer(mediaplayer);
    }
        @FXML
    void onplayclick(ActionEvent event) {
     mediaplayer.play();
    }
        @FXML
    void onPauseClick(ActionEvent event) {
     mediaplayer.pause();
    }
    
    @FXML
    void onresetclick(ActionEvent event) {
    mediaplayer.seek(Duration.seconds(0.0));
    }
        @FXML
    void onbackclick(ActionEvent event) {
    
    }

}