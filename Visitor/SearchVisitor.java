import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
	private String extension;
	private List<File> results = new ArrayList<>();

	public SearchVisitor(String extension) {
		this.extension = extension;
	}

	@Override
	public void visitFile(File file) {
		if (file.getExtension().equalsIgnoreCase(extension)) {
			results.add(file);
		}
	}

	@Override
	public void visitDirectory(Directory directory) {
		for (FileSystemElement child : directory.getChildren()) {
			child.accept(this);
		}
	}

	public List<File> getResults() {
		return results;
	}
}
