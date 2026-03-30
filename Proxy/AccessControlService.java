import java.util.HashSet;
import java.util.Set;

public class AccessControlService {
	private static AccessControlService instance;
	private Set<String> allowedPairs;

	private AccessControlService() {
		allowedPairs = new HashSet<>();
	}

	public static AccessControlService getInstance() {
		if (instance == null) {
			instance = new AccessControlService();
		}
		return instance;
	}

	public void grantAccess(String documentId, String username) {
		allowedPairs.add(username + ":" + documentId);
	}

	public boolean isAllowed(String documentId, String username) {
		return allowedPairs.contains(username + ":" + documentId);
	}
}
