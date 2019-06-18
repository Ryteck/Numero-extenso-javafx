package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Initializer extends Application {

    public void home(){
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {

        Parent root = FXMLLoader.load(getClass().getResource("/views/home.fxml"));

        Scene scene = new Scene(root);

        stage.setTitle("Conversor");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

}
