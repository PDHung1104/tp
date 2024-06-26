//@@author PDHung1104
package recipeio.ui;

import recipeio.recipe.Recipe;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * UI class is responsible for handling user interface.
 */
public class UI {
    public static final String SEPARATOR = "---------------------------------------------------";

    private final Scanner in;

    /**
     * Constructor for UI.
     */
    public UI() {
        this(System.in);
    }

    /**
     * Constructor for UI.
     *
     * @param in InputStream object.
     */
    public UI (InputStream in) {
        this.in = new Scanner(in);
    }

    /**
     * Prints a line separator.
     */
    public static void printLine() {
        System.out.println(SEPARATOR);
    }

    /**
     * Asks user for input in console.
     */
    public String getUserInput() {
        printLine();
        System.out.print("\t");
        String fullInputLine = in.nextLine();
        printLine();
        return fullInputLine;
    }

    /**
     * Greets the user.
     */
    public static void sayHi() {
        printLine();
        System.out.println("Welcome to Recipe.io! How can I help you today chef?");
    }

    /**
     * Prints a message to the user.
     *
     * @param message The message to be printed.
     */
    public static void printMessage(String message) {
        printLine();
        System.out.println(message);
        printLine();
    }

    /**
     * Prints list of valid sort types.
     */
    public static void printSortTypes() {
        System.out.println("These are the valid sort type inputs:");
        System.out.println("\tsortname: Sort the list by name in lexicographically ascending order");
        System.out.println("\tsortdate: Sort the list by date in ascending order i.e. from oldest to newest");
        System.out.println("\tsortcooktime: Sort the list by cook time in ascending order");
        System.out.println("\tsortcalories: Sort the list by calories in ascending order");
    }

    //@@author nidhi-nayak
    /**
     * Reports to the user that a recipe has been added successfully.
     * Also reports the number of recipes in the recipe book.
     *
     * @param recipe The recipe that was added.
     * @param recipeListSize The size of the recipe book.
     */
    public static void printAddMessage(Recipe recipe, int recipeListSize) {
        System.out.println("Woo hoo chef! I have added this recipe to your recipe book:");
        System.out.print("\t");
        System.out.print(recipe.toString());
        System.out.println("\nYou now have " + recipeListSize + " recipes in your recipe book. Keep adding some!");
    }

    /**
     * Reports to the user that a recipe has been deleted successfully.
     * Also reports the number of recipes in the recipe book.
     *
     * @param recipe The recipe that was deleted.
     * @param recipeListSize The size of the recipe book.
     */
    public static void printDeleteMessage(Recipe recipe, int recipeListSize) {
        System.out.println("Okay chef! I have deleted this recipe from your recipe book:");
        System.out.print("\t");
        System.out.print(recipe.toString());
        System.out.println("\nYou now have " + recipeListSize + " recipes in your recipe book. Keep adding some!");
    }

    /**
     * Prints the valid meal categories.
     */
    public static void printValidMealCategories() {
        System.out.println("Accepted meal categories are:");
        System.out.println("\tBreakfast");
        System.out.println("\tLunch");
        System.out.println("\tDinner");
        System.out.println("\tDessert");
        System.out.println("\tAppetizer");
        System.out.println("\tGeneral");
    }

    /**
     * Prints list of accepted instructions.
     */
    public static void printInstructions(){
        System.out.println("Here are all of my accepted commands:\n");
        System.out.println("help: shows available commands\n");
        System.out.println("list: shows you list of recipes");
        System.out.println("\tInput Example: list\n");
        System.out.println("list SORT_TYPE: shows list of recipes sorted by different filters");
        System.out.println("These filters include sortname, sortdate, sortcooktime, sortcalories");
        System.out.println("\tInput Example: list sortname\n");
        System.out.println("add NAME, MINUTES, KCALS, SINGULAR-TENSE SLASH-SEPARATED ALLERGIES, CATEGORY, " +
                "URL: adds a recipe");
        System.out.println("\tInput Example: add pizza, 34, 340, egg/nut/dairy/red meat, dinner, www.food.com\n");
        System.out.println("detail RECIPE_NUMBER: shows you a detailed view of a recipe");
        System.out.println("\tInput Example: detail 1\n");
        System.out.println("delete RECIPE_NUMBER: deletes a recipe with a given recipe number");
        System.out.println("\tInput Example: delete 1\n");
        System.out.println("find kw KEYWORD: finds recipes with a given keyword");
        System.out.println("\tInput Example: find kw pizza\n");
        System.out.println("find date YYYY-MM-DD: finds recipes added on a given date");
        System.out.println("\tInput Example: find date 2024-03-28\n");
        System.out.println("find url VALID_URL: finds recipes with the valid url given ");
        System.out.println("\tInput Example: find url www.food.com\n");
        System.out.println("find meal MEAL_CATEGORY: finds recipes with a particular meal category");
        System.out.println("\tInput Example: find meal dinner\n");
        System.out.println("filter ALLERGY: lists the recipes that do not contain this allergen");
        System.out.println("\tInput Example: filter dairy\n");
        System.out.println("exit: to leave the program");
    }

    /**
     * Prints list of recipes. Refer to toString() method in Recipe class for implementation.
     */
    public static void printRecipes(ArrayList<Recipe> matches, ArrayList<Integer> listNumbers) {
        for (int i = 0; i < matches.size(); i++) {
            int number = listNumbers.get(i);
            Recipe recipe = matches.get(i);
            System.out.println("Recipe " + number + ". " + recipe);
        }
    }

    /**
     * Prints warning when an unrecognised command is entered.
     */
    public static void printInvalidCommandWarning() {
        System.out.println("The command you entered is invalid.\n" +
                "Please try another command, or enter 'help' to see all possible commands.");
    }

    /**
     * Bids farewell to the user.
     */
    public static void bye() {
        System.out.println("Okay, thanks for using RecipeIO! See you later chef!");
        printLine();
    }
}
