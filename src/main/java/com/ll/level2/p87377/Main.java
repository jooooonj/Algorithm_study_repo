package com.ll.level2.p87377;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[][] testCase1 = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        int[][] testCase2 = {{0, -1, 1}, {1, 0, -1}, {1, 0, 1}};

        Solution s = new Solution();
        String[] result = s.solution(testCase2);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    //그래프가 그려지는 표의 사이즈를 알아내기 위해서
    static int minX = Integer.MAX_VALUE;
    static int maxX = Integer.MIN_VALUE;

    static int minY = Integer.MAX_VALUE;
    static int maxY = Integer.MIN_VALUE;

    public String[] solution(int[][] line) {

        List<long[]> xy = new ArrayList<>();
        for(int i=0; i<line.length - 1; i++){

            for(int j=i+1; j<line.length; j++){
                double xd = xValue(line[i], line[j]);
                double yd = yValue(line[i], line[j]);
                if (isInteger(xd, yd)) {
                    Long x = (long)xd;
                    Long y = (long)yd;

                    setMinAndMax(x.intValue(), y.intValue());
                    xy.add(new long[]{x,y});
                }
            }
        }
        String[] result = new String[(maxY - minY + 1)];
        Arrays.fill(result, "");

        int index = 0;
        for(long r=maxY; r>=minY; r--){

            for(long c=minX; c<=maxX; c++){
                boolean isAdd = false;
                for(long[] tmp : xy){
                    if(tmp[1]==r && tmp[0] ==c){
                        result[index] += "*";
                        isAdd = true;
                        break;
                    }
                }
                if(!isAdd)
                    result[index] += ".";
            }
            index++;
        }
        return result;
    }

    private static void setMinAndMax(int x, int y) {
        if(minX > x)
            minX = x;
        if(maxX < x)
            maxX = x;
        if(minY > y)
            minY = y;
        if(maxY < y)
            maxY = y;
    }

    public double xValue(int[] line1, int[] line2){
        double adMinusBc = (double)((long)line1[0]*line2[1] - (long)line1[1]*line2[0]);
        return (double)((long)line1[1]*line2[2] - (long)line1[2]*line2[1]) / adMinusBc;
    }

    public double yValue(int[] line1, int[] line2){
        double adMinusBc = (double)((long)line1[0]*line2[1] - (long)line1[1]*line2[0]);
        return (double)((long)line1[2]*line2[0] - (long)line1[0]*line2[2]) / adMinusBc;
    }

    public boolean isInteger(double x, double y){
        if(x%1.0==0.0 && y%1.0==0.0)
            return true;
        return false;
    }
}
