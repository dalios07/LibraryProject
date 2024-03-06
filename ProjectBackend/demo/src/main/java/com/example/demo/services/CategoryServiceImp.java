package com.example.demo.services;
import com.example.demo.Enums.status;
import com.example.demo.Exceptions.ResourceNotFoundException;
import com.example.demo.dtos.CategoryDto;
import com.example.demo.entites.Category;
import com.example.demo.mappers.CategoryMapper;
import com.example.demo.repositories.CategoryRepo;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryServiceImp implements CategoryService {


    private final CategoryRepo categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public Page<CategoryDto> findAll(Pageable pageable) {
        Page<Category> categories = categoryRepository.findAll(pageable);

        return categories.map(category -> categoryMapper.toCategoryDto(category));
    }
    @Override
    public Category findByNameAndStatus (String name)
    {
        if (!categoryRepository.existsByNameAndStatus(name,status.ACTIVATED)) {
            throw new ResourceNotFoundException("Category not found with name " + name);}
        return categoryRepository.findByNameAndStatus(name, status.ACTIVATED);
    }

    @Override
    public Category addCategory(CategoryDto CategoryDto) {

        return (categoryRepository.save(categoryMapper.toCategory(CategoryDto)));
    }

    @Override
    public void deleteCategory(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found with id " + id);
        }
        categoryRepository.deleteById(id);
    }

}
