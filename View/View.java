package View;

import  Controller.Controller;
import Model.Ingredient;
import Model.IngredientQuantity;
import Model.Recipe;
import Model.Utils.MyIList;
import Model.Utils.MyList;
import java.lang.Integer;
import java.util.*;

public class View {
    Controller ctrl;
    //Scanner scanner = new Scanner(System.in);

    public View() {
    }
    public View(Controller ctrl) {
        this.ctrl = ctrl;
    }

    public void menu(){
        System.out.print("\nMain Menu\n");
        System.out.print("1 - Show all recipes \n");
        System.out.print("2 - Add a recipe \n");
        System.out.print("3 - Exit the menu \n");
        System.out.print("Choose an option: \n");
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        int k = 1;
       // String opt="2";

       //String opt = scanner.next();
        while (k == 1) {
            menu();
            String opt = scanner.next();
            if (opt.equals("1")) {
                ctrl.showRecipesC();
            } else if (opt .equals( "2")) {
                addRecipeV();
            } else {
                k = 0;
            }
        }
    }

    public  MyList<IngredientQuantity> addIngredientQuantity (){
        Scanner scanner = new Scanner(System.in);
        //se populeaza un vector cu Obiecte de tip IngredientQuantity , care urmeaza a fi folosit in
        //interiorul  functiei addRecipeV , pentru obictul Recipe , in cadrul unui for , deoarece
        //obiectul Recipe are metoda de a adauga un obiect de tip IngredientQuantity

        //vectorul in care se aduna obiectele:
        MyList<IngredientQuantity> vector = new MyList<IngredientQuantity>();

        //k will be control variable . When k is 0 the IQ objects input stops.
        int k = 1;
        while (k == 1){
            //for ingredient part:
            System.out.print("The name of the ingredient is: ");
            String name = scanner.nextLine();

            System.out.print("The food group of the ingredient is: ");
            String category = scanner.nextLine();

            Ingredient i = new Ingredient(name,category);
            //for IQ:
            System.out.print("The quantity is(g): ");
            String q = scanner.nextLine();
            //int qu = Integer.parseInt(q);
            //Create IQ;
            IngredientQuantity iq = new IngredientQuantity(q,i);

            //We add the instance to the vector:
            vector.push(iq);

            //We ask the user if he wants to add another ingredient
            System.out.print("Would you like to add another ingredient? type 1 if so, 0 otherwise. ");
            String opt = scanner.nextLine();
            if(opt.equals("0")){
                k = 0;
            }
        }
        return vector;
    }

    public  MyList<String> addStep(){
        Scanner scanner = new Scanner(System.in);
        //vectorul in care se aduna obiectele:
        MyList<String> vector = new MyList<String>();

        int k = 1;
        while(k == 1) {
            System.out.print("Describe the step: ");
            String step = scanner.nextLine();
            vector.push(step);

            System.out.print("Would you like to add another step? type 1 if so, 0 otherwise. ");
            String opt = scanner.nextLine();
            if(opt.equals("0")){
                k = 0;
            }
        }
        return vector;
    }

    public void addRecipeV(){
        Scanner scanner = new Scanner(System.in);
        //se creeaza doi vectori tip myList  cu obiecte IngredientsQuantity (ingred) si String (steps)
        //se creeaza un obiect nou reteta , cu datele de la user.

        System.out.print("The name of the recipe is: ");
        String name = scanner.nextLine();
        System.out.print("Preping time(min): ");
        String prep = scanner.nextLine();
        System.out.print("Cooking time(min): ");
        String cook = scanner.nextLine();
        System.out.print("Category(dinner, breakfast etc.): ");
        String category = scanner.nextLine();
        System.out.print("The ingredients are as follows: ");
        //perform the necessary conversions:
        int p = Integer.valueOf(prep);
        int c = Integer.valueOf(cook);

        MyList<IngredientQuantity> ig = addIngredientQuantity();
        MyList<String> st = addStep();

        //We create the obj Recipe:
        Recipe r = new Recipe(name, st, p, c, category, ig);

        //Now we call the addRecipe from ctrl:
        ctrl.addRecipeC(r);
    }
}
