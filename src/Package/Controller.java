package Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import javax.xml.soap.Text;
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
    private int lettersInputed;

    @FXML
    private Rectangle selectorRec;

    //    @FXML
    private Text text1;

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
            if (!stack.isEmpty() && row == 2 && column == 8) {
                Command command = stack.pop();
                command.undo();
            }

            //ENTER
            else if (lettersInputed == 3 && row == 2 && column == 9) {
                //TODO ENTER THEIR NAME AND GO TO NEXT SCREEN
            } else {
                Command command = new NameCommand(row, column, text1);
                command.execute();
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
        currentY -= 60;
        selectorRec.setY(currentY);
        if (row == 0)
            topRow = true;
        bottomRow = false;
    }

    private void moveDown() {
        row++;
        currentY += 60;
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
