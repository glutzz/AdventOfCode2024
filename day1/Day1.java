package day1;

import java.util.*;
import java.io.*;

class Day1 {
    // Create a method which takes in two arrays
    // Sort the array from smallest to largest
    // Compare the difference between each one

    // Also need to read in a text file for puzzle input
    // White space == 3; split list left & right to populate
    // Call this in main method


    // Part One
    public static int calculateDistance(int[] leftList, int[] rightList) {
        Arrays.sort(leftList);
        Arrays.sort(rightList);
        
        int totalDistance = 0;

        for (int i = 0; i < leftList.length; i++) {
            totalDistance += Math.abs((leftList[i] - rightList[i]));
        }

        return totalDistance;
    }

    // Part Two
    public static int calculateSame(int[] leftList, int[] rightList) {
        int simScore = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        // Counting the frequency of each number in the list
        for (int num : rightList) {
            hm.put(num, hm.getOrDefault(num, 0) + 1);
        }

        for (int num : leftList) {
            if (hm.containsKey(num)) {
                simScore += num * hm.get(num);
            }
        }
        return simScore;

        }

    public static void main(String[] args) {
        // int[] left = {1,2,3,3,3,4};
        // int[] right = {3,3,3,4,5,9};

        try {
            // TEST CASES
            // int[] left = {1,2,3,3,3,4};
            // int[] right = {3,3,3,4,5,9};
            File file = new File("puzzleinput.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));

            List<Integer> leftInput = new ArrayList<>();
            List<Integer> rightInput = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] spaces = line.trim().split("\\s{3}");
                leftInput.add(Integer.parseInt(spaces[0]));
                rightInput.add(Integer.parseInt(spaces[1]));
            }
            br.close();

            int[] left = leftInput.stream().mapToInt(i -> i).toArray();
            int[] right = rightInput.stream().mapToInt(i -> i).toArray();


            // Part One Answer
           // int total = calculateDistance(left, right);
           
            // Part Two Answer
            int sameScore = calculateSame(left, right);

            System.out.println(sameScore);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}