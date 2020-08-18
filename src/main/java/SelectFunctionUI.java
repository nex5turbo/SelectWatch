import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;

public class SelectFunctionUI {

	public SelectFunctionUI(SelectFunction selectfunction, View view) {
		this.selectfunction = selectfunction;
		this.view = view;

		view.btnFunct.addActionListener(flistener);
		view.btnStart.addActionListener(slistener);
		view.btnReset.addActionListener(rlistener);
		view.btnMode.addMouseListener(m2slistener);
	}

	private SelectFunction selectfunction;
	private View view;


	public void showSet() {
		switch(selectfunction.part) {
			case 2:
				view.datelb.setText("TMR");
				break;
			case 3:
				view.datelb.setText("SWC");
				break;
			case 4:
				view.datelb.setText("ALM");
				break;
			case 5:
				view.datelb.setText("RNG");
				break;
			case 6:
				view.datelb.setText("RDG");
				break;
			default:
				break;
		}
		if(selectfunction.showArray[selectfunction.part-2] != 0) {
			view.setDot(30);
		}
		else {
			view.removeDot(30);
		}
	}

	ActionListener flistener = new ActionListener() {
		public void actionPerformed(ActionEvent listener) {
			int k = 0;
			try {
				if(view.checkfunc(7) == 0)
					return;


				if(selectfunction.toSet[selectfunction.array]!=0) {
					selectfunction.array++;
					if(selectfunction.array > 3) {
						selectfunction.saveFunction();
						selectfunction.setting = 0;
						selectfunction.array = 1;
						for(int i = 0; i < 4; i++) {
							if(selectfunction.toSet[i] == 4) {
								if(selectfunction.functionlist.alarm.alist.alarm.size() >= 1)
									view.setalarmIcon();
								k = 1;//k�� 1�̸� �˶� on 0�̸� off
							}
							selectfunction.toSet[i] = 0;
						}
						if(k == 0)
							view.removealarmIcon();
						for(int i = 0; i < 5; i++) {
							selectfunction.showArray[i] = 0;
						}
						selectfunction.part = 2;
						view.currfunc = 1;
						selectfunction.functionlist.timekeeping.displayTime();
						return;
					}
					selectfunction.part++;
					if(selectfunction.part > 6)
						selectfunction.part = 2;
					System.out.println(selectfunction.array);
					showSet();
				}
				else {
					selectfunction.part++;
					if(selectfunction.part > 6)
						selectfunction.part = 2;
					System.out.println(selectfunction.array);
					showSet();
				}

			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener slistener = new ActionListener() {
		public void actionPerformed(ActionEvent listener) {
			try {
				if(view.checkfunc(7) == 0) {
					return;
				}
				selectfunction.setFunction(0);
				showSet();

			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};

	MouseListener m2slistener = new MouseListener() {
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
				if(selectfunction.functionlist.timekeeping.time.onoff == 0)
					return;
				if(selectfunction.setting == 1)
					return;
				view.currfunc = 7;
				selectfunction.reqSelectFunction();
			}
			else {
				if(selectfunction.functionlist.timekeeping.time.onoff == 0)
					return;
				if(selectfunction.setting == 1)
					return;
				selectfunction.reqNextFunction();
			}
		}
	};

	ActionListener rlistener = new ActionListener() {
		public void actionPerformed(ActionEvent listener) {
			try {
				if(view.checkfunc(7) == 0) {
					return;
				}
				selectfunction.setFunction(1);
				showSet();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};

}
