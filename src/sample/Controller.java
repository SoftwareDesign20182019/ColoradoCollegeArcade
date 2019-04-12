package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.util.Stack;

public class Controller {
    private Main main;
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


    @FXML
    private Rectangle selectorRec;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    public Controller() {
        this.stack = new Stack<Command>();
        topRow = true;
        bottomRow = false;
        leftCol = true;
        rightCol = false;
    }

    @FXML
    public void handleButtonPress(ActionEvent event) {

    }

    @FXML
    private void handleKeyPress(KeyEvent e) {
        //ENTER
        if (e.getCode() == KeyCode.ENTER) {
//            choice = selection; //a method for selection
            System.out.println("ENTER");

            //BACKSPACE
            System.out.println(stack.isEmpty());
            if (!stack.isEmpty() && row == 2 && column == 8) {
                System.out.println("undo");
                Command command = stack.pop();
                command.undo();
                lettersInputed--;
            }

            //ENTER
            else if (lettersInputed == 3 && row == 2 && column == 9) {
                String name = letterOne + letterTwo + letterThree;
                System.out.println(name);
                System.exit(0);
                //TODO ENTER THEIR NAME AND GO TO NEXT SCREEN
            } else if (!(row == 2 && column == 9) && !(row == 2 && column == 8)) {
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


    private void moveUp() {
        row--;
        currentY -= 55;
        selectorRec.setY(currentY);
        if (row == 0)
            topRow = true;
        bottomRow = false;
    }

    private void moveDown() {
        row++;
        currentY += 55;
        selectorRec.setY(currentY);
        if (row == 2)
            bottomRow = true;
        topRow = false;
    }

    private void moveLeft() {
        column--;
        currentX -= 45;
        selectorRec.setX(currentX);
        if (column == 0)
            leftCol = true;
        rightCol = false;
    }

    private void moveRight() {
        column++;
        currentX += 45;
        selectorRec.setX(currentX);
        if (column == 9)
            rightCol = true;
        leftCol = false;
    }
}
