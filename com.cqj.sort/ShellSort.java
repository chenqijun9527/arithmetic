package com.cqj.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class ShellSort {

    public static void main(String[] args) {
        //int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        // shellSort1(arr);
        //shellSort(arr);

        // 创建8万个随机数的数组
        int[] arr = new int[800000];
        for (int i = 0; i < 800000; i++) {
            arr[i] = (int) (Math.random() * 8000000);   // 生成一个[0,8000000] 数
        }

        System.out.println("排序前");
        Date date1 = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date1Str = simpleDateFormat.format(date1);
        System.out.println("排序前的时间是=" + date1Str);

        shellSort2(arr);

        Date date2 = new Date();
        String date2Str = simpleDateFormat.format(date2);
        System.out.println("排序后的时间是=" + date2Str);

        //System.out.println(Arrays.toString(arr));

    }

    /**
     * 分步分析后的最终代码实现：交换法
     * 相当于：希尔分组+冒泡排序
     *
     * @param arr
     */
    public static void shellSort(int[] arr) {
        int temp = 0;
        int count = 0;
        // 根据shellSort1的分步处理，现在使用循环处理
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 下面两个for相当于冒泡排序
            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有arr.leng/gap个元素),步长gap
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
            //System.out.println("希尔排序第" + ++count + "轮=" + Arrays.toString(arr));
        }

    }

    /**
     * 希尔排序-移位法
     * 相当于：希尔分组+插入排序
     *
     * @param arr
     */
    public static void shellSort2(int[] arr) {

        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            // 下面for+while 相当于插入排序
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[j - gap]) {
                    while (j - gap >= 0 && temp < arr[j - gap]) {
                        // 移动
                        arr[j] = arr[j - gap];
                        j -= gap;
                    }
                    // 当退出while后，就给temp找到插入的位置
                    arr[j] = temp;
                }
            }
        }

    }


    /**
     * 使用逐步推导的方式来编写希尔排序
     *
     * @param arr
     */
    public static void shellSort1(int[] arr) {
        int temp = 0;

        // 希尔排序的第1轮排序
        // 第1轮排序，是将10个数分成了 10/2 = 5组，每组2个元素
        for (int i = 5; i < arr.length; i++) {
            // 遍历各组中所有的元素
            for (int j = i - 5; j >= 0; j -= 5) {
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 5]) {
                    temp = arr[j];
                    arr[j] = arr[j + 5];
                    arr[j + 5] = temp;
                }
            }
        }

        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));


        // 希尔排序的第2轮排序
        // 第2轮排序，是将10个数分成了 5/2 = 2组，每组5个元素
        for (int i = 2; i < arr.length; i++) {
            // 遍历各组中所有的元素
            for (int j = i - 2; j >= 0; j -= 2) {
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 2]) {
                    temp = arr[j];
                    arr[j] = arr[j + 2];
                    arr[j + 2] = temp;
                }
            }
        }

        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));


        // 希尔排序的第3轮排序
        // 第3轮排序，是将10个数分成了 2/2 = 1组，每组10个元素
        for (int i = 1; i < arr.length; i++) {
            // 遍历各组中所有的元素
            for (int j = i - 1; j >= 0; j -= 1) {
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("希尔排序1轮后=" + Arrays.toString(arr));

    }

}
