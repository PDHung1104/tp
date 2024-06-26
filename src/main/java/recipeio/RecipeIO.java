package recipeio;

import recipeio.recipe.RecipeList;
import recipeio.storage.Storage;
import recipeio.ui.UI;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import static  recipeio.constants.RecipeIOConstants.MESSAGE_ASK_INPUT;
import static  recipeio.constants.RecipeIOConstants.EXIT_COMMAND;

/**
 * Main entry-point for the Recipe.IO application.
 */
public class RecipeIO {
    private static UI ui;
    private static final Logger logger = Logger.getLogger("RecipeIO Logger");
    private static final String PATH_TO_FILE = "data/recipe.txt";

    private final RecipeList recipeList;

    /**
     * Instantiates UI object, Storage object, and RecipeList object, for use during application run.
     *
     * @param filePath path to the file where recipe book is stored.
     */
    public RecipeIO(String filePath) {
        ui = new UI();
        Storage storage = new Storage(filePath);
        recipeList = new RecipeList(storage.loadData());
    }

    public void run() {
        UI.sayHi();
        runCommandLoopUntilExitCommand();
        UI.bye();
    }

    /**
     * Asks user for input. While the command is not 'exit', passes the input to RecipeList class to handle.
     */
    public void runCommandLoopUntilExitCommand() {
        logger.log(Level.INFO, MESSAGE_ASK_INPUT);
        String userInput = ui.getUserInput();
        String parsedCommand = InputParser.parseCommand(userInput);
        assert !userInput.isEmpty() : "user input empty";

        while (!parsedCommand.equals(EXIT_COMMAND)) {
            logger.log(Level.INFO, "Executing command: "+ userInput);
            recipeList.executeCommand(parsedCommand, userInput);
            logger.log(Level.INFO, MESSAGE_ASK_INPUT);
            userInput = ui.getUserInput();
            parsedCommand = InputParser.parseCommand(userInput);
        }

    }

    /**
     * Sets up logger object.
     */
    public static void setUpLogger() {
        LogManager.getLogManager().reset();
        logger.setLevel(Level.ALL);
        try {
            FileHandler fileHandler = new FileHandler("logger.log", false);
            fileHandler.setLevel(Level.INFO);
            logger.setLevel(Level.INFO);
            logger.addHandler(fileHandler);
            assert logger.getHandlers().length > 0 : "File handler not added to logger";
        } catch (IOException e){
            logger.log(Level.SEVERE, "File logger not working");
        }
    }

    /**
     * Main entry-point for the application.
     */
    public static void main(String[] args) {
        setUpLogger();
        new RecipeIO(PATH_TO_FILE).run();
    }
}
