package usolv.com.vn.entitys;

public class CategoryEntity {
	private String categoryId;
	private String categoryName;
	private boolean status;

	public CategoryEntity() {
		super();
	}

	public CategoryEntity(String categoryId, String categoryName, boolean status) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.status = status;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
