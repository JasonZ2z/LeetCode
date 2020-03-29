##Trie

> Trie树，又称单词查找树或键树，是一种树形结构，是一种哈希树的变种。 
> 典型应用是 
 > 1. 用于统计和排序大量的字符串（但不仅限于字符串），所以经常被搜索引擎系统用于文本词频统计。 
 > 2. 用于前缀匹配，比如我们在搜索引擎中输入待搜索的字词时，搜索引擎会给予提示有哪些前缀。 
>
    > 优点：最大限度地减少无谓的字符串比较，查询效率比哈希表高。
    > 缺点: 空间开销大。

### Code Template
```java
class TrieNode {
	Map<Character, TrieNode> childdren;
	boolean wordEnd;
 
	public TrieNode() {
		childdren = new HashMap<>();
		wordEnd = false;
	}
}

public class Trie {
	private TrieNode root;
	public Trie() {
		root = new TrieNode();
		root.wordEnd = false;
	}
 
	public void insert(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			if (!node.childdren.containsKey(c)) {
				node.childdren.put(c, new TrieNode());
			}
			node = node.childdren.get(c);
		}
		node.wordEnd = true;
	}
 
	public boolean search(String word) {
		TrieNode node = root;
		for (int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			if (!node.childdren.containsKey(c)) {
				return false;
			}
			node = node.childdren.get(c);
		}
		return node.wordEnd;
	}
 
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		boolean found = true;
		for (int i = 0; i < prefix.length(); i++) {
			Character c = prefix.charAt(i);
			if (!node.childdren.containsKey(c)) {
				return false;
			}
			node = node.childdren.get(c);
		}
		return found;
	}
}
```

### Related Problems
1. Leetcode208. 实现 Trie (前缀树)
2. Leetcode211. 添加与搜索单词 - 数据结构设计
3. Leetcode212. 单词搜索 II
4. Leetcode336. 回文对
5. Leetcode421. 数组中两个数的最大异或值
6. Leetcode472. 连接词
7. Leetcode648. 单词替换
8. Leetcode676. 实现一个魔法字典
9. Leetcode677. 键值映射    
10. Leetcode692. 前K个高频单词
11. Leetcode720. 词典中最长的单词
12. Leetcode745. 前缀和后缀搜索
13. Leetcode820. 单词的压缩编码
14. Leetcode1023. 驼峰式匹配
15. Leetcode1032. 字符流

[Merkle Patricia Tree 详解](https://ethfans.org/toya/articles/588)