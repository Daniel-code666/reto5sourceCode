
package com.reto3.sa.practica.reto3grupo05g8.service;

import com.reto3.sa.practica.reto3grupo05g8.entity.Category;
import com.reto3.sa.practica.reto3grupo05g8.entity.Client;
import com.reto3.sa.practica.reto3grupo05g8.repository.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.reto3.sa.practica.reto3grupo05g8.repository.ClientRepository;

/**
 *
 * @author G5
 */
@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repo;
   
    public List<Category> listCategory(){
        return repo.findAll();
    }
    
    public Category listCategoryById(Category category){
        return repo.findById(category.getId()).orElse(null);
    }
   
    public Category insertCategory(Category category){
        return repo.save(category);
    }
    
    public Category updtCategory(Category category){
        Category checkIfExist = repo.findById(category.getId()).orElse(null);
        
        checkIfExist.setName(category.getName());
        checkIfExist.setDescription(category.getDescription());
        return repo.save(checkIfExist);
    }
 
    public void delCategory(int id){
        repo.deleteById(id);

    }
}
