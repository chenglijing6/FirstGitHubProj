package com.hfxt.multiThread;

public class CommunicationDemo {
	public static void main(String[] args) {
		//����ͬһ����Դ
		ShareData sd=new ShareData();
		//�������߳�
		new Consumer(sd).start();
		//�������߳�
		new Producer(sd).start();
	}
}
