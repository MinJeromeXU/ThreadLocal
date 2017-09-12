package threadLocal;

import java.util.concurrent.Exchanger;

public class A extends Thread {
	public Object value;	
	private ThreadLocal<Object> seqNum =null;
	Exchanger<Object> exgr=null;
	public A(Object value, ThreadLocal<Object> seqNum,Exchanger<Object> exgr) {
		super();
		this.value = value;
		this.seqNum = seqNum;
		this.exgr=exgr;
	}
	  public void run() {  
              seqNum.set(value);
              Integer k = ((A0)(seqNum.get())).value;
              for(int i=0;i<10;i++){
            	  k++;
              }
              ((A0)(seqNum.get())).value=k;
              // ④每个线程打出3个序列值  
//        	  try {
//				Object obj =exgr.exchange(seqNum.get());
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} 
              

      }  
}
