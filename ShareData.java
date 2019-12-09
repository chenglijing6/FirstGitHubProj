package com.hfxt.multiThread;

public class ShareData {
	private char c;
	private boolean isProduced=false;
	//ͬ������putShareChar()
	public synchronized void putShareData(char c){
		//�����Ʒ��δ���ѣ��������ߵȴ�������������
		if (isProduced){
			try {
				System.out.println("�����߻�δ���ѣ����������ֹͣ����");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.c=c;
		isProduced=true;//����Ѿ�����
		notify();//֪ͨ�������Ѿ�����
		System.out.println("�����˲�Ʒ"+c+"֪ͨ����������...");
	}
	//ͬ��getShareChar()����������������
	public synchronized char getShareChar(){
		if (!isProduced){
			try {
				System.out.println("�����߻�δ���������������ֹͣ����");
				wait();//�����ߵȴ�
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		isProduced=false;//����Ѿ�����
		notify();//֪ͨ��Ҫ����
		System.out.println("�����������˲�Ʒ"+c+"֪ͨ����������...");	
		return this.c;
	}
}
