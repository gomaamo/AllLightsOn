import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        View view = new View();
        Controller controller = new Controller(view);

        view.intialize(primaryStage);
        controller.intializeEvents();
        primaryStage.setTitle("All Lights On");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
