## What is dynamic programming? ##
in simple world it is statergy to optimize recusive problem.
Idea is if you have overlapping problem , you can store results instead of recomputing it.

DP is implemented by two approaches
1. Memoization (Top -down approach)
2. Tabulation (Bottom up approach)

Where is it used ?
1. routing , string search , diff utility and buy selling problem.

### Memoization ###
Simple implementation without DP
e.g. Fibonnaci number
// 0, 1, 1, 2,
```java
// find nth fibonnaci number
int fib(int n){
    if (n==0|| n==1)
        return n;
    else
        return fib(n-1)+fib(n-2);
}
```

problem is complexity of this solution is 2^n or golden ratio to the power is expontial
Can we do better ? Yes it we can store precomputed value we will save alot and bring time complexity to `N`

Implementing it using memoization
```java
int fit(int n, Map<Integer, Integer>nValMap){
        if (n==0|| n==1){
            return n;
        }
        if(!nValMap.containsKey(n)){
            int result = fit(n-1)+ fit(n-2);
            nValMap.put(n, result);
            return result;
        }else{
            return nValMap.get(n);
        }
    }
```

### Tabulation ###
This is a bottom up solution, meaning  we will iterate from starting, compute and store. 
we would reuse stored value to compute and proceed further
```java
int fit(int n){
    if (n==0|| n==1){
        return n;
    }
    int[] res= new int[n+1];
    res[0]=0;
    res[1]=1;
    for (int i=2;i<=n;i++){
        res[i]=res[i-1]+res[i-2];
    }
    return res[n];
}

```

> **Point to remember**
> Memoization is easy to  implement verse tabulation. Example is optimal strategy for a game, tabulation is very hard to implement
> Memoization is expensive since you have overhead of function call (Function stack etc)

### Question: Find the longest common subsequence of given two Strings  ###
e.g. s1=ABCDGH s2=AEDFH op=3  because A_D_H are subsequence common in both
1. By Memoization

```java
class Main {
    int getMaxSubSequence(String s1, String s2, int m, int n, int[][] cache) {
        // We will iterate on reverse order
        // Base condition
        if (m == -1 || n == -1) {
            return 0;
        }

        if (cache[m][n] == -1) { // not precomputed
            if (s1.charAt(m) == s2.charAt(n))
                cache[m][n] = 1 + getMaxSubSequence(s1, s2, m - 1, n - 1, cache);
            else // we will iterate on all possible and find max
                cache[m][n] = Math.max(getMaxSubSequence(s1, s2, m, n - 1, cache), getMaxSubSequence(s1, s2, m - 1, n, cache));
        }
        return cache[m][n];
    }
}

```

2. Tabular solution

```java
int getMaxSubSequence( String s1, String s2){
    // Remember that this is bottom up solution which means we need to reconstruct  for smallest
    // Please not m and n are not index but length    
    int m=s1.length(), n=s2.length(); 
    int [][] cache = new int[m+1][n+1];// we take addition size because we want to consider empty string also
    for (int i=0;i<=m;i++)
        cache[i][0]=0 // fill last column
        
    for (int i=0;i<=n;i++)
        cache[0][n]=0 // fill last row
        
    for  (int i=1; i<=m;i++){
        for(int j=1;j<=n;j++){
            if (s1.charAt(i-1)==s1.charAt(j-1)){
                cache[i][j] =1+cache[i-1][j-1];
            }else{
                cache[i][j] = Math.max(cache[i][j-1], cache[i-1][j]);
             }
        }    
    }
    return cache[m][n];
}

```

### Question: Coin count problem ###
Coin: [1,2,3]
Sum: 4
find  count of all combination to get sum 4
[1,1,1,1] [1,2,1] [1,3] [2,2]
so total 4

1. Naive approach
```java
int getCoin(int [] coin, int idx, int currSum){
    if(idx>=coin.length|| currSum<0 )
        return 0;
    if(currSum==0){
        return 1;
    }
    // Include element and reduce sum or don't include it and let sum as is
    return getCoin(coin, idx, currSum-coin[idx])+ getCoin(coin, idx+1, currSum) ;    
}

int getCoinCountCombination( int[] coin, int sum){
        return getCoin(coin, sum);
 }
```

2. Using memoization
```java
int getCoinMem(int [] coin, int idx, int currSum, int[][] cache){
    if(idx>=coin.length|| currSum<0 )
        return 0;
    if(currSum==0){
        cache[idx][currSum]=1;
        return 1;
    }
    
    // Include element and reduce sum or don't include it and let sum as is
        int diff=currSum-coin[idx];
    if (diff >=0 && cache[idx][diff]=-1 ){
        cache[idx][diff] = getCoin(coin, idx, currSum-coin[idx])+ getCoin(coin, idx+1, currSum);
        }    
    return cache[idx][diff];    
}

int getCoinCountCombination( int[] coin, int sum){
        int [][] cache = new int [coin.length][sum];
        for (int r=0; r<cache.length;r++){
            for (int c=0;c<cache[0].length;c++){
                cache[r][c]=-1;
            }
        }
        return getCoinMem(coin, sum, cache);
 }


```

### Question: Edit distance problem
    Find minimum number of operation (Update, delete , insert) to convert String A1 to A2
    e.g. SUNDAY -> SATURDAY  is  3, CAT->CUT  1 (update A) GEEK->GEEKS is 1 etc

Naive approach
```java

/***
 * i and j are length of s1 and s2 respectively
 */
int getMinOperation(String s1, String s2, int i , int j){
    // base case
        if(i==0) return j;// Because I need j insert operation to make both string equal
        if(j==0) return i;
    
    if (s1.charAt(i-1)==s2.charAt(j-1)){
        return getMinOperation(s1, s2,i-1,j-1);
    } 
    else{
        // Problem is how to represent insert , update ???
        return 1+ Math.min( Math.min( getMinOperation(s1,s2,i-1,j-1), 
                    , getMinOperation(s1,s2,i-1,j)),getMinOperation(s1,s2,i,j-1)); // 1 is added at end
    
    }
    
        }
        

int editDistance(String s1, String s2){
    return getMinOperation(s1, s2, s.lenght , j.length)
        }
```

### Tabulation based solution
```java
int editDistance(String s1, String s2){
    // Create table to hold value and it should be n+1 m+1 size
        int [][]cache = new int[s1.length+1][s2.length+1];
    // fill 1st row and 1 column with 1-n and 1-m ???    
        for (int i=0; i<cache.length;i++)
            cache[i][0]=i;
        for (int i=0; i<cache[0].length;i++)
            cache[0][i]=i;
        
        // Now iterating 
        for (int r=1;r<=s1.length();r++){
            for (int c=1;c<=s2.length();c++){
                if (s1.charAt(r-1)==s2.charAt(c-1))
                    cache[r][c]=cache[r-1][c-1];
                else
                    cache[r][c]=1+ Math.min(cache[r-1][c], Math.min(cache[r][c-1], cache[r-1][c-1]));
            }   
        }
        return cache[s1.length][s2.length];
        
        }

```

### Question: Count Longest increasing subsequence in array
e.g. a=[3,4,2,8,10] o/p is [3,4,8,10] ans=4
Naive approach
```java
/***
 * i is lenght
 */
int getLongestSubSeq(int [] ip){
    int [] lis= new int [ip.length];
    lis[0]=1;
    for (int i=1;i<ip.length;i++){
        int maxLis=0;
        for (int j=i-1; j>=0;j--){
            if (ip[j]<ip[i]){
                maxLis=Math.max(lis[j],maxLis);    
            }   
        }
        lis[i]=maxLis+1;
    }
    int res=1;
    for (int i=1;i<lis.length;i++) res=Math.max(res, lis[i]);   
    
    return res;

}

```
Time complexity is Theta (n^2)
Space Complexity is Theta (n)

Better way to do it is using Binary search ...
Let us try it.

```java
// 3,4,2,8,10

int binarySearch(int[] ip, int payLoad, int s, int e){
    while(s<e){
    int mid=s+(e-s)/2
        if(ip[mid]>=payload) 
            e=mid;
        else
            s=mid+1;
    }
    return e;
}   

int getLongestSubSeq(int [] ip){
// First we need to track LIS Array
        int []lis = new int [ip.length];
        lis[0]= ip[0];
        int last=ip[0];
        int ctr=1;
        // Now we will iterate all element and find LIS
        // Please note that result is finally sum of length of array
        for (int i=1;i<ip.length;i++){
            
            if(last<=ip[i]){
            //Simply add
            lis[ctr]=ip[i];
            ctr++;
            }else{
                // search and replace
                int idx= binarySearch(ip, ip[i], 0, ctr);
                lis[idx]=ip[i];
            }
            
        }
        return ctr;
}

```

### Question: WAP to find maximum sum of increasing subsequence

```java
// I will use LIS approach an then find sum of it
 int getMaxSumOfLst(int [] nums){
         int [] lis=new int [nums.length];
         lis[0]=nums[0];
         for (int i=1;i<nums.length;i++){
            int maxSum=Integer.MIN_VALUE;
            for (int j=i-1;j>=0;j--){
                if(nums[j]<=nums[i]){
                    maxSum=Math.max(lis[j],maxSum );
                }
            }
            lis[i]=nums[i]+maxSum;
        }
        int maxSum=Integer.MIN_VALUE;
        for (int i=0;i<lis.length;i++){
             maxSum= Math.max(maxSum,lis[i]);
        }
        return maxSum;
}
```

### Question: WAP to find maximum length bitonic subsequnece
ip= [1,11,2,10,4,5,2,1]
op= 6 ( because  1,2,10,5,2,1) 
in bitonic left and right side, both can be empty
```java
// So Idea is simple  Take LIS from right and left and do sum of it 
// But make sure to -1 since we would count index twise
int getMaxLenBitonicSeq(int [] nums){
    int [] lis = new int[nums.length];
    int [] lds = new int[nums.length];
    // computing lis
        lis[0]=1;
        for(int i=1;i<nums.length;i++){
            int maxLen=1;
            for (int j=nums.length-1;j>=0;j++){
               if(nums[i]>=nums[j])
                   maxLen=Math.max(maxLen, nums[j]);
            } 
            lis[i]=maxLen+1;
        }
        
        // Computing LDS
        lds[nums.length-1]=1;
        for (int i=nums.length-2;i>=0;i--){
            int maxLen=1;
            for (int j=i+1; j<nums.length;j++){
                if(num[i]<=num[j])
                    maxLen=Math.max(maxLen, nums[j]);
            }
            lds[i]=maxLen+1;
        }
        int max=1;
        for (int i=0;i<nums.length;i++){
            max=Math,max(max, lds[i]+lis[i]-1);
        }
        
        return max;
    }

```

### Question Maximum cut on rode
input rode=5 a=2 b=3, c=5

```java
int maxCut(int leftOutRod, int a, int b, int c){
    if (leftOutRod <a && leftOutRod < b && leftOutRod < c)
        return -1;
    if (leftOutRod ==a && leftOutRod == b && leftOutRod == c)
        return 1;
        
    int res =Math.max(Math.max(maxCut(leftOutRod-a,a,b,c),maxCut(leftOutRod-b,a,b,c)), maxCut(leftOutRod-c,a,b,c));
    if (res==-1)
        return res;
    else
        return res+1;
    
}
```

converting it to memoization approach

```java
int maxCut(int leftOutRod, int a, int b, int c, int []cache){
    if (leftOutRod <a && leftOutRod < b && leftOutRod < c)
        return -1;
    if (leftOutRod ==a && leftOutRod == b && leftOutRod == c)
        return 1;
        
    if(cache[leftOutRod]==-1){


        int res=Math.max(Math.max(cache[leftOutRod-a],cache[leftOutRod-b]), cache[leftOutRod-c]);
        if(res==-1)
        cache[leftOutRod] =res;
        else
        cache[leftOutRod]= res+1;
    }
    return cache[leftOutRod];
}
```

Converting it to tabular approach
```java
int maxCut(int rode, int a, int b, int c){
    int []tab = new int [rode.length+1];
    tab[0]=0;
    for (int i=0; i<=rode;i++){
        tab[i]=-1
         if (i-a>=0) Math.max(tab[i-a],tab[i]);
        if (i-b>=0) Math.max(tab[i-b],tab[i]);
        if (i-c>=0) Math.max(tab[i-c],tab[i]);
        if(tab[i]!=-1)
            return tab[i]++;
    }
    return tab[rode];
        
    
}
```