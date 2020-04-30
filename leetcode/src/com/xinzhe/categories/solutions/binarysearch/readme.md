## 二分查找
把「待搜索区间」分为「有目标元素的区间」和「不包含目标元素的区间」，排除掉「不包含目标元素的区间」的区间，剩下就是「有目标元素的区间」。

### Code Template

#### 边界收缩行为 1： mid 被分到左边。即区间被分成 [left, mid] 与 [mid + 1, right]，此时取中间数的时候下取整。
```
int mid = left + (right - left) / 2;
if (check(mid)) {
    // 下一轮搜索区间是 [mid + 1, right]，因此把左边界设置到 mid + 1 位置
    left = mid + 1;
} else {
    // 上面对了以后，不加思考，剩下的区间一定是 [left, mid]，因此左边界向右收缩到 mid 位置
    right = mid;
}
```
#### 边界收缩行为 2： mid 被分到右边。即区间被分成 [left, mid - 1] 与 [mid, right]，此时取中间数的时候上取整。
```
int mid = left + (right - left + 1) / 2;
if (check(mid)) {
    // 下一轮搜索区间是 [left, mid - 1]
    right = mid - 1;
} else {
    left = mid;
}
```

### Related Problems
- 入门 Leetcode704. 二分查找

#### 查找符合条件的元素
1. Leetcode033. 搜索旋转排序数组
2. Leetcode034. 在排序数组中查找元素的第一个和最后一个位置
3. Leetcode035. 搜索插入位置
4. Leetcode081. 搜索旋转排序数组 II
5. Leetcode153. 寻找旋转排序数组中的最小值
6. Leetcode154. 寻找旋转排序数组中的最小值 II
7. Leetcode300. 最长上升子序列
8. Leetcode275. H指数 II
9. Leetcode1095. 山脉数组中查找目标值

11. Leetcode004. 寻找两个有序数组的中位数  ***hard***

#### 在一个有上下界的区间里搜索一个整数
1. Leetcode069. 平方根
2. Leetcode287. 寻找重复数
3. Leetcode374. 猜数字大小

#### 判别条件是一个函数
1. Leetcode278. 第一个错误的版本
2. Leetcode410. 分割数组的最大值
3. Leetcode658. 找到 K 个最接近的元素
4. Leetcode875. 爱吃香蕉的珂珂
5. Leetcode1300. 转变数组后最接近目标值的数组和