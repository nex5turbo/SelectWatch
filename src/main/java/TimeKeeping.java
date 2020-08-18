import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Date;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;

public class TimeKeeping {


	public TimeKeeping(View view, Buzzer buzzer){
		time = new TimeData(buzzer);
		this.view = view;
		displayTime();
	}



	public int funcNum = 1;
	public View view;
	public TimeData time;
	public int[] eLCD = new int[60];
	public Thread display;
	public int part = -1;
	public int saveValue = 0;

	public void reqSetTime() throws InterruptedException {
		// TODO implement here
		for(int i = 0; i < 6; i++) {
			time.saveTimePart(i, 0);
		}
		for(int i = 6; i < 10; i++) {
			time.saveTimePart(i, 1);
		}
		time.onoff = 0;
	}

	public void setTimePart(int button) {//0->start(+) 1->reset(-)
		if(part == -1)
			return;


		if(button == 0) {
			switch(part) {
				case 0://am pm
					saveValue++;
					if(saveValue == 3)
						saveValue = 0;

					break;
				case 1://sec
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;

					break;
				case 2://sec10
					saveValue++;
					if(saveValue == 6)
						saveValue = 5;

					break;
				case 3://min
					saveValue++;
					if(saveValue == 10)
						saveValue = 9;

					break;
				case 4://min10
					saveValue++;
					if(saveValue == 6)
						saveValue = 5;

					break;
				case 5://hour
					saveValue++;

					if(saveValue == 10)
						saveValue = 9;

					break;
				case 6://hour10
					saveValue++;
					switch(time.format) {
						case 0:
							if(saveValue > 0) {
								if(time.hour > 2)
									saveValue = 0;
							}
							if(saveValue > 1)
								saveValue = 0;
							break;
						case 1:
							if(saveValue > 0) {
								if(time.hour > 2)
									saveValue = 0;
							}
							if(saveValue > 1)
								saveValue = 0;
							break;

						case 2:
							if(saveValue > 1) {
								if(time.hour > 3)
									saveValue = 0;
							}
							if(saveValue > 2)
								saveValue = 0;
							break;
						default:
							break;
					}


					break;
				case 7://date
					saveValue++;
					if(saveValue == 7)
						saveValue = 0;

					break;
				case 8://month
					saveValue++;
					if(saveValue == 13)
						saveValue = 12;

					break;
				case 9://day
					saveValue++;
					if(saveValue == 29 && time.month == 2)
						saveValue = 28;
					if(saveValue == 31)
						if(time.month == 4 || time.month == 6 || time.month == 9 || time.month == 11)
							saveValue = 30;
					if(saveValue == 32)
						saveValue = 31;

					break;
				default:
					break;


			}
		}
		if(button == 1) {
			switch(part) {
				case 0:
					saveValue--;
					if(saveValue == -1)
						saveValue = 2;
					break;
				case 1:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 2:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 3:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 4:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 5:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 6:
					saveValue--;
					if(saveValue == -1)
						saveValue = 0;

					break;
				case 7://date
					saveValue--;
					if(saveValue == -1)
						saveValue = 6;

					break;
				case 8://month
					saveValue--;
					if(saveValue == 0)
						saveValue = 1;

					break;
				case 9://day
					saveValue--;
					if(saveValue == 0)
						saveValue = 1;

					break;

				default:
					break;
			}
		}
	}

	public void reqStoreTime() {
		// TODO implement here
		time.saveTimePart(part, saveValue);
	}

	public void southFinder(String min, String min10, String hour, String hour10) {
		int southMin = Integer.parseInt(min) + Integer.parseInt(min10)*10;
		int southHour = Integer.parseInt(hour) + Integer.parseInt(hour10)*10;

		int casesm = 0;
		for(int i = 0; i < 60; i++) {
			if(southMin > 0 && southMin < 12) {
				casesm = 0;
			}
			if(southMin > 12 && southMin < 24) {
				casesm = 12;
			}
			if(southMin > 24 && southMin < 36) {
				casesm = 24;
			}
			if(southMin > 36 && southMin < 48) {
				casesm = 36;
			}
			if(southMin > 48 && southMin < 60) {
				casesm = 48;
			}
			eLCD[i] = 0;
		}

		switch(time.format) {
			case 0:
				if(southHour == 12) {
					switch(casesm) {
						case 0:
							eLCD[0] = 1;
							break;
						case 12:
							eLCD[0] = 1;
							eLCD[1] = 1;
							break;
						case 24:
							eLCD[2] = 1;
							eLCD[1] = 1;
							break;
						case 36:
							eLCD[3] = 1;
							eLCD[1] = 1;
							eLCD[2] = 1;
							break;
						case 48:
							eLCD[4] = 1;
							eLCD[2] = 1;
							break;
						default:
							break;
					}

				}
				else {
					switch(casesm) {
						case 0:
							eLCD[southHour*5] = 1;
							if((southHour*5)%2 == 0) {
								eLCD[(southHour*5)/2+30] = 1;
							}
							else {
								eLCD[(southHour*5)/2+30] = 1;
								eLCD[(southHour*5)/2+1+30] = 1;
							}
							break;
						case 12:
							eLCD[southHour*5+1] = 1;
							if((southHour*5+1)%2 == 0) {
								eLCD[(southHour*5+1)/2+30] = 1;
							}
							else {
								eLCD[(southHour*5+1)/2+30] = 1;
								eLCD[(southHour*5+1)/2+1+30] = 1;
							}
							break;
						case 24:
							eLCD[southHour*5+2] = 1;
							if((southHour*5+2)%2 == 0) {
								eLCD[(southHour*5+2)/2+30] = 1;
							}
							else {
								eLCD[(southHour*5+2)/2+30] = 1;
								eLCD[(southHour*5+2)/2+1+30] = 1;
							}
							break;
						case 36:
							eLCD[southHour*5+3] = 1;
							if((southHour*5+3)%2 == 0) {
								eLCD[(southHour*5+3)/2+30] = 1;
							}
							else {
								eLCD[(southHour*5+3)/2+30] = 1;
								eLCD[(southHour*5+3)/2+1+30] = 1;
							}
							break;
						case 48:
							eLCD[southHour*5+4] = 1;
							if((southHour*5+4)%2 == 0) {
								eLCD[(southHour*5+4)/2+30] = 1;
							}
							else {

								eLCD[(southHour*5+4)/2+30] = 1;
								if((southHour*5+4)/2+1+30 == 60)
									eLCD[0] = 1;
								else
									eLCD[(southHour*5+4)/2+1+30] = 1;
							}

							break;
						default:
							break;
					}
				}
				break;
			case 1:
				if(southHour == 12) {
					switch(casesm) {
						case 0:
							eLCD[0] = 1;
							eLCD[30] = 1;
							break;
						case 12:
							eLCD[0] = 1;
							eLCD[1] = 1;
							eLCD[1] = 1;
							break;
						case 24:
							eLCD[2] = 1;
							eLCD[1] = 1;
							break;
						case 36:
							eLCD[3] = 1;
							eLCD[1] = 1;
							eLCD[2] = 1;
							break;
						case 48:
							eLCD[4] = 1;
							eLCD[2] = 1;
							break;
						default:
							break;
					}

				}
				else {
					switch(casesm) {
						case 0:
							eLCD[southHour*5] = 1;
							if((southHour*5)%2 == 0) {
								eLCD[(southHour*5)/2] = 1;
							}
							else {
								eLCD[(southHour*5)/2] = 1;
								eLCD[(southHour*5)/2+1] = 1;
							}
							break;
						case 12:
							eLCD[southHour*5+1] = 1;
							if((southHour*5+1)%2 == 0) {
								eLCD[(southHour*5+1)/2] = 1;
							}
							else {
								eLCD[(southHour*5+1)/2] = 1;
								eLCD[(southHour*5+1)/2+1] = 1;
							}
							break;
						case 24:
							eLCD[southHour*5+2] = 1;
							if((southHour*5+2)%2 == 0) {
								eLCD[(southHour*5+2)/2] = 1;
							}
							else {
								eLCD[(southHour*5+2)/2] = 1;
								eLCD[(southHour*5+2)/2+1] = 1;
							}
							break;
						case 36:
							eLCD[southHour*5+3] = 1;
							if((southHour*5+3)%2 == 0) {
								eLCD[(southHour*5+3)/2] = 1;
							}
							else {
								eLCD[(southHour*5+3)/2] = 1;
								eLCD[(southHour*5+3)/2+1] = 1;
							}
							break;
						case 48:
							eLCD[southHour*5+4] = 1;
							if((southHour*5+4)%2 == 0) {
								eLCD[(southHour*5+4)/2] = 1;
							}
							else {
								eLCD[(southHour*5+4)/2] = 1;
								eLCD[(southHour*5+4)/2+1] = 1;
							}
							break;
						default:
							break;
					}
				}
				break;
			case 2:
				if(southHour > 11) {
					switch(casesm) {
						case 0:
							if((southHour-12)*5 == 60)
								eLCD[0] = 1;
							else
								eLCD[(southHour-12)*5] = 1;
							if((southHour*5)%2 == 0) {
								eLCD[((southHour-12)*5)/2] = 1;
							}
							else {
								eLCD[((southHour-12)*5)/2] = 1;
								eLCD[((southHour-12)*5)/2+1] = 1;
							}
							break;
						case 12:
							eLCD[(southHour-12)*5+1] = 1;
							if((southHour*5+1)%2 == 0) {
								eLCD[((southHour-12)*5+1)/2] = 1;
							}
							else {
								eLCD[((southHour-12)*5+1)/2] = 1;
								eLCD[((southHour-12)*5+1)/2+1] = 1;
							}
							break;
						case 24:
							eLCD[(southHour-12)*5+2] = 1;
							if((southHour*5+2)%2 == 0) {
								eLCD[((southHour-12)*5+2)/2] = 1;
							}
							else {
								eLCD[((southHour-12)*5+2)/2] = 1;
								eLCD[((southHour-12)*5+2)/2+1] = 1;
							}

							break;
						case 36:
							eLCD[(southHour-12)*5+3] = 1;
							if((southHour*5+3)%2 == 0) {
								eLCD[((southHour-12)*5+3)/2] = 1;
							}
							else {
								eLCD[((southHour-12)*5+3)/2] = 1;
								eLCD[((southHour-12)*5+3)/2+1] = 1;
							}
							break;
						case 48:
							eLCD[(southHour-12)*5+4] = 1;
							if((southHour*5+4)%2 == 0) {
								eLCD[((southHour-12)*5+4)/2] = 1;
							}
							else {
								eLCD[((southHour-12)*5+4)/2] = 1;
								eLCD[((southHour-12)*5+4)/2+1] = 1;
							}
							break;
						default:
							break;
					}

				}
				else {
					switch(casesm) {
						case 0:
							if(southHour == 12)
								eLCD[0] = 1;
							else
								eLCD[southHour*5] = 1;
							if((southHour*5)%2 == 0) {
								eLCD[(southHour*5)/2+30] = 1;
							}
							else {
								eLCD[(southHour*5)/2+30] = 1;
								eLCD[(southHour*5)/2+1+30] = 1;
							}
							break;
						case 12:
							if(southHour == 12)
								eLCD[1] = 1;
							else
								eLCD[southHour*5+1] = 1;
							if((southHour*5+1)%2 == 0) {
								eLCD[(southHour*5+1)/2+30] = 1;
							}
							else {
								eLCD[(southHour*5+1)/2+30] = 1;
								eLCD[(southHour*5+1)/2+1+30] = 1;
							}
							break;
						case 24:
							if(southHour == 12)
								eLCD[2] = 1;
							else
								eLCD[southHour*5+2] = 1;
							if((southHour*5+2)%2 == 0) {
								eLCD[(southHour*5+2)/2+30] = 1;
							}
							else {
								eLCD[(southHour*5+2)/2+30] = 1;
								eLCD[(southHour*5+2)/2+1+30] = 1;
							}
							break;
						case 36:
							if(southHour == 12)
								eLCD[3] = 1;
							else
								eLCD[southHour*5+3] = 1;
							if((southHour*5+3)%2 == 0) {
								eLCD[(southHour*5+3)/2+30] = 1;
							}
							else {
								eLCD[(southHour*5+3)/2+30] = 1;
								eLCD[(southHour*5+3)/2+1+30] = 1;
							}
							break;
						case 48:
							if(southHour == 12)
								eLCD[4] = 1;
							else
								eLCD[southHour*5+4] = 1;
							if((southHour*5+4)%2 == 0) {
								eLCD[(southHour*5+4)/2+30] = 1;
							}
							else {
								eLCD[(southHour*5+4)/2+30] = 1;
								if((southHour*5+4)/2+1+30 == 60)
									eLCD[0] = 1;
								else
									eLCD[(southHour*5+4)/2+1+30] = 1;
							}
							break;
						default:
							break;
					}
				}
				break;
		}

	}

	public void displayTime() {//f m day date
		display = new Thread(new Runnable() {
			public void run() {
				while(true) {
					if(view.currfunc != funcNum)
						break;
					if(time.onoff == 0) {
						while(time.onoff == 0) {
							try {
								Thread.sleep(300);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
					}
					String sec = "";
					String sec10 = "";
					String min = "";
					String min10 = "";
					String hour = "";
					String hour10 = "";
					String date = "";
					String day = "";
					String month = "";
					String format = "";


					StringTokenizer timetoken = new StringTokenizer(time.displayTime(), "/");
					format = timetoken.nextToken();
					month = timetoken.nextToken();
					day = timetoken.nextToken();
					date = timetoken.nextToken();
					hour10 = timetoken.nextToken();
					hour = timetoken.nextToken();
					min10 = timetoken.nextToken();
					min = timetoken.nextToken();
					sec10 = timetoken.nextToken();
					sec = timetoken.nextToken();

					view.sec.setText(sec);
					view.sec10.setText(sec10);
					view.min.setText(min);
					view.min10.setText(min10);
					view.hour.setText(hour);
					view.hour10.setText(hour10);
					view.monthlb.setText(month+".");
					view.daylb.setText(day+".");
					if(format.equals("0"))
						view.ampm.setText("am");
					if(format.equals("1"))
						view.ampm.setText("pm");
					if(format.equals("2"))
						view.ampm.setText("24");

					southFinder(min, min10, hour, hour10);

					for(int i = 0; i<60; i++) {
						if(eLCD[i] == 1)
							view.setDot(i);
						else
							view.removeDot(i);
					}


					switch(Integer.parseInt(date)) {
						case 0:
							view.datelb.setText("SUN");
							break;
						case 1:
							view.datelb.setText("MON");
							break;
						case 2:
							view.datelb.setText("TUE");
							break;
						case 3:
							view.datelb.setText("WED");
							break;
						case 4:
							view.datelb.setText("THU");
							break;
						case 5:
							view.datelb.setText("FRI");
							break;
						case 6:
							view.datelb.setText("SAT");
							break;
						default:
							break;
					}
				}

			}
		});
		display.start();
	}

}