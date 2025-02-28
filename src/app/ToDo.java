import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ToDo extends Application
{
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/todo.fxml"));
        ScrollPane root = loader.load();
        Scene scene = new Scene(root, Color.WHITE);

        Font.loadFont(getClass().getResourceAsStream("fonts/Poppins-Regular.ttf"), 14);
        scene.getStylesheets().add(getClass().getResource("css/style.css").toExternalForm());

        primaryStage.setTitle("Mr ToDoer");
        primaryStage.setWidth(400);
        primaryStage.setHeight(500);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
