import java.util.*;

public class LapSplitList {

	public LapSplitList() {

	}

	public int nodeNum = 0;
	private int checkLS = 0;
	public Vector lns = new Vector(180);


	public void storeLapSplit(Vector lns) {
		// TODO implement here
		if(this.lns.size() == 180)
			return;

		this.lns.add(lns.elementAt(0));
		this.lns.add(lns.elementAt(1));
		this.lns.add(lns.elementAt(2));
		System.out.println(this.lns.size());

		if(this.lns.size() == 3) {

			this.lns.add(lns.elementAt(0));
			this.lns.add(lns.elementAt(1));
			this.lns.add(lns.elementAt(2));

		}
		else {
			int prevLap = 0;
			int currLap = 0;
			int result = 0;
			String resultS = "", min = "", sec = "", milsec = "";
			currLap = (int)lns.elementAt(0)*10000+(int)lns.elementAt(1)*100+(int)lns.elementAt(2);
			prevLap = (int)this.lns.elementAt(this.lns.size()-9)*10000 + (int)this.lns.elementAt(this.lns.size()-8)*100+(int)this.lns.elementAt(this.lns.size()-7);
			result = currLap - prevLap;
			resultS = String.valueOf(result);
			switch(resultS.length()) {
				case 1:
					this.lns.add((int)0);//min
					this.lns.add((int)0);//sec
					this.lns.add(Integer.parseInt(resultS));//milsec
					break;
				case 2:
					this.lns.add((int)0);//min
					this.lns.add((int)0);//sec
					this.lns.add(Integer.parseInt(resultS));//milsec
					break;
				case 3:
					sec = resultS.substring(0, 1);
					milsec = resultS.substring(1);
					this.lns.add(0);//min
					this.lns.add(Integer.parseInt(sec));//sec
					this.lns.add(Integer.parseInt(milsec));//milsec
					break;
				case 4:
					sec = resultS.substring(0, 2);
					milsec = resultS.substring(2);
					this.lns.add(0);//min
					this.lns.add(Integer.parseInt(sec));//sec
					this.lns.add(Integer.parseInt(milsec));//milsec
					break;
				case 5:
					min = resultS.substring(0,1);
					sec = resultS.substring(1, 3);
					milsec = resultS.substring(3);
					this.lns.add(Integer.parseInt(min));//min
					this.lns.add(Integer.parseInt(sec));//sec
					this.lns.add(Integer.parseInt(milsec));//milsec
					break;
				case 6:
					min = resultS.substring(0,2);
					sec = resultS.substring(3, 4);
					milsec = resultS.substring(4);
					this.lns.add(Integer.parseInt(min));//min
					this.lns.add(Integer.parseInt(sec));//sec
					this.lns.add(Integer.parseInt(milsec));//milsec
					break;
				default:
					break;
			}


		}
	}

	public Vector getList() {
		// TODO implement here
		Vector rtVector = new Vector(5);
		int rtnum = 0;
		rtVector.add(this.lns.elementAt(nodeNum));
		rtVector.add(this.lns.elementAt(nodeNum+1));
		rtVector.add(this.lns.elementAt(nodeNum+2));
		nodeNum = nodeNum + 3;

		rtnum = nodeNum/3;//
		System.out.println(rtnum);
		if(rtnum%2 == 1) {
			rtnum  = rtnum - checkLS;
			rtVector.add(rtnum);
			rtVector.add(0);
			checkLS++;
			if(this.lns.size() == nodeNum) {
				nodeNum = 0;
				checkLS = 0;
			}
			return rtVector;
		}
		else {
			rtnum = rtnum - checkLS;
			rtVector.add(rtnum);
			rtVector.add(1);
			if(this.lns.size() == nodeNum) {
				nodeNum = 0;
				checkLS = 0;
			}
			return rtVector;
		}


	}

}