import java.time.LocalDate;

public class Main {
	public static void main(String[] args) {
		Library library = new Library();
		AccessControlService acs = AccessControlService.getInstance();

		library.addDocument("doc1", LocalDate.of(2024, 1, 10), "Public content of doc1");
		library.addProtectedDocument("doc2", LocalDate.of(2024, 3, 15), "Secret content of doc2");
		library.addProtectedDocument("doc3", LocalDate.of(2025, 6, 20), "Classified content of doc3");

		acs.grantAccess("doc2", "alice");
		acs.grantAccess("doc3", "alice");
		acs.grantAccess("doc2", "bob");

		User alice = new User("alice");
		User bob = new User("bob");
		User charlie = new User("charlie");

		DocumentInterface doc1 = library.getDocument("doc1");
		System.out.println("=== Unprotected document ===");
		System.out.println("ID: " + doc1.getId());
		System.out.println("Date: " + doc1.getCreationDate());
		try {
			System.out.println("Content (charlie): " + doc1.getContent(charlie));
		} catch (AccessDeniedException e) {
			System.out.println("Denied: " + e.getMessage());
		}

		DocumentInterface doc2 = library.getDocument("doc2");
		System.out.println("\n=== Protected document (doc2) ===");
		System.out.println("ID: " + doc2.getId());
		System.out.println("Date: " + doc2.getCreationDate());
		try {
			System.out.println("Content (alice): " + doc2.getContent(alice));
		} catch (AccessDeniedException e) {
			System.out.println("Denied: " + e.getMessage());
		}
		try {
			System.out.println("Content (bob): " + doc2.getContent(bob));
		} catch (AccessDeniedException e) {
			System.out.println("Denied: " + e.getMessage());
		}
		try {
			System.out.println("Content (charlie): " + doc2.getContent(charlie));
		} catch (AccessDeniedException e) {
			System.out.println("Denied: " + e.getMessage());
		}

		DocumentInterface doc3 = library.getDocument("doc3");
		System.out.println("\n=== Protected document (doc3) ===");
		System.out.println("ID: " + doc3.getId());
		System.out.println("Date: " + doc3.getCreationDate());
		try {
			System.out.println("Content (alice): " + doc3.getContent(alice));
		} catch (AccessDeniedException e) {
			System.out.println("Denied: " + e.getMessage());
		}
		try {
			System.out.println("Content (bob): " + doc3.getContent(bob));
		} catch (AccessDeniedException e) {
			System.out.println("Denied: " + e.getMessage());
		}
	}
}
