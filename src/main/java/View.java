import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class View extends JFrame {
	ImageIcon icon;
	ImageIcon watchdot;
	ImageIcon black;
	ImageIcon alarmicon;
	ImageIcon alarmonicon;
	private JPanel contentPane;

	Font customFont;
	{
		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("DSEG14ClassicMini-Regular.ttf")).deriveFont(Font.PLAIN, 50);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	Font customFont_t;
	{
		try {
			customFont_t = Font.createFont(Font.TRUETYPE_FONT, new File("DSEG14ClassicMini-Regular.ttf")).deriveFont(Font.PLAIN, 80);
		} catch (FontFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setalarmIcon() {
		alarmLb.setIcon(alarmonicon);
	}

	public void removealarmIcon() {
		alarmLb.setIcon(alarmicon);
	}

	public int currfunc = 1;
	public String watchdotloca = "watchdot.jpg";
	public String blackloca = "watchdotgray.jpg";
	public String alarmloca = "black.jpg";
	public String alarmonloca = "alarmon.jpg";

	public JLabel alarmLb = new JLabel("");
	public JButton btnMode = new JButton("Mode");
	public JButton btnFunct = new JButton("Funct");
	public JButton btnStart = new JButton("Start");
	public JButton btnReset = new JButton("Reset");
	public JLabel sec = new JLabel("0");
	public JLabel sec10 = new JLabel("0");
	public JLabel min = new JLabel("0");
	public JLabel min10 = new JLabel("0");
	public JLabel hour = new JLabel("0");
	public JLabel hour10 = new JLabel("0");
	public JLabel funcTest = new JLabel("");
	public JLabel datelb = new JLabel("");
	public JLabel monthlb = new JLabel("");
	public JLabel daylb = new JLabel("");
	public JLabel ampm = new JLabel("");
	public JPanel panel;


	public JLabel locaLCD1 = new JLabel("");
	public JLabel locaLCD2 = new JLabel();
	public JLabel locaLCD3 = new JLabel();
	public JLabel locaLCD4 = new JLabel();
	public JLabel locaLCD5 = new JLabel();
	public JLabel locaLCD6 = new JLabel();
	public JLabel locaLCD7 = new JLabel();
	public JLabel locaLCD8 = new JLabel();
	public JLabel locaLCD9 = new JLabel();
	public JLabel locaLCD10 = new JLabel();
	public JLabel locaLCD11 = new JLabel();
	public JLabel locaLCD12 = new JLabel();
	public JLabel locaLCD13 = new JLabel();
	public JLabel locaLCD14 = new JLabel();
	public JLabel locaLCD15 = new JLabel();
	public JLabel locaLCD16 = new JLabel();
	public JLabel locaLCD17 = new JLabel();
	public JLabel locaLCD18 = new JLabel();
	public JLabel locaLCD19 = new JLabel();
	public JLabel locaLCD20 = new JLabel();
	public JLabel locaLCD21 = new JLabel();
	public JLabel locaLCD22 = new JLabel();
	public JLabel locaLCD23 = new JLabel();
	public JLabel locaLCD24 = new JLabel();
	public JLabel locaLCD25 = new JLabel();
	public JLabel locaLCD26 = new JLabel();
	public JLabel locaLCD27 = new JLabel();
	public JLabel locaLCD28 = new JLabel();
	public JLabel locaLCD29 = new JLabel();
	public JLabel locaLCD30 = new JLabel();
	public JLabel locaLCD31 = new JLabel();
	public JLabel locaLCD32 = new JLabel();
	public JLabel locaLCD33 = new JLabel();
	public JLabel locaLCD34 = new JLabel();
	public JLabel locaLCD35 = new JLabel();
	public JLabel locaLCD36 = new JLabel();
	public JLabel locaLCD37 = new JLabel();
	public JLabel locaLCD38 = new JLabel();
	public JLabel locaLCD39 = new JLabel();
	public JLabel locaLCD40 = new JLabel();
	public JLabel locaLCD41 = new JLabel();
	public JLabel locaLCD42 = new JLabel();
	public JLabel locaLCD43 = new JLabel();
	public JLabel locaLCD44 = new JLabel();
	public JLabel locaLCD45 = new JLabel();
	public JLabel locaLCD46 = new JLabel();
	public JLabel locaLCD47 = new JLabel();
	public JLabel locaLCD48 = new JLabel();
	public JLabel locaLCD49 = new JLabel();
	public JLabel locaLCD50 = new JLabel();
	public JLabel locaLCD51 = new JLabel();
	public JLabel locaLCD52 = new JLabel();
	public JLabel locaLCD53 = new JLabel();
	public JLabel locaLCD54 = new JLabel();
	public JLabel locaLCD55 = new JLabel();
	public JLabel locaLCD56 = new JLabel();
	public JLabel locaLCD57 = new JLabel();
	public JLabel locaLCD58 = new JLabel();
	public JLabel locaLCD59 = new JLabel();
	public JLabel locaLCD60 = new JLabel();
	private Vector dotVec = new Vector(60);
	public JLabel buzzerlb = new JLabel("");

	public int checkfunc(int funcNum) {
		if(funcNum == currfunc)
			return 1;
		else
			return 0;

	}
	public void initLabel() {
		sec.setText("0");
		sec10.setText("0");
		min.setText("0");
		min10.setText("0");
		hour.setText("0");
		hour10.setText("0");
	}

	public void initDot() {
		for(int i = 0; i < 60; i++) {
			JLabel temp = (JLabel)dotVec.elementAt(i);
			temp.setIcon(black);
		}
	}

	public void setDot(int index) {
		JLabel temp = (JLabel)dotVec.elementAt(index);
		temp.setIcon(watchdot);
	}

	public void removeDot(int index) {
		JLabel temp = (JLabel)dotVec.elementAt(index);
		temp.setIcon(black);
	}

	private void vecAdd() {
		dotVec.add(locaLCD1);
		dotVec.add(locaLCD2);
		dotVec.add(locaLCD3);
		dotVec.add(locaLCD4);
		dotVec.add(locaLCD5);
		dotVec.add(locaLCD6);
		dotVec.add(locaLCD7);
		dotVec.add(locaLCD8);
		dotVec.add(locaLCD9);
		dotVec.add(locaLCD10);
		dotVec.add(locaLCD11);
		dotVec.add(locaLCD12);
		dotVec.add(locaLCD13);
		dotVec.add(locaLCD14);
		dotVec.add(locaLCD15);
		dotVec.add(locaLCD16);
		dotVec.add(locaLCD17);
		dotVec.add(locaLCD18);
		dotVec.add(locaLCD19);
		dotVec.add(locaLCD20);
		dotVec.add(locaLCD21);
		dotVec.add(locaLCD22);
		dotVec.add(locaLCD23);
		dotVec.add(locaLCD24);
		dotVec.add(locaLCD25);
		dotVec.add(locaLCD26);
		dotVec.add(locaLCD27);
		dotVec.add(locaLCD28);
		dotVec.add(locaLCD29);
		dotVec.add(locaLCD30);
		dotVec.add(locaLCD31);
		dotVec.add(locaLCD32);
		dotVec.add(locaLCD33);
		dotVec.add(locaLCD34);
		dotVec.add(locaLCD35);
		dotVec.add(locaLCD36);
		dotVec.add(locaLCD37);
		dotVec.add(locaLCD38);
		dotVec.add(locaLCD39);
		dotVec.add(locaLCD40);
		dotVec.add(locaLCD41);
		dotVec.add(locaLCD42);
		dotVec.add(locaLCD43);
		dotVec.add(locaLCD44);
		dotVec.add(locaLCD45);
		dotVec.add(locaLCD46);
		dotVec.add(locaLCD47);
		dotVec.add(locaLCD48);
		dotVec.add(locaLCD49);
		dotVec.add(locaLCD50);
		dotVec.add(locaLCD51);
		dotVec.add(locaLCD52);
		dotVec.add(locaLCD53);
		dotVec.add(locaLCD54);
		dotVec.add(locaLCD55);
		dotVec.add(locaLCD56);
		dotVec.add(locaLCD57);
		dotVec.add(locaLCD58);
		dotVec.add(locaLCD59);
		dotVec.add(locaLCD60);
	}

	public View() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 1000);
		contentPane = new JPanel();

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		watchdot = new ImageIcon("watchdot.jpg");
		black = new ImageIcon(blackloca);
		icon = new ImageIcon("watchnodot.jpg");
		alarmicon = new ImageIcon(alarmloca);
		alarmonicon = new ImageIcon(alarmonloca);

		btnMode.setBounds(14, 66, 105, 27);
		contentPane.add(btnMode);


		btnFunct.setBounds(863, 66, 105, 27);
		contentPane.add(btnFunct);


		btnStart.setBounds(14, 914, 105, 27);
		contentPane.add(btnStart);


		btnReset.setBounds(863, 914, 105, 27);
		contentPane.add(btnReset);
		sec.setForeground(Color.WHITE);


		sec.setBounds(728, 459, 82, 99);
		contentPane.add(sec);
		sec10.setForeground(Color.WHITE);


		sec10.setBounds(628, 459, 83, 99);
		contentPane.add(sec10);
		min.setForeground(Color.WHITE);


		min.setBounds(528, 459, 77, 99);
		contentPane.add(min);
		min10.setForeground(Color.WHITE);


		min10.setBounds(428, 459, 80, 99);
		contentPane.add(min10);
		hour.setForeground(Color.WHITE);


		hour.setBounds(328, 459, 84, 99);
		contentPane.add(hour);
		hour10.setForeground(Color.WHITE);


		hour10.setBounds(228, 459, 82, 99);
		contentPane.add(hour10);



		funcTest.setForeground(Color.BLACK);
		funcTest.setBounds(28, 0, 346, 93);
		contentPane.add(funcTest);



		datelb.setForeground(Color.WHITE);
		datelb.setBounds(250, 360, 137, 83);

		contentPane.add(datelb);
		monthlb.setForeground(Color.WHITE);
		monthlb.setBounds(430, 360, 90, 83);

		contentPane.add(monthlb);
		daylb.setForeground(Color.WHITE);
		daylb.setBounds(550, 360, 90, 83);

		contentPane.add(daylb);
		ampm.setHorizontalAlignment(SwingConstants.RIGHT);
		ampm.setForeground(Color.WHITE);
		ampm.setBounds(680, 360, 101, 83);

		contentPane.add(ampm);

		funcTest.setFont(new Font("굴림", Font.BOLD, 28));
		ampm.setFont(customFont);
		sec.setFont(customFont_t);
		sec10.setFont(customFont_t);
		min.setFont(customFont_t);
		min10.setFont(customFont_t);
		hour.setFont(customFont_t);
		hour10.setFont(customFont_t);
		datelb.setFont(customFont);
		daylb.setFont(customFont);
		monthlb.setFont(customFont);


		locaLCD1.setForeground(Color.WHITE);
		locaLCD2.setForeground(Color.WHITE);
		locaLCD3.setForeground(Color.WHITE);
		locaLCD4.setForeground(Color.WHITE);
		locaLCD5.setForeground(Color.WHITE);
		locaLCD6.setForeground(Color.WHITE);
		locaLCD7.setForeground(Color.WHITE);
		locaLCD8.setForeground(Color.WHITE);
		locaLCD9.setForeground(Color.WHITE);
		locaLCD10.setForeground(Color.WHITE);
		locaLCD11.setForeground(Color.WHITE);
		locaLCD12.setForeground(Color.WHITE);
		locaLCD13.setForeground(Color.WHITE);
		locaLCD14.setForeground(Color.WHITE);
		locaLCD15.setForeground(Color.WHITE);
		locaLCD16.setForeground(Color.WHITE);
		locaLCD17.setForeground(Color.WHITE);
		locaLCD18.setForeground(Color.WHITE);
		locaLCD19.setForeground(Color.WHITE);
		locaLCD20.setForeground(Color.WHITE);
		locaLCD21.setForeground(Color.WHITE);
		locaLCD22.setForeground(Color.WHITE);
		locaLCD23.setForeground(Color.WHITE);
		locaLCD24.setForeground(Color.WHITE);
		locaLCD25.setForeground(Color.WHITE);
		locaLCD26.setForeground(Color.WHITE);
		locaLCD27.setForeground(Color.WHITE);
		locaLCD28.setForeground(Color.WHITE);
		locaLCD29.setForeground(Color.WHITE);
		locaLCD30.setForeground(Color.WHITE);
		locaLCD31.setForeground(Color.WHITE);
		locaLCD32.setForeground(Color.WHITE);
		locaLCD33.setForeground(Color.WHITE);
		locaLCD34.setForeground(Color.WHITE);
		locaLCD35.setForeground(Color.WHITE);
		locaLCD36.setForeground(Color.WHITE);
		locaLCD37.setForeground(Color.WHITE);
		locaLCD38.setForeground(Color.WHITE);
		locaLCD39.setForeground(Color.WHITE);
		locaLCD40.setForeground(Color.WHITE);
		locaLCD41.setForeground(Color.WHITE);
		locaLCD42.setForeground(Color.WHITE);
		locaLCD43.setForeground(Color.WHITE);
		locaLCD44.setForeground(Color.WHITE);
		locaLCD45.setForeground(Color.WHITE);
		locaLCD46.setForeground(Color.WHITE);
		locaLCD47.setForeground(Color.WHITE);
		locaLCD48.setForeground(Color.WHITE);
		locaLCD49.setForeground(Color.WHITE);
		locaLCD50.setForeground(Color.WHITE);
		locaLCD51.setForeground(Color.WHITE);
		locaLCD52.setForeground(Color.WHITE);
		locaLCD53.setForeground(Color.WHITE);
		locaLCD54.setForeground(Color.WHITE);
		locaLCD55.setForeground(Color.WHITE);
		locaLCD56.setForeground(Color.WHITE);
		locaLCD57.setForeground(Color.WHITE);
		locaLCD58.setForeground(Color.WHITE);
		locaLCD59.setForeground(Color.WHITE);
		locaLCD60.setForeground(Color.WHITE);



		locaLCD1.setBounds(499+5, 163-5, 20, 20);
		locaLCD2.setBounds(535+5, 166-5, 20, 20);
		locaLCD3.setBounds(569+5, 171-5, 20, 20);
		locaLCD4.setBounds(604+5, 180-5, 20, 20);
		locaLCD5.setBounds(636+5, 194-5, 20, 20);
		locaLCD6.setBounds(669+5, 209-5, 20, 20);
		locaLCD7.setBounds(700+5, 229-5, 20, 20);
		locaLCD8.setBounds(724+5, 250-5, 20, 20);
		locaLCD9.setBounds(752+5, 276-5, 20, 20);
		locaLCD10.setBounds(773+5, 302-5, 20, 20);
		locaLCD11.setBounds(793+5, 331-5, 20, 20);
		locaLCD12.setBounds(808+5, 365-5, 20, 20);
		locaLCD13.setBounds(822+5, 397-5, 20, 20);
		locaLCD14.setBounds(829+5, 430-5, 20, 20);
		locaLCD15.setBounds(835+5, 467-5, 20, 20);
		locaLCD16.setBounds(836+5, 502-5, 20, 20);
		locaLCD17.setBounds(836+5, 538-5, 20, 20);
		locaLCD18.setBounds(830+5, 571-5, 20, 20);
		locaLCD19.setBounds(820+5, 605-5, 20, 20);
		locaLCD20.setBounds(809+5, 639-5, 20, 20);
		locaLCD21.setBounds(792+5, 670-5, 20, 20);
		locaLCD22.setBounds(774+5, 700-5, 20, 20);
		locaLCD23.setBounds(751+5, 727-5, 20, 20);
		locaLCD24.setBounds(726+5, 753-5, 20, 20);
		locaLCD25.setBounds(697+5, 774-5, 20, 20);
		locaLCD26.setBounds(669+5, 793-5, 20, 20);
		locaLCD27.setBounds(637+5, 809-5, 20, 20);
		locaLCD28.setBounds(604+5, 829-15, 20, 20);
		locaLCD29.setBounds(569+5, 830-5, 20, 20);
		locaLCD30.setBounds(535+5, 838-5, 20, 20);
		locaLCD31.setBounds(500+5, 839-5, 20, 20);
		locaLCD32.setBounds(464+5, 838-5, 20, 20);
		locaLCD33.setBounds(429+5, 833-5, 20, 20);
		locaLCD34.setBounds(394+5, 821-5, 20, 20);
		locaLCD35.setBounds(362+5, 808-5, 20, 20);
		locaLCD36.setBounds(331+5, 792-5, 20, 20);
		locaLCD37.setBounds(300+5, 774-5, 20, 20);
		locaLCD38.setBounds(274+5, 751-5, 20, 20);
		locaLCD39.setBounds(249+5, 726-5, 20, 20);
		locaLCD40.setBounds(228+5, 700-5, 20, 20);
		locaLCD41.setBounds(206+5, 668-5, 20, 20);
		locaLCD42.setBounds(190+5, 638-5, 20, 20);
		locaLCD43.setBounds(177+5, 603-5, 20, 20);
		locaLCD44.setBounds(169+5, 571-5, 20, 20);
		locaLCD45.setBounds(164+5, 537-5, 20, 20);
		locaLCD46.setBounds(163+5, 500-5, 20, 20);
		locaLCD47.setBounds(165+5, 464-5, 20, 20);
		locaLCD48.setBounds(169+5, 430-5, 20, 20);
		locaLCD49.setBounds(178+5, 396-5, 20, 20);
		locaLCD50.setBounds(192+5, 364-5, 20, 20);
		locaLCD51.setBounds(206+5, 332-5, 20, 20);
		locaLCD52.setBounds(227+5, 303-5, 20, 20);
		locaLCD53.setBounds(249+5, 275-5, 20, 20);
		locaLCD54.setBounds(273+5, 251-5, 20, 20);
		locaLCD55.setBounds(301+5, 227-5, 20, 20);
		locaLCD56.setBounds(331+5, 209-5, 20, 20);
		locaLCD57.setBounds(362+5, 192-5, 20, 20);
		locaLCD58.setBounds(396+5, 180-5, 20, 20);
		locaLCD59.setBounds(430+5, 170-5, 20, 20);
		locaLCD60.setBounds(464+5, 164-5, 20, 20);


		contentPane.add(locaLCD1);
		contentPane.add(locaLCD2);
		contentPane.add(locaLCD3);
		contentPane.add(locaLCD4);
		contentPane.add(locaLCD5);
		contentPane.add(locaLCD6);
		contentPane.add(locaLCD7);
		contentPane.add(locaLCD8);
		contentPane.add(locaLCD9);
		contentPane.add(locaLCD10);
		contentPane.add(locaLCD11);
		contentPane.add(locaLCD12);
		contentPane.add(locaLCD13);
		contentPane.add(locaLCD14);
		contentPane.add(locaLCD15);
		contentPane.add(locaLCD16);
		contentPane.add(locaLCD17);
		contentPane.add(locaLCD18);
		contentPane.add(locaLCD19);
		contentPane.add(locaLCD20);
		contentPane.add(locaLCD21);
		contentPane.add(locaLCD22);
		contentPane.add(locaLCD23);
		contentPane.add(locaLCD24);
		contentPane.add(locaLCD25);
		contentPane.add(locaLCD26);
		contentPane.add(locaLCD27);
		contentPane.add(locaLCD28);
		contentPane.add(locaLCD29);
		contentPane.add(locaLCD30);
		contentPane.add(locaLCD31);
		contentPane.add(locaLCD32);
		contentPane.add(locaLCD33);
		contentPane.add(locaLCD34);
		contentPane.add(locaLCD35);
		contentPane.add(locaLCD36);
		contentPane.add(locaLCD37);
		contentPane.add(locaLCD38);
		contentPane.add(locaLCD39);
		contentPane.add(locaLCD40);
		contentPane.add(locaLCD41);
		contentPane.add(locaLCD42);
		contentPane.add(locaLCD43);
		contentPane.add(locaLCD44);
		contentPane.add(locaLCD45);
		contentPane.add(locaLCD46);
		contentPane.add(locaLCD47);
		contentPane.add(locaLCD48);
		contentPane.add(locaLCD49);
		contentPane.add(locaLCD50);
		contentPane.add(locaLCD51);
		contentPane.add(locaLCD52);
		contentPane.add(locaLCD53);
		contentPane.add(locaLCD54);
		contentPane.add(locaLCD55);
		contentPane.add(locaLCD56);
		contentPane.add(locaLCD57);
		contentPane.add(locaLCD58);
		contentPane.add(locaLCD59);
		contentPane.add(locaLCD60);
		buzzerlb.setFont(customFont);
		buzzerlb.setForeground(Color.WHITE);
		buzzerlb.setBounds(380, 297, 260, 49);

		contentPane.add(buzzerlb);
		alarmLb.setHorizontalAlignment(SwingConstants.CENTER);


		alarmLb.setBounds(472, 566, 84, 83);
		contentPane.add(alarmLb);

		vecAdd();
		initDot();

		panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(icon.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponents(g);
			}
		};
		panel.setBounds(14, 12, 1000, 1000);
		contentPane.add(panel);





		this.setVisible(true);
	}
}
