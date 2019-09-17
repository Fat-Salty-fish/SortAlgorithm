package leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author acer
 * @Date 2019/7/28 18:38
 */
public class LeetCode733 {
    private class Node {
        int sr;
        int sc;

        public Node(int sr, int sc) {
            this.sr = sr;
            this.sc = sc;
        }

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        fill(image, sr, sc, newColor);
        return image;
    }

    public void fill(int[][] image, int sr, int sc, int newColor) {
        //用于储存要修改的像素
        List<Node> list = new ArrayList<>();
        int nowColor = image[sr][sc];
        if (sr != 0 && image[sr - 1][sc] == nowColor && image[sr - 1][sc] !=newColor)
            list.add(new Node(sr - 1, sc));
        if (sc != 0 && image[sr][sc - 1] == nowColor && image[sr][sc - 1] != newColor) {
            list.add(new Node(sr, sc - 1));
        }
        if (sr != image.length-1 && image[sr + 1][sc] == nowColor && image[sr + 1][sc] != newColor) {
            list.add(new Node(sr + 1, sc));
        }
        if (sc != image[0].length-1 && image[sr][sc + 1] == nowColor && image[sr][sc + 1] != newColor) {
            list.add(new Node(sr, sc + 1));
        }
        image[sr][sc] = newColor;
        for(int i = 0;i<list.size();i++){
            fill(image,list.get(i).sr,list.get(i).sc,newColor);
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
        int sr = 1;
        int sc = 1;
        int newColor = 2;
        System.out.println(new LeetCode733().floodFill(array,sr,sc,newColor));
    }
}
