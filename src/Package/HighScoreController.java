package Package;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Rectangle;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;

/**
 * NameSelectorController class for the name selector GUI
 */
public class HighScoreController {//implements Initializable {
    private HighScore highScore;
    private HashMap<String, String> highScores;
    private ArrayList<Label> names;

    @FXML
    private Label instructions;
    @FXML
    private Label name1;
    @FXML
    private Label name2;
    @FXML
    private Label name3;
    @FXML
    private Label name4;
    @FXML
    private Label name5;
    @FXML
    private Label name6;
    @FXML
    private Label name7;
    @FXML
    private Label name8;
    @FXML
    private Label name9;
    @FXML
    private Label name10;

    @FXML
    private Label score1;
    @FXML
    private Label score2;
    @FXML
    private Label score3;
    @FXML
    private Label score4;
    @FXML
    private Label score5;
    @FXML
    private Label score6;
    @FXML
    private Label score7;
    @FXML
    private Label score8;
    @FXML
    private Label score9;
    @FXML
    private Label score10;


    /**
     * Constructor that initializes variables
     */
    public HighScoreController() {
//        highScores = getHighScores();
//        for (String key : highScores.keySet())
//        {
//            name1.setText(key);
//        }
        names = new ArrayList<>();
        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);
        names.add(name6);
        names.add(name7);
        names.add(name8);
        names.add(name9);
        names.add(name10);

    }

    private void displayHighScores(){
//        highScores = getHighScores();
//        ScoreDatabase database = new ScoreDatabase("ArcadeGames");
//        database.getScores()

    }

    public HashMap<String, String> getHighScores(){
        return highScore.getHighScores();
    }

    public String getGameName(){return highScore.getGameName();}


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
    private void handleKeyPress(KeyEvent e) {
        if(e.getCode() == KeyCode.ENTER )
        {
            instructions.setText(getGameName());
            highScores = getHighScores();
            System.out.println(highScores);
            Set<String> keySet = highScores.keySet();
            ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
            Collection<String> values = highScores.values();
            ArrayList<String> listOfValues = new ArrayList<String>(values);
            try {
                name1.setText(listOfKeys.get(0));
                score1.setText(listOfValues.get(0));

                name2.setText(listOfKeys.get(1));
                score2.setText(listOfValues.get(1));

                name3.setText(listOfKeys.get(2));
                score3.setText(listOfValues.get(2));

                name4.setText(listOfKeys.get(3));
                score4.setText(listOfValues.get(3));

                name5.setText(listOfKeys.get(4));
                score5.setText(listOfValues.get(4));

                name6.setText(listOfKeys.get(5));
                score6.setText(listOfValues.get(5));

                name7.setText(listOfKeys.get(6));
                score7.setText(listOfValues.get(6));

                name8.setText(listOfKeys.get(7));
                score8.setText(listOfValues.get(7));

                name9.setText(listOfKeys.get(8));
                score9.setText(listOfValues.get(8));

                name10.setText(listOfKeys.get(9));
                score10.setText(listOfValues.get(9));
            } catch (Exception x){}
//            for(int i = 0; i < 10; i++)
//            {
//                Label name = names.get(i);
//                System.out.println(name);
//                name.setText(listOfKeys.get(i));
//            }
        }
//        highScores = getHighScores();
//        Set<String> keySet = highScores.keySet();
//        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
//        Collection<String> values = highScores.values();
//        ArrayList<String> listOfValues = new ArrayList<String>(values);
//        System.out.println("KEY " + listOfKeys.get(1));
//        System.out.println("VALUE " + listOfValues.get(1));
//        name1.setText(listOfKeys.get(1));
//        score1.setText(listOfValues.get(1));

    }

    public void initData(HighScore highScore) {
        this.highScore = highScore;
    }
//
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        instructions.setText(getGameName());
//        highScores = getHighScores();
//        Set<String> keySet = highScores.keySet();
//        ArrayList<String> listOfKeys = new ArrayList<String>(keySet);
//        Collection<String> values = highScores.values();
//        ArrayList<String> listOfValues = new ArrayList<String>(values);
//        name1.setText(listOfKeys.get(1));
//        score1.setText(listOfValues.get(1));
//
//        name2.setText(listOfKeys.get(2));
//        score2.setText(listOfValues.get(2));
//
//        name3.setText(listOfKeys.get(3));
//        score3.setText(listOfValues.get(3));
//
//        name4.setText(listOfKeys.get(4));
//        score4.setText(listOfValues.get(4));
//
//        name5.setText(listOfKeys.get(5));
//        score5.setText(listOfValues.get(5));
//
//        name6.setText(listOfKeys.get(6));
//        score6.setText(listOfValues.get(6));
//
//        name7.setText(listOfKeys.get(7));
//        score7.setText(listOfValues.get(7));
//
//        name8.setText(listOfKeys.get(8));
//        score8.setText(listOfValues.get(8));
//
//        name9.setText(listOfKeys.get(9));
//        score9.setText(listOfValues.get(9));
//
//        name10.setText(listOfKeys.get(10));
//        score10.setText(listOfValues.get(10));
//    }
}
