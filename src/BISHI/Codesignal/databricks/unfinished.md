(3) q is simulation question, input array of audiobook length and logs. 
for each log it could either be listen x or drop i, 
if listen we listen the current audio book for x minute, 
if drop we ban this book and never listen to it in the future. 
If we reach the end of the audiobook array we would start from index 0 again. 
Find the audiobook with the maximum listening time. Break tie by selecting largest index.

(3) bubble
因为是一起explode，你先定义一个二维矩阵，然后helper function dfs把这个矩阵传进去，
对每个点四个方向搜索记录同颜色的数量，和位置，如果大于等于2就把记录的位置在矩阵里标true，
然后再创建一个新矩阵存储炸以后的情况，你从下往上update，如果是true就填false继续往上，没填的都是0就可以了
Imagine you are given a board of cells, each containing a bubble of a specific color (as shown below). 
Neighboring cells of the bubble are defined as adjacent cells (on either the same row or column as the given cell) 
which have a common side with the given cell. For example. the neighboring cells for each of the cells A, B, and c are 
highlighted in corresponding color in the picture below.

Your task is to perform a bubble explosion on the board. A bubble explosion is defined by the following rules
A bubble within any given cell is eligible to explode if it has the same color as bubbles in at least 2 neighboring cell 
All eligible bubbles and bubbles of the same color in neighboring cells are marked for explosion.
All marked bubbles explode at the same time. Exploded bubbles are removed from the board, resulting in empty cells
After all exploded bubbles are removed, remaining bubbles in cells above the empty cells drop down to fill all empty cells

(3) 进货、更新货物、卖货。
进货：进p_name商品共count个，每个价值price；
更新：更新p_name商品count个，把原价old_price升级为new_price，共升级count个
卖货：卖出p_name商品count个，优先卖出便宜货。返回这次卖出的总收益
Medium难度
用哈希表存储 key商品名：value优先级队列 [价格，价格，价格，。。。]，卖出时，优先弹出最小值

(4) 给一个数组和一系列操作
当操作为L时，将第一个出现的0改为1
当操作为C {val}时，将索引第 val 个改为0
返回操作后的数组
Medium难度
将所有值为0的所以存在一个优先级队列，每次操作为L时，弹出最小，操作为C时，推入当前索引

(4) 给一个diff，一堆queries，每次给你加入或者移除一个数，‍ 然后你输出当前集合所有差为diff的pair个数。
解：记录一个res初始为0，用一个map，
加x，
res += map[x - diff] + map[x + diff]
map[x]++
减x，
res -= map[x - diff] + map[x + diff]
map[x]--
每次更新之后的res就是每次query需要返回的值

(3) 第三题，假设有n个server（编号0至n-1），对这些server发送两种命令，
第一种：工作；第二种：重启第i个server。如果是第一种，则顺序找到下一个可以工作的server进行工作，消耗一秒钟；
如果是第二种，将指定的server重启，使得其立刻结束maintain时间。
maintain时间是指，如果一个server连续执行过k个工作（k是问题的一个输入），就会进入t秒的maintain（t是问题的一个输入）。
最后返回哪个server执行了最多的工作。

(3) 给一个2d array of strings代表每个人赛车的最好成绩，要求按成绩每轮淘汰一个人，return string array of 淘汰顺序。

比如[["alice 160", "eddie 170", "mark 130"], ["alice 160", "eddie 170", "mark 170"], [["alice 160", "eddie 170", "mark 110"]]
第一轮淘汰eddie，第二轮淘汰alice，因为mark最好成绩是130，第三轮淘汰mark因为只剩他了。
这题lz用java的map做的，搞了半天没debug出map哪里出了问题，最后只过了一两个test case

(3) 给你一个N乘N的矩阵。然后这个矩阵里面只有三种数字，0，1，2，然后他说他要在这个矩阵里面画一个Y，
这个Y必须是就是正着的Y。然后有两种颜色，颜色可以选，一种是Y的颜色，一种是它的背景的颜色，
然后每一种颜色就是可以选零一或者二。然后你要把这个矩阵里面的数字给替换掉，来形成一个Y，他问你最少的。替换次数是多少？


