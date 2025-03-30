package leetCode;

import java.util.*;

public class LeetCode269火星词典 {

    /**
     * BFS+拓扑排序
     * 已经按照字典序排序过了，所以要根据给定的字符串排列出来字母的顺序
     * 如何构建邻接表？理论上，每个字母只有一个前辈，一个后辈
     * 重点是如何构建邻接表
     *
     * @param words
     * @return
     */
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0) return "";
        // 邻接矩阵
        Map<Character, Set<Character>> matrix = new HashMap<>();
        // 维护每个字母的入度227
        Map<Character, Integer> inDegrees = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            matrix.put((char) ('a' + i), new HashSet<>());
        }

        Set<Character> contains = new HashSet<>();

        // 初始化，对所有出现过的字母初始化入度
        for (String word : words) {
            for (char c : word.toCharArray()) {
                //inDegrees.put(c, 0);
                contains.add(c);
            }
        }

        // 对比每两个相邻的单词，直到遇到不相同的字母，构建邻接矩阵和入度表
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];

            int index = 0;
            while (index < first.length() && index < second.length() && first.charAt(index) == second.charAt(index)) {
                index++;
            }

            if (index < first.length() && index < second.length()) {
                char firstChar = first.charAt(index);
                char secondChar = second.charAt(index);
                Set<Character> targetOfFirstChar = matrix.getOrDefault(firstChar, new HashSet<>());
                if (!targetOfFirstChar.contains(secondChar)) {
                    targetOfFirstChar.add(secondChar);
                    matrix.put(firstChar, targetOfFirstChar);
                    inDegrees.put(firstChar, inDegrees.getOrDefault(firstChar, 0));
                    inDegrees.put(secondChar, inDegrees.getOrDefault(secondChar, 0) + 1);
                }
            } else if (index < first.length() && index == second.length()) {
                return "";
            } else {
                // 只记录一下第一个点的入度为0即可
                char firstChar = first.charAt(0);
                inDegrees.put(firstChar, inDegrees.getOrDefault(firstChar, 0));
            }
        }

        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry : inDegrees.entrySet()) {
            if (entry.getValue() == 0) {
                queue.offer(entry.getKey());
            }
        }

        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char temp = queue.poll();
                Set<Character> targets = matrix.getOrDefault(temp, new HashSet<>());
                for (Character target : targets) {
                    int inDegreeNew = inDegrees.get(target) - 1;
                    inDegrees.put(target, inDegreeNew);
                    if (inDegreeNew == 0) {
                        queue.offer(target);
                    }
                }
                result.add(String.valueOf(temp));
                contains.remove(temp);
            }
        }

        for (Integer inDegree : inDegrees.values()) {
            if (inDegree != 0) {
                return "";
            }
        }

        if (!contains.isEmpty()) {
            result.addAll(contains.stream().map(String::valueOf).toList());
        }

        return String.join("", result);
    }

    public static void main(String[] args) {
        String[] words = new String[]{"aba"};
        String result = new LeetCode269火星词典().alienOrder(words);
        System.out.println(result);
    }
}
