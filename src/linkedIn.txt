1. Given a BT, return its mirror

2. Implement a thread-safe blocking queue.

3. 一个嵌套Map， 就是一个Hash Map, 它的value可以是一个element也可以是另外一个
嵌套map或是空的map. 实现一个iterator来遍历这个map里面的所有element。 就是类
似树遍历一样的方法

4. Find an element occurs more than n/3 times in array. 

5.后缀波兰表达式STRING转换为中缀表达式的STRING。
这题本来很简单，但我可能算错了。纠结的地方是a,b,+,c,/ 
到底是 (c/(a+b)) 还是 ((a+b)/c)Reverse Polish notation
http://en.wikipedia.org/wiki/Reverse_Polish_notation

6. pow(x, n)  

7. (LC) 2-sum

8. 算逆波兰表达式。又是一个细节题，我知道会写错。小心翼翼地写，一边写一边解
释，最后还是有小错。

9. (LC) Valid number

10. Implement List Interface.

11. (LC) Search a 2D sorted array

12. coding就问了在数组中那个查找那个出现概率不小于1/2的数。后来做延伸到找K个
这样的数，不过那个面试者显然搞错了，说要求找top K个出现次数>=N/K (N是数组大
小)的数，这样唯一可能性就只有K个数每个都出现N/K次。开始被让晕了，后来发现这
个问 题。 

13. Intersection and  Union of two arrays 

14. 题目描述起来很简单，就是给出一个数，找出所有Unique的组合。 比如： 2 ：　
１＋１ 
３：　　１＋２，　１＋１＋１　 
４：　　１＋３，　１＋２，　１＋１＋１＋１，　２＋２ 

15. (LC) Max subarray sum
16. Max subarray product

17. (LC) search in rotated array 

18. implement Singleton in two ways

19. What is Mutex, Semaphore 

20. implement memmove (void* src, void* dec, size_t num_bytes) 
(c++ pass)

21. 输入是个stream
class input_stream
{
    // Character or -1
    int read();
}
每次call read（），返回一个char，如果到头了就是返回-

21. (LC) Roman To Integer

22. (LC) Text Justification

23. (LC) String to integer

24. (LC) Insert interval

25. Celebrity Problem 

26. (LC) build BST from its inorder and post-order

27. (LC) Sorted array, given element x, find how many times x shown in array 


28. Level sum，算是deep iterator的变种。一个多重nested array，例如{a,{b,c
},{{d},e}}，返回level sum = a + 2 * (b + c) + 3 * d + 2 * e。

29. (LC) First Common Ancestor with parent pointer。What if the parent pointer
is not available?

30. (LC) max subarray sum
31. (LC) BST to inoder and postoder array, then array to BST


32. (LC) pow(x,n), check boundaries, O(log(n)) (leetcode 2*)
33. (LC) rotated binary search (leetcode 3*)
34.  Implement a simple hash function, why use 31 as the magic number
35. Kth closest point to point P on a plane with N points (heap, comparator).
36. Implement dynamic ArrayList in Java
37. (LC) Maximum Subarray Sum
38.Maximum Product Subarray
39. Insert a node in a BST


40. tinyURL web service design. 

41. Difference between Interface  and abstract class
42.  multithread, thread safe
43. Difference between equals and == 
44. Difference between in Get and Post in Http Request
Solu: http://www.w3schools.com/tags/ref_httpmethods.asp
45.  Level-Weight-Sum, 如 {2, 4, {6, {8}}} calculate weighted sum. weight is the 
depth. result = 2*1 + 4*2 + 6*3 + 8*4. 
46. (LC) Two sum
47. (LC) Text Justification
48：minimize the cost of painting K houses, each house has different
costs to paint in different colors, 
        	2 houses (next to each other) cannot be painted in the same 
color. DP 

49. factorial digits sum。比如input为10，因为10！= 3628800，就返回sum的值 = 3+6+2+8 ...
用了java的BigInteger class 过了。
51. 之后很快安排了电面，题目是设计一个battleship游戏，和面试的人讨论细节后，需要implement相关的函数

52。查找2个单词的距离
/*
* Example:
*   WordDistanceFinder finder = new WordDistanceFinder(Arrays.asList("the",
"quick", "brown", "fox", "quick"));
*   assert(finder.distance("fox","the") == 3);
*   assert(finder.distance("quick", "fox") == 1);
*/
53. 洗牌 要求in-place

* Return the smallest character that is strictly larger than the search 
character, 
* ['c', 'f', 'j', 'p', 'v'], 'a' => 'c'



54. (LC) WordLadder
55. Implement memcpy(src, dest), src may overlap with dest. 
Like a C++ problem
56. Insert and delete in BST
57. Implement inorder Iterator of  BST 
58. 实现两个函数: H() and O(), 这两个函数会被多线程调用。当一个线程调用H或O时
，如果当前已经有至少两个线程call H和一个线程call O。那么让两个call H和一个
call O的线程返回（产生一个水分子），其他的都block。

59. Given a social graph, find if there is a path between two persons with at
most 2 steps (3rd level connection), how to handle it in distributed way (
large graph stored at a large number of nodes, minimize cross-communication)

60. Design. a restful server with 4GB,  
given a request such as: http://seq=4?len=60?xxxxdata
the system will store the binary data with that sequence number.
given a request: http://startseq=3?maxLen=100, the system returns all data objects with sequence >= 3 with total data length less equal than 100.
multiple clients calling simutaneous
what data structure, concurrency, locking, etc..


61. 一个双向链表，带头尾指针，每个节点可能都有父节点和子节点，每个父子节点又是
一个链表。要求把它拍扁，顺序随意。
一开始说了一个类似DFS的算法，他说我的空间复杂度是O(N)，我说递归的方法如果堆
栈空间也算的话确实是O(N)，但他咬定我临时放节点的地方也是O(N)，楞说我存节点需
要分配额外空间，我就很纳闷，这节点都已经是双向链表了，里面有next/prev，为毛
还需要分配O(N)的空间来存这些节点？坚持跟他讨论半天，把节点定义什么都给出来，
一点一点说明白，才证明是他理解有问题，幸好还算坚持，不然就被他带沟里去了。
当然这个算法有更好的解，既然不要求顺序，而且有头尾指针，每次把父子链表接到尾
巴后面就可以了。连递归都省了。

62. (LC) int sqrt(int x)
- 

63. (LC)  Permuation
64. Valid number. 
65. Nested integer weighted sum. 一个list, 元素可能是list，也可能是Integer，
但是每个元素都包装在NestedInteger类里面了，求weighted sum. 例子是{2, {4, {6}
}}. 应该返回2×1 + 4×2 + 6×3. 我可能该开始就省题不清，写成了 (((6*3) + 4)*
2 + 1)*1. 经过面试官提醒，改了一个小地方就对了。感觉自己代码还算简洁，总共15
行左右。



66.  (LC )Level order tree traversal. 
67.  Find the distance between two words in a list. The words can repeat.

68. (LC) pow(x, n)
69.  Number factorization (Repeated)
70. Write-through cache vs write-back cache 
71. what's memory mapped file
72.  给一个nested的int array， 返回sum of int weight by its depth
73.  写一个支持removeRandom的hashtable
74. 一串字符串，返回有多少个substring符合某些pattern，这些pattern都是10char的
长度，所以逐个比较就可以了
75.  tree lowest ancestor( tree node have parent pointer)
76. Data mining Position
2D matrix，行列都sorted，每行的第一个数小于前一行的最后一个数，给一个
target，判断其在不在矩阵内
如果没有第二个条件，如何搜索
如何使算法是log(m) + log(n)，log的底数是多少

77.  分布式相关问题，没深入细节，包括2pc, paxos, zookeeper的实现等
2. 波兰小伙
有点害羞，但人非常好。
a. message{msgId,byte[]}。大量message持续的input，要支持Message[] getAll(
msgId)，问怎么存储message。
问题：如何设计分布式倒排索引，如何进行query。
a. 假设有函数int[] getConnection(memberID)，结果是有序的，要求实现：
isFirstDegree(member1,member2)
isSecondDegree(member1,member2)
isThirdDegree(member1,member2)
就是判断一度，二度，三度好友关系，是系统设计题，伪代码即可。
follow up：分布式下怎么做

78. tinyurl
follow up:问如何scala-out
79. 给一个矩阵，followMatrix[i][j]==true，表示j影响了i。求influencer，即影响
所有人，且不被任何人影响
80. 三角形问题，输入一些线段的长度，找出能形成三角形的三条线段

81. (LC) max points on a line

82. (LC) Rotated binary search
83. (LC) 给你一个BST的pre-order traverse的结果，让你返回in-order traverse的结果。

84. (LC) double power(a,b)
85. (LC) binary tree level traversal，
              
86. Coding : Implement a blocking bounded queue
87. Coding: 要安装gcc 2.1 这个程序，会有一些 dependency，让你写个程序，让你返回安装一个程序所需的所有dependency。

88. 第一题：给一个words list, 输入两个单词，找出这两个单词在list中的最近距离(先
写了一个没有预处理的，又写了一个预处理建index的)
['green', 'blue', 'orange', 'purple', 'green']  f.distance(list, 'blue', '
green') # output 1
89. binary tree level order traversal, 写了三种方法。。。(BFS用arraylist，类似
DFS，BFS用queue)

90. (LC) edit distance
91. LCA(with parent pointer)
92. 写一个structure,要求支持o(1)加节点,删除指定节点,随机删除节点
93. 给一堆点， 找一条线穿过最多的点
94. 设计一个网络游戏hangman
95. 中午吃饭：不知道这个算不算面试的一部分，问了好多how do you improve xxx这类问
题，xxx是facebook, gmail, linkedin homepage


96. (LC) search in rotated sorted array，（with or without duplicates）
97. Given an array of integers, find out a triple of integers such that
they form a triangle. i.e. given a,b,c from the array, a +b >c, b +c >a, a 
+c >b, 返回任何三个就可以了。 

98. print  factors of a given integer 
example： 12 可以表示为：
12 ＊1
6 ＊2 ＊1
4 ＊3 ＊1
3 ＊2 ＊2 ＊1
要求走几个例子，写出完整的递归的stack trace

99. (LC) Lowest common ancestor w/ and w/o parent pointer
100. (LC) Search in rotated sorted array
101. Implement addInterval(start, end) and getcoverage(), 
102. Design: tinyurl 
103. exclusive array, give an arr1, return a new arr2, arr2[i] is the 
multiplication of all elements in arr1 except arr1[i] 
104. boolean isMirrorTrees(tree1, tree2)/inplace convert a tree to its mirror 
tree/create a new mirror tree
105. find the intersection of two linked list(do not use hashmap)
106. (LC) Text Justification
107. ? Print B-tree by level 
SKIP
108. replace string，就是实现java里面的String.replace(String find, String 
replace)
109. (LC) minimum window
110. isomorphic ?
111. union/ intersect of sorted linkedlist
112. (LC)lowest common ancestor; 
113. (LC)merge intervals
114. find the smallest character that is strictly larger than the search 
character; 
115. minimal distance between two words
116.  sum nested list; 
117. given a sequence of DNA (ATGC), find the 10-letter sequence that has the most occurrences
118.  technical communication. 介绍一个你最自豪的项目，会穿插问你一些问题
119. maximum points on a line 只做了一个题，开始互相介绍之后，因为对他做的东西
比较感兴趣，我问了他一些问题占用了好些时间。
120.  design a web-based hangman game. 两个表情严肃的印度大哥，怎么也逗不笑
121. hosting manager. 互相介绍，问了问背景。剩下时间全在讨论一个新API发布的问
题。这个API所有的接口全变了，存储也是全新的架构并且初始为空（数据在旧API后面
的存储），线上业务会读写数据。问怎么无缝线上发布，出问题怎么回滚，某些API调
用方没时间更新API的情况下怎么关掉旧API的server等等各种细节问题。
122. 给2个string，判断是否可以map. say (foo, abb) 这2个string是可以map的, f->a
, o->b. say (foo, sdf)，是不可以map的……返回bool值
123. 给一个string，每10个letter一组，输出所有出现次数超过一次的strings with 
length of 10. 一定要用rolling hashing做
124. 给一个数组，输出连续元素的最大和。
125. 判断2个linkedlist是否在某一点会重合. O(1) space.
126. (LC)Max Points on a Line
127. (LC) string reverse. 输入 "Hello, word"， 输出 "word Hello,".

128. 打印一个数的所有乘数组合，从大到小，不要有重复



129. (LC)search a number in rotated sorted array 
sum of nested list 

130. (LC)Given n points, find the nearest K points to a new point.
permutation (leetcode)


140. 给定一个undirected graph和一个s节点和一个d节点，判断s和d的距离是否<=3。距离
定义为s和d之间最短路径上link的数目。如果d是s的邻居，则距离为1。 
注意，这个undirected graph使用adjacent array来表示一个节点的所有neighbors，并
且每个节点最多有n个neighbors。每个节点都有一个Idx，并且每个节点的adjacent 
array都是sorted。例如1有邻居2和3，那么1的adjacent array是[2,3] (sorted)
直接的BSF解法时间复杂度是O(n^3)。
要求设计Solution是时间 O(n^2)。

141.  设计一个hash table，实现set（int key，int val）和get（int key）

142. Decide whether a target is covered by a list of intervals (类似merge 
intervals)

143. 设计一个iterator class处理文件line by line


144. Given two (dictionary) words as Strings, determine if they are isomorphic
. Two words are called isomorphic if the letters in one word can be remapped
to get the second word. Remapping a letter means replacing all occurrences 
of it with another letter while the ordering of the letters remains 
unchanged. No two letters may map to the same letter, but a letter may map 
to itself.
Example:
Given "foo", "app"; returns true
   we can map 'f' -> 'a' and 'o' -> 'p'
Given "bar", "foo"; returns false
   we can't map both 'a' and 'r' to 'o'
Given "turtle", "tletur"; returns true
   we can map 't' -> 't', 'u' -> 'l', 'r' -> 'e', 'l' -> 'u', 'e' -'r'
Given "ab", "ca"; returns true
   we can map 'a' -> 'c', 'b' 

1. Implement Linked list.
3. Design question, tiny url service. 
5. Coding: same tree, 
calculate product of an array without the number itself





题目就是有个msg class

class Msg
{
  long key;  
  long value;
};
每个Msg都对应一个key。现在要设计一个class，实现如下功能
class Window
{
  Window(int nMilliseconds);
  addMsg(Msg m);
  Msg getMsg(long key);
  Double getAvg();
};
nMilliseconds给你了个time window，比如说如果是１０分钟，你只保存当前为止１０
分钟前的MSG。你需要能够添加信息，实现对于key的query（注意如果这个key对应的信
息是１０分钟前的，就返回NULL）， 和计算所有１０分钟内msg的平均。
我本来想用circular array，但不知道该怎么存这些msg。还有就是每个key和msg应该
用map来存吧，但如果用CIRCULAR ARRAY对于过时的信息还是得在MAP里一条一条删除。
我觉得好象也没有怎么省时间。所以我干脆用一个linkedlist来存每个MSG的timestamp
和msg，每次调用其他函数前先得update ，同时在list和map里删除过时的节点。对于
计算AVG，只需要记录tot和msg的个数，并update就可以了.不知道这题要不要考多线程
，反正我跟面试官说我一点也不会。
class MsgWrapper{
	Msg m;
	long timeStamp;
	MsgWrapper(long t, Msg msg){
    	m = msg;
    	timeStamp = t;
	}
}
class Window{
	private long getTimeStamp(){
    	return System.currentTimeMillis();
	}
	long windowSize;
	List<MsgWrapper> list;
	long tot;
	int numMsg;
	Map<Long, Msg> map;
	Window(int nMilliseconds){
    	list = new LinkedList<MsgWrapper>();
    	windowSize = (long)nMilliseconds;
    	tot = 0;
    	numMsg = 0;
    	map = new HashMap<Long, Msg>();
	}
    
	private long update(){
    	long timeStamp = getTimeStamp();
    	long lastTimeStamp = timeStamp - windowSize;
    	int ptr = 0;
    	while (ptr < list.size()){
        	if (list.get(0).timeStamp < lastTimeStamp){
            	Msg currMsg = list.get(0).m;
            	map.remove(currMsg.key);
            	tot -= currMsg.value;
            	--numMsg;
            	list.remove(0);
        	}else
            	break;
    	}
    	return timeStamp;
	}
    
	addMsg(Msg m){
    	update();
    	list.add(new MsgWrapper(currTImeStamp, m));
    	map.put(m.key, m);
    	tot += m.value;
    	++numMsg;
	}
    
	Msg getMsg(long key){
    	update();
    	return map.get(key);
	}
    
	double getAvg(){
    	update();
    	return ((double)tot)/numMsg;
	}
}
他最后也没说什么也没给提示。有没有朋友帮忙给出更efficient的解法呀？上次别人
贴这题的时候就有不少朋友说CIRCULAR BUFFER。到底该怎么用呢？非常感谢

onsite:

第一轮：hiring manager，主要就是谈project，我讲了我最近在做的一个OO design的
东西，因为和面的组没啥关系，看得出来hiring manager是耐着性子听我说完的 :-P

第二轮：印男加国男，given a stream of data and a sliding window, implement 
put(), getAverage(),和另外一个function（忘了是啥了）。考虑multithreading的情况

第三轮: 吃饭

第四轮：最坑爹的一轮，recruiter告诉我也是跪在了这一轮，所以多说两句。来的是
个中年老印加一个中年国男，国男shadow。老印一出现就是一幅超鄙夷超不屑的臭脸。
出了一个inverted index的题，就是有一大堆doc，对doc里出现的word建inverted 
index，doc很多所以是distribute在很多machine上的，问怎么实现这个inverted 
index。我听了题目暗爽，这种题我准备的很充分啊！因为这题有很多解法，我就从差
到好一一说来，每个都说了为啥不好，然后引出我认为最好的那一个。可是我每说一个
老印就急吼吼的跳起来反驳我。搞了两回，我意识到可能老印就是想听最佳答案，我就
解释说我只是想list一下所有的option，我也问他你是不是prefer直接告诉你最佳答案
？他说是。我就直接给了我认为的最佳答案。

接下来还有几个相关的小问题我都忘了，有一个是关于map reduce的。最后一个，是找
出前K个最常用的word。我说用min heap找出每个machine的K个最常见word，再用一个
min heap merge这些list。奇葩的事情就出现了，老印跳出来说，不对，你用min heap
是不对的，应该用max heap！这时国男也一脸诚恳的“提醒”我说：是的，你用min 
heap找出来的是最不常用的K个word哦！我我我，我当场就愣了！不会吧，俩linkedin
的老员工了，好歹是个面试官啊，居然连min heap和max heap是啥都不知道？愣了两秒
，我就给他们讲了一遍啥是min heap啥是max heap，和为啥找K个最常用的word要用min
heap而不是max heap。一遍讲我一边想：我这是来面试的还是来给linkedin的员工培
训基本data structure的？最后俩人还是将信将疑，又问了一个有关于thread的小问题
就结束了。

第五轮：小印女加小印男，也是问了一个类似在stream里找k个最大数的题，我还是用
了min heap，还好俩人都知道啥是min heap，也比较认同我的做法。然后大部分的时间
都在讨论multi threading的实现，我提到了read write lock，和三种fairness 
policy，不过他俩都是一脸茫然，好像他们只知道read write lock，但不知道
fairness这回事，挺奇怪的。（另：刚又想起，这一轮还问了max point on a line一
题，leetcode上有，只要求pseudo code，我做了个square的，问小印男还有没有更快
的，他说就他所知没有了）。

第六轮：亚裔男（不是国男）加印男，问了romanToInt和intToRoman的题，intToRoman
和leetcode一样，但romanToInt要考虑很多corner case。这些corner case在leetcode
和EPI上都没有提到过。另外，好像EPI上的解法很多错误，我没看几道题就已经找出很
多错了，有的错的很离谱，大家得注意一下。

第七轮：白男加国女，问了一个design的题，design monitoring system，自我感觉是
发挥的最好的一轮。


http://www.mitbbs.com/article_t/JobHunting/32754421.html


1.  Return if two strings are isomorphic. (character 1-1 match)
“zoo” -> “fee”  ( z->f, o->e)           	true
“zoo” -> “dui”  ( z->d, o->u, o-> )    	false
“dui” -> “zoo” (d->z, u->o, i-> )     	false

Use two hashmaps

*****************************************************************
2.  K nearest points (solution see below)  Time: O(nlgk)

*****************************************************************
2. public interface Intervals {

	/**
 	* Adds an interval [from, to] into internal structure.
 	*/
	void addInterval(int from, int to);


	/**
 	* Returns a total length covered by intervals.
 	* If several intervals intersect, intersection should be counted only 
once.
 	* Example:
 	*
 	* addInterval(3, 6)
 	* addInterval(8, 9)
 	* addInterval(1, 5)
 	*
 	* getTotalCoveredLength() -> 6
 	* i.e. [1,5] and [3,6] intersect and give a total covered interval [1,6]
 	* [1,6] and [8,9] don't intersect so total covered length is a sum for 
both intervals, that is 6.
 	*
 	* 0  1	2	3	4	5   6   7	8	9	10
 	*/
	int getTotalCoveredLength();
}


两轮电话，一天onsite. onsite全是白人和ABC,还有一个日本哥们，他是唯一的senior
staff engineer.

具体题目基本都在leetcode上见过，没见过的思路也类似。我觉得做题还是对编程水平
有提高，至少拓宽了思路。覆盖了binary tree, BST, arrays, dynamic programming.

onsite两轮解题，每轮两道题。还有一轮设计题，是一个staff engineer问的，讨论如
何实现一个具体的功能：每天都有很多人共享文章，怎样算出共享最多的文章，过去5
分钟，过去1小时，过去一天等等。我给出了数据结构，核心问题的解决算法，最后讨
论了整体的架构。比如说几个data center直接怎样联系，需要往返什么样的数据。在
解决核心问题的时候卡了一会儿，在一点提示下明白了如何实现。感觉一定要不停的说
不停的问，想到什么哪怕不对都要说出来，面试的人才知道你的思路才能帮你。然后和
hiring manager聊天，聊以前的经历和人生。最后是和那个日本哥们，他让我假设他是
一个新来的，然后给他讲解项目的细节。这个没法瞎扯，确实需要自己亲自做过参与过
一个项目，要很熟悉。他一边看技术和经验，另一边看交流能力。这个提前准备一下还
是很有用。

我在第二轮解题的时候最后一道题耽误了时间，最后一分钟写出了DP算法核心部分的代
码，但是没有时间写如何初始数组。。。只能口头描述了一下。不知道是不是会栽到这
儿。。。其他的题做得很顺，讲解思路加基本上一次写出正确答案。希望他们不要太计
较时间仓促没写出完整的答案。。。请大家帮忙祝福一下。

LGF 混合
给一个填字游戏的grid， 有些cell不能填，给你一个dict，完成填字
树寻找maximun path sum（LC原题）
数组排序， 排成a1<a2>a3<a4>a5...问的非常的细
string replace, 给一个原string，一个target，一个替换的新str，把所有出现
target str的地方都换成新的str， 长度可以任意
maximum point on line(LC)
interval merge(LC)
给一个string，判断是不是UTF-8
给一个数学表达式，自己想方法表示它，实现算值简化还有个什么功能忘了
有障碍的房间里找最短路径，直觉应该A*最好但是具体忘了怎么写了最后写了个DFS面
试官也没让优化，就问了下用哪些test case
print tree by level(LC)
水只能往低处流，标出水能同时流到两个地方的点
reverse words in a string(LC)
设计在线日历系统，不擅长这个，跟他们说我先不考虑时区问题，之后再考虑，然后后
来答的乱七八糟的也没时间考虑了。


