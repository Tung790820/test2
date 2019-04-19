//question 3

/*
 * 3025這數字可以被稱為中位數。
 * 所謂中位數即，將這數字看成字串，分成兩半，分別為30及25，則其平方和(30+25)^2 = 3025，又變成原來的數字了。
 *
 * 試寫出一 function 傳入一個位數(2,4,6或8....)，打印出位數區間內的所有中位數。
 *
 * 例如傳入 4 從0000到9999。請注意，0也要算在內，
 * 也就是說0001也等於(00+01)^2，也是4位數中的巧合數。
 *
 * 例如輸入2時，輸出是00,01,81。
 * 例如輸入4時，輸出是0000,0001,2025,3025,9801。
 *
 * */

solution(4);

	
	public static void solution(int n){
		StringBuilder s = new StringBuilder();
		String str = "";
		int t;
		
		for(int i = 0; i <= n/2 ; i++) {
			if(i == 0) {
				s.append('1'); 
			} else {
				s.append('0');
			}
		}
		str = s.toString();
		t = Integer.valueOf(str);
		
		for(int i=0 ; i < Math.pow(10, n) ;i++ ) {
			if(i == 0) {
				String str2 = String.valueOf(i);
				StringBuffer sb = new StringBuffer();
				for(int j = 0; j < n - str2.length(); j++) {
				sb.append("0");
				}
				sb.append(str2);
				str2 = sb.toString();
				System.out.print(str2);
			}else if(Math.pow((i/t)+(i%t), 2) == i) {
				String str2 = String.valueOf(i);
				StringBuffer sb = new StringBuffer();
				for(int j = 0; j < n - str2.length(); j++) {
				sb.append("0");
				}
				sb.append(str2);
				str2 = sb.toString();
				System.out.print("," + str2);
			}
		}
		
    }