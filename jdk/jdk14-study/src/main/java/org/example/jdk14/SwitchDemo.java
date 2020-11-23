package org.example.jdk14;

/**
 * @author qiqiang
 * @date 2020-10-15 10:24 上午
 */
public class SwitchDemo {
    public static void main(String[] args) {
        f1(8);
        System.out.println(f2(0));
    }

    private static void f1(int grade) {
        switch (grade) {
            case 9, 10 -> System.out.println("大神牛逼");
            case 7, 8 -> System.out.println("一般般");
            case 6 -> System.out.println("刚好及格");
            default -> System.out.println("不及格");
        }
    }

    private static String f2(int grade) {
        return switch (grade) {
            case 9, 10 -> "大神牛逼";
            case 7, 8 -> "一般般";
            case 6 -> "刚好及格";
            default -> {
                if (grade == 0) {
                    yield "出门右拐罚站";
                } else {
                    yield "不及格";
                }
            }
        };
    }
}