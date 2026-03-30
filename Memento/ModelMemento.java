import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javafx.scene.paint.Color;

public class ModelMemento implements StateMetadata {

	private final Color color1;
	private final Color color2;
	private final Color color3;
	private final boolean checkboxState;
	private final LocalDateTime timestamp;

	public ModelMemento(Color color1, Color color2, Color color3, boolean checkboxState) {
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
		this.checkboxState = checkboxState;
		this.timestamp = LocalDateTime.now();
	}

	public Color getColor1() {
		return color1;
	}

	public Color getColor2() {
		return color2;
	}

	public Color getColor3() {
		return color3;
	}

	public boolean isCheckboxState() {
		return checkboxState;
	}

	@Override
	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	@Override
	public String getDescription() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		return "State saved at " + timestamp.format(formatter);
	}
}
