import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

import javax.management.modelmbean.RequiredModelMBean;

public class AlarmUI {

	public AlarmUI(Alarm alarm, View view) {
		this.alarm = alarm;
		this.view = view;

		view.btnFunct.addMouseListener(f2slistener);
		view.btnStart.addActionListener(slistener);
		view.btnMode.addActionListener(mlistener);
		view.btnReset.addMouseListener(r2slistener);

	}

	private Alarm alarm;
	private View view;

	private void showSet() {
		view.sec.setText(String.valueOf(alarm.sec));
		view.sec10.setText(String.valueOf(alarm.sec10));
		view.min.setText(String.valueOf(alarm.min));
		view.min10.setText(String.valueOf(alarm.min10));
		view.hour.setText(String.valueOf(alarm.hour));
		view.hour10.setText(String.valueOf(alarm.hour10));
		if(alarm.ison == 1) {
			view.setDot(30);
		}
		else {
			view.removeDot(30);
		}
		if(alarm.sun == 1) {
			view.setDot(0);
		}
		else {
			view.removeDot(0);
		}
		if(alarm.mon == 1) {
			view.setDot(1);
		}
		else {
			view.removeDot(1);
		}
		if(alarm.tue == 1) {
			view.setDot(2);
		}
		else {
			view.removeDot(2);
		}
		if(alarm.wed == 1) {
			view.setDot(3);
		}
		else {
			view.removeDot(3);
		}
		if(alarm.fri == 1) {
			view.setDot(5);
		}
		else {
			view.removeDot(5);
		}
		if(alarm.thu == 1) {
			view.setDot(4);
		}
		else {
			view.removeDot(4);
		}
		if(alarm.sat == 1) {
			view.setDot(6);
		}
		else {
			view.removeDot(6);
		}


	}

	MouseListener f2slistener = new MouseListener() {
		Date pressedTime;
		long timeClicked;
		public void mousePressed(MouseEvent e) {
			pressedTime = new Date();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			timeClicked = new Date().getTime() - pressedTime.getTime();
			if(timeClicked >= 2000) {
				if(view.checkfunc(4) == 0) {
					return;
				}
				if(alarm.part != -1) {//�˶��� ������ �϶�
					alarm.reqSaveAlarm();
					view.ampm.setText("");
					alarm.displayAlarmList();
					view.setalarmIcon();
				}
				else {
					if(alarm.alist.alarm.size() == 10) {
						alarm.alist.alarm.remove(alarm.alarmIndex);
					}
					alarm.reqSetAlarm();
					view.initDot();
					showSet();
				}
			}
			else {
				if(view.checkfunc(4) == 0) {
					return;
				}
				if(alarm.buzzer.on == true) {
					alarm.reqSetSnooze();
					System.out.println("setSnooze over");
					return;
				}
				alarm.part++;
			}
		}
	};
	ActionListener slistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(4) == 0) {
					//System.out.println("where1");
					return;
				}
				if(alarm.buzzer.on == true) {
					//System.out.println("where2");
					alarm.buzzer.reqStop(2);
					return;
				}
				if(alarm.part == -1) {
					//System.out.println("where3");
					alarm.displayAlarmList();
					return;
				}
				if(alarm.part != -1){
					//System.out.println("set start");
					alarm.setAlarmPart(0);
					//System.out.println(alarm.part);
					showSet();
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener mlistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(4) == 0) {
					return;
				}
				alarm.part = -1;
				alarm.alarmIndex = 0;
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	MouseListener r2slistener = new MouseListener() {
		Date pressedTime;
		long timeClicked;
		public void mousePressed(MouseEvent e) {
			pressedTime = new Date();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			timeClicked = new Date().getTime() - pressedTime.getTime();
			if(timeClicked >= 2000) {
				if(view.checkfunc(4) == 0) {
					return;
				}
				if(alarm.buzzer.on == true)
					alarm.buzzer.reqStop(2);
				else {
					alarm.reqDeleteAlarm();
					if(alarm.alist.alarm.size() == 0) {
						view.ampm.setText("");
						view.removealarmIcon();
					}
				}

			}
			else {
				if(view.checkfunc(4) == 0) {
					return;
				}
				if(alarm.buzzer.on == true) {
					alarm.buzzer.reqStop(2);
					return;
				}
				if(alarm.part == -1) {
					return;
				}
				else {
					//System.out.println("set reset");
					alarm.setAlarmPart(1);
					//System.out.println(alarm.part);
					showSet();
				}
			}
		}
	};

}
