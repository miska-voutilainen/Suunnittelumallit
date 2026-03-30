import java.time.format.DateTimeFormatter;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainApp extends Application {

	private static final DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");

	private final ColorModel model = new ColorModel();
	private final Caretaker caretaker = new Caretaker();

	private Rectangle rect1;
	private Rectangle rect2;
	private Rectangle rect3;
	private CheckBox checkBox;

	@Override
	public void start(Stage primaryStage) {
		rect1 = new Rectangle(100, 100);
		rect2 = new Rectangle(100, 100);
		rect3 = new Rectangle(100, 100);

		ColorPicker picker1 = new ColorPicker(model.getColor1());
		ColorPicker picker2 = new ColorPicker(model.getColor2());
		ColorPicker picker3 = new ColorPicker(model.getColor3());

		picker1.setOnAction(e -> {
			ModelMemento before = model.saveState();
			caretaker.save(before);
			model.setColor1(picker1.getValue());
			updateUI(picker1, picker2, picker3);
		});

		picker2.setOnAction(e -> {
			ModelMemento before = model.saveState();
			caretaker.save(before);
			model.setColor2(picker2.getValue());
			updateUI(picker1, picker2, picker3);
		});

		picker3.setOnAction(e -> {
			ModelMemento before = model.saveState();
			caretaker.save(before);
			model.setColor3(picker3.getValue());
			updateUI(picker1, picker2, picker3);
		});

		checkBox = new CheckBox("Checkbox");
		checkBox.setSelected(model.isCheckboxState());
		checkBox.setOnAction(e -> {
			ModelMemento before = model.saveState();
			caretaker.save(before);
			model.setCheckboxState(checkBox.isSelected());
			updateUI(picker1, picker2, picker3);
		});

		VBox col1 = new VBox(5, rect1, picker1);
		VBox col2 = new VBox(5, rect2, picker2);
		VBox col3 = new VBox(5, rect3, picker3);
		col1.setAlignment(Pos.CENTER);
		col2.setAlignment(Pos.CENTER);
		col3.setAlignment(Pos.CENTER);

		Button historyBtn = new Button("History");
		historyBtn.setOnAction(e -> openHistoryWindow(picker1, picker2, picker3));

		HBox rectRow = new HBox(20, col1, col2, col3);
		rectRow.setAlignment(Pos.CENTER);

		HBox bottomRow = new HBox(20, checkBox, historyBtn);
		bottomRow.setAlignment(Pos.CENTER);

		VBox root = new VBox(20, rectRow, bottomRow);
		root.setPadding(new Insets(20));
		root.setAlignment(Pos.CENTER);

		updateUI(picker1, picker2, picker3);

		Scene scene = new Scene(root, 500, 300);

		KeyCodeCombination undoKeys = new KeyCodeCombination(KeyCode.Z, KeyCombination.CONTROL_DOWN);
		KeyCodeCombination redoKeys = new KeyCodeCombination(KeyCode.Y, KeyCombination.CONTROL_DOWN);

		scene.setOnKeyPressed(e -> {
			if (undoKeys.match(e)) {
				ModelMemento current = model.saveState();
				caretaker.undo(current).ifPresent(memento -> {
					model.restoreState(memento);
					updateUI(picker1, picker2, picker3);
				});
			} else if (redoKeys.match(e)) {
				ModelMemento current = model.saveState();
				caretaker.redo(current).ifPresent(memento -> {
					model.restoreState(memento);
					updateUI(picker1, picker2, picker3);
				});
			}
		});

		primaryStage.setTitle("Memento Pattern");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void updateUI(ColorPicker picker1, ColorPicker picker2, ColorPicker picker3) {
		rect1.setFill(model.getColor1());
		rect2.setFill(model.getColor2());
		rect3.setFill(model.getColor3());
		picker1.setValue(model.getColor1());
		picker2.setValue(model.getColor2());
		picker3.setValue(model.getColor3());
		checkBox.setSelected(model.isCheckboxState());
	}

	private void openHistoryWindow(ColorPicker picker1, ColorPicker picker2, ColorPicker picker3) {
		Stage historyStage = new Stage();
		historyStage.setTitle("State History");

		List<ModelMemento> history = caretaker.getHistory();

		ListView<ModelMemento> listView = new ListView<>();
		listView.getItems().addAll(history);

		listView.setCellFactory(lv -> new ListCell<>() {
			@Override
			protected void updateItem(ModelMemento item, boolean empty) {
				super.updateItem(item, empty);
				if (empty || item == null) {
					setText(null);
				} else {
					setText(item.getTimestamp().format(TIME_FORMAT) + " — " + item.getDescription());
				}
			}
		});

		listView.setOnMouseClicked(e -> {
			ModelMemento selected = listView.getSelectionModel().getSelectedItem();
			if (selected != null) {
				ModelMemento current = model.saveState();
				caretaker.save(current);
				model.restoreState(selected);
				updateUI(picker1, picker2, picker3);
				historyStage.close();
			}
		});

		Label label = new Label("Click a state to restore it:");
		VBox vbox = new VBox(10, label, listView);
		vbox.setPadding(new Insets(15));

		historyStage.setScene(new Scene(vbox, 350, 300));
		historyStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
