import java.net.URL;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class CalendarController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Label monthLabel;

	@FXML
	private Label yearLabel;

	@FXML
	private GridPane daysInMonth;
	private int currentMonth;
	private int currentYear;
	private Calendar cal = Calendar.getInstance();
	private int numDays;
	private int startDay;
	private HashMap<Date, String> map;
	private Alert modifyDay = new Alert(AlertType.CONFIRMATION);
	private Date d;
	private TextArea textArea;

	// left grid month's buttons actions ( from JAN to DEC )
	@FXML
	void pressedJanuary(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.JANUARY);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedFebruary(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.FEBRUARY);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedMarch(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.MARCH);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedApril(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.APRIL);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedMay(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.MAY);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedJune(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.JUNE);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedJuly(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.JULY);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedAugust(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.AUGUST);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedSeptember(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedOctober(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.OCTOBER);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedNovember(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.NOVEMBER);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	@FXML
	void pressedDecember(ActionEvent event) {
		cal.set(Calendar.MONTH, Calendar.DECEMBER);
		currentMonth = cal.get(Calendar.MONTH);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		updateCal();
	}

	// next & previous year buttons actions
	@FXML
	void nextYear(ActionEvent event) {
		cal.add(Calendar.YEAR, 1);
		currentYear = cal.get(Calendar.YEAR);
		yearLabel.setText(currentYear + "");
		updateCal();
	}

	@FXML
	void prevYear(ActionEvent event) {
		cal.add(Calendar.YEAR, -1);
		currentYear = cal.get(Calendar.YEAR);
		yearLabel.setText(currentYear + "");
		updateCal();
	}

	@FXML
	void initialize() {
		map = new HashMap<Date, String>();
		textArea = new TextArea();
		buildCal();
	}

	// build calendar grid method
	private void buildCal() {
		// get the current date & display it to the user
		currentMonth = cal.get(Calendar.MONTH);
		currentYear = cal.get(Calendar.YEAR);
		monthLabel.setText(cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH));
		yearLabel.setText(currentYear + "");
		numDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		cal.set(Calendar.DAY_OF_MONTH, 1);
		startDay = cal.get(Calendar.DAY_OF_WEEK);
		daysInMonth.setHgap(10);
		daysInMonth.setVgap(10);
		daysInMonth.setAlignment(Pos.CENTER);
		updateCal();
	}

	// update calendar method
	private void updateCal() {
		daysInMonth.getChildren().clear();
		numDays = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		startDay = cal.get(Calendar.DAY_OF_WEEK);
		updateCalGrid();
	}

	// updating the calendar days grid
	private void updateCalGrid() {
		// set the names of the week on row 0
		String[] daysOfWeek = { "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat" };
		for (int i = 0; i < 7; i++) {
			Text day = new Text(daysOfWeek[i]);
			GridPane.setHalignment(day, HPos.CENTER);
			day.setFill(Color.DARKRED);
			daysInMonth.add(day, i, 0);
		}
		// create styled buttons for every day in the month
		for (int i = 1; i <= numDays; i++) {
			Button clickeDay = new Button(String.valueOf(i));
			clickeDay.setStyle("-fx-background-color: transparent; -fx-border-color: grey;");
			clickeDay.setMaxWidth(Double.MAX_VALUE);
			clickeDay.setMaxHeight(Double.MAX_VALUE);
			daysInMonth.add(clickeDay, (startDay - 1 + i - 1) % 7, (startDay - 1 + i - 1) / 7 + 1);
			clickeDay.setOnAction(event -> {
				String day = ((Button) event.getSource()).getText();
				d = new Date(Integer.parseInt(day), currentMonth, currentYear);
				textArea = new TextArea();
				MeetingsOverviewDialog(d);
				// hover effect for the buttons
			});
			clickeDay.setOnMouseEntered(event -> {
				clickeDay.setStyle("-fx-background-color: mediumpurple");
			});
			clickeDay.setOnMouseExited(event -> {
				clickeDay.setStyle("-fx-background-color: transparent; -fx-border-color: grey;");
			});
		}
	}

	// Dialog box pop-up
	private void MeetingsOverviewDialog(Date d) {
		textArea.setText(map.get(d));
		modifyDay.setContentText(textArea.getText());
		modifyDay.setTitle("Meeting schedeueled for today");
		modifyDay.setHeaderText("What is up today? \nHere is your meetings overview \n");
		Image icon = new Image("https://cdn-icons-png.flaticon.com/512/1048/1048953.png");
		ImageView iconView = new ImageView(icon);
		iconView.setFitHeight(75);
		iconView.setFitWidth(75);
		modifyDay.setGraphic(iconView);
		ButtonType addMeetings = new ButtonType("add");
		ButtonType cancel = new ButtonType("cancel", ButtonData.CANCEL_CLOSE);
		modifyDay.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
		modifyDay.getButtonTypes().setAll(addMeetings, cancel);
		Optional<ButtonType> userChoice = modifyDay.showAndWait();
		Stage stage = new Stage();
		if (userChoice.get() == addMeetings) {
			Button saveButton = new Button("Save");
			saveButton.setAlignment(Pos.CENTER);
			saveButton.setPadding(new Insets(10));
			saveButton.setOnAction(event -> {
				textArea.appendText("\n");
				map.put(d, textArea.getText());
				textArea.setText(map.get(d));
				stage.close();
			});
			VBox editWindow = new VBox(textArea, saveButton);
			VBox.setMargin(saveButton, new Insets(10));
			editWindow.setAlignment(Pos.CENTER);
			Scene scene = new Scene(editWindow, 400, 300);
			stage.setScene(scene);
			stage.setTitle("Add / Edit your meeting here");
			stage.show();
		} else if (userChoice.get() == cancel) {
			modifyDay.close();
		}
	}
}
