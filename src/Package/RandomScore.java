package Package;
import java.util.Random;

public class RandomScore implements Game {

    public int playGame(){
        return scoreGame();
    }

    private int scoreGame(){
        return (int) (Math.random() * 10);
    }
    
    public String getName() {
    	Random r = new Random();
    	String name = "";
    	for (int i = 0; i < 3; i++) {
    		char letterInName = (char)(r.nextInt(26) + 'a');
    		name = name + letterInName;
    	}
    	return name;
    }
    
    public String toString() {
    	return "RandomScore";
    }
}
