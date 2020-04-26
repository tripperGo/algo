package com.mright.algo.chapter01;

/**
 * @author: mright
 * @date: Created in 2020/4/19 3:46 PM
 * @desc: 对象可以在被GC时自我拯救
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC HOOK = null;

    public void isAlive() {
        System.out.println("yes, i am still alive.");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize执行");
        FinalizeEscapeGC.HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        HOOK = new FinalizeEscapeGC();
        HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (HOOK != null) {
            System.out.println("生存");
        } else {
            System.out.println("死亡");
        }

        HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (HOOK != null) {
            System.out.println("生存");
        } else {
            System.out.println("死亡");
        }
    }
}
