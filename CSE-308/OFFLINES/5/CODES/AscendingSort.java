import java.util.ArrayList;

public class AscendingSort {

    public static ArrayList<Integer> Sort(ArrayList<Integer> list)
    {
        for(int i = 0; i < list.size(); i++){

            for(int j = i + 1; j < list.size(); j++){
                if(list.get(i) > list.get(j)){
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }

        }

        return list;
    }

}
