import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseButton;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class ToDoController
{
    @FXML private TextField todoInput;
    @FXML private VBox todoList;
    @FXML private GridPane bottomTask;
    @FXML private Button clearAll;

    @FXML
    private void handleUserInput()
    {
        String taskValue = todoInput.textProperty().get();
        if(taskValue.isEmpty())
            return;

        // Creating the grid pane
        GridPane grid = new GridPane(0, 0);
        grid.setAlignment(Pos.CENTER);
        grid.getStyleClass().add("listDiv");

        // Creating Label and Button inside grid
        Label task = new Label(taskValue);
        task.getStyleClass().add("todo-job");

        Button delete = new Button("🗑️");
        delete.prefWidth(50);

        task.setOnMouseClicked(e ->
        {
            if(e.getButton() == MouseButton.SECONDARY)
            {
                showTask(task.getText());
            }
            else
            {
                if(task.getStyleClass().contains("done"))
                {
                    task.getStyleClass().remove("done");
                    delete.getStyleClass().remove("done");
                }
                else
                {
                    task.getStyleClass().add("done");
                    delete.getStyleClass().add("done");
                }
            }
            
        });

        delete.setOnAction(e ->
        {
            grid.getChildren().remove(task);
            grid.getChildren().remove(delete);

            VBox.setMargin(grid, null);
        });

        clearAll.setOnAction(e -> 
        {
            todoList.getChildren().clear();
        });
        
        // Adding margin to grid
        VBox.setMargin(grid, new Insets(10, 0, 0, 0));
        
        // Adding elements to the grid
        grid.add(task, 0, 0);
        grid.add(delete, 1, 0);

        todoList.getChildren().add(grid);
        todoInput.textProperty().set("");
    }

    private void showTask(String message)
    {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("View Task");
        alert.setWidth(500);
        alert.setResizable(false);
        alert.setHeaderText(message);;
        alert.showAndWait();
    }
}
