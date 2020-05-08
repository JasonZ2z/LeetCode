## KMP

### Code Template
```java
class Solution{
    private int[] getNext(String s) {
        int n = s.length();
        int[] next = new int[n +1];
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

    private static List search(String txt, String pattern){
            int[] next = getNext(pattern);
            List<Integer> res = new ArrayList<>();
            int i=0, j = -1;
            while( i < txt.length()){
                if(j == -1 || txt.charAt(i) == pattern.charAt(j)) {
                    i++;
                    j++;
                } else {
                    j = next[j];
                }
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
1. Leetcode028
2. Leetcode459
3. Leetcode1392. 最长快乐前缀
4. Leetcode1397. 找到所有好字符串 //todo