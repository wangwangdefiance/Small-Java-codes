import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by defiance on 2017/6/26.
 */
public class warship {
    private String name="untiltled";
    private ArrayList<String> location_cell;
    private boolean isAlive=true;

    public void setName(String newname)
    {
        name=newname;
    }

    public void setLocation(ArrayList<String> cells)
    {
        location_cell=cells;
    }

    public boolean isAlive()
    {return isAlive;}

    public boolean isHit(String guess)
    {
        boolean flag=false;
        int index=location_cell.indexOf(guess);
        System.out.println(index);
                if(index<0)
                {
                            return false;
                }
                else
                {
                    System.out.print("hit\n");
                    location_cell.remove(guess);
                    flag=true;
                    if(location_cell.isEmpty())
                    {
                        isAlive=false;
                        System.out.println(name+"is sunken\n");
                    }
                }
        return flag;
    }
}
