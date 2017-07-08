import java.io.Serializable;

/**
 * Created by defiance on 2017/7/8.
 */
public class Structure implements Serializable {
    int number1;
    String number2;
    String[] Entities;

    public Structure()
    {
        number1=0;number2="00000000";Entities =new String[1];Entities[0]="this is a null object.";
    }

    public Structure(int n1,String n2,String[] en)
    {
        number1=n1;number2=n2;Entities= en;
    }

    public void show()
    {
        String list=" ";
        System.out.println("restored object:"+number1);
        System.out.println("inner_id:"+number2);
        for(int i=0;i<Entities.length;i++)
        {
            list+=Entities[i]+" ";
        }
        System.out.println("entities:"+list);
    }
}