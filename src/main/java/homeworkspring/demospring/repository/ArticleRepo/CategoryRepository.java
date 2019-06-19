package homeworkspring.demospring.repository.ArticleRepo;
import homeworkspring.demospring.repository.model.Article;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import homeworkspring.demospring.repository.model.Category;
import org.apache.ibatis.annotations.Insert;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryRepository {
    @Select("select * from tb_category")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    List<Category> findAll();
//    @Insert("INSERT INOT tb_category (name) values(#{name})");
//    boolean add(Category category);
}
