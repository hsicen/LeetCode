package com.hsicen.think_in_java.chapter13;

/**
 * 作者：hsicen  2020/8/11 22:32
 * 邮箱：codinghuang@163.com
 * 作用：
 * 描述：LeetCode
 */
class WitherStringBuilder {

    public String implicit(String[] fields) {
        String result = "";

        for (String field : fields) {
            result += field;
        }

        return result;
    }

    public String explicit(String[] fields) {
        StringBuilder result = new StringBuilder();

        for (String field : fields) {
            result.append(field + ",");
        }

        return result.toString();
    }

    public String explicit2(String[] fields) {
        StringBuilder result = new StringBuilder();

        for (String field : fields) {
            result.append(field).append(",");
        }

        return result.toString();
    }
}
