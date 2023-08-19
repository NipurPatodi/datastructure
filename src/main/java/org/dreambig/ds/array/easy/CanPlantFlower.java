package org.dreambig.ds.array.easy;

import org.dreambig.ds.picker.IQuestion;

import java.util.List;

public class CanPlantFlower implements IQuestion {
    @Override
    public String getQuestion() {
        return "You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.\n" +
                "\n" +
                "Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: flowerbed = [1,0,0,0,1], n = 1\n" +
                "Output: true\n" +
                "Example 2:\n" +
                "\n" +
                "Input: flowerbed = [1,0,0,0,1], n = 2\n" +
                "Output: false\n" +
                " \n" +
                "\n" +
                "Constraints:\n" +
                "\n" +
                "1 <= flowerbed.length <= 2 * 104\n" +
                "flowerbed[i] is 0 or 1.\n" +
                "There are no two adjacent flowers in flowerbed.\n" +
                "0 <= n <= flowerbed.length";
    }

    @Override
    public List<String> getCompanies() {
        return null;
    }

    @Override
    public String getThingsToRemember() {
        return null;
    }

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n==0) return true;
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            boolean isLeftEmpty = (i == 0) || (flowerbed[i - 1]== 0);
            boolean isRightEmpty = (i + 1 == flowerbed.length) || (flowerbed[i + 1] == 0);
            if (isLeftEmpty && isRightEmpty && flowerbed[i] == 0) {
                count++;
                flowerbed[i]=1;
            }
            if (count == n) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CanPlantFlower inst = new CanPlantFlower();
        int [] flowers={1,0,0,0,0,1};
        System.out.println(inst.canPlaceFlowers(flowers,2));
    }
}
