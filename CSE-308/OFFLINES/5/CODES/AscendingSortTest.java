import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AscendingSortTest {

    private int multiplier = (int) 1e6;
    private int notANumber = (int) 1e8;

    ArrayList<Integer> generateList(int size){
        ArrayList<Integer> list = new ArrayList<Integer>();

        for(int i = 0; i < size; i++)
        {
            list.add((int)Math.random()*multiplier);
        }

        return list;
    }



    Boolean testIfAltered(ArrayList<Integer> previous, ArrayList<Integer> present){

        if(previous.size() != present.size()){
            return true;
        }

        for(int i = 0; i < present.size(); i++){
            int temp = present.get(i);
            for(int j = 0; j < previous.size(); j++){
                if(previous.get(j) == temp){
                    previous.set(j, notANumber);
                }
            }
        }

        for(int i = 0; i < previous.size(); i++){
            if(previous.get(i) != notANumber){
                return true;
            }
        }

        return false;
    }



    Boolean testIfSorted(ArrayList<Integer> list)
    {

        int previous = -notANumber;
        for(int i = 0; i < list.size(); i++){
            if(previous > list.get(i)){
                return false;
            }
            previous = list.get(i);
        }

        return true;
    }



    @Test
    void blankListTest(){

        ArrayList<Integer> blankList = new ArrayList<Integer>();

        ArrayList<Integer> tempList = new ArrayList<Integer>();

        blankList = AscendingSort.Sort(blankList);

        Boolean altered, sorted;

        altered = testIfAltered(tempList, blankList);
        sorted = testIfSorted(blankList);

        assertEquals(altered, false);
        assertEquals(sorted, true);
    }

    @Test
    void oneNumberListTest(){

        ArrayList<Integer> oneNumberList = new ArrayList<Integer>();

        oneNumberList = generateList(1);

        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i<oneNumberList.size(); i++){
            tempList.add(oneNumberList.get(i));
        }

        oneNumberList = AscendingSort.Sort(oneNumberList);

        Boolean altered, sorted;

        altered = testIfAltered(tempList, oneNumberList);
        sorted = testIfSorted(oneNumberList);

        assertEquals(altered, false);
        assertEquals(sorted, true);


    }


    @Test
    void twoNumberListTest(){

        ArrayList<Integer> twoNumberList = new ArrayList<Integer>();

        twoNumberList = generateList(2);

        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i<twoNumberList.size(); i++){
            tempList.add(twoNumberList.get(i));
        }

        twoNumberList = AscendingSort.Sort(twoNumberList);

        Boolean altered, sorted;

        altered = testIfAltered(tempList, twoNumberList);
        sorted = testIfSorted(twoNumberList);

        assertEquals(altered, false);
        assertEquals(sorted, true);



    }

    @Test
    void randomSizedListTest(){

        ArrayList<Integer> randomSizedList = new ArrayList<Integer>();

        int randSize = (int)Math.random()*multiplier;
        randomSizedList = generateList(randSize);

        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i<randomSizedList.size(); i++){
            tempList.add(randomSizedList.get(i));
        }

        randomSizedList = AscendingSort.Sort(randomSizedList);

        Boolean altered, sorted;

        altered = testIfAltered(tempList, randomSizedList);
        sorted = testIfSorted(randomSizedList);

        assertEquals(altered, false);
        assertEquals(sorted, true);






    }

    @Test
    void randomListTest(){

        ArrayList<Integer> randomList = new ArrayList<Integer>();

        randomList = generateList(20);

        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i<randomList.size(); i++){
            tempList.add(randomList.get(i));
        }

        randomList = AscendingSort.Sort(randomList);

        Boolean altered, sorted;

        altered = testIfAltered(tempList, randomList);
        sorted = testIfSorted(randomList);

        assertEquals(altered, false);
        assertEquals(sorted, true);


    }

    @Test
    void AscendingListTest(){

        ArrayList<Integer> AscendingList = new ArrayList<Integer>();
        int prev = 0;

        for(int i = 0; i < 20; i++)
        {
            prev += (int)Math.random()*100;
            AscendingList.add(prev);
        }

        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i<AscendingList.size(); i++){
            tempList.add(AscendingList.get(i));
        }

        AscendingList = AscendingSort.Sort(AscendingList);

        Boolean altered, sorted;

        altered = testIfAltered(tempList, AscendingList);
        sorted = testIfSorted(AscendingList);

        assertEquals(altered, false);
        assertEquals(sorted, true);


    }

    @Test
    void DescendingListTest(){

        ArrayList<Integer> DescendingList = new ArrayList<Integer>();

        int prev = 500;

        for(int i = 0; i < 20; i++)
        {
            prev -= (int)Math.random()*10;
            DescendingList.add(prev);
        }



        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i<DescendingList.size(); i++){
            tempList.add(DescendingList.get(i));
        }

        DescendingList = AscendingSort.Sort(DescendingList);

        Boolean altered, sorted;

        altered = testIfAltered(tempList, DescendingList);
        sorted = testIfSorted(DescendingList);

        assertEquals(altered, false);
        assertEquals(sorted, true);




    }

    @Test
    void equalListTest(){

        ArrayList<Integer> equalList = new ArrayList<Integer>();

        int sameVal = (int)Math.random()*1000;

        for(int i = 0; i < 20; i++){
            equalList.add(sameVal);
        }



        ArrayList<Integer> tempList = new ArrayList<Integer>();

        for(int i = 0; i<equalList.size(); i++){
            tempList.add(equalList.get(i));
        }

        equalList = AscendingSort.Sort(equalList);

        Boolean altered, sorted;

        altered = testIfAltered(tempList, equalList);
        sorted = testIfSorted(equalList);

        assertEquals(altered, false);
        assertEquals(sorted, true);


    }


}