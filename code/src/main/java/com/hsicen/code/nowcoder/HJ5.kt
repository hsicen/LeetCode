package com.hsicen.code.nowcoderimport java.util.Scanner/** * @author: hsc * @date: 2023/12/6 18:02 * @email: codinghuang@163.com * description: HJ5 进制转换 * * 描述：写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。 */fun main() {    val sc = Scanner(System.`in`)    while (sc.hasNext()) {        println(hexToInt(sc.next()))    }}private fun hexToInt(src: String?): Int {    val content = src?.substring(2)?.toCharArray() ?: return 0    if (content.isEmpty()) return 0    val char2Int = HashMap<Char, Int>().apply {        put('0', 0)        put('1', 1)        put('2', 2)        put('3', 3)        put('4', 4)        put('5', 5)        put('6', 6)        put('7', 7)        put('8', 8)        put('9', 9)        put('A', 10)        put('B', 11)        put('C', 12)        put('D', 13)        put('E', 14)        put('F', 15)    }    var base = 0    var sum = 0    val len = content.size - 1    for (i in len downTo 0) {        char2Int[content[i]]?.let { num ->            sum += num shl base            base += 4        }    }    return sum}