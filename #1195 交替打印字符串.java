class FizzBuzz {
    private int n;
    Semaphore sfizz = new Semaphore(0);
    Semaphore sbuzz = new Semaphore(0);
    Semaphore sfizzbuzz = new Semaphore(0);
    Semaphore snumber = new Semaphore(1);
    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i=1;i<=n;i++) {
            if(i%3==0 && i%5!=0) {
                sfizz.acquire();
                printFizz.run();
                snumber.release();
            }
        }

    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i=1;i<=n;i++) {
            if(i%3!=0 && i%5==0) {
                sbuzz.acquire();
                printBuzz.run();
                snumber.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i=1;i<=n;i++) {
            if(i%3==0 && i%5==0) {
                sfizzbuzz.acquire();
                printFizzBuzz.run();
                snumber.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i=1;i<=n;i++) {
            snumber.acquire();
            if(i%3==0 && i%5==0) sfizzbuzz.release();
            else if(i%3==0 && i%5!=0) sfizz.release();
            else if(i%3!=0 && i%5==0) sbuzz.release();
            else {
                printNumber.accept(i);
                snumber.release();
            }
        }
    }
}