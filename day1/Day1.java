package day1;

import java.util.*;
import java.io.*;

class Day1 {
    // part one
    public static int calculateDistance(int[] leftList, int[] rightList) {
        Arrays.sort(leftList);
        Arrays.sort(rightList);
        
        int totalDistance = 0;

        for (int i = 0; i < leftList.length; i++) {
            totalDistance += Math.abs((leftList[i] - rightList[i]));
        }
        return totalDistance;
    }
    // part two
    public static int calculateSame(int[] leftList, int[] rightList) {
        int simScore = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
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

        try {
            // given test cases!! :)
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

            // part one answer
            int total = calculateDistance(left, right);
           
            // part two answer
            int sameScore = calculateSame(left, right);

            System.out.println(total);
            System.out.println(sameScore);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}