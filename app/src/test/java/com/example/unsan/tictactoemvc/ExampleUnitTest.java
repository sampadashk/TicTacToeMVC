package com.example.unsan.tictactoemvc;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    int arr[]={1,1,2,2,3,3,3,4};
    int n=arr.length;
    List<Integer> li=new ArrayList();

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void check() {
        li.add(arr.length);
        for (int i = 0; i < n; i++)

        {
            int notCount = 0;
            while (arr[i] == 0) {
                i += 1;
            }
            int min=arr[i];


            for (int j = i; j < n; j++) {

                //System.out.println("i value is"+min);

                arr[j] = arr[j] - min;
                if (arr[j] > 0) {
                    notCount += 1;
                }
                System.out.println(arr[j]);


            }

            li.add(notCount);
            System.out.println();
            System.out.println("after 1 ");



        }
        System.out.println("after cout");
        for(int i:li)
        {
            if(i!=0)
            System.out.println(i);
        }
    }
}