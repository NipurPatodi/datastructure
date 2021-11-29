package org.dreambig.ds.backtracking.medium;

import org.dreambig.ds.picker.IQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PaintHouse implements IQuestion {
    @Override
    public String getQuestion() {
        return "256. Paint House\n" +
                "Medium\n" +
                "\n" +
                "1560\n" +
                "\n" +
                "109\n" +
                "\n" +
                "Add to List\n" +
                "\n" +
                "Share\n" +
                "There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.\n" +
                "\n" +
                "The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.\n" +
                "\n" +
                "For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...\n" +
                "Return the minimum cost to paint all houses.\n" +
                "\n" +
                " \n" +
                "\n" +
                "Example 1:\n" +
                "\n" +
                "Input: costs = [[17,2,17],[16,16,5],[14,3,19]]\n" +
                "Output: 10\n" +
                "Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.\n" +
                "Minimum cost: 2 + 5 + 3 = 10.\n" +
                "Example 2:\n" +
                "\n" +
                "Input: costs = [[7,6,2]]\n" +
                "Output: 2\n" +
                "Please find more details @ https://leetcode.com/problems/paint-house/";
    }

    @Override
    public List<String> getCompanies() {
        return Arrays.asList("linkedin".split(" "));
    }

    @Override
    public String getThingsToRemember() {
        return "It can be implemented by DP ... but use Backtracking will help.";
    }

    private Map<String, Integer> costMap;

    public int getMinimumCostPainting(int[][] cost) {// [N] [Color]
        costMap = new HashMap<>();
        return Math.min(Math.min(getMinPaint(cost, 0, 0), getMinPaint(cost, 0, 1)), getMinPaint(cost, 0, 2));
    }

    String getKey(int n, int color) {
        return n + " " + color;
    }

    private int getMinPaint(int[][] cost, int n, int color) {
        int totCost = cost[n][color];
        if (costMap.containsKey(getKey(n, color))) {
            return costMap.get(getKey(n, color));
        }
        if (n != cost.length - 1) {
            if (color == 0)
                totCost += Math.min(getMinPaint(cost, n + 1, 1), getMinPaint(cost, n + 1, 2));
            else if (color == 1)
                totCost += Math.min(getMinPaint(cost, n + 1, 0), getMinPaint(cost, n + 1, 2));
            else
                totCost += Math.min(getMinPaint(cost, n + 1, 0), getMinPaint(cost, n + 1, 1));

        }
        costMap.put(getKey(n, color), totCost);
        return totCost;
    }


    public static void main(String[] args) {
        PaintHouse ph = new PaintHouse();
        int[][] ip = {{17, 2, 17}, {16, 16, 5}, {14, 3, 19}};
        System.out.println(ph.getMinimumCostPainting(ip));
    }
}