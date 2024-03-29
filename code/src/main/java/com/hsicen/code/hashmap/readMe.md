# 散列表

### 散列函数设计要求

- 散列函数计算得到的散列值是一个非负整数  (数组下标从0开始)
- 散列函数的设计不能太复杂
- 散列函数生成的值要尽可能随机并且均匀分布
- 如果 key1 ＝ key2，那 hash(key1) ＝ hash(key2)
- 如果 key1 ≠ key2，那 hash(key1) ≠ hash(key2) (散列冲突)

不同的key，对应不同的散列值 => 这样的hash函数很难找到，所以会存在散列冲突

##### 散列冲突解决方法

开放寻址法

- 线性探测：依次往后探测(步长为1)，直到找到可用位置
- 二次探测：依次往后探测(步长为二次方)，直到找到可用位置
- 双重散列：使用一组散列函数

链表法：散列值相同的元素会用一个链表连起来

装载因子：表示饱和度 装载因子 = 填入元素个数 / 散列表的长度

高效扩容：

1. 每次只搬移一部分数据到新的散列表，查找时先重新的散列表查找，然后再从老的散列表查找

应用：

1. Word文档单词拼写检查功能：将所有单词建立一个散列表，用户每输入一个单词就去查找是否有这个单词，没有就提示拼写错误

问题：

1. 假设我们有 10 万条 URL 访问日志，如何按照访问次数给 URL 排序？
   > URL为key，次数为value，存入散列表，同时记录访问次数最大值和最小值，得出差值K；若K不是很大用桶排序O(
   N)，否则用快速排序O(NlogN)
2. 有两个字符串数组，每个数组大约有 10 万条字符串，如何快速找出两个数组中相同的字符串？
   > 以第一个字符串数组构建散列表，key为字符串，value为出现次数；再遍历第二个字符串数组，以字符串为key在散列表中查找，如果
   value>0 ,说明存在相同字符串；时间复杂度为O(n)
    
