## KMP
### Code Template
```java
class Solution{
    private int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n+1];
        next[0] = -1;
        int i=0, j=-1;
        while (i < n) {
            if(j==-1 || s.charAt(i) == s.charAt(j)) {
                next[++i] = ++j;
            } else {
                j = next[j];
            }
        }
        return next;
    }
    
    private static List<Integer> search(String txt, String pattern){
            int[] next = getNext(pattern);
            List<Integer> res = new ArrayList<>();
            int i=0, j=-1;
            while( i < txt.length()){
                if(j == -1 || txt.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
                //如果是存在性问题，只要判断相等即可;
                //第一个相等开始索引为i-j;
                //因存在多种匹配情况，用list存储;
                if(j ==  pattern.length()) {
                    res.add(i-j);
                    j = -1;
                }
            }
            return res;
        }
}
```

### KMP的时间复杂度
- KMP的整体时间复杂度为O(m + n)

### Related Problem
1. Leetcode028. 实现 strStr()
2. Leetcode459. 重复的子字符串
3. Leetcode1392. 最长快乐前缀
4. Leetcode1397. 找到所有好字符串 //Todo

### Reference
#### 视频
- [KMP字符串匹配算法1](https://www.bilibili.com/video/BV1Px411z7Yo?from=search&seid=1628698671596369034)
- [KMP字符串匹配算法2](https://www.bilibili.com/video/BV1hW411a7ys?from=search&seid=1628698671596369034)
- [KMP算法之爆锤next数组](https://www.bilibili.com/video/BV1i64y1M7zv?from=search&seid=1628698671596369034)
#### 博客
- [从头到尾彻底理解KMP](https://blog.csdn.net/v_july_v/article/details/7041827)