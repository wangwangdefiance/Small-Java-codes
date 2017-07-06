/**
 * Created by defiance on 2017/6/26.
 */
//this helper class create the grid implicitly
//the getstring method takes an integer number to be the guess of the player;
//the mapping method takes an integer number to be the length of the ship;and returns a ArrayList<String> object
//in which the location of the ship with the format like (2,a) is stored implicitly.
//every time the mapping method is call will cause a new ship to spouse.
import java.io.*;
import java.util.ArrayList;

public class Gamehelper {
    private static final String alphabet="abcdefg";
    private int gridlength=7;
    private int gridsize=49;
    private int [] gridflag=new int[gridsize];
    private int counter=0;

    public String getString(String input) {
        String inputline=null;
        System.out.println(input+"　");
        try{
            BufferedReader is=new BufferedReader(new InputStreamReader(System.in));
            inputline=is.readLine();
            if(inputline.length()==0)return null;
        }
        catch(IOException e){
            System.out.println("IOExeption:"+ e);
        }
        return inputline.toLowerCase();
    }

    public ArrayList<String> mapping(int ship_size)
    {
        ArrayList<String> alpha_cell = new ArrayList<String>();
        String [] alphacoords= new String[ship_size];
        String tmp=null;
        int [] coords=new int[ship_size];
        int attempts=0;
        boolean isSuccess=false;
        int location=0;

        counter++;
        int incr=1;
        if((counter%2)==1)
        {
            incr=gridlength;
        }//these means that the 1st warship will be put row-wards while the 2nd warship will be put column-wards, and so on.

        while(!isSuccess)//finite attempts in case of timeout.
        {
            System.out.println("try\n");
            location=(int)(Math.random()*gridsize);
            int shiplength=0;//the step of the warship,renewed after every failure to create a new ship
            isSuccess=true;
            while(isSuccess&&shiplength<ship_size)//the last attempt is accepted
                if (gridflag[location]==0)
                {
                    coords[shiplength++]=location;
                    location+=incr;
                    if(location>=gridsize)
                        isSuccess=false;
                    if((shiplength>0)&&(location%gridlength==0))//the right bound has been reached.
                        isSuccess=false;
                }
                else{
                    isSuccess=false;
                }

        }

        //when this line is reached, a new ship with length of ship_length has been created successfully.
        int ship_length=0;
        int row=0;
        int column=0;
        while(ship_length<ship_size)
        {
            gridflag[coords[ship_length]]=1;//the flag should be set after a successful creation of a ship
            row=(int)(coords[ship_length]/gridlength);//record the location of the ship;the ship is
            column=coords[ship_length]%gridlength;    //created with the 1 dimension array,so the calculation is needed.
            tmp=String.valueOf(alphabet.charAt(column));//column number to alphabetic order
            alpha_cell.add(tmp.concat(Integer.toString(row)));//alphacell stores the ship location with mode like (2,a) .
            ship_length++;
            System.out.print("ship"+ship_length+"="+alpha_cell.get(ship_length-1)+"\n");
        }
        return alpha_cell;
    }
}
