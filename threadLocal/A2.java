package threadLocal;

import java.util.concurrent.Exchanger;

public class A2 extends Thread {
	public Object value;	
	private ThreadLocal<Object> seqNum =null;
	Exchanger<Object> exgr=null;
	public A2(Object value, ThreadLocal<Object> seqNum,Exchanger<Object> exgr) {
		super();
		this.value = value;
		this.seqNum = seqNum;
		this.exgr = exgr;
	}
	  public void run() {  
         try {
        	seqNum.set(value);
        	Thread.sleep(10000);
        	value = seqNum.get();
        	System.out.println(((A0)value).value);
//			Object obj =exgr.exchange(value);
//			if(obj==value)
//				System.out.println("True");
//			else
//				System.out.println("False");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
      }  
}
