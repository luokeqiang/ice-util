package org.luoke.ice.util.core.lang;

/**
 *  数学运算相关工具类
 * @author luoke
 * @date 2022/6/28 15:41
 */
public class MathUtil {
    /**
     *  获取三个数中的中间值
     * @param num1 value1
     * @param num2 value2
     * @param num3 value3
     * @return 三个数中第二大的数
     */
    public static int mid(int num1,int num2,int num3){
        if (num1 > num2) {
            num1 = num1 ^ num2;
            num2 = num1 ^ num2;
            num1 = num1 ^ num2;
        }
        if (num1 > num3) {
            num1 = num1 ^ num3;
            num3 = num1 ^ num3;
            num1 = num1 ^ num3;
        }
        if (num2 > num3) {
            num2 = num2 ^ num3;
            num3 = num2 ^ num3;
            num2 = num2 ^ num3;
        }
        return num2;
    }
}
