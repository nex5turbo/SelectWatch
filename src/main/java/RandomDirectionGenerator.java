import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class RandomDirectionGenerator {

    public RandomDirectionGenerator(View view) {
        this.view = view;

    }

    private View view;
    public int funcNum = 6;
    public int result = 0;
    public int[] eLCD = new int[60];

    public void reqRandomDirection() {
        for(int i = 0; i < 60; i++) {
            eLCD[i] = 0;
        }
        generateRandomNumber();
    }

    public void generateRandomNumber() {
        Random randomNumber = new Random();
        while(result == 0)
            result = randomNumber.nextInt(61);
        display_eLCD();
    }

    public void display_eLCD() {
        //ve to implement for gui wy
        eLCD[result-1] = 1;
        view.setDot(result-1);
    }

}