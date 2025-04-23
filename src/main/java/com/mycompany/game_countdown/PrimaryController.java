package com.mycompany.game_countdown;

import Model.Game;
import Model.GameListing;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class PrimaryController {
    @FXML
    private Button btn_Details1;

    @FXML
    private Button btn_Details2;

    @FXML
    private Button btn_Details3;

    @FXML
    private Button btn_Details4;

    @FXML
    private Button btn_Details5;

    @FXML
    private Button btn_Details6;

    @FXML
    private ImageView imageviewgame1;

    @FXML
    private ImageView imageviewgame2;

    @FXML
    private ImageView imageviewgame3;

    @FXML
    private ImageView imageviewgame4;

    @FXML
    private ImageView imageviewgame5;

    @FXML
    private ImageView imageviewgame6;

    @FXML
    private Label lblGameTitle1;

    @FXML
    private Label lblGameTitle2;

    @FXML
    private Label lblGameTitle3;

    @FXML
    private Label lblGameTitle4;

    @FXML
    private Label lblGameTitle5;

    @FXML
    private Label lblGameTitle6;

    @FXML
    private Label timeoutgame1;

    @FXML
    private Label timeoutgame2;

    @FXML
    private Label timeoutgame3;

    @FXML
    private Label timeoutgame4;

    @FXML
    private Label timeoutgame5;

    @FXML
    private Label timeoutgame6;

    @FXML
    private TextArea txtdescribationgame1;

    @FXML
    private TextArea txtdescribationgame2;

    @FXML
    private TextArea txtdescribationgame3;

    @FXML
    private TextArea txtdescribationgame4;

    @FXML
    private TextArea txtdescribationgame5;

    @FXML
    private TextArea txtdescribationgame6;
        private static Scene scene;
        

    @FXML
    void onclickbtn_Details(ActionEvent event) throws IOException {
      Button clickedButton = (Button) event.getSource();
      String id = clickedButton.getId();


     FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
     Parent root = loader.load();

     SecondaryController controller = loader.getController();

     controller.setButtonId(id);

     Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
     stage.setScene(new Scene(root));
     stage.show();

    }
      @FXML
    public void initialize() {
          GameListing.Games.add(new Game("Fortnite","Fortnite is a free-to-play online game where 100 players fight to be the last one standing. It’s a mix of shooting, building, and fast action. Players can collect weapons, build structures for defense, and explore a colorful island. The game also features fun events, new skins, and dances that make it popular with players of all ages.",
          "/images/1.jpg","/Videos/1.mp4",LocalDateTime.of(2025, 4, 25, 0, 0, 0)));
         
          GameListing.Games.add(new Game(" Call of Duty: Warzone","Call of Duty: Warzone is a free-to-play battle royale game where players fight to be the last one standing on a massive map, using realistic weapons and tactics.",
          "/images/2.png","/Videos/2.mp4",LocalDateTime.of(2026, 5, 25, 10, 50, 10)));
          GameListing.Games.add(new Game("Minecraft","Minecraft is a sandbox game where players can build, explore, and survive in a blocky, pixelated world made entirely of cubes.",
          "/images/3.jpg","/Videos/3.mp4",LocalDateTime.of(2025, 6, 12, 0, 0, 0)));
          GameListing.Games.add(new Game("GTA V",
    "Grand Theft Auto V is an action-adventure game set in an open world. Players can switch between three characters, complete missions, explore a huge city, and engage in countless side activities. The online mode offers endless multiplayer experiences.",
    "/images/4.jpg", "/Videos/4.mp4", LocalDateTime.of(2025, 8, 1, 12, 30, 0)));

      GameListing.Games.add(new Game("FIFA 24",
    "FIFA 24 (EA Sports FC) is a realistic football simulation game where players can build teams, play tournaments, and compete online. It features real clubs, stadiums, and players from around the world.",
    "/images/5.jpg", "/Videos/5.mp4", LocalDateTime.of(2024, 9, 15, 18, 0, 0)));

          GameListing.Games.add(new Game("PUBG",
    "PlayerUnknown's Battlegrounds (PUBG) is a battle royale shooter that pits 100 players against each other in a fight for survival. Scavenge weapons, stay in the safe zone, and be the last player or squad standing.",
    "/images/6.jpg", "/Videos/6.mp4", LocalDateTime.of(2025, 7, 20, 14, 45, 0)));
       displayGame(0,lblGameTitle1,txtdescribationgame1,imageviewgame1,timeoutgame1);
       displayGame(1,lblGameTitle2,txtdescribationgame2,imageviewgame2,timeoutgame2);
       displayGame(2,lblGameTitle3,txtdescribationgame3,imageviewgame3,timeoutgame3);
       displayGame(3,lblGameTitle4,txtdescribationgame4,imageviewgame4,timeoutgame4);
       displayGame(4,lblGameTitle5,txtdescribationgame5,imageviewgame5,timeoutgame5);
       displayGame(5,lblGameTitle6,txtdescribationgame6,imageviewgame6,timeoutgame6);



                
            
            
            
          
    }
 
        private void  displayGame(int numberofgame,Label Title,TextArea Dec,ImageView img,Label Date){
             Game g= GameListing.Games.get(numberofgame);
        
             Title.setText(g.getTitle());
            Dec.setText(g.getDescription());
            Image GameImage = new Image(getClass().getResource(g.getImagePath()).toExternalForm());
            img.setImage(GameImage);
            
               
   new Thread(new Runnable() {
    @Override
    public void run() {
        while (true) {
            try {
              Duration duration = Duration.between(LocalDateTime.now(), g.getReleaseDate());


                if (!duration.isNegative()) {
                    long totalSeconds = duration.getSeconds();

                    long days = totalSeconds / (24 * 3600);
                    totalSeconds %= (24 * 3600);

                    long hours = totalSeconds / 3600;
                    totalSeconds %= 3600;

                    long minutes = totalSeconds / 60;
                    long seconds = totalSeconds % 60;

                    String remainingTime = days + " days, " +
                            hours + " hours, " +
                            minutes + " minutes, " +
                            seconds + " seconds";

                    Platform.runLater(() -> {
                        Date.setText(remainingTime);
                    });
                } else {
                    Platform.runLater(() -> {
                        Date.setText("Released!");
                    });
                    break; 
                }

                Thread.sleep(1000); 
            } catch (InterruptedException ex) {
                ex.printStackTrace();
                break;
            } catch (Exception ex) {
                ex.printStackTrace();
                break;
            }
        }
    }
}).start();

        }
}
