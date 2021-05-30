package com.grainoil.common.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: chenminghong
 * @Date: 2021/5/19 14:29
 */
public class ListUtils {

    /**
     * 查询left单独有的list
     * @param left
     * @param right
     * @return
     */
    public static List getLeftCompare(List left, List right){

        List hand = new ArrayList(left);
        List realB = new ArrayList(right);
// 求交集
        hand.retainAll(realB);
        List aa = new ArrayList(left);
        List bb = new ArrayList(right);
// 求差集：结果
        aa.removeAll(hand);
        return aa;
    }

    /**
     * 查询right单独有的list
     * @param left
     * @param right
     * @return
     */
    public static List getRightCompare(List left,List right){

        List hand = new ArrayList(left);
        List realB = new ArrayList(right);
// 求交集
        hand.retainAll(realB);
        List bb = new ArrayList(right);
// 求差集：结果
        bb.removeAll(hand);
        return bb;
    }

    public static void main(String[] args) {
        List one = Arrays.asList(1L,2L,3L,4L);
        List two = Arrays.asList(3L,4L,5L);
        List leftCompare = getLeftCompare(one, two);
        List rightCompare = getRightCompare(one, two);
        System.out.println(leftCompare);
        System.out.println(rightCompare);
    }
}
