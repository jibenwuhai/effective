package com.example.effective.chapter2.clauses8;


import sun.misc.Cleaner;

/**
 * 假设房间回收前必须被清理
 *
 * @Author: zhenglongze
 * @Date 2019/11/18 14:34
 */
public class Room implements AutoCloseable{

    //private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable{

        int numJunkPiles;

        State(int numJunkPiles){
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("Cleaning room");
            numJunkPiles = 0;
        }
    }

    private final State state;

    private final Cleaner cleaner;

    public Room(int numJunkPiles){
        state = new State(numJunkPiles);
        //cleanable = cleaner.clean();
        cleaner = Cleaner.create(this,state);
    }


    @Override
    public void close() throws Exception {
        cleaner.clean();
    }
}
