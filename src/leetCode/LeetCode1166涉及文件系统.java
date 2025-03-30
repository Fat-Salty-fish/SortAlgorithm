package leetCode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1166涉及文件系统 {

    /**
     * 前缀树
     */
    static class FileSystem {

        static class PrefixNode {
            private Map<String, PrefixNode> treeNode;

            private Integer value;

            public PrefixNode() {
                treeNode = new HashMap<>();
            }

            public PrefixNode(int value) {
                treeNode = new HashMap<>();
                this.value = value;
            }

            public PrefixNode find(String prefix) {
                return treeNode.getOrDefault(prefix, null);
            }

            public int getValue() {
                return value;
            }

            public void add(String nextStr, PrefixNode next) {
                treeNode.put(nextStr, next);
            }
        }

        private PrefixNode treeHead;

        public FileSystem() {
            treeHead = new PrefixNode();
        }

        public boolean createPath(String path, int value) {
            if (path.isBlank()) {
                return false;
            }

            String[] pathArray = path.split("/");
            PrefixNode current = treeHead;
            for (int i = 1; i < pathArray.length - 1; i++) {
                PrefixNode next = current.find(pathArray[i]);
                if (next == null) {
                    return false;
                }
                current = next;
            }
            if (current.find(pathArray[pathArray.length - 1]) != null) {
                return false;
            }
            current.add(pathArray[pathArray.length - 1], new PrefixNode(value));
            return true;
        }

        public int get(String path) {
            if (path.isBlank()) {
                return -1;
            }
            String[] pathArray = path.split("/");
            PrefixNode current = treeHead;
            for (int i = 1; i < pathArray.length; i++) {
                PrefixNode next = current.find(pathArray[i]);
                if (next == null) {
                    return -1;
                }
                current = next;
            }
            return current.getValue();
        }
    }

    public static void main(String[] args) {
        FileSystem fileSystem = new FileSystem();
        fileSystem.createPath("/a", 1);
        System.out.println(fileSystem.get("/a"));
    }
}
