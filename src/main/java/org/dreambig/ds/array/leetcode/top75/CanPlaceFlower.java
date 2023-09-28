package org.dreambig.ds.array.leetcode.top75;

/**
 * You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
 * <p>
 * Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.
 * <p>
 *
 *
 * Example 1:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: true
 * Example 2:
 * <p>
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: false
 * link => https://leetcode.com/problems/can-place-flowers/?envType=study-plan-v2&envId=leetcode-75
 */
public class CanPlaceFlower {
  /***
  Altough this problem looks like DP but it is not.. it is just to return true and false
  DP was if I need to get max cost
  **/
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
      if(n==0) return true;

      for (int i=0;i<flowerbed.length;i++){


          boolean isLeft =false, isRight=false;
          isLeft = i == 0 || flowerbed[i - 1] == 0;
          isRight = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;
          if (isLeft && isRight&& flowerbed[i]==0){
            flowerbed[i]=1;
            n--;
          }
          if(n==0)
            return true;

      }
      return false;
    }

    public static void main(String[] args) {
        CanPlaceFlower inst = new CanPlaceFlower();
        int [] ip ={1,0,0,0,0,1};
        int n=1;
        System.out.println(inst.canPlaceFlowers(ip,n));

    }
}
