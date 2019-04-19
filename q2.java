
//question 2

/*
 * f(n) 為一費式數列。
 * 費式數列規則為：第n項之值是第n-1項及第n-2項之和，且f(0)=1,f(1)=1
 * 即：
 * f(0)=1,
 * f(1)=1,
 * f(2)=2,
 * f(3)=3,
 * f(4)=5,
 * f(5)=8,
 * f(6)=13
 * ...以此類推。
 *
 * 試寫出一 function 傳入 一數字 n 回傳 f(n) 的值。
 *
 *
 * */

solution(4);


function solution(n){
        if(n==1)
                return 1;
        else if (n==2)
                return 1;
        else
                return solution(n-1)+solution(n-2); 
}


