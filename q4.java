//question 4

/*
 * 給定一個字串s，代表希望計算的運算式。
 * 內容包含加減乘除四種運算符號(先乘除後加減)以及數字。
 * 數字與運算間皆用"一個空格"隔開。計算運算式s的結果並將其回傳。
 *
 * 試寫出二個 function
 *
 * 第一個 function 不用處理乘與除，只會傳入加與減的運算式，例如:傳入 "3 + 2 - 4"，需回傳 1
 *
 * 第二個 function 處理四則運算，先乘除後加減，例如:傳入 "2 + 4 * 3 - 8 / 2"，需回傳 10
 *
 * */


solution1('3 + 2 - 4');

function solution1(s) {
		int sum[] = new int[(s.length()+1)/2];
		char symbol[] = new char[(s.length()-1)/2];
		int j = 0, k = 0;
		for(int i = 1;i<=s.length();i++) {
			if(i%2 == 1) {
				sum[j] = s.charAt(i-1);
				sum[j] = sum[j]-48;
				j++;
			}else{
				symbol[k] = s.charAt(i-1);
				k++;
			}
		}
		
		int n = sum[0];
		for(int i=0;i<symbol.length;i++) {
			switch(symbol[i]) {
			case '+':
				n = n+sum[i+1];
				break;
			case '-':
				n = n-sum[i+1];
				break;
			case '*':
				n = n*sum[i+1];
				break;
			case '/':
				n = n/sum[i+1];
				break;
				default:
					break;
			}
		}
		return n;
}


function solution2(s){

}



