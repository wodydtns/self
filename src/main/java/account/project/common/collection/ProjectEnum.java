package account.project.common.collection;

public enum ProjectEnum {
	SESSION_ADMIN_KEY("ADMIN_login");
	
	private final String adminKey;

	private ProjectEnum(String adminKey) {
		this.adminKey = adminKey;
	}
	
	public String adminKey() {
		return adminKey;
	}
}
