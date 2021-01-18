# Problem Three: Merchant's Guide to the Galaxy

You decided to give up on earth after the latest financial collapse left 99.99% of the earth's population with 0.01% of the wealth. Luckily, with the scant sum of money that is left in your account, you are able to afford to rent a spaceship, leave earth, and fly all over the galaxy to sell common metals and dirt (which apparently is worth a lot).
 
Buying and selling over the galaxy requires you to convert numbers and units, and you decided to write a program to help you.
 
The numbers used for intergalactic transactions follows similar convention to the roman numerals and you have painstakingly collected the appropriate translation between them.
 
Roman numerals are based on seven symbols:
 
```
Symbol  - Value

I     -   1

V     -   5

X     -   10

L     -   50

C     -   100

D     -   500

M     -   1000
```


Numbers are formed by combining symbols together and adding the values. For example, MMVI is 1000 + 1000 + 5 + 1 = 2006. Generally, symbols are placed in order of value, starting with the largest values. When smaller values precede larger values, the smaller values are subtracted from the larger values, and the result is added to the total. For example MCMXLIV = 1000 + (1000 − 100) + (50 − 10) + (5 − 1) = 1944.


The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) "D", "L", and "V" can never be repeated.
"I" can be subtracted from "V" and "X" only. "X" can be subtracted from "L" and "C" only. "C" can be subtracted from "D" and "M" only. "V", "L", and "D" can never be subtracted.
Only one small-value symbol may be subtracted from any large-value symbol.
A number written in [16]Arabic numerals can be broken into digits. For example, 1903 is composed of 1, 9, 0, and 3. To write the Roman numeral, each of the non-zero digits should be treated separately. Inthe above example, 1,000 = M, 900 = CM, and 3 = III. Therefore, 1903 = MCMIII.
(Source: Wikipedia ( [17]http://en.wikipedia.org/wiki/Roman_numerals)
 
 
Input to your program consists of lines of text detailing your notes on the conversion between intergalactic units and roman numerals.
 
You are expected to handle invalid queries appropriately.
 
### Test input:
```
glob is I
prok is V
pish is X
tegj is L
glob glob Silver is 34 Credits
glob prok Gold is 57800 Credits
pish pish Iron is 3910 Credits

how much is pish tegj glob glob ?
how many Credits is glob prok Silver ?
how many Credits is glob prok Gold ?
how many Credits is glob prok Iron ?
how much wood could a woodchuck chuck if a woodchuck could chuck wood ?
```


### Test Output:

```
pish tegj glob glob is 42
glob prok Silver is 68 Credits
glob prok Gold is 57800 Credits
glob prok Iron is 782 Credits
I have no idea what you are talking about
```
### Program environment

```markdown
1. jdk1.8
2. IntelliJ IDEA
3. windows/linux
```

### Problem solving ideas

```markdown
1. 读取需要输入的内容文件
2. 解析数据,数据分为两大类:
   2.1 用于计算的规则,又分为两大类
      2.1.1 与题目给出的标志相对应的数据 例如:glob is I
      2.1.2 由2.1.1数据组装的组合数据 例如:glob glob Silver is 34 Credits
   2.2 需要解答的问题,分为两大类
      2.2.1 how much xxx 例如:how much is pish tegj glob glob ?
      2.2.2 how many xxx 例如:how many Credits is glob prok Iron ?
3. 利用策略模式将不同种类的数据分别处理
```

### Program advantages

```markdown
1. 充分利用java8 lambda表达式以及Stream流式处理,简化代码
3. 利用策略模式处理对应的数据,减少不必要的if else 语句
4. 吸取spring中的jsr-303数据校验思路,捕捉全局异常并输出
```

### Program disadvantages

```markdown
1. 对文件输入的内容没有进行正则表达式校验,会面临很多的因不满足规则而无法计算的数据
2. 程序处理的数据规则不灵活,如果规则变化,会面临修改代码的问题
3. 还可以改进的地方:输入的内容可以打乱,但是在解析数据时,必须先将2.1.1中的数据处理完后,再处理其余数据
```