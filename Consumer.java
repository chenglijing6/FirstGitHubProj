package com.hfxt.multiThread;

public class Consumer extends Thread{
	private ShareData s;
	Consumer(ShareData s){
		this.s=s;
	}
	public void run(){
		char ch;
		do{
			try {
				Thread.sleep((int)(Math.random()*3000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ch=s.getShareChar();//�Ӳֿ���ȡ����Ʒ
		}while(ch!='D');
	}
}
