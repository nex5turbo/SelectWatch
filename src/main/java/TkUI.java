import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class TkUI {
	public TkUI(TimeKeeping tk, View view) {
		this.tk = tk;
		this.view = view;
		view.btnStart.addActionListener(slistener);
		view.btnMode.addActionListener(mlistener);
		view.btnReset.addActionListener(rlistener);
		view.btnFunct.addMouseListener(f2slistener);
	}
	private TimeKeeping tk;
	private View view;

	public void showSet() {
		switch(tk.part) {
			case 0://am pm
				if(tk.saveValue == 0)
					view.ampm.setText("am");
				if(tk.saveValue == 1)
					view.ampm.setText("pm");
				if(tk.saveValue == 2)
					view.ampm.setText("24");
				break;
			case 1://sec
				view.sec.setText(String.valueOf(tk.saveValue));
				break;
			case 2://sec10
				view.sec10.setText(String.valueOf(tk.saveValue));
				break;
			case 3://min
				view.min.setText(String.valueOf(tk.saveValue));
				break;
			case 4://min10
				view.min10.setText(String.valueOf(tk.saveValue));
				break;
			case 5://hour
				view.hour.setText(String.valueOf(tk.saveValue));
				break;
			case 6://hour10
				view.hour10.setText(String.valueOf(tk.saveValue));
				break;
			case 7://date
				switch(tk.saveValue) {
					case 0:
						view.datelb.setText("Sun");
						break;
					case 1:
						view.datelb.setText("Mon");
						break;
					case 2:
						view.datelb.setText("Tue");
						break;
					case 3:
						view.datelb.setText("Wed");
						break;
					case 4:
						view.datelb.setText("Thu");
						break;
					case 5:
						view.datelb.setText("Fri");
						break;
					case 6:
						view.datelb.setText("Sat");
						break;
					default:
						break;
				}
				break;
			case 8://month
				view.monthlb.setText(String.valueOf(tk.saveValue));
				break;
			case 9://day
				view.daylb.setText(String.valueOf(tk.saveValue));
				break;
			default:
				break;

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
				try {
					if(view.checkfunc(1) == 0) {
						return;
					}
					if(tk.time.onoff == 1) {
						tk.reqSetTime();
						view.sec.setText("1");
						view.sec10.setText("1");
						view.min.setText("1");
						view.min10.setText("1");
						view.hour.setText("1");
						view.hour10.setText("1");
						view.ampm.setText("pm");
						view.daylb.setText("1.");
						view.datelb.setText("MON");
						view.monthlb.setText("1.");
						view.initDot();
					}
					else {
						tk.reqStoreTime();
						tk.time.onoff = 1;
						tk.part = -1;
						return;
					}
					tk.saveValue = 0;
					tk.part = 0;

				} catch (RuntimeException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					if(view.checkfunc(1) == 0) {
						return;
					}
					if(tk.time.onoff == 1) {
						return;
					}
					tk.reqStoreTime();
					tk.saveValue = 0;
					tk.part++;

				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		}
	};
	ActionListener slistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(1) == 0) {
					return;
				}

				tk.setTimePart(0);
				showSet();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener mlistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(1) == 0) {
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
				if(view.checkfunc(1) == 0) {
					return;
				}

				tk.setTimePart(1);
				showSet();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};

}
