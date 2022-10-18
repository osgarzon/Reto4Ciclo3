package co.usa.reto3.reto3.repository;

import co.usa.reto3.reto3.model.Booking;
import co.usa.reto3.reto3.model.Category;
import co.usa.reto3.reto3.repository.crud.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

    @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public List<Category> getAll(){
        return (List<Category>) categoryCrudRepository.findAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryCrudRepository.findById(id);
    }

    public Category save(Category ca){
        return categoryCrudRepository.save(ca);
    }

    public void delete (Category category){
        categoryCrudRepository.delete(category);
    }
}
