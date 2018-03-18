package algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/** 문제
fibonacci(3)을 호출하면 다음과 같은 일이 일어난다.
•fibonacci(3)은 fibonacci(2)와 fibonacci(1) (첫 번째 호출)을 호출한다.
•fibonacci(2)는 fibonacci(1) (두 번째 호출)과 fibonacci(0)을 호출한다.
•두 번째 호출한 fibonacci(1)은 1을 출력하고 1을 리턴한다.
•fibonacci(0)은 0을 출력하고, 0을 리턴한다.
•fibonacci(2)는 fibonacci(1)과 fibonacci(0)의 결과를 얻고, 1을 리턴한다.
•첫 번째 호출한 fibonacci(1)은 1을 출력하고, 1을 리턴한다.
•fibonacci(3)은 fibonacci(2)와 fibonacci(1)의 결과를 얻고, 2를 리턴한다.
1은 2번 출력되고, 0은 1번 출력된다. N이 주어졌을 때, fibonacci(N)을 호출했을 때, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램을 작성하시오.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 다음과 같이 구성되어있다.
첫째 줄에 N이 주어진다. N은 40보다 작거나 같은 자연수 또는 0이다.

출력
각 테스트 케이스마다 0이 출력되는 횟수와 1이 출력되는 횟수를 공백으로 구분해서 출력한다.

예제 입력  
3
0
1
3

예제 출력 
1 0
0 1
1 2

 */
public class Algo1003 {
	static Integer[] res = new Integer[2];
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		HashMap<String, Integer[]> memorizedMap = new HashMap<String,Integer[]>();
		try {
			int lnT = Integer.parseInt(br.readLine().trim()); // 반복수
		
			for(int i = 0; i < lnT; i++) {
				res[0] = 0;
				res[1] = 0;
				int lnNum = Integer.parseInt(br.readLine().trim());
				
				function(lnNum, memorizedMap);
				sb.append(res[0] + " " + res[1] + ((i==(lnT-1))?"":"\n"));

			}
			System.out.print(sb);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	/*
	 * 재귀함수 용 함수
	 */
	public static void function(int param, HashMap<String, Integer[]> memorizedMap) {
		if(param == 0) {
			res[0]++;
		} else if(param == 1) {
			res[1]++;
		} else if(memorizedMap.containsKey(Integer.valueOf(param).toString())) {
			res[0] += memorizedMap.get(Integer.valueOf(param).toString())[0];
			res[1] += memorizedMap.get(Integer.valueOf(param).toString())[1];
		} else {
			function(param - 1, memorizedMap);
			function(param - 2, memorizedMap);
			if(!memorizedMap.containsKey(Integer.valueOf(param).toString())) {
				Integer[] inputRes = new Integer[2];
				inputRes[0] = res[0];
				inputRes[1] = res[1];
				memorizedMap.put(Integer.valueOf(param).toString(), inputRes);
			}
		}
	}
	
}
