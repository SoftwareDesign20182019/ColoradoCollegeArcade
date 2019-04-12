package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Command class for selecting a letter and changing the corresponding label to that letter
 */
public class NameCommand implements Command {
    private int row;
    private int col;
    private int cursor;
    private String[][] alphabet;

    @FXML
    private Label label;


    /**
     * Constructor that takes the arguments for this instance of the command
     * Initializes the 2dArray of the alphabet
     *
     * @param row   - the row number when enter was pressed
     * @param col   - the column number when enter was pressed
     * @param label - the label to be changed
     */
    public NameCommand(int row, int col, Label label) {
        this.row = row;
        this.col = col;
        this.label = label;
        alphabet = new String[3][10];
        alphabet[0][0] = "A";
        alphabet[0][1] = "B";
        alphabet[0][2] = "C";
        alphabet[0][3] = "D";
        alphabet[0][4] = "E";
        alphabet[0][5] = "F";
        alphabet[0][6] = "G";
        alphabet[0][7] = "H";
        alphabet[0][8] = "I";
        alphabet[0][9] = "J";

        alphabet[1][0] = "K";
        alphabet[1][1] = "L";
        alphabet[1][2] = "M";
        alphabet[1][3] = "N";
        alphabet[1][4] = "O";
        alphabet[1][5] = "P";
        alphabet[1][6] = "Q";
        alphabet[1][7] = "R";
        alphabet[1][8] = "S";
        alphabet[1][9] = "T";

        alphabet[2][0] = "U";
        alphabet[2][1] = "V";
        alphabet[2][2] = "W";
        alphabet[2][3] = "X";
        alphabet[2][4] = "Y";
        alphabet[2][5] = "Z";
        alphabet[2][6] = ".";
        alphabet[2][7] = "-";
        alphabet[2][8] = " ";
        alphabet[2][9] = "*";

    }

    /**
     * Sets the texts of the label to the indicated letter
     * @return - the letter selected
     */
    @Override
    public String execute() {

        label.setText(alphabet[row][col]);
        return alphabet[row][col];
    }


    /**
     * Sets the label to a space, appearing blank
     */
    @Override
    public void undo() {
        label.setText(alphabet[2][8]);
    }
}
