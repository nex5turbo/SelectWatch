//import java.util.*;

public class TimerData {

    public TimerData(View view) {
        this.view = view;
    }

    private View view;
    public int sec = 0;
    private int sec10 = 0;
    private int min = 0;
    private int min10 = 0;
    private int hour = 0;
    private int hour10 = 0;

    public void saveTimerPart(int part, int value) {
        switch(part) {
            case 1:
                sec =  value;

                break;
            case 2:
                sec10 =  value;

                break;
            case 3:
                min = value;

                break;
            case 4:
                min10 = value;

                break;
            case 5:
                hour = value;

                break;
            case 6:
                hour10 = value;

                break;
            default:
                break;
        }

    }

    public int [] reqTimerData() {

        int rtsec = 0, rtmin = 0, rthour = 0;
        rtsec = sec + sec10*10;
        rtmin = min + min10*10;
        rthour = hour + hour10*10;
        int [] rttime = {rtsec, rtmin, rthour};
        return rttime;
    }

    public void initTimerData() {

        sec = 0;
        sec10 = 0;
        min = 0;
        min10 = 0;
        hour = 0;
        hour10 = 0;

        view.sec.setText("0");
        view.sec10.setText("0");
        view.min.setText("0");
        view.min10.setText("0");
        view.hour.setText("0");
        view.hour10.setText("0");
    }

}