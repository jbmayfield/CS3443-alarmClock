public class PleaseProvideControllerClassName {

    @FXML
    private Button reset;

    @FXML
    private Button start;

    @FXML
    private Button stop;

    @FXML
    private VBox timer;

    @FXML
    void ResetTime(MouseEvent event) {

    }

    @FXML
    void StartTIme(MouseEvent event) {

    }

    @FXML
    void StopTime(MouseEvent event) {

    }

}






/*package application.controller;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.fxml.FXML;


public class TimerControllerClassName {

    @FXML
    private Button reset; //BUTTON reset

    @FXML
    private Button start; //BUTTON start

    @FXML
    private Button stop; //BUTTON stop

    @FXML
    private VBox timer; //TEXTFIELD timer

}


public abstract class Timer implements ActionListener {
	
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started  = false;
	String seconds_string = String.format("%02d",seconds);
	String minutes_string = String.format("%02d",minutes);
	String hours_string = String.format("%02d",hours);
	
	Timer timer = new Timer(1000, new ActionListener())
	{
		public void actionPerformed(ActionEvent e)
		{
			elapsedTime = elapsedTime+1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02", hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		  	
		}
		
			
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==startButton)
		{
			startTimer();
			if(started == false)
			{
				started = true;
				startButton.setText("STOP");
				startTimer();
			}
			else
			{
				started = false;
				startButton.setText("START");
				stopTimer();
			}
		}
		if(e.getSource()==resetButton)
		{
			started = false;
			startButton.setText("Start");
			resetTimer();
		}
	}
	void startTimer()
	{
		timer.startTimer();
		
	}
	void stopTimer()
	{
		timer.stopTimer();
	}
	void resetTimer()
	{
		timer.stopTimer();
		elapsedTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02", hours);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	  	
	}
}
*/	



