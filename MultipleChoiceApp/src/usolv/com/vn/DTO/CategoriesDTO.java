package usolv.com.vn.DTO;

import java.util.ArrayList;
import java.util.List;

import usolv.com.vn.DAO.CategoryDAO;
import usolv.com.vn.DAO.Impl.CategoryDAOImpl;
import usolv.com.vn.entitys.CategoryEntity;

public class CategoriesDTO {
	private int id;
	private String categoryId;
	private String categoryName;
	private boolean status;

	public CategoriesDTO() {
		super();
	}

	public CategoriesDTO(int id, String categoryId, String categoryName, boolean status) {
		super();
		this.id = id;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<CategoriesDTO> GetAllCategoriesDTO() {
		int index = 1;
		CategoryDAO categoryDAO = new CategoryDAOImpl();
		List<CategoriesDTO> listCategoriesDTO = new ArrayList<CategoriesDTO>();
		List<CategoryEntity> listUserEntity = categoryDAO.GetAllCategories();
		for (CategoryEntity categoryEntity : listUserEntity) {
			CategoriesDTO categoriesDTO = new CategoriesDTO();
			categoriesDTO.setId(index);
			categoriesDTO.setCategoryId(categoryEntity.getCategoryId());
			categoriesDTO.setCategoryName(categoryEntity.getCategoryName());
			categoriesDTO.setStatus(categoryEntity.isStatus());
			index++;
			listCategoriesDTO.add(categoriesDTO);
		}
		return listCategoriesDTO;
	}
}
