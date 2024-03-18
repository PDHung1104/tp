package recipeio.recipe;

import ui.UI;

import java.util.ArrayList;


public class RecipeList {
    /**
     * Represents the user's list of recipes (ie their recipe book).
     */
    private final ArrayList<Recipe> recipes;

    /**
     * Constructor for RecipeList.
     */
    public RecipeList() {
        recipes = new ArrayList<>();
    }

    /**
     * Deletes the Recipe from the recipe list.
     *
     * @param recipeNumber The recipe number from the user.
     */
    public void deleteRecipe(int recipeNumber) {
        recipeNumber = recipeNumber - 1;
        if (recipeNumber >= recipes.size() || recipeNumber < 0) {
            System.out.println("Sorry, there were no recipes with that number.");
        } else {
            Recipe selectedRecipe = recipes.get(recipeNumber);
            recipes.remove(recipeNumber);
            System.out.println("Deleted that recipe!");
        }
    }

    /**
     * Adds a recipe to the list.
     *
     * @param recipe The new recipe to be added.
     */
    public void addRecipe(Recipe recipe) {
        //this try-catch block can be helpful when there's not enough memory for a new recipe in the list
        try {
            recipes.add(recipe); //TaskList<T> add method only throw IndexOutOfBound exception for the overload add(int, T).
        } catch (Exception e) {
            UI.printMessage(e.toString());
        }
    }

    /**
     * Returns the size of the list (recipe book).
     *
     * @return The size of the list (recipe book).
     */
    public int getSize() {
        return recipes.size();
    }

    /**
     * Returns the recipe at the specified index.
     *
     * @param index The index of the recipe.
     * @return The recipe at the specified index.
     */
    public Recipe get(int index) {
        return recipes.get(index);
    }

    /**
     * Prints the recipes in the list.
     */
    public void printRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("Sorry, there are no recipes in your recipe book to print.");
        } else {
            int counter = 0;
            StringBuilder output = new StringBuilder();
            while (counter < recipes.size()) {
                String recipeNumber = Integer.toString(counter + 1);
                Recipe selected = recipes.get(counter);
                output.append(selected.toString());
                if (counter != recipes.size() - 1) {
                    output.append("\n");
                }
                counter += 1;
            }
            System.out.println(output);
        }
    }

    /**
     * Finds the recipes with key name in recipe book.
     *
     * @param keyword The keyword that the user passes in.
     */
    public void findRecipe(String keyword) {
        RecipeList matches = new RecipeList();
        if (recipes.isEmpty()) {
            System.out.println("Sorry, you have no recipes to find matches with. Try adding some!");
        } else {
            for (int i = 0; i < recipes.size(); i += 1) {
                if (recipes.get(i).name.contains(keyword)) {
                    matches.addRecipe(recipes.get(i));
                }
            }
            if (matches.getSize() == 0) {
                System.out.println("There were no matches. Try searching for something else.");
            } else {
                int counter = 0;
                StringBuilder output = new StringBuilder();
                while (counter < matches.getSize()) {
                    String recipeNumber = Integer.toString(counter + 1);
                    Recipe selected = matches.get(counter);
                    output.append(selected.toString());
                    if (counter != matches.getSize() - 1) {
                        output.append("\n");
                    }
                    counter += 1;
                }
                System.out.println("Here are your matches:\n" + output);
            }
        }
    }
}
