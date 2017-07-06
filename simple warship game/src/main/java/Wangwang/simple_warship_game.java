import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by defiance on 2017/6/26.
 */
import java.util.ArrayList;
public class simple_warship_game {
    private ArrayList<warship> warfleet=new ArrayList<warship>();
    private int sunken=0;
    private int guesscounter=0;
    private Gamehelper helper=new Gamehelper();

    public void warship_gener(int ship_length)
    {
        warship warship1=new warship();
        warship warship2=new warship();
        warship warship3=new warship();
        warship1.setName("Rodney");
        warship2.setName("Nelson");
        warship3.setName("Warspite");
        warfleet.add(warship1);
        warfleet.add(warship2);
        warfleet.add(warship3);
        for(warship tmp:warfleet)
        {
            ArrayList<String> location=helper.mapping(2);
            tmp.setLocation(location);
        }
        System.out.println("The HMS warfleet has arrived.");
    }

    public void game_start()
    {
        while(!warfleet.isEmpty())
        {
            String guess=helper.getString("enter the firespot(ex. a3)(no more than g7)");
            check(guess);
        }
    }

    public String check(String guessString)
    {
        guesscounter++;
        String result="miss";
        for(warship underattack:warfleet)
        {
            System.out.println(guessString);
            if(underattack.isHit(guessString))
            {
                if(underattack.isAlive())
                {
                    result="hit";
                    break;
                }
                else
                {
                    result="sunk";
                    warfleet.remove(underattack);
                    sunken++;
                    break;
                }
            }
            else
            {
                System.out.println("missed out");
                result="miss";
            }
        }
        return result;
    }


    public void endgame()
    {
        System.out.println("the HMS has been defeated;");
    }


}
