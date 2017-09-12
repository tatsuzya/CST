package q3;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * StopWatchPanel.
 * 
 * @author jay
 * @version 1.0
 */
@SuppressWarnings("serial")
public class StopWatchPanel extends JPanel implements ActionListener {
	/** label for display. */
	private JLabel display;
	/** current milliseconds when timer start. */
	private long watchStart;
	/** stop watch. */
	private Timer stopWatch;
	/** time when paused. */
	private long pausedTime;
	/** start the timer. */
	private JButton startTimer;
	/** stop the timer. */
	private JButton stopTimer;
	/** pause the timer. */
	private JButton pauseTimer;
	/** width for the panel. */
	private final int width = 800;
	/** height for the panel. */
	private final int height = 400;
	/** row. */
	private final int row1 = 3;
	/** column. */
	private final int row2 = 1;
	/** column. */
	private final int col = 3;
	/** millisecond in a second. */
	private final int ms = 1000;
	/** seconds in a minute. */
	private final int secToMin = 60;
	/** hours in a day. */
	private final int hrToDay = 24;
	/** minutes in an hour. */
	private final int minToHr = 60;
	/** time interval between action. */
	private final int interval = 100;

	/**
	 * Constructor for the object of type StopWatchPanel.
	 */
	public StopWatchPanel() {

		super();
		setSize(width, height);
		setLayout(new GridLayout(row1, 1));

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(row2, col, 2, 2));

		startTimer = new JButton("Start");
		stopTimer = new JButton("Reset");
		pauseTimer = new JButton("Pause");

		startTimer.addActionListener(this);
		stopTimer.addActionListener(this);
		pauseTimer.addActionListener(this);

		display = new JLabel("Stop Watch");
		display.setHorizontalAlignment(JLabel.CENTER);

		JLabel time = new JLabel("0 hours 0 min 0 sec");
		time.setHorizontalAlignment(JLabel.CENTER);

		buttonPanel.add(startTimer);
		buttonPanel.add(stopTimer);
		buttonPanel.add(pauseTimer);
		add(display);
		add(buttonPanel);
		add(time);

		stopWatch = new Timer(interval, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				long mSeconds = (System.currentTimeMillis() - watchStart);
				long mSec = (mSeconds) % ms;
				long seconds = mSeconds / ms;
				long sec = seconds % secToMin;
				long minutes = (seconds / secToMin);
				long min = minutes % minToHr;
				long hours = (minutes / minToHr);
				long hr = hours % hrToDay;
				String timer = new String("" + hr + " hours " + min + " min " + sec + " sec " + mSec);
				time.setText(timer);
			}
		});
	}

	/**
	 * Action performed.
	 * 
	 * @param e
	 *            event
	 */
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Reset")) {
			watchStart = System.currentTimeMillis();
			stopWatch.stop();
			pausedTime = 0;
		} else if (e.getActionCommand().equals("Start")) {
			watchStart = System.currentTimeMillis();
			stopWatch.start();
		} else if (e.getActionCommand().equals("Resume")) {
			watchStart = System.currentTimeMillis() + pausedTime;
			pausedTime = 0;
			stopWatch.restart();
			startTimer.setText("Start");
		} else if (e.getActionCommand().equals("Pause")) {
			long currentTime = System.currentTimeMillis();
			pausedTime = pausedTime - (currentTime - watchStart);
			stopWatch.stop();
			startTimer.setText("Resume");
		}
	}
}
