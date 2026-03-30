import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class Caretaker {

	private final Deque<ModelMemento> undoStack = new ArrayDeque<>();
	private final Deque<ModelMemento> redoStack = new ArrayDeque<>();

	public void save(ModelMemento memento) {
		undoStack.push(memento);
		redoStack.clear();
	}

	public Optional<ModelMemento> undo(ModelMemento currentState) {
		if (undoStack.isEmpty()) {
			return Optional.empty();
		}
		redoStack.push(currentState);
		return Optional.of(undoStack.pop());
	}

	public Optional<ModelMemento> redo(ModelMemento currentState) {
		if (redoStack.isEmpty()) {
			return Optional.empty();
		}
		undoStack.push(currentState);
		return Optional.of(redoStack.pop());
	}

	public List<ModelMemento> getHistory() {
		return Collections.unmodifiableList(new ArrayList<>(undoStack));
	}
}
