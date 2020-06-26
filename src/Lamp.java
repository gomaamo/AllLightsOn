import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Lamp extends Rectangle {
    private boolean isOn;
    private int height,width,x,y;

    public Lamp(int x, int y){
        height=100;
        width=100;
        isOn=false;
        setHeight(height);
        setWidth(width);
        setFill(Color.BLUE);
        setStroke(Color.BLACK);
        this.x=x;
        this.y=y;
    }

    public void toggle(){
        if(isOn){
            setFill(Color.BLUE);
            isOn =! isOn;
        }
        else{
            setFill(Color.YELLOW);
            isOn =! isOn;
        }
    }

    public void switchOff(){
        isOn = false;
        setFill(Color.BLUE);
    }

    public boolean isOn(){ return isOn; }
    public int getCoorX(){ return x; }
    public int getCoorY(){ return y; }

}
