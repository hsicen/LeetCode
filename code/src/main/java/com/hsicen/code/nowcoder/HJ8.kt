package com.hsicen.code.nowcoderimport java.util.Scanner/** * @author: hsicen * @date: 2023/12/12 15:50 * @email: codinghuang@163.com * description: HJ8 合并表记录 * * 数据表记录包含表索引index和数值value（int范围的正整数），请对表索引相同的记录进行合并， * 即将相同索引的数值进行求和运算，输出按照index值升序进行输出。 */fun main() {    val sc = Scanner(System.`in`)    val nums = sc.nextInt()    val map = HashMap<Int, Int>(nums)    repeat(nums) {        val key = sc.nextInt()        val value = sc.nextInt()        map[key] = value + (map[key] ?: 0)    }    map.forEach {        println("${it.key} ${it.value}")    }}