import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class TimerUI {

	public TimerUI(Timer timer, View view) {
		this.timer = timer;
		this.view = view;

		view.btnFunct.addActionListener(flistener);
		view.btnMode.addActionListener(mlistener);
		view.btnReset.addActionListener(rlistener);
		view.btnStart.addMouseListener(s2slistener);

	}

	private Timer timer;
	private View view;

	MouseListener s2slistener = new MouseListener() {
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
				if(view.checkfunc(2) == 0) {
					return;
				}
				if(timer.part == 0)
					return;
				try {
					timer.reqStartTimer();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					if(view.checkfunc(2) == 0) {
						return;
					}
					if(timer.buzzer.on == true && timer.buzzer.funcType == 1) {
						timer.buzzer.reqStop(timer.funcNum);
						return;
					}
					if(view.checkfunc(2) == 0) {
						return;
					}
					if(timer.part == 0)
						return;
					timer.setTimerPart(0);
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		}
	};

	ActionListener flistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {

				if(view.checkfunc(2) == 0) {
					return;
				}
				if(timer.part == 0)
					return;
				if(timer.buzzer.on == true && timer.buzzer.funcType == 1) {
					timer.buzzer.reqStop(timer.funcNum);
					return;
				}
				timer.part++;
				timer.saveValue = 0;
				if(timer.part == 7)
					timer.part = 1;
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener mlistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(2) == 0) {
					return;
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener rlistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {

				if(view.checkfunc(2) == 0) {
					return;
				}
				if(timer.buzzer.on == true && timer.buzzer.funcType == 1) {
					timer.buzzer.reqStop(timer.funcNum);
					return;
				}
				if(timer.part == 0)
					return;
				timer.setTimerPart(1);
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};

}
