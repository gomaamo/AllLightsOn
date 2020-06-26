import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.LinkedList;

public class View extends BorderPane {
    GridPane grid1;
    GridPane grid2;
    Button reset;
    Label msg;
    Label on;
    Label off;
    Label logo;
    LinkedList<Lamp> lamps;

    public void intialize(Stage primaryStage){
        grid1 = new GridPane();
        grid2 = new GridPane();
        lamps = new LinkedList<Lamp>();

       grid1.setLayoutX(5);
       grid1.setLayoutY(5);

        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                Lamp lamp = new Lamp(i,j);
                lamps.add(lamp);
                grid1.add(lamp,i,j);
            }
        }

        reset = new Button("Reset");
        msg = new Label();
        on = new Label("on: 0");
        on.setTextFill(Color.BLACK);
        on.setBackground(new Background(new BackgroundFill(Color.YELLOW,
                CornerRadii.EMPTY, Insets.EMPTY)));
        off = new Label("off: 25");
        off.setTextFill(Color.WHITE);
        off.setBackground(new Background(new BackgroundFill(Color.BLUE,
                CornerRadii.EMPTY,Insets.EMPTY)));
        logo = new Label("       © 2019 Mohamed Gomaa");

        reset.setPadding(new Insets(0,10,0,10));
        msg.setPadding(new Insets(0,10,0,10));
        on.setPadding(new Insets(0,10,0,10));
        off.setPadding(new Insets(0,10,0,10));
        logo.setPadding(new Insets(0,10,0,10));

        grid2.addRow(0);
        grid2.add(reset,0,0);
        grid2.add(msg,1,0);
        grid2.add(on,2,0);
        grid2.add(off,3,0);
        grid2.add(logo,4,0);

        setTop(grid1);
        setBottom(grid2);
        primaryStage.setScene(new Scene(this));
    }

    public void addEventHandler(EventHandler<ActionEvent> eventReset){
        reset.addEventHandler(ActionEvent.ACTION, eventReset);
    }

    public LinkedList<Lamp> getLamps(){ return lamps; }
    public Label getMsg(){ return msg; }
    public Label getOn(){ return  on; }
    public Label getOff(){ return off; }

}
