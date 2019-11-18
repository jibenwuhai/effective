package com.example.effective.chapter2.clauses8;

/**
 * 房间清理工作
 *
 * @Author: zhenglongze
 * @Date 2019/11/18 15:08
 */
public class RoomTest {


    public static void main(String[] args) {
        //adult();
        teenager();
    }

    //房间回收前会清理房间
    public static void adult() {
        try (Room room  = new Room(7)){
            //room.close();
            System.out.println("Goodbye");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void teenager(){
        new Room(99);
        System.out.println("peace out");
    }

}
