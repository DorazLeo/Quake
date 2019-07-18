package it.quake.controller.documental;

import it.quake.model.documental.Category;
import it.quake.repository.documental.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Controller to expone services for categories
 * @author Christopher Leofreddi
 */
@RequestMapping("category")
@Controller
public class CategoryController {
    @Autowired
    CategoryRepository categoryRepository;

    /**
     * Method for get every object from "category" table
     *
     * @return List of categories
     * @throws Exception
     */
    @RequestMapping(value = "/getAllCategories", method = RequestMethod.GET, produces = {"application/json"})
    public @ResponseBody
    List<Category> loadCategories() throws Exception {
        return categoryRepository.findAll();
    }

    /**
     * Method for save or update the object passed with param.
     * The method is going to run the "SAVE" query if id in the param is null.
     * The method is going to run the "UPDATE" query if id in the param is not null.
     *
     * @param category Category
     * @return Category saved or updated
     * @throws Exception
     */
    @RequestMapping(value = "/saveCategory", method = RequestMethod.POST, produces = {"application/json"})
    public Category saveCategory(@RequestBody Category category) throws Exception {
        return categoryRepository.save(category);
    }

    /**
     * Method for delete the object passed with param.
     *
     * @param category Category
     * @throws Exception
     */
    @RequestMapping(value = "/deleteCategory", method = RequestMethod.DELETE, produces = {"application/json"})
    public void deleteCategory(@RequestBody Category category) throws Exception {
        categoryRepository.delete(category);
    }

}
