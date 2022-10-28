# hgottam-ICA8-Test
## SER 515  Testing 
### Task task: 
<p> You need to write a function that returns the maximum of free urinals as an integer according to the unwritten rule. </p>
Examples:

10001 returns 1 (10101) 
1001 returns 0 (1001) 
00000 returns 3 (10101) 
0000 returns 2 (1001) 
01000 returns 1 (01010 or 01001)  
011 returns -1 

#### Input 

<p>A String containing 1s and 0s (Example:  10001 ) (1 <= Length <= 20). This string can come from the keyboard, or a file 
called urinal.dat. The program will continue processing until a -1 or <eof> is reached. (This means you handle unusual 
input without crashing.) <p>

<p> A one stands for a taken urinal and a zero for a free one. </p>
#### Output 
<p> If input is the keyboard, print the results to the screen. If input is from a file, output to rule.txt. If the file rule.txt already 
exists, increment a counter, and rename the file using the following rule pattern:  rule1.txt, rule2.txt, etc. The output is 
JUST THE NUMBER of free urinals. Given the above output, your rule.txt file should contain: </p>
1 
0 
3 
2 
1 
-1 
