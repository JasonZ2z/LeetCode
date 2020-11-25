package com.xinzhe.categories.solutions.trick;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Xin
 * @date 2020/11/25
 * Title :843. 猜猜这个单词
 * Description : 我们给出了一个由一些独特的单词组成的单词列表，每个单词都是 6 个字母长，并且这个列表中的一个单词将被选作秘密。
 *              你可以调用 master.guess(word) 来猜单词。你所猜的单词应当是存在于原列表并且由 6 个小写字母组成的类型字符串。
 *              此函数将会返回一个整型数字，表示你的猜测与秘密单词的准确匹配（值和位置同时匹配）的数目。此外，如果你的猜测不在给定的单词列表中，它将返回 -1。
 *              对于每个测试用例，你有 10 次机会来猜出这个单词。当所有调用都结束时，如果您对 master.guess 的调用不超过 10 次，并且至少有一次猜到秘密，那么您将通过该测试用例。
 *              除了下面示例给出的测试用例外，还会有 5 个额外的测试用例，每个单词列表中将会有 100 个单词。这些测试用例中的每个单词的字母都是从 'a' 到 'z'中随机选取的，并且保证给定单词列表中的每个单词都是唯一的。
 * link : https://leetcode-cn.com/problems/guess-the-word
 * Level : Hard
 */
//todo need to review
public class Leetcode843 {
    public static void main(String[] args) {
        Leetcode843 lc = new Leetcode843();
        String[] list = {"gaxckt","trlccr","jxwhkz","ycbfps","peayuf","yiejjw","ldzccp","nqsjoa","qrjasy","pcldos","acrtag","buyeia",
                "ubmtpj","drtclz","zqderp","snywek","caoztp","ibpghw","evtkhl","bhpfla","ymqhxk","qkvipb","tvmued","rvbass",
                "axeasm","qolsjg","roswcb","vdjgxx","bugbyv","zipjpc","tamszl","osdifo","dvxlxm","iwmyfb","wmnwhe","hslnop",
                "nkrfwn","puvgve","rqsqpq","jwoswl","tittgf","evqsqe","aishiv","pmwovj","sorbte","hbaczn","coifed","hrctvp",
                "vkytbw","dizcxz","arabol","uywurk","ppywdo","resfls","tmoliy","etriev","oanvlx","wcsnzy","loufkw","onnwcy",
                "novblw","mtxgwe","rgrdbt","ckolob","kxnflb","phonmg","egcdab","cykndr","lkzobv","ifwmwp","jqmbib","mypnvf",
                "lnrgnj","clijwa","kiioqr","syzebr","rqsmhg","sczjmz","hsdjfp","mjcgvm","ajotcx","olgnfv","mjyjxj","wzgbmg",
                "lpcnbj","yjjlwn","blrogv","bdplzs","oxblph","twejel","rupapy","euwrrz","apiqzu","ydcroj","ldvzgq","zailgu","xgqpsr","wxdyho","alrplq","brklfk"};
        final String s = "hbaczn";
        lc.findSecretWord(list, word -> {
            int cnt = 0;
            for (int i = 0; i < word.length(); i++) {
                if(word.charAt(i) == s.charAt(i)) cnt++;
            }
            if(cnt == 6) {
                System.out.println(" -------------------");
            }
            return cnt;
        });
    }

    public void findSecretWord(String[] wordlist, Master master) {
        int n = wordlist.length;
        HashMap<Integer, HashSet<Integer>>[] set = new HashMap[n];
        for(int i=0; i<n; i++) set[i] = new HashMap<>(6);
        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n; j++) {
                int x = getDist(wordlist, i, j);
                set[i].computeIfAbsent(x, a -> new HashSet<>()).add(j);
                set[j].computeIfAbsent(x, a -> new HashSet<>()).add(i);
            }
        }
        HashSet<Integer> used = new HashSet<>();
        Integer cur = 0;
        int t = 0;
        while(t++ < 10) {
            int x = master.guess(wordlist[cur]);
            if(x == 6) return;
            HashSet<Integer> tmp = set[cur].get(6 - x);
            if (!used.isEmpty()) {
                tmp.retainAll(used);
            }
            used = tmp;
            Iterator<Integer> it = used.iterator();
            if (it.hasNext()) {
                cur = it.next();
            } else {
                return;
            }
        }
    }

    private int getDist(String[] wordlist, int i, int j) {
        int cnt = 0;
        for(int k=0; k<6; k++) {
            if(wordlist[i].charAt(k) != wordlist[j].charAt(k)) cnt++;
        }
        return cnt;
    }
}
interface Master {
    int guess(String word) ;
}