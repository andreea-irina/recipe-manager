package Model;

public class IngredientQuantity {
    String quantity;
    Ingredient ingredient;

    public IngredientQuantity() {};
    public IngredientQuantity(String q,Ingredient i) {

        quantity=q;
        ingredient=i;
    }

    //Getters
    public String getQuantity() {
        return quantity;
    }
    public Ingredient getIngredient() {
        return ingredient;
    }

    //Setters
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    //to string
    public String toString(){

        return quantity + " " + ingredient.getName();
    }
}
