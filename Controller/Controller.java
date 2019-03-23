package Controller;

import Model.IngredientQuantity;
import Model.Recipe;
import Repository.RecipeRepository;

public class Controller {

    RecipeRepository repository;

    public Controller() {
    }
    public Controller(RecipeRepository r) {
        repository = r;
    }

   //Getters and setters
    public RecipeRepository getRepository() {
        return repository;
    }
    public void setRepository(RecipeRepository repository) {
        this.repository = repository;
    }

    public void addRecipeC(Recipe r){
        repository.addRecipe(r);
    }

    public void showRecipesC(){
        repository.showRecipes();
    }

}
