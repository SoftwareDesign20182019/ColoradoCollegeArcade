package Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

/**
 * NameSelectorController class for the name selector GUI
 */
public class NameSelectorController {
    private int row = 0;
    private int column = 0;
    private boolean topRow;
    private boolean bottomRow;
    private boolean leftCol;
    private boolean rightCol;
    private int currentX = 76;
    private int currentY = 338;
    private Stack<Command> stack;
    private int lettersInputed = 0;
    private String letterOne;
    private String letterTwo;
    private String letterThree;
    private NameSelector nameSelector;


    @FXML
    private Rectangle selectorRec;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    /**
     * Constructor that initializes variables
     */
    public NameSelectorController() {
        this.stack = new Stack<Command>();
        topRow = true;
        bottomRow = false;
        leftCol = true;
        rightCol = false;
    }

    /**
     * Button press event necessary for functionality because of weird button bug
     *
     * @param event - button press
     */
    @FXML
    public void handleButtonPress(ActionEvent event) {

    }

    /**
     * Handles key presses and does different actions based on the key pressed and the state
     * @param e - the key event
     */
    @FXML
    private void handleKeyPress(KeyEvent e) throws Exception{
        //ENTER
        if (e.getCode() == KeyCode.ENTER) {

            //BACKSPACE
            if (!stack.isEmpty() && row == 2 && column == 8) {
                Command command = stack.pop();
                command.undo();
                lettersInputed--;
            }

            //ENTER
            else if (lettersInputed == 3 && row == 2 && column == 9) {
                String name = letterOne + letterTwo + letterThree;
                returnName(name);
//                System.exit(0);
                //TODO GO TO NEXT SCREEN
            }

            //LETTER SELECTION
            else if (!(row == 2 && column == 9) && !(row == 2 && column == 8)) {
                switch (lettersInputed) {
                    case 0:
                        Command commandOne = new NameCommand(row, column, label1);
                        letterOne = commandOne.execute();
                        stack.push(commandOne);

                        lettersInputed++;
                        break;
                    case 1:
                        Command commandTwo = new NameCommand(row, column, label2);
                        letterTwo = commandTwo.execute();
                        stack.push(commandTwo);
                        lettersInputed++;
                        break;
                    case 2:
                        Command commandThree = new NameCommand(row, column, label3);
                        letterThree = commandThree.execute();
                        stack.push(commandThree);
                        lettersInputed++;
                        break;
                }

            }
        }
        //MOVE UP
        else if (!topRow && e.getCode() == KeyCode.W) {
            moveUp();

        }

        //MOVE DOWN
        else if (!bottomRow && e.getCode() == KeyCode.S) {
            moveDown();
        }

        //MOVE LEFT
        else if (!leftCol && e.getCode() == KeyCode.A) {
            moveLeft();
        }

        //MOVE RIGHT
        else if (!rightCol && e.getCode() == KeyCode.D) {
            moveRight();
        }
    }

    /**
     * Move the cursor one letter up
     */
    private void moveUp() {
        row--;
        currentY -= 55;
        selectorRec.setY(currentY);
        if (row == 0)
            topRow = true;
        bottomRow = false;
    }

    /**
     * Moves the cursor one letter down
     */
    private void moveDown() {
        row++;
        currentY += 55;
        selectorRec.setY(currentY);
        if (row == 2)
            bottomRow = true;
        topRow = false;
    }

    /**
     * Moves the cursor one letter left
     */
    private void moveLeft() {
        column--;
        currentX -= 45;
        selectorRec.setX(currentX);
        if (column == 0)
            leftCol = true;
        rightCol = false;
    }

    /**
     * Moves the cursor one letter right
     */
    private void moveRight() {
        column++;
        currentX += 45;
        selectorRec.setX(currentX);
        if (column == 9)
            rightCol = true;
        leftCol = false;
    }

    private void returnName(String name) throws Exception{
        nameSelector.setName(name);
        nameSelector.finishGame();
    }

    void initData(NameSelector nameSelector) {
        this.nameSelector = nameSelector;
    }
}
