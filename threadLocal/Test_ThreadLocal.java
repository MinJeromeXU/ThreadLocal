package threadLocal;

import java.util.concurrent.Exchanger;

public class Test_ThreadLocal {
	private static ThreadLocal<Object> seqNum = new ThreadLocal<Object>() {  
        public Integer initialValue() {  
            return 0;  
        }  
    }; 
    public static void main(String[] args) {  
        // ③ 3个线程共享sn，各自产生序列号  
    	A0 Obj = new A0();
    	Exchanger<Object> exgr = new Exchanger<Object>();
        A t1 = new A(Obj,seqNum,exgr);
        A2 t2 = new A2(Obj,seqNum,exgr);             
        t1.start();  
        t2.start();   
    } 
}
