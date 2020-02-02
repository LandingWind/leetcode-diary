class FooBar {
    private int n;
    volatile int mutex = 0;
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(mutex==1){Thread.yield();}
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	try{printFoo.run();}
            finally{
            mutex=1;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            while(mutex==0){Thread.yield();}
            // printBar.run() outputs "bar". Do not change or remove this line.
        	try{printBar.run();}
            finally{
            mutex=0;
            }
        }
    }
}