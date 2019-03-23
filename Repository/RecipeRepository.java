package Repository;

import Model.Recipe;
import Model.Utils.*;

public class RecipeRepository {
    MyList<Recipe> cookbook;
    int current_recipe;
    int total_recipes;

    // constructors
    public RecipeRepository() { current_recipe = 0; total_recipes = 0; cookbook = new MyList<Recipe>(); }
    public RecipeRepository(MyList<Recipe> c, int current, int total) { cookbook = c; current_recipe = current; total_recipes = total; }

    // getters
    public MyList<Recipe> getCookbook() {
        return cookbook;
    }
    public int getCurrent_recipe() {
        return current_recipe;
    }
    public int getTotal_recipes() {
        return total_recipes;
    }

    public void addRecipe(Recipe r){
        cookbook.push(r);
    }

    public void showRecipes(){
        System.out.print(cookbook.toStr());
    }
}

