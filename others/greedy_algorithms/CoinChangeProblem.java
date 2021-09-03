package others.greedy_algorithms;

import java.util.Arrays;

public class CoinChangeProblem {
  public static void main(String[] args) {
    int[] coins = { 1, 2, 5, 10, 20, 50, 100, 1000 };
    int amount = 2035;
    System.out.println("Coins available: " + Arrays.toString(coins));
    System.out.println("Amount: " + amount);
    Helper.coinChangeProblem(coins, amount);
  }
}

class Helper {
  static void coinChangeProblem(int[] coins, int totalAmount) {
    Arrays.sort(coins);
    int index = coins.length - 1;
    while (true) {
      int coinValue = coins[index];
      index--;
      int maxAmount = (totalAmount / coinValue) * coinValue;
      if (maxAmount > 0) {
        System.out.println("Coin value: " + coinValue + ", taken count: " + (totalAmount / coinValue));
        totalAmount = totalAmount - maxAmount;
      }
      if (totalAmount == 0) {
        break;
      }
    }
  }
}