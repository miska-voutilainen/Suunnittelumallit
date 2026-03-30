import java.time.LocalDate;
import java.util.HashMap;

public class Library {
	private HashMap<String, DocumentInterface> documents;

	public Library() {
		documents = new HashMap<>();
	}

	public void addDocument(String id, LocalDate date, String content) {
		documents.put(id, new Document(id, date, content));
	}

	public void addProtectedDocument(String id, LocalDate date, String content) {
		Document document = new Document(id, date, content);
		documents.put(id, new DocumentProxy(document));
	}

	public DocumentInterface getDocument(String id) {
		return documents.get(id);
	}
}
