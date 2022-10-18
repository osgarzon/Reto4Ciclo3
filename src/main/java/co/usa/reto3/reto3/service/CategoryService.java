package co.usa.reto3.reto3.service;

import co.usa.reto3.reto3.model.Category;
import co.usa.reto3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c) {
        if (c.getId() == null) {
            return categoryRepository.save(c);
        } else {
            Optional<Category> caux = categoryRepository.getCategory(c.getId());
            if (caux.isEmpty()) {
                return categoryRepository.save(c);
            } else {
                return c;
            }
        }
    }

    public Category update(Category c) {
        if (c.getId() != null) {
            Optional<Category> caux = categoryRepository.getCategory(c.getId());
            if (!caux.isEmpty()) {
                if (c.getDescription() != null) {
                    caux.get().setDescription(c.getDescription());
                }
                if (c.getName() != null) {
                    caux.get().setName(c.getName());
                }
                return categoryRepository.save(caux.get());
            }
        }
        return c;
    }

    public boolean delete(int id) {
        Boolean result = getCategory(id).map(elemento -> {
            categoryRepository.delete(elemento);
            return true;
        }).orElse(false);
        return result;
    }
}
