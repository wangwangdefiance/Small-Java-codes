import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.lang.reflect.Executable;

/**
 * Created by defiance on 2017/7/8.
 the no0 and no1 Structure has no transient entities while the sub_Structure no2 extending
 the normal class Structure and the Entities labeled transient so it is initialized again.*/

public class Main {
    public static void main(String[] args)
    {
        Structure no0=new Structure(1,"12345678",new String[]{"C++","Java","Python"});
//        no0.show();
        Structure no1=new Structure(2,"87654321",new String[]{"Assembly","Compile","Link"});
        sub_Structure no2=new sub_Structure(3,"99999999",new String[]{"you should not","see this line"});

        try
        {
            ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("Serializaion_practice.ser"));
            oos.writeObject(no0);
            oos.writeObject(no1);
            oos.writeObject(no2);
        }catch(Exception e){
            e.printStackTrace();
        }//Serialization

        try
        {
            ObjectInputStream ois=new ObjectInputStream(new FileInputStream("Serializaion_practice.ser"));
            Structure Restored_no0=(Structure) ois.readObject();
            Structure Restored_no1=(Structure) ois.readObject();
            sub_Structure Restored_no2=(sub_Structure) ois.readObject();

            Restored_no0.show();
            Restored_no1.show();
            Restored_no2.show();
        }catch (Exception e)
        {
            e.printStackTrace();
        }//deserialization and show the status
    }
}


