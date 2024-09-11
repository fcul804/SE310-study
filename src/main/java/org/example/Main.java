package org.example;

import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //inputs for study1 and study2. Please change according to each question
        List<List<Integer>> originalData = Arrays.asList(
                Arrays.asList(1, 1),
                Arrays.asList(1, 1),
                Arrays.asList(1, 1)
        );
        double[] resultForStudy1 = Study1.main(originalData);
        System.out.println(Arrays.toString(resultForStudy1));

        //inputs for study3 and study4. Please change according to each question
        Study3 study3 = new Study3();
        String resultForStudy3 = study3.main(1, study3.FEBRUARY,1900);
        System.out.println(resultForStudy3);



    }
}