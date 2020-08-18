import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class RandomNumberGeneratorUI {

	public RandomNumberGeneratorUI(View view, RandomNumberGenerator rng) {
		this.view = view;
		this.rng = rng;
		view.btnStart.addMouseListener(s2slistener);
		view.btnMode.addActionListener(mlistener);
		view.btnReset.addActionListener(rlistener);
		view.btnFunct.addActionListener(flistener);
	}

	private void showSet() {
		switch(rng.part) {

			case 1://sec
				view.sec.setText(String.valueOf(rng.saveValue));
				break;
			case 2://sec10
				view.sec10.setText(String.valueOf(rng.saveValue));
				break;
			case 3://min
				view.min.setText(String.valueOf(rng.saveValue));
				break;
			case 4://min10
				view.min10.setText(String.valueOf(rng.saveValue));
				break;
			case 5://hour
				view.hour.setText(String.valueOf(rng.saveValue));
				break;
			case 6://hour10
				view.hour10.setText(String.valueOf(rng.saveValue));
				break;
			default:
				break;
		}
	}

	private View view;
	private RandomNumberGenerator rng;
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
				try {
					if(view.checkfunc(5) == 0) {
						return;
					}
					if(rng.scope == 0)
						return;
					rng.saveScope();

					int result = rng.reqRandomNumber(rng.scope);

					String resultNum = String.valueOf(result);
					int length = resultNum.length();
					String [] digit = {"0","0","0","0","0","0"};
					for(int i = 0; i < length; i++) {
						if(i == length-1)
							digit[length-i-1] = resultNum.substring(i);
						digit[length-i-1] = resultNum.substring(i, i+1);
					}

					view.sec.setText(digit[0]);
					view.sec10.setText(digit[1]);
					view.min.setText(digit[2]);
					view.min10.setText(digit[3]);
					view.hour.setText(digit[4]);
					view.hour10.setText(digit[5]);
					rng.part = 0;
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
			else {
				try {
					if(view.checkfunc(5) == 0) {
						return;
					}
					rng.setScopePart(0);
					showSet();
				} catch (RuntimeException e) {
					e.printStackTrace();
				}
			}
		}
	};

	ActionListener flistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(5) == 0) {
					return;
				}

				rng.saveScope();

			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};

	ActionListener mlistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(5) == 0) {
					return;
				}
				rng.scope = 0;
				rng.saveValue = 0;
				rng.part = 1;
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener rlistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(5) == 0) {
					return;
				}
				if(rng.part == 0) {
					rng.reqBackToSetScope();
					view.sec.setText("0");
					view.sec10.setText("0");
					view.min.setText("0");
					view.min10.setText("0");
					view.hour.setText("0");
					view.hour10.setText("0");
					return;
				}
				rng.setScopePart(1);
				showSet();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};

}
