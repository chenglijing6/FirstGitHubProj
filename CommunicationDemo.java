package com.hfxt.multiThread;

public class CommunicationDemo {
	public static void main(String[] args) {
		//共享同一个资源
		ShareData sd=new ShareData();
		//消费者线程
		new Consumer(sd).start();
		//生产者线程
		new Producer(sd).start();
	}
}
