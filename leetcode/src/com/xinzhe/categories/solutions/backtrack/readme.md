## 回溯算法
解决一个回溯问题，实际上就是一个决策树的遍历过程。只需要思考 3 个问题：

1、路径：也就是已经做出的选择。

2、选择列表：也就是你当前可以做的选择。

3、结束条件：也就是到达决策树底层，无法再做选择的条件。

### Categories
- 全排列问题
- N皇后问题

### Code Template
```
result = []
def backtrack(路径, 选择列表):
    if 满足结束条件:
        result.add(路径)
        return
    
    for 选择 in 选择列表:
        做选择
        backtrack(路径, 选择列表)
        撤销选择
```
### Related Problems
1. Leetcode022. 括号生成
2. Leetcode039. 组合总和
3. Leetcode040. 组合总和 II
4. Leetcode046. 全排列
5. Leetcode047. 全排列 II
6. Leetcode060. 第k个排列
7. Leetcode078. 子集
8. Leetcode090. 子集 II
9. Leetcode131. 分割回文串
10. Leetcode216. 组合总和 III
11. Leetcode377. 组合总和 Ⅳ
12. Leetcode491. 递增子序列
13. Leetcode784. 字母大小写全排列