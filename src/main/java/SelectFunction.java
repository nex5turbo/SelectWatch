import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SelectFunction{

	public SelectFunction(View view, FunctionList list) {
		functionlist = list;
		this.view = view;

	}


	public View view;
	public int funcNum = 7;
	public FunctionList functionlist;
	public int currFunct = 1;
	public int selectedFunction;
	public int[] showArray = {0,0,0,0,0};
	public int [] toSet = {1,0,0,0};
	public int array = 1;
	public int part = 2;
	public int setting = 0;

	public void reqNextFunction() {
		// TODO implement here;
		currFunct = functionlist.getNextFunction(currFunct);
		view.currfunc = currFunct;
		switch(currFunct) {
			case 1:
				System.out.println(view.currfunc);
				functionlist.timekeeping.displayTime();
				view.funcTest.setText("TimeKeeping");
				view.initLabel();
				view.initDot();
				break;
			case 2:
				System.out.println(view.currfunc);
				functionlist.timer.reqResetTimer();
				view.funcTest.setText("Timer");
				view.monthlb.setText("");
				view.daylb.setText("");
				view.datelb.setText("");
				view.ampm.setText("");
				view.initLabel();
				view.initDot();
				break;
			case 3:
				System.out.println(view.currfunc);
				view.funcTest.setText("StopWatch");
				view.monthlb.setText("");
				view.daylb.setText("");
				view.datelb.setText("");
				view.ampm.setText("");
				view.initLabel();
				view.initDot();
				break;
			case 4:
				System.out.println(view.currfunc);
				view.funcTest.setText("Alarm");
				view.monthlb.setText("");
				view.daylb.setText("");
				view.datelb.setText("");
				view.ampm.setText("");
				view.initLabel();
				view.initDot();
				functionlist.alarm.displayAlarmList();
				break;
			case 5:
				System.out.println(view.currfunc);
				functionlist.rng.reqSetScope();
				view.funcTest.setText("R. N. G");
				view.monthlb.setText("");
				view.daylb.setText("");
				view.datelb.setText("");
				view.ampm.setText("");
				view.initLabel();
				view.initDot();
				break;
			case 6:
				System.out.println(view.currfunc);
				view.sec.setText("");
				view.sec10.setText("");
				view.min.setText("");
				view.min10.setText("");
				view.hour.setText("");
				view.hour10.setText("");
				view.monthlb.setText("");
				view.daylb.setText("");
				view.datelb.setText("");
				view.ampm.setText("");
				view.funcTest.setText("R. D. G");
				view.initDot();
				break;
			default:
				break;
		}

	}

	public void reqSelectFunction() {
		view.sec.setText("");
		view.sec10.setText("");
		view.min.setText("");
		view.min10.setText("");
		view.hour.setText("");
		view.hour10.setText("");
		view.monthlb.setText("");
		view.daylb.setText("");
		view.datelb.setText("TMR");
		view.ampm.setText("");
		view.initDot();
		setting = 1;
	}

	public void setFunction(int button) {
		switch(button) {
			case 0:
				toSet[array] = part;
				showArray[part-2] = 1;
				break;
			case 1:
				toSet[array] = 0;
				showArray[part-2] = 0;
				break;
			default:
				break;
		}
	}

	public void saveFunction() {
		functionlist.update(1, toSet[1]);
		functionlist.update(2, toSet[2]);
		functionlist.update(3, toSet[3]);
	}
}