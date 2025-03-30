package leetCode;

import java.util.HashSet;
import java.util.Set;

public class LeetCode困于环中的机器人 {

    /**
     * 理解错了题意，机器人无限循环才返回true，否则返回false
     *
     * @param instructions
     * @return
     */
    public boolean isRobotBounded(String instructions) {
        Set<Position> positions = new HashSet<Position>();
        Position currentPosition = new Position(0, 0, 'n');
        for (int i = 0; i < instructions.length(); i++) {
            char c = instructions.charAt(i);
            if (c == 'G') {
                currentPosition.move();
            } else if (c == 'L') {
                currentPosition.turnLeft();
            } else if (c == 'R') {
                currentPosition.turnRight();
            }
        }
        // 结束一次执行，如果结束时还在原点，则必定循环
        if (currentPosition.x == 0 && currentPosition.y == 0){
            return true;
        }
        // 否则，看方向，如果方向是南方向，则再执行一次之后还是还是会回到原点，也必定循环
        if (currentPosition.direction == 's'){
            return true;
        }
        // 如果方向是东方或者西方，则发生了一次90度转弯。转4次之后，还会回到原先的位置，也必定循环
        if (currentPosition.direction == 'e' || currentPosition.direction == 'w'){
            return true;
        }

        //  只有执行完之后不在原点并且方向仍然朝北方的是可以一直走下去的
        return false;
    }


    public static class Position {
        public int x;
        public int y;
        public char direction;

        public Position(int x, int y, char direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }

        public void turnLeft() {
            switch (direction) {
                case 'n':
                    direction = 'w';
                    break;
                case 'w':
                    direction = 's';
                    break;
                case 's':
                    direction = 'e';
                    break;
                case 'e':
                    direction = 'n';
                    break;
            }
        }

        public void turnRight() {
            switch (direction) {
                case 'n':
                    direction = 'e';
                    break;
                case 'w':
                    direction = 'n';
                    break;
                case 's':
                    direction = 'w';
                    break;
                case 'e':
                    direction = 's';
                    break;
            }
        }

        public void move() {
            switch (direction) {
                case 'n':
                    y++;
                    break;
                case 's':
                    y--;
                    break;
                case 'w':
                    x--;
                    break;
                case 'e':
                    x++;
                    break;
            }
        }
    }
}
