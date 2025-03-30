package leetCode;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode1058最小化舍入误差以满足目标 {

    /**
     * 我认为就是DFS遍历吧
     *
     * @param prices
     * @param target
     * @return
     */
    public String minimizeError(String[] prices, int target) {
        BigDecimal[] pricesDouble = new BigDecimal[prices.length];
        for (int i = 0; i < prices.length; i++) {
            BigDecimal tempDecimal = new BigDecimal(prices[i]);
            pricesDouble[i] = tempDecimal;
        }
        // 向下取整的值
        BigDecimal[][] floorPricesBig = new BigDecimal[pricesDouble.length][2];
        // 向上取整的值
        BigDecimal[][] ceilPricesBig = new BigDecimal[pricesDouble.length][2];
        // 分别计算向上和向下的值
        for (int i = 0; i < prices.length; i++) {
            floorPricesBig[i][0] = pricesDouble[i].setScale(0, RoundingMode.DOWN);
            floorPricesBig[i][1] = pricesDouble[i].subtract(floorPricesBig[i][0]).abs();

            ceilPricesBig[i][0] = pricesDouble[i].setScale(0, RoundingMode.UP);
            ceilPricesBig[i][1] = pricesDouble[i].subtract(ceilPricesBig[i][0]).abs();
        }

        double[][] floorPrices = new double[floorPricesBig.length][2];
        double[][] ceilPrices = new double[ceilPricesBig.length][2];
        for (int i = 0; i < floorPricesBig.length; i++) {
            floorPrices[i][0] = floorPricesBig[i][0].doubleValue();
            floorPrices[i][1] = floorPricesBig[i][1].doubleValue();
            ceilPrices[i][0] = ceilPricesBig[i][0].doubleValue();
            ceilPrices[i][1] = ceilPricesBig[i][1].doubleValue();
        }

        BigDecimal tempSum = BigDecimal.ZERO;
        for (int i = 0; i < floorPrices.length; i++) {
            BigDecimal temp = ceilPricesBig[i][0];
            tempSum = tempSum.add(temp);
        }
        if (tempSum.intValue() < target) {
            return "-1";
        }

        List<List<Double>> possibleResult = new ArrayList<>();
        dfs(floorPrices, ceilPrices, possibleResult, new ArrayList<>(), 0, 0, target);
        if (possibleResult.isEmpty()) {
            return "-1";
        }
        double min = Double.MAX_VALUE;
        for (List<Double> row : possibleResult) {
            BigDecimal sum = new BigDecimal(0);
            for (Double temp : row) {
                BigDecimal tempDecimal = new BigDecimal(temp);
                sum = sum.add(tempDecimal);
            }
            min = Math.min(min, sum.doubleValue());
        }

        BigDecimal result = BigDecimal.valueOf(min).setScale(3, RoundingMode.DOWN);

        return String.valueOf(result);
    }

    private void dfs(double[][] floorPrices, double[][] ceilPrices, List<List<Double>> possibleResult, List<Double> currentPath, int currentIndex, int currentSum, int target) {
        if (currentIndex == floorPrices.length) {
            if (currentSum == target) {
                possibleResult.add(new ArrayList<>(currentPath));
            }
            return;
        }
        // 取一个向上取整的
        double[] currentCeil = ceilPrices[currentIndex];
        if (currentSum + currentCeil[0] <= target) {
            List<Double> temp = new ArrayList<>(currentPath);
            temp.add(currentCeil[1]);
            dfs(floorPrices, ceilPrices, possibleResult, temp, currentIndex + 1, (int) (currentSum + currentCeil[0]), target);
        }
        // 取一个向下取整的
        double[] currentFloor = floorPrices[currentIndex];
        if (currentSum + currentFloor[0] <= target) {
            List<Double> temp = new ArrayList<>(currentPath);
            temp.add(currentFloor[1]);
            dfs(floorPrices, ceilPrices, possibleResult, temp, currentIndex + 1, (int) (currentSum + currentFloor[0]), target);
        }
    }

    /**
     * DFS 不顶用，还需要贪心一下
     *
     * @param prices
     * @param target
     * @return
     */
    public String minimizeError2(String[] prices, int target) {
        BigDecimal[] pricesDouble = new BigDecimal[prices.length];
        for (int i = 0; i < prices.length; i++) {
            BigDecimal tempDecimal = new BigDecimal(prices[i]);
            pricesDouble[i] = tempDecimal;
        }
        // 向下取整的值
        BigDecimal[][] floorPricesBig = new BigDecimal[pricesDouble.length][2];
        // 向上取整的值
        BigDecimal[][] ceilPricesBig = new BigDecimal[pricesDouble.length][2];
        // 分别计算向上和向下的值
        for (int i = 0; i < prices.length; i++) {
            floorPricesBig[i][0] = pricesDouble[i].setScale(0, RoundingMode.DOWN);
            floorPricesBig[i][1] = pricesDouble[i].subtract(floorPricesBig[i][0]).abs();

            ceilPricesBig[i][0] = pricesDouble[i].setScale(0, RoundingMode.UP);
            ceilPricesBig[i][1] = pricesDouble[i].subtract(ceilPricesBig[i][0]).abs();
        }

        double[][] floorPrices = new double[floorPricesBig.length][2];
        double[][] ceilPrices = new double[ceilPricesBig.length][2];
        for (int i = 0; i < floorPricesBig.length; i++) {
            floorPrices[i][0] = floorPricesBig[i][0].doubleValue();
            floorPrices[i][1] = floorPricesBig[i][1].doubleValue();
            ceilPrices[i][0] = ceilPricesBig[i][0].doubleValue();
            ceilPrices[i][1] = ceilPricesBig[i][1].doubleValue();
        }

        // 如果floor或者ceil的sub和target比较得不到，那返回-1
        BigDecimal tempCeilSum = BigDecimal.ZERO;
        BigDecimal tempFloorSum = BigDecimal.ZERO;
        for (int i = 0; i < floorPrices.length; i++) {
            BigDecimal tempCeil = ceilPricesBig[i][0];
            tempCeilSum = tempCeilSum.add(tempCeil);
            BigDecimal tempFloor = floorPricesBig[i][0];
            tempFloorSum = tempFloorSum.add(tempFloor);
        }
        if (tempCeilSum.intValue() < target || tempFloorSum.intValue() > target) {
            return "-1";
        }

        // 如何贪心？
        // target - tempFloorSum 就是需要向上取整的值
        int gap = target - tempFloorSum.intValue();
        double[][] array = new double[floorPrices.length][3];
        for (int i = 0; i < floorPrices.length; i++) {
            array[i][0] = floorPrices[i][0];
            array[i][1] = floorPrices[i][1];
            array[i][2] = ceilPrices[i][1];
        }
        Arrays.sort(array, (x, y) -> {
            if (Double.compare(x[2], y[2]) == 0) {
                return Double.compare(x[1], y[1]);
            }
            return Double.compare(x[2], y[2]);
        });

        double result = 0;

        for (int i = 0; i < prices.length; i++) {
            if (array[i][1] == 0d){
                continue;
            }
            if (gap > 0){
                gap--;
                result += array[i][2];
            }else {
                result += array[i][1];
            }
        }

        return String.format("%.3f", result);
    }


    public static void main(String[] args) {
        String[] array = new String[]{"0.700","2.800","4.900"};
        int target = 8;
        System.out.println(new LeetCode1058最小化舍入误差以满足目标().minimizeError2(array, target));
    }
}
