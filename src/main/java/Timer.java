import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.*;

public class Timer {

	public Timer(View view, Buzzer buzzer) {
		this.view = view;
		this.buzzer = buzzer;
		timer = new TimerData(view);
	}




	public Buzzer buzzer;
	public View view;
	public int funcNum = 2;
	public TimerData timer;
	public Thread timerThread;
	public int part = 1;
	public int saveValue = 0;



	public void reqSetTimer() {
		// TODO implement here
		view.sec.setText("g");
		view.sec10.setText("n");
		view.min.setText("i");
		view.min10.setText("t");
		view.hour.setText("e");
		view.hour10.setText("s");
	}

	public void setTimerPart(int button) {
		if(button == 0) {
			switch(part) {
				case 1://sec
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;
					view.sec.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 2://sec10
					saveValue++;
					if(saveValue == 6)
						saveValue = 5;
					view.sec10.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 3://min
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;
					view.min.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 4://min10
					saveValue++;
					if(saveValue == 6)
						saveValue = 5;
					view.min10.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 5://hour
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;
					view.hour.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 6://hour10
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;
					view.hour10.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				default:
					break;
			}
		}
		if(button == 1) {
			switch(part) {
				case 1:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;
					view.sec.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 2:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;
					view.sec10.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 3:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;
					view.min.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 4:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;
					view.min10.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 5:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;
					view.hour.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				case 6:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;
					view.hour10.setText(String.valueOf(saveValue));
					timer.saveTimerPart(part, saveValue);
					break;
				default:
					break;
			}
		}
	}

	public void reqStartTimer() {
		// TODO implement here
		start();
		part = 0;
		saveValue = 0;
	}

	public void reqResetTimer() {
		// TODO implement here
		view.sec.setText("0");
		view.sec10.setText("0");
		view.min.setText("0");
		view.min10.setText("0");
		view.hour.setText("0");
		view.hour10.setText("0");
	}

	public void start() {
		// TODO implement here
		timerThread = new Thread(new Runnable() {
			public void run() {
				int [] getTime = timer.reqTimerData();
				int sec = 0;
				int min = 0;
				int hour = 0;
				sec = getTime[0];
				min = getTime[1];
				hour = getTime[2];
				while(true) {
					if(hour == 0 && min == 0 && sec == 0)
						break;
					try {
						displayTimer(sec, min, hour);
						Thread.sleep(1000);
						sec--;
						if(sec == 59 && min > 0) {
							min--;
						}
						if(min == 59 && hour > 0) {
							hour--;
						}
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				view.sec.setText("0");
				buzzer.beep(1);
				part = 1;
			}
		});
		timerThread.start();
	}

	public void reqStopTimerBuzzer() {
		// TODO implement here
		buzzer.reqStop(1);
	}

	public void displayTimer(int sec, int min, int hour) {
		// TODO implement here
		if(view.currfunc != funcNum)
			return;
		String [] digit = {"0","0","0","0","0","0"};
		String ssec = "";
		String smin = "";
		String shour = "";

		ssec = String.valueOf(sec);
		smin = String.valueOf(min);
		shour = String.valueOf(hour);

		digit[1] = shour.substring(0, 1);
		if(shour.length() == 2) {
			digit[0] = shour.substring(0,1);
			digit[1] = shour.substring(1);
		}
		digit[3] = smin.substring(0, 1);
		if(smin.length() == 2) {
			digit[2] = smin.substring(0,1);
			digit[3] = smin.substring(1);
		}
		digit[5] = ssec.substring(0, 1);
		if(ssec.length() == 2) {
			digit[4] = ssec.substring(0,1);
			digit[5] = ssec.substring(1);
		}

		view.sec.setText(digit[5]);
		view.sec10.setText(digit[4]);
		view.min.setText(digit[3]);
		view.min10.setText(digit[2]);
		view.hour.setText(digit[1]);
		view.hour10.setText(digit[0]);
	}

}