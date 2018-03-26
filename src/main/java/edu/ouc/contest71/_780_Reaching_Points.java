package edu.ouc.contest71;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Assert;

/**
 * @author wqx
 */
public class _780_Reaching_Points {

    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        State rootState = new State(sx, sy ,tx, ty);
        if(rootState.isLegal()){
            return true;
        }
        Queue<State> queue = new LinkedList<>();
        queue.offer(rootState);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size ; i++){
                State curState = queue.poll();
                System.out.println("state:" + curState.toString());
                if(curState.isLegal()){
                    return true;
                }
                if (curState.isIllegal()) {
                    continue;
                }
                State s1 = curState.transformingX();
                State s2 = curState.transformingY();
                if(!s1.isIllegal()){
                    queue.offer(curState.transformingX());
                }
                if(!s2.isIllegal()){
                    queue.offer(curState.transformingY());
                }
            }
        }
        return false;
    }
    class State{
        long sx;
        long sy;
        long tx;
        long ty;

        public State(long sx, long sy, long tx, long ty){
            this.sx = sx;
            this.sy = sy;
            this.tx = tx;
            this.ty = ty;
        }
        public boolean isLegal(){
            return sx == tx && sy == ty;
        }
        public boolean isIllegal(){
            return sx > tx || sy > ty;
        }
        public State transformingY(){
            long nextY = sx + sy;
            if(ty > nextY * 110 && nextY * 110 < Integer.MAX_VALUE){
                nextY = (sx + sy) * 100;
            }
            return new State(sx, nextY, tx, ty);
        }
        public State transformingX(){
            long nextX = sx + sy;
            if(tx > nextX * 110 && nextX * 110 < Integer.MAX_VALUE){
                nextX = (sx + sy) * 100;
            }
            return new State(nextX, sy, tx, ty);
        }

        @Override
        public String toString() {
            return "sx:" + sx + ",sy:" + sy + ",tx:" + tx + ",ty:" + ty;
        }
    }

    public static void main(String args[]) {
        //test case1
        _780_Reaching_Points tester = new _780_Reaching_Points();
        int sx = 1, sy = 1, tx = 1, ty = 1;
        Assert.assertTrue(tester.reachingPoints(sx, sy, tx, ty));
        System.out.println("aaa");
        int sx2 = 35, sy2 = 13, tx2 = 455955547, ty2 = 420098884;
        Assert.assertTrue(tester.reachingPoints(sx2, sy2, tx2, ty2));
    }
}
