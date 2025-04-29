package com.horadrim.staff.ltcd.math;

public class Print2Pow1000 {
    final private static int base = 2;

    public int [] solution(int pow) {
        int [] number = {base};

        if (pow == 0) {
            number[0] = 0;
            return number;
        }

        for (int i = 0; i < pow - 1; ++i) {
            int digits = number.length;
            int carry = 0;
            for (int j = 0; j < digits; ++j) {
                int product = number[j] * base + carry;
                number[j] = product % 10;
                carry = product / 10;
            }

            while (carry > 0) {
                int [] newNum = new int[number.length + 1];
                System.arraycopy(number, 0, newNum, 0, number.length);
                newNum[number.length] = carry;
                number = newNum;
                carry = carry / 10;
            }
        }

        return number;
    }
}
