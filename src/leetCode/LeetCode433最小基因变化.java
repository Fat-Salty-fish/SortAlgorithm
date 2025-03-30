package leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class LeetCode433最小基因变化 {
    /**
     * 可以单向BFS，也可以双向BFS
     * 双向BFS
     *
     * @param startGene
     * @param endGene
     * @param bank
     * @return
     */
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = Arrays.stream(bank).collect(Collectors.toSet());
        if (!bankSet.contains(endGene)) {
            return -1;
        }
        Set<String> leftQueue = new HashSet<>();
        Set<String> rightQueue = new HashSet<>();
        leftQueue.add(startGene);
        rightQueue.add(endGene);
        int changedNum = 0;
        Set<String> visited = new HashSet<>();
        visited.add(startGene);
        char[] ableToBe = new char[]{'A', 'C', 'G', 'T'};
        while (!leftQueue.isEmpty() && !rightQueue.isEmpty()) {
            if (leftQueue.size() > rightQueue.size()) {
                Set<String> temp = leftQueue;
                leftQueue = rightQueue;
                rightQueue = temp;
            }
            Set<String> nextLevel = new HashSet<>();
            for (String gene : leftQueue) {
                for (int i = 0; i < gene.length(); i++) {
                    for (char toBe : ableToBe) {
                        char[] geneArray = gene.toCharArray();
                        if (geneArray[i] == toBe) {
                            continue;
                        }
                        geneArray[i] = toBe;
                        String changedGene = new String(geneArray);
                        if (rightQueue.contains(changedGene)) {
                            return changedNum + 1;
                        }
                        if (bankSet.contains(changedGene) && !visited.contains(changedGene)) {
                            nextLevel.add(changedGene);
                            visited.add(changedGene);
                        }
                    }
                }
            }
            leftQueue = nextLevel;
            changedNum++;
        }
        return -1;
    }
}
