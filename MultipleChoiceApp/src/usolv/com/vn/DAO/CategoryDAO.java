package usolv.com.vn.DAO;

import java.util.List;

import usolv.com.vn.entitys.CategoryEntity;

public interface CategoryDAO {
	public List<CategoryEntity> GetAllCategories();

	public String GetCategoryById(String categoryId);

	public boolean DeleteCategory(String categoryId);

	public boolean AddCategory(CategoryEntity categoryEntity);

	public boolean UpdateCategory(CategoryEntity categoryEntity);

	public CategoryEntity GetCategoryByCategoryId(String categoryId);

	public String convertCategoryId(String categoryId);
	
	public  String getCategoryId();

}
