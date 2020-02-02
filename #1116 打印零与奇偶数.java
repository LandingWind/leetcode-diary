class ZeroEvenOdd {
    private int n;
    Semaphore a = new Semaphore(1);
    Semaphore b = new Semaphore(0);
    Semaphore c = new Semaphore(0);
    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++){
            a.acquire();
            printNumber.accept(0);
            if(i%2==0) b.release();
            else c.release();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i=2;i<=n;i=i+2){
            b.acquire();
            printNumber.accept(i);
            a.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i=i+2){
            c.acquire();
            printNumber.accept(i);
            a.release();
        }
    }
}