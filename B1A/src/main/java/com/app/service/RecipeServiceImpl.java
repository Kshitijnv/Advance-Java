package com.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.RecipeRepository;
import com.app.pojos.Recipe;

@Service
public class RecipeServiceImpl implements RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    public Recipe getRecipeById(Long recipeId) {
        return recipeRepository.findById(recipeId).orElse(null);
    }

    @Override
    public Recipe createRecipe(Recipe recipe) {
        recipe.setCreationDate(new Date());
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe updateRecipe(Long recipeId, Recipe updatedRecipe) {
        Recipe existingRecipe = recipeRepository.findById(recipeId).orElse(null);
        if (existingRecipe != null) {
            // Update fields based on your requirements
            existingRecipe.setTitle(updatedRecipe.getTitle());
            existingRecipe.setDescription(updatedRecipe.getDescription());
            // Update other fields as needed
            return recipeRepository.save(existingRecipe);
        }
        return null;
    }

    @Override
    public void deleteRecipe(Long recipeId) {
        recipeRepository.deleteById(recipeId);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}

