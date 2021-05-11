package usolv.com.vn.DAO;

import java.util.List;

import usolv.com.vn.entitys.CategoryEntity;

public interface CategoryDAO {
	public List<CategoryEntity> GetAllCategories();

	public String GetCategoryByCategoryId(String categoryId);
}
