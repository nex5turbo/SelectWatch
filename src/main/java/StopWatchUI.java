import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class StopWatchUI {

	public StopWatchUI(View view, Stopwatch sw) {
		this.view = view;
		this.sw = sw;
		view.btnStart.addActionListener(slistener);
		view.btnMode.addActionListener(mlistener);
		view.btnReset.addActionListener(rlistener);
		view.btnFunct.addMouseListener(f2slistener);
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
					if(view.checkfunc(3) == 0) {
						return;
					}
					if(sw.paused == 2) {
						sw.paused = 3;
						sw.reqNextLapSplit();
						return;
					}

				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					if(view.checkfunc(3) == 0) {
						return;
					}
					if(sw.paused == 1 || sw.paused == 2) {
						return;
					}
					if(sw.paused == 3) {
						sw.reqBackToStopwatch();
						view.ampm.setText("");
						view.daylb.setText("");
						String [] digit = {"0","0","0","0","0","0"};
						String dmins = String.valueOf(sw.min);
						String dsecs = String.valueOf(sw.sec);
						String dmilsecs = String.valueOf(sw.milsec);

						digit[0] = dmins.substring(0, 1);
						if(dmins.length() == 1) {
							digit[0] = "0";
							digit[1] = dmins;
						}
						if(dmins.length() == 2)
							digit[1] = dmins.substring(1);

						digit[2] = dsecs.substring(0, 1);
						if(dsecs.length() == 1) {
							digit[2] = "0";
							digit[3] = dsecs;
						}
						if(dsecs.length() == 2)
							digit[3] = dsecs.substring(1);

						digit[4] = dmilsecs.substring(0, 1);
						if(dmilsecs.length() == 1) {
							digit[4] = "0";
							digit[5] = dmilsecs;
						}
						if(dmilsecs.length() == 2)
							digit[5] = dmilsecs.substring(1);


						view.sec.setText(digit[5]);
						view.sec10.setText(digit[4]);
						view.min.setText(digit[3]);
						view.min10.setText(digit[2]);
						view.hour.setText(digit[1]);
						view.hour10.setText(digit[0]);
						return;
					}
					sw.reqStoreLapSplit();

				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		}
	};

	ActionListener slistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(3) == 0) {
					return;
				}
				if(sw.paused == 1) {
					sw.start();
				}
				else if(sw.paused == 2) {
					sw.reqResume();
				}
				else if(sw.paused == 3) {
					sw.reqNextLapSplit();

				}
				else {
					sw.reqPause();
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener mlistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(3) == 0) {
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
				if(view.checkfunc(3) == 0) {
					return;
				}
				if(sw.paused == 3)
					return;
				sw.resetStopwatch();
				view.sec.setText("0");
				view.sec10.setText("0");
				view.min.setText("0");
				view.min10.setText("0");
				view.hour.setText("0");
				view.hour10.setText("0");
				view.ampm.setText("");
				view.daylb.setText("");
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};

	private View view;
	private Stopwatch sw;




}
