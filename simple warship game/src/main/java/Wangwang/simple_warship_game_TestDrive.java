import java.util.ArrayList;

/**
 * Created by defiance on 2017/6/26.
 */
public class simple_warship_game_TestDrive {
    public static void main(String[] args) {
        int numOfGuesses=0;
        simple_warship_game game0 = new simple_warship_game();
        game0.warship_gener(2);
        game0.game_start();
        game0.endgame();

    }


}
