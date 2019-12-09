package com.hfxt.multiThread;

public class ShareData {
	private char c;
	private boolean isProduced=false;
	//同步方法putShareChar()
	public synchronized void putShareData(char c){
		//如果产品还未消费，则生产者等待——》生产者
		if (isProduced){
			try {
				System.out.println("消费者还未消费，因此生产者停止生产");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.c=c;
		isProduced=true;//标记已经生产
		notify();//通知消费者已经生产
		System.out.println("生产了产品"+c+"通知消费者消费...");
	}
	//同步getShareChar()方法——》消费者
	public synchronized char getShareChar(){
		if (!isProduced){
			try {
				System.out.println("生产者还未生产，因此消费者停止消费");
				wait();//消费者等待
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isProduced=false;//标记已经消费
		notify();//通知需要生产
		System.out.println("消费者消费了产品"+c+"通知生产者生产...");	
		return this.c;
	}
}
