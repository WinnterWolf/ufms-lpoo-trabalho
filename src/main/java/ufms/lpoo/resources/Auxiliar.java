package ufms.lpoo.resources;

public class Auxiliar {

    public static int count;


    public static int autoIncrementKey(){
        if(count == 0)
            count = 1;
        else{
            count++;
        }
        return count;
    }
}
