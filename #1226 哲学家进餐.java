// 核心思想: 同时拿起或者同时放下筷子, 为了避免死锁, 支持4个哲学家同时操作.

class DiningPhilosophers {
    Semaphore sp = new Semaphore(4);
    ArrayList<Semaphore> arr = new ArrayList<>();
    public DiningPhilosophers() {
        sp = new Semaphore(4);
        for(int i=0;i<5;i++) {
            Semaphore t = new Semaphore(1);
            arr.add(t);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        sp.acquire();
        arr.get(philosopher).acquire();
        arr.get((philosopher+1)%5).acquire();
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        putRightFork.run();
        arr.get(philosopher).release();
        arr.get((philosopher+1)%5).release();
        sp.release();
    }
}