package com.peisia.lotto;

public class Lotto {

	public void run() {
//		int x[] = {1,2};
		//로또 로직
		int p[] = {1,2,3,4,5,6};
		int r[] = new int[6];
		
		r[0] = (int)(Math.random()*45+1);
		
		// 중복체크: 2번째번호
		while(true) {
			r[1] = (int)(Math.random()*45+1);
			if(r[0]!=r[1]) {
				break;
			}
		}
		
		// 중복체크: 3번째번호
		while(true) {
			r[2] = (int)(Math.random()*45+1);
			if(r[0]!=r[2] && r[1]!=r[2]) {
				break;
			}
		}
		
		// 중복체크: 4번째번호
		while(true) {
			r[3] = (int)(Math.random()*45+1);
			if(r[0]!=r[3] && r[1]!=r[3] && r[2]!=r[3]) {
				break;
			}
		}
		
		// 중복체크: 5번째번호
		while(true) {
			r[4] = (int)(Math.random()*45+1);
			if(r[0]!=r[4] && r[1]!=r[4] && r[2]!=r[4] && r[3]!=r[4]) {
				break;
			}
		}
		
		// 중복체크: 6번째번호
		while(true) {
			r[5] = (int)(Math.random()*45+1);
			if(r[0]!=r[5] && r[1]!=r[5] && r[2]!=r[5] && r[3]!=r[5] && r[4]!=r[5]) {
				break;
			}
		}
		
		System.out.println("=== 당첨 번호 ===");
		System.out.print(r[0]+" ");
		System.out.print(r[1]+" ");
		System.out.print(r[2]+" ");
		System.out.print(r[3]+" ");
		System.out.print(r[4]+" ");
		System.out.print(r[5]+" ");
		
		int win = 0;
		for(int i=0;i<6;i=i+1) {
			for(int j=0;j<6;j=j+1) {
				if(p[i] == r[j]) {
					win=win+1;
				}
			}
		}
		
		System.out.println("맞춘갯수:"+win);
	}
}