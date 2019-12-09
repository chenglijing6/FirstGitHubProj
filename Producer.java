package com.hfxt.multiThread;

public class Producer extends Thread {
	private ShareData s;
	Producer(ShareData s){
		this.s=s;
	}
	public void run(){
		for(char ch='A';ch<='D';ch++){
			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s.putShareData(ch);//将产品放入仓库
			
		}
	}
}
