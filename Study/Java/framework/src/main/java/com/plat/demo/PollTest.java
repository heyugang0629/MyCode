package com.plat.demo;

/**
 * Created by jack on 2021/3/27.
 */
public class PollTest {

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};

        // 轮询规则：指定起始索引位置
        int index = 4;

        for (int i = 0; i < 100000; i++) {

            // 下一个轮询索引(开始位置)
            int nextIndex = (index + 1) % 11;
            index = nextIndex;
            System.out.println("轮询结果：" + arr[nextIndex]);
        }
    }
}
