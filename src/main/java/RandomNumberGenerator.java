import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.Random;

public class RandomNumberGenerator {

	public RandomNumberGenerator(View view) {
		this.view = view;
	}


	View view;
	public int funcNum = 5;
	public int saveValue = 0;
	public int part = 1;
	public int scope = 0;

	public void reqSetScope() {
		// TODO implement here
		view.sec.setText("0");
		view.sec10.setText("0");
		view.min.setText("0");
		view.min10.setText("0");
		view.hour.setText("0");
		view.hour10.setText("0");
	}

	public void setScopePart(int button) {

		if(button == 0) {
			switch(part) {

				case 1://sec
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;

					break;
				case 2://sec10
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;

					break;
				case 3://min
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;

					break;
				case 4://min10
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;

					break;
				case 5://hour
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;

					break;
				case 6://hour10
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;

					break;
				default:
					break;
			}
		}
		if(button == 1) {
			switch(part) {

				case 1://sec
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 2://sec10
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 3://min
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 4://min10
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 5://hour
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 6://hour10
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				default:
					break;
			}
		}
	}

	public void saveScope() {
		// TODO implement here
		//ve to implement for gui
		switch(part) {
			case 1:
				scope = scope + saveValue;
				part++;
				saveValue = 0;
				break;
			case 2:
				scope = scope + saveValue*10;
				part++;
				saveValue = 0;
				break;
			case 3:
				scope = scope + saveValue*100;
				part++;
				saveValue = 0;
				break;
			case 4:
				scope = scope + saveValue*1000;
				part++;
				saveValue = 0;
				break;
			case 5:
				scope = scope + saveValue*10000;
				part++;
				saveValue = 0;
				break;
			case 6:
				scope = scope + saveValue*100000;
				part++;
				saveValue = 0;
				break;
			default:
				break;
		}

	}

	public int reqRandomNumber(int scope) {
		// TODO implement here
		Random RND = new Random();
		int result = RND.nextInt(scope);

		return result;
	}

	public void reqBackToSetScope() {
		part = 1;
	}

}


