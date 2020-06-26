import java.util.LinkedList;

public class Controller {
    View view;

    public Controller(View view){ this.view=view; }

    public void intializeEvents(){
        for(Lamp lamp: view.getLamps()){
            lamp.setOnMouseClicked(event ->
                    this.toggle(lamp.getCoorX(),lamp.getCoorY()));
        }
        view.addEventHandler(event -> this.resetLamps());
    }

    public void toggle(int x, int y){
        LinkedList<Lamp> lamps = view.getLamps();
        System.out.println(x + "," + y);
        lamps.get(x*5+y).toggle();
        if(x>0){
            lamps.get((x-1)*5+y).toggle();
        }
        if(y>0){
            lamps.get(x*5+(y-1)).toggle();
        }
        if(x<4) {
            lamps.get((x + 1) * 5 + y).toggle();
        }
        if(y<4){
            lamps.get(x*5+(y+1)).toggle();
        }
        this.setMessage();
    }

    public void resetLamps(){
        for(Lamp lamp: view.getLamps()){
            lamp.switchOff();
        }
        view.getMsg().setText("");
        view.getOn().setText("on: 0");
        view.getOff().setText("off: 25");
    }

    public boolean isWon(){
        boolean isWon=true;

        for(Lamp lamp: view.getLamps()){
            if(!lamp.isOn()){
                isWon=false;
                break;
            }
        }
        return isWon;
    }

    public void setMessage(){
        if(this.isWon()){
            view.getMsg().setText("We have a WINNER!, reset to play again");
        }

        view.getOn().setText("on: " +
                String.valueOf(this.count(true)));
        view.getOff().setText("off: " +
                String.valueOf(count(false)));
    }

    public int count(boolean isOn){
        int count = 0;
        for(Lamp lamp: view.getLamps()){
            if(isOn==lamp.isOn()){
                count++;
            }
        }
        return count;
    }
}
