package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import application.model.AlarmModel;
import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.event.EventHandler;
import javafx.util.Duration;

public class AlarmController implements Initializable {

	SimpleDateFormat test = new SimpleDateFormat("hh:mm a");

	final DateFormat format = DateFormat.getInstance();

	@FXML
	private Label currentTime;

	@FXML
	private AnchorPane mainPane;

	@FXML
	private Label nextAlarm;

	@FXML
	private ChoiceBox<Integer> hour;

	@FXML
	private Pane timeSelect;

	@FXML
	private ChoiceBox<String> when;

	@FXML
	private ChoiceBox<Integer> minute;

	@FXML
	private ListView<String> alarms1;

	@FXML
	private ListView<String> alarms2;

	@FXML
	private ChoiceBox<Integer> alarmNumber;

	@FXML
	private Pane alarmRemove;

	@FXML
	void add(ActionEvent event) throws IOException {
		timeSelect.setVisible(false);
		AlarmModel save = new AlarmModel();
		save.saveAlarm(hour.getValue(), minute.getValue(), (when.getValue().equals("AM")) ? true : false, "alarms.txt");

		alarms1.getItems().clear();
		alarms2.getItems().clear();
		AlarmModel load = new AlarmModel();
		int count = 1;
		ArrayList<String> alarms1List = new ArrayList<String>();
		ArrayList<String> alarms2List = new ArrayList<String>();
		try {
			alarms1List = load.loadAlarms1("alarms.txt");
			alarms2List = load.loadAlarms2("alarms.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < alarms1List.size(); i++) {
			alarms1.getItems().add("Alarm " + count + ": " + alarms1List.get(i));
			count++;
		}

		for (int i = 0; i < alarms2List.size(); i++) {
			alarms2.getItems().add("Alarm " + count + ": " + alarms2List.get(i));
			count++;
		}

		alarmNumber.getItems().clear();
		for (int i = 1; i < count; i++) {
			alarmNumber.getItems().add(i);
		}
	}

	@FXML
	void remove(ActionEvent event) throws IOException {
		alarmRemove.setVisible(false);
		if (alarmNumber.getValue() == null) {
			System.out.println("No alarms removed.");
			return;
		}
		AlarmModel update = new AlarmModel();
		update.removeAlarm(alarmNumber.getValue() - 1, "alarms.txt");

		AlarmModel load = new AlarmModel();
		int count = 1;
		ArrayList<String> alarms1List = new ArrayList<String>();
		ArrayList<String> alarms2List = new ArrayList<String>();
		try {
			alarms1List = load.loadAlarms1("alarms.txt");
			alarms2List = load.loadAlarms2("alarms.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		alarms1.getItems().clear();
		alarms2.getItems().clear();

		for (int i = 0; i < alarms1List.size(); i++) {
			alarms1.getItems().add("Alarm " + count + ": " + alarms1List.get(i));
			count++;
		}

		for (int i = 0; i < alarms2List.size(); i++) {
			alarms2.getItems().add("Alarm " + count + ": " + alarms2List.get(i));
			count++;
		}

		alarmNumber.getItems().clear();
		for (int i = 1; i < count; i++) {
			alarmNumber.getItems().add(i);
		}

	}

	@FXML
	void addAlarm(ActionEvent event) throws Exception {
		timeSelect.setVisible(true);
	}

	@FXML
	void handleAlarm(ActionEvent event) throws IOException {
		URL url = new File("Alarm.fxml").toURI().toURL();
		mainPane = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	void handleClock(ActionEvent event) throws IOException {
		URL url = new File("Clock.fxml").toURI().toURL();
		mainPane = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	void handleTimer(ActionEvent event) throws IOException {
		URL url = new File("Timer.fxml").toURI().toURL();
		mainPane = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	void handleWeather(ActionEvent event) throws IOException {
		URL url = new File("Weather.fxml").toURI().toURL();
		mainPane = FXMLLoader.load(url);
		Scene scene = new Scene(mainPane);
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	@FXML
	void removeAlarm(ActionEvent event) {
		alarmRemove.setVisible(true);
	}

	@FXML
	public void updateNextAlarm() {

	}

	public AlarmController() {
		bindToTime();
	}

	private void bindToTime() {

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(0), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent actionEvent) {
				Calendar time = Calendar.getInstance();
				currentTime.setText(format.format(time.getTime()));

				AlarmModel load = new AlarmModel();

				ArrayList<String> alarms1List = new ArrayList<String>();
				ArrayList<String> alarms2List = new ArrayList<String>();
				try {
					alarms1List = load.loadAlarms1("alarms.txt");
					alarms2List = load.loadAlarms2("alarms.txt");
				} catch (IOException e) {
					e.printStackTrace();
				}

				// SimpleDateFormat test = new SimpleDateFormat("hh:mm a");

				try {
					Date nextAlarmTime = test.parse("23:59 PM");
					if (!alarms1List.isEmpty()) {
						for (int i = 0; i < alarms1List.size(); i++) {
							try {
								Date alarmCheck = test.parse(alarms1List.get(i));
								Date today = test
										.parse(time.getTime().getHours() - 12 + ":" + time.getTime().getMinutes() + " "
												+ (time.getTime().getHours() >= 12 ? "PM" : "AM"));
								if (alarmCheck.before(today)) {
									alarmCheck.setDate(alarmCheck.getDate() + 1);
									;
								}

								if (alarmCheck.after(today)) {
									if (alarmCheck.before(nextAlarmTime)) {
										nextAlarmTime = alarmCheck;
									}
								}
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							
						}

						for (int i = 0; i < alarms2List.size(); i++) {
							try {
								Date alarmCheck = test.parse(alarms2List.get(i));
								Date today = test.parse(time.getTime().getHours()-12+":"+time.getTime().getMinutes() +" "+(time.getTime().getHours() > 12 ? "PM" : "AM"));
								if (alarmCheck.before(today)) {
									alarmCheck.setDate(alarmCheck.getDate()+1);;
								}
								
								if (alarmCheck.after(today)) {
									if (alarmCheck.before(nextAlarmTime)) {
										nextAlarmTime = alarmCheck;
									}
								}
							} catch (ParseException e) {
							   //TODO Auto-generated catch block
								e.printStackTrace();
							}

						
						}
						//System.out.println(test.parse(nextAlarmTime.getHours()+":"+nextAlarmTime.getMinutes()+" "+(nextAlarmTime.getHours() > 12 ? "PM" : "AM")));
						
						nextAlarm.setText((nextAlarmTime.getHours() > 12 ? nextAlarmTime.getHours()-12 : nextAlarmTime.getHours())+":"+nextAlarmTime.getMinutes()+" "+(nextAlarmTime.getHours() > 12 ? "PM" : "AM"));

						

					}
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		}), new KeyFrame(Duration.seconds(1)));

		timeline.setCycleCount(Animation.INDEFINITE);
		timeline.play();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AlarmModel load = new AlarmModel();
		int count = 1;
		ArrayList<String> alarms1List = new ArrayList<String>();
		ArrayList<String> alarms2List = new ArrayList<String>();
		try {
			alarms1List = load.loadAlarms1("alarms.txt");
			alarms2List = load.loadAlarms2("alarms.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < alarms1List.size(); i++) {
			alarms1.getItems().add("Alarm " + count + ": " + alarms1List.get(i));
			count++;
		}

		for (int i = 0; i < alarms2List.size(); i++) {
			alarms2.getItems().add("Alarm " + count + ": " + alarms2List.get(i));
			count++;
		}

		for (int i = 1; i < count; i++) {
			alarmNumber.getItems().add(i);
		}

		updateNextAlarm();
		for (int i = 1; i <= 12; i++) {
			hour.getItems().add(i);
		}

		for (int i = 1; i < 60; i++) {
			minute.getItems().add(i);
		}

		when.getItems().addAll("AM", "PM");

		hour.setValue(6);
		minute.setValue(30);
		when.setValue("AM");

	}

}
