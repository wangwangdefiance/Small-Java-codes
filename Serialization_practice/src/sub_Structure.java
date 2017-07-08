/**
 * Created by defiance on 2017/7/8.
 */
public class sub_Structure extends Structure{
    transient String[] Entities;
    public sub_Structure()
    {
        number1=0;number2="00000000";Entities =new String[1];Entities[0]="this is a null object.";
    }

    public sub_Structure(int n1,String n2,String[] en)
    {
        number1=n1;number2=n2;en= Entities;
    }
}
