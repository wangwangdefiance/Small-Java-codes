/**
 * Created by defiance on 2017/7/9.
 */
public class wordCard {
    String question,answer;
    static int id_counter=0;
    int pid;

    public wordCard()
    {
        id_counter++;
        pid=id_counter;
        System.out.println("this is the no."+id_counter+" card");
        System.out.println(question=new String("This is an empty question."));
        System.out.println(answer=new String("this is an empty answer"));
    }

    public wordCard(String in_question,String in_answer)
    {
        question=in_question;answer=in_answer;
    }
}
