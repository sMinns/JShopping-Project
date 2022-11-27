package gui.contents.sub;

import custom.ButtonType1;
import custom.ButtonType2;
import custom.ButtonType3;
import system.Setup;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Calendar;
import java.util.StringTokenizer;

public class DesDateCalendar extends JPanel implements ActionListener, MouseListener {
	private int year, month, day, week, lastDate,
			selectYear, selectMonth, selectDay,
			thisYear, thisMonth, thisDay,
			defaultYear, defaultMonth, defaultDay;
	private JPanel[] pan;
	private JLabel[] days;
	private JPanel calenderPanel, outPanel;
	private JButton minus, plus, cancel, ok;
	private JLabel date;
	private Calendar c = Calendar.getInstance();
	private JTextField tf;
	public DesDateCalendar(JTextField tf, JPanel panel) {
		outPanel = panel;
		this.tf = tf;
		defaultDateSet();
		//Calender Setting
			this.setSize(270, 240);
			this.setBorder(BorderFactory.createLineBorder(Setup.checkBoxBorderColor, 2));

			GridBagLayout CalenderLayout = new GridBagLayout();
			CalenderLayout.columnWidths = new int[]{15, 195, 15};
			CalenderLayout.rowHeights = new int[]{40, 0, 40, 0};
			CalenderLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
			CalenderLayout.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
			this.setLayout(CalenderLayout);

		//TopPanel Setting
			JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
			topPanel.setBackground(Setup.white);
			GridBagConstraints calenderBagCon = new GridBagConstraints();
			calenderBagCon.gridwidth = 3;
			calenderBagCon.fill = GridBagConstraints.BOTH;
			this.add(topPanel, calenderBagCon);

			GridBagLayout topPanelLayout = new GridBagLayout();
			topPanelLayout.columnWidths = new int[]{60, 150, 60};
			topPanelLayout.columnWeights = new double[]{0.0, 1.0, 0.0};
			topPanelLayout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			topPanel.setLayout(topPanelLayout);

			//TopPanel Date
				GridBagConstraints dateBagCon = new GridBagConstraints();
				dateBagCon.gridx = 0;
				dateBagCon.anchor = GridBagConstraints.EAST;

				minus = new ButtonType3(true);
				minus.addActionListener(this);
				topPanel.add(minus, dateBagCon);

				date = new JLabel(year + "년 " + (month+1) + "월");
				date.setFont(new Font(Setup.font, Font.BOLD, 16));
				dateBagCon.gridx = 1;
				dateBagCon.anchor = GridBagConstraints.CENTER;
				topPanel.add(date, dateBagCon);

				plus = new ButtonType3(false);
				plus.addActionListener(this);
				dateBagCon.gridx = 2;
				dateBagCon.anchor = GridBagConstraints.WEST;
				topPanel.add(plus, dateBagCon);

		//Middle BlankPanel
			JPanel blankPanel1 = new JPanel();
			blankPanel1.setBackground(Setup.white);
			calenderBagCon.gridwidth = 1;
			calenderBagCon.gridy = 1;
			this.add(blankPanel1, calenderBagCon);

			JPanel blankPanel2 = new JPanel();
			blankPanel2.setBackground(Setup.white);
			calenderBagCon.gridx = 2;
			this.add(blankPanel2, calenderBagCon);

		//Middle CalenderPanel
			calenderPanel = new JPanel();
			calenderPanel.setBackground(Setup.white);
			calenderBagCon.gridx = 1;
			this.add(calenderPanel, calenderBagCon);
			calenderPanel.setLayout(new GridLayout(gridRows(year, month), 7, 0, 0));
			CalenderPrint(gridRows(year, month), year, month);

		//Bottom ButtonPanel
			JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 35, 9));
			buttonPanel.setBackground(Setup.white);
			calenderBagCon.insets = new Insets(2, 0, 0, 0);
			calenderBagCon.gridx = 0;
			calenderBagCon.gridwidth = 3;
			calenderBagCon.gridy = 2;
			this.add(buttonPanel, calenderBagCon);

			cancel = new ButtonType2(20, 3, 3, "취 소", 14);
			ok = new ButtonType1(20, 3, 3, "적 용", 14);

			cancel.addActionListener(this);
			ok.addActionListener(this);
			buttonPanel.add(cancel);
			buttonPanel.add(ok);
	}

	public void CalenderPrint(int rows, int y, int m) {
		week = c.get(Calendar.DAY_OF_WEEK);
		lastDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		if(week != 1) { lastMonthPrint(y, m); }
		c.set(y, m, c.get(Calendar.DATE));

		thisMonthPrint();

		nextMonthPrint(rows);
	}

	public void lastMonthPrint(int y, int m) {
		c.set(y, m-1, 1);
		int befWeek = c.get(Calendar.DAY_OF_WEEK);
		int befLastDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		int beflastWeek = 0;

		for (int i = befLastDate; ((i + befWeek) % 7) != 1; i--) {
			beflastWeek = i;
		}
		for(int i = beflastWeek; i <= befLastDate; i++) {
			JLabel day = new JLabel();
			day.setText(i + "");
			day.setHorizontalAlignment(JLabel.CENTER);
			day.setForeground(Setup.textGray);
			if ((befWeek + i - 1) % 7 == 1) { day.setForeground(new Color(255, 155, 155)); }
			calenderPanel.add(day);
		}
	}

	public void thisMonthPrint() {
		pan = new JPanel[lastDate];
		days = new JLabel[lastDate];
		for(int i = 0; i < lastDate; i++) {
			pan[i] = new JPanel(new GridBagLayout());
			days[i] = new JLabel();
			days[i].setFont(new Font(Setup.font, Font.BOLD, 14));
			days[i].setText(1 + i + "");
			pan[i].setBackground(Setup.white);
			days[i].setForeground(Setup.darkGray);
			if(year > thisYear) {
				if ((week + i) % 7 == 0) { days[i].setForeground(Color.blue); }
				if ((week + i) % 7 == 1) { days[i].setForeground(Color.red); }
				pan[i].addMouseListener(this);
			}else if(year == thisYear) {
				if(month > thisMonth) {
					if ((week + i) % 7 == 0) { days[i].setForeground(Color.blue); }
					if ((week + i) % 7 == 1) { days[i].setForeground(Color.red); }
					pan[i].addMouseListener(this);
				}else if(month == thisMonth) {
					if(i > thisDay) {
						if ((week + i) % 7 == 0) { days[i].setForeground(Color.blue); }
						if ((week + i) % 7 == 1) { days[i].setForeground(Color.red); }
						pan[i].addMouseListener(this);
					}else {
						days[i].setForeground(Setup.textGray);
						if ((week + i) % 7 == 0) { days[i].setForeground(new Color(180, 180, 255)); }
						if ((week + i) % 7 == 1) { days[i].setForeground(new Color(255, 155, 155)); }
					}
				}else {
					days[i].setForeground(Setup.textGray);
					if ((week + i) % 7 == 0) { days[i].setForeground(new Color(180, 180, 255)); }
					if ((week + i) % 7 == 1) { days[i].setForeground(new Color(255, 155, 155)); }
				}
			}else {
				days[i].setForeground(Setup.textGray);
				if ((week + i) % 7 == 0) { days[i].setForeground(new Color(180, 180, 255)); }
				if ((week + i) % 7 == 1) { days[i].setForeground(new Color(255, 155, 155)); }
			}
			pan[i].add(days[i]);
			calenderPanel.add(pan[i]);
		}
		if(selectMonth == month + 1 && selectYear == year) {
			days[selectDay-1].setForeground(Setup.white);
			pan[selectDay-1].setBackground(Setup.magenta);
		}
	}

	public void nextMonthPrint(int rows) {
		for (int i = lastDate; i <= 7*rows - week; i++) {
			JLabel day = new JLabel();
			day.setText(i - lastDate + 1 + "");
			day.setHorizontalAlignment(JLabel.CENTER);
			day.setForeground(Setup.textGray);
			if ((week + i) % 7 == 0) { day.setForeground(new Color(180, 180, 255)); }
			if ((week + i) % 7 == 1) { day.setForeground(new Color(255, 155, 155)); }
			calenderPanel.add(day);
		}
	}

	public int gridRows(int y, int m) {
		c.set(y, m-1, 1);
		c.set(y, m, 1);
		int week = c.get(Calendar.DAY_OF_WEEK);
		int lastDate = c.getActualMaximum(Calendar.DAY_OF_MONTH);
		if((week + lastDate) > 36) { return 6; }
		else { return 5; }
	}

	public void defaultDateSet() {
		String str = tf.getText();
		StringTokenizer st = new StringTokenizer(str, ". ");

		selectYear = Integer.parseInt(st.nextToken());
		selectMonth = Integer.parseInt(st.nextToken());
		selectDay = Integer.parseInt(st.nextToken());

		defaultYear = selectYear;
		defaultMonth = selectMonth;
		defaultDay = selectDay;

		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DATE);
		c.set(year, month, day);

		thisYear = year;
		thisMonth = month;
		thisDay = day;

		year = selectYear;
		month = selectMonth - 1;
		day = selectDay;
		c.set(year, month, day);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == minus) {
			month--;
			if(month == -1) { year--; month = 11; }
			calenderPanel.removeAll();
			calenderPanel.setLayout(new GridLayout(gridRows(year, month), 7));
			CalenderPrint(gridRows(year, month), year, month);
			date.setText(year + "년 " + (month+1) + "월");
		} else if (e.getSource() == plus) {
			month++;
			if(month == 12) { year++; month = 0; }
			calenderPanel.removeAll();
			calenderPanel.setLayout(new GridLayout(gridRows(year, month), 7));
			CalenderPrint(gridRows(year, month), year, month);
			date.setText(year + "년 " + (month+1) + "월");
		}
		if (e.getSource() == ok) {
			outPanel.setVisible(false);
		}
		if (e.getSource() == cancel) {
			outPanel.setVisible(false);
			tf.setText(defaultYear + ". " + defaultMonth + ". " + defaultDay);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		for (int i = 1; i < pan.length+1; i++) {
			if (e.getSource() == pan[i-1]) {
				if(selectYear == year && selectMonth == month+1 && i == selectDay) { return; }
				pan[selectDay-1].setBackground(Setup.white);
				if(thisMonth == month) {
					if(selectDay > thisDay+1) {
						if ((week + selectDay-1) % 7 == 0) { days[selectDay-1].setForeground(Color.blue); }
						else if ((week + selectDay-1) % 7 == 1) { days[selectDay-1].setForeground(Color.red); }
						else { days[selectDay-1].setForeground(Setup.darkGray); }
					}else {
						if ((week + selectDay-1) % 7 == 0) { days[selectDay-1].setForeground(new Color(180, 180, 255)); }
						else if ((week + selectDay-1) % 7 == 1) { days[selectDay-1].setForeground(new Color(255, 155, 155)); }
						else { days[selectDay-1].setForeground(Setup.textGray); }
					}
				}else {
					if ((week + selectDay-1) % 7 == 0) { days[selectDay-1].setForeground(Color.blue); }
					else if ((week + selectDay-1) % 7 == 1) { days[selectDay-1].setForeground(Color.red); }
					else { days[selectDay-1].setForeground(Setup.darkGray); }
				}
				pan[i-1].setBackground(Setup.magenta);
				days[i-1].setForeground(Setup.white);
				selectYear = year;
				selectMonth = month+1;
				selectDay = i;
				tf.setText(selectYear + ". " + selectMonth + ". " + selectDay);
			}
		}
	}
	public void mouseEntered(MouseEvent e) { setCursor(new Cursor(Cursor.HAND_CURSOR)); }
	public void mouseExited(MouseEvent e) { setCursor(new Cursor(Cursor.DEFAULT_CURSOR)); }
	public void mousePressed(MouseEvent e) { }
	public void mouseReleased(MouseEvent e) { }
}