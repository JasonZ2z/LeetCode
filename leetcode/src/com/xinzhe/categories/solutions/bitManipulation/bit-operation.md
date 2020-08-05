1. `x & (-x)`  获取到二进制中最右边的 1，且其它位设置为 0.  

    1.1 `Integer.lowestOneBit(x)`
    
    1.2 `Integer.highestOneBit(x)`
    
2. `x & (x - 1)` 去除二进制中最右边的 1.

3. 异或运算
    
    3.1     `0^a=a，a^a=0`
    
    3.2     `a^b^c=a^c^b`