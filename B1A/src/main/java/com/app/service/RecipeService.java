package com.app.service;

import java.util.List;

import com.app.pojos.Recipe;

public interface RecipeService {
    Recipe getRecipeById(Long recipeId);

    Recipe createRecipe(Recipe recipe);

    Recipe updateRecipe(Long recipeId, Recipe updatedRecipe);

    void deleteRecipe(Long recipeId);

    List<Recipe> getAllRecipes();
}

