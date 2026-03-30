import java.time.LocalDate;

public class DocumentProxy implements DocumentInterface {
	private Document document;
	private AccessControlService accessControlService;

	public DocumentProxy(Document document) {
		this.document = document;
		this.accessControlService = AccessControlService.getInstance();
	}

	@Override
	public String getId() {
		return document.getId();
	}

	@Override
	public LocalDate getCreationDate() {
		return document.getCreationDate();
	}

	@Override
	public String getContent(User user) throws AccessDeniedException {
		if (!accessControlService.isAllowed(document.getId(), user.getUsername())) {
			throw new AccessDeniedException(
				"Access denied for user '" + user.getUsername() + "' on document '" + document.getId() + "'"
			);
		}
		return document.getContent(user);
	}
}
