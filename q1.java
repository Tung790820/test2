//Question 1

/*

程式碼解說--身份證字號規則說明

1.目前的中華民國身分證字號一共有十碼，包括起首一個大寫的英文字母與接續的九個阿拉伯數字，最後一位數字為檢查碼。
　　　(1)英文代號以下表轉換成數字
　　　A=10 台北市　　　J=18 新竹縣　　　S=26 高雄縣
　　　B=11 台中市　　　K=19 苗栗縣　　　T=27 屏東縣
　　　C=12 基隆市　　　L=20 台中縣　　　U=28 花蓮縣
　　　D=13 台南市　　　M=21 南投縣　　　V=29 台東縣
　　　E=14 高雄市　　　N=22 彰化縣　　* W=32 金門縣
　　　F=15 台北縣　　* O=35 新竹市　　　X=30 澎湖縣
　　　G=16 宜蘭縣　　　P=23 雲林縣　　　Y=31 陽明山
　　　H=17 桃園縣　　　Q=24 嘉義縣　　* Z=33 連江縣
　　* I=34 嘉義市　　　R=25 台南縣　

　　(2)，而首位數字則是拿來區分性別，男性為1、女性為2，
2.規則說明：
　　　(1)英文轉成的數字, 個位數乘９再加上十位數
　　　(2)各數字從右到左依次乘１、２、３、４．．．．８
　　　(3)求出(1),(2)之和
　　　(4)求出(3)除10後之餘數,用10減該餘數,結果就是檢查碼,若餘數為0
　　　　 檢查碼就是0
例如:A123456789

A=10，帶入後變成
10123456789
套入公式: 1x1 + 0*9 + 1*8 + 2*7 + 3*6 + 4*5 + 5*4 + 6*3 + 7*2 + 8*1 + 9 = 130 ,130除以10為整除表示該身分證有效

 * 根據身分證規則，可參考q1_explanation.php
 * 試寫出一 function
 * 若傳入的是 身分證字串(例如:"A123456789") 回傳是否為合法的身分證字號 合法回傳true 不合法回傳false
 * 若傳入的是 資料陣列(例如:["gender"=>"男","location"=>"台中縣"]) 則回傳一組符合地點及性別的隨機合法身分證字串
 *
*/
solution(A123456789);

	public static char stringToChar (String s) {
		switch(s) {
		 case "台北市":
		   return 'A';
		 case "新竹縣":
		   return 'J'; 
		 case "高雄縣":
		   return 'S';
		 case "台中市":
			 return 'B';
		 case "苗栗縣":
			return 'K';
		 case "屏東縣":
			return 'T';
		 case "基隆市":
			return 'C';
		 case "台中縣":
			return 'L';
		 case "花蓮縣":
			return 'U';
		 case "台南市":
			return 'D';
		 case "南投縣":
			return 'M';
		 case "台東縣":
			return 'V';
		 case "高雄市":
			return 'E';
		 case "彰化縣":
			return 'N';
		 case "金門縣":
			return 'W';
		 case "台北縣":
			return 'F';
		 case "新竹市":
			return 'O';
		 case "澎湖縣":
			return 'X';
		 case "宜蘭縣":
			return 'G';
		 case "雲林縣":
			return 'P';
		 case "陽明山":
			return 'Y';
		 case "桃園縣":
			return 'H';
		 case "嘉義縣":
			return 'Q';
		 case "連江縣":
			return 'Z';
		 case "嘉義市":
			return 'I';
		 case "台南縣":
			return 'R';
			default:
				return '0';
		}
	}

//	function solution(data){
//		char b[] = new char[data.length()];
//		
//	}
	
	public static String solution2 (Map<String, String> data) {
		String n = "", ans = "";
		char e,f;
		boolean flag = false;
		
		while(!flag) {
		e = stringToChar(data.get("location"));
		
		if(data.get("gender").equals("男")) {
			f = '1';
		}else {
			f = '2';
		}
		
		Random ran = new Random();
		for(int i =0;i<8;i++) {
			n = n + String.valueOf(ran.nextInt(9) + 1);
		}
		
		ans = new StringBuilder().append(e).append(f).append(n).toString();
		System.out.println(ans);
		flag = solution(ans);
		}
		
		return ans;
	}
	
	public static boolean solution (String data) {
		char b[] = new char[data.length()];
		int sum[] = new int[data.length()];
		int n=0, j=1;
		for(int i=0 ; i<data.length() ; i++) {
			b[i] = data.charAt(i); 
		}
		sum[0] = charToInt (b[0]);
		
//		System.out.println("\nsum[0]=" + sum[0]);
		for(int i=1 ; i<data.length() ; i++) {
			sum[i]=b[i] - 48;
		}
		n = ((sum[0]%10)*9)+(sum[0]/10);
		for(int i=8 ; i>0 ; i--) {
			n = n + (sum[j]*i);
			j++;
		}
		n += sum[9];
		
		if(n%10 == 0) {
			System.out.println("true");
		    return true;
		}else {
			System.out.println("false");
			return false;
		}
	}
				 
	
	public static int charToInt (char c) {
		switch (c) {
		case 'A':
			return 10;
		case 'B':
			return 11;
		case 'C':
			return 12;
		case 'D':
			return 13;
		case 'E':
			return 14;
		case 'F':
			return 15;
		case 'G':
			return 16;
		case 'H':
			return 17;
		case 'I':
			return 34;
		case 'J':
			return 18;
		case 'K':
			return 19;
		case 'L':
			return 20;
		case 'M':
			return 21;
		case 'N':
			return 22;
		case 'O':
			return 35;
		case 'P':
			return 23;
		case 'Q':
			return 24;
		case 'R':
			return 25;
		case 'S':
			return 26;
		case 'T':
			return 27;
		case 'U':
			return 28;
		case 'V':
			return 29;
		case 'W':
			return 32;
		case 'X':
			return 30;
		case 'Y':
			return 31;
		case 'Z':
			return 33;
		default:
				return 0;
		}

	}
