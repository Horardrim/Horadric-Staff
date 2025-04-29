package com.horadrim.staff.ltcd.string;

import java.util.LinkedList;

public class DecodeString {
    public String solution(String encodedStr) {
        int ptr = 0;
        LinkedList<String> stack = new LinkedList<>();

        while (ptr < encodedStr.length()) {
            char cur = encodedStr.charAt(ptr);
            // 遇到数字将多位数字解析出来
            if (Character.isDigit(cur)) {
                String digits = getDigits(encodedStr, ptr);
                ptr += digits.length();
                stack.addLast(digits);
            
            }
            // 如果是字母或'['则进栈
            else if (Character.isLetter(cur) || cur == '[') {
                stack.addLast(String.valueOf(cur));
                ptr++;
            }
            // 遇到']'则出栈
            else {
                ++ptr;
                LinkedList<String> subString = new LinkedList<>();
                while (!"[".equals(stack.peekLast())) {
                    subString.addFirst(stack.removeLast());
                }
                // 将'['出栈
                stack.removeLast();

                // 此时栈顶为当前 sub 对应的字符串应该出现的次数
                int repTime = Integer.parseInt(stack.removeLast());

                StringBuffer t = new StringBuffer();
                String o = getString(subString);
                // 构造字符串
                while (repTime-- > 0) {
                    t.append(o);
                }

                // 将构造好的字串放回栈顶
                stack.addLast(t.toString());

            }

        }

        return getString(stack);
    }

    private String getDigits(String encodedStr, int ptr) {
        StringBuffer ret = new StringBuffer();
        while (Character.isDigit(encodedStr.charAt(ptr))) {
            ret.append(encodedStr.charAt(ptr++));
        }
        return ret.toString();
    }

    private String getString(LinkedList<String> v) {
        StringBuffer ret = new StringBuffer();
        for (String s : v) {
            ret.append(s);
        }
        return ret.toString();
    }
}
