import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RandomDirectionGeneratorUI {
	public RandomDirectionGeneratorUI(RandomDirectionGenerator rdg, View view) {
		this.view = view;
		this.rdg = rdg;
		view.btnFunct.addActionListener(flistener);
		view.btnStart.addActionListener(slistener);
		view.btnMode.addActionListener(mlistener);
		view.btnReset.addActionListener(rlistener);
	}

	private View view;
	private RandomDirectionGenerator rdg;

	ActionListener flistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(6) == 0) {
					return;
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener slistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(6) == 0) {
					return;
				}

				if(rdg.result != 0) {
					view.removeDot(rdg.result-1);
					rdg.result = 0;
				}
				rdg.reqRandomDirection();
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener mlistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(6) == 0) {
					return;
				}
				for(int i = 0; i < 60; i++) {
					rdg.eLCD[i] = 0;
				}
				view.initDot();
				rdg.result = 0;
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};
	ActionListener rlistener = new ActionListener() {
		public void actionPerformed(ActionEvent startlistener) {
			try {
				if(view.checkfunc(6) == 0) {
					return;
				}
			} catch (RuntimeException e) {
				e.printStackTrace();
			}
		}
	};

}
