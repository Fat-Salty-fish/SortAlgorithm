package leetCode;

import java.util.*;

public class LeetCode1203项目管理 {

    /**
     * 拓扑排序，不仅要构建节点之间的关系，还要构建分组之间的关系
     *
     * @param n
     * @param m
     * @param group
     * @param beforeItems
     * @return
     */
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        // 节点邻接矩阵，表示i节点的子节点（子节点依赖i节点）
        Map<Integer, Set<Integer>> nodeMatrix = new HashMap<>();
        // 节点的入度，表示i节点的入度
        Map<Integer, Integer> nodeInDegree = new HashMap<>();
        // 组邻接矩阵，表示第i个组的子组（子组依赖第i个组）
        Map<Integer, Set<Integer>> groupMatrix = new HashMap<>();
        // 组的入度，表示第i个组的入度
        Map<Integer, Integer> groupInDegree = new HashMap<>();
        // 组有多少个work item，做完一个应该即使删除？
        Map<Integer, Set<Integer>> groupWorkItems = new HashMap<>();
        // 维护父节点
        Map<Integer, Set<Integer>> groupParent = new HashMap<>();
        // 组的数量 需要重新计算组的数量，因为有的项目没有被指定为任何组，所以需要重新分配。每个未分配的组分配为一个单独的组即可。不能把他们都归为一组，因为可能会造成循环
        int groupNum = m;
        for (int i = 0; i < n; i++) {
            nodeMatrix.put(i, new HashSet<>());
            nodeInDegree.put(i, 0);

            if (group[i] == -1) {
                group[i] = groupNum;
                Set<Integer> currentGroupWorkItems = new HashSet<>();
                currentGroupWorkItems.add(i);
                groupWorkItems.put(groupNum++, currentGroupWorkItems);
            } else {
                int currentGroup = group[i];
                Set<Integer> currentGroupWorkItems = groupWorkItems.getOrDefault(currentGroup, new HashSet<>());
                currentGroupWorkItems.add(i);
                groupWorkItems.put(currentGroup, currentGroupWorkItems);
            }
        }
        for (int i = 0; i < groupNum; i++) {
            groupMatrix.put(i, new HashSet<>());
            groupInDegree.put(i, 0);
            groupParent.put(i, new HashSet<>());
        }
        // 填充map
        for (int i = 0; i < beforeItems.size(); i++) {
            List<Integer> current = beforeItems.get(i);
            int target = i;
            for (int j = 0; j < current.size(); j++) {
                int from = current.get(j);
                nodeInDegree.put(i, nodeInDegree.get(i) + 1);
                nodeMatrix.get(from).add(target);

                int fromGroup = group[from];
                int targetGroup = group[target];

                if (fromGroup != targetGroup) {
                    groupMatrix.get(fromGroup).add(targetGroup);
                    groupParent.get(targetGroup).add(fromGroup);
                    groupInDegree.put(targetGroup, groupParent.get(targetGroup).size());
                }
            }
        }


        // 拓扑排序两次
        // 第一次，先对group进行拓扑排序
        List<Integer> groupResult = new ArrayList<>();
        List<List<Integer>> groupResultWithDepth = new ArrayList<>();
        Queue<Integer> groupQueue = new LinkedList<>();
        // 初始化
        for (Map.Entry<Integer, Integer> groupEntry : groupInDegree.entrySet()) {
            if (groupEntry.getValue() == 0) {
                groupQueue.offer(groupEntry.getKey());
                groupResult.add(groupEntry.getKey());
            }
        }

        while (!groupQueue.isEmpty()) {
            int size = groupQueue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                int currentGroup = groupQueue.poll();
                temp.add(currentGroup);
                Set<Integer> targetGroups = groupMatrix.get(currentGroup);
                for (Integer target : targetGroups) {
                    int targetGroup = target;
                    groupInDegree.put(targetGroup, groupInDegree.get(targetGroup) - 1);
                    if (groupInDegree.get(targetGroup) == 0) {
                        groupQueue.offer(targetGroup);
                        groupResult.add(targetGroup);
                    }
                }
            }
            groupResultWithDepth.add(temp);
        }
        if (groupResult.size() != groupNum) {
            return new int[]{};
        }

        // 第二次，对work items进行拓扑排序
        List<Integer> resultWorkItems = new ArrayList<>();
        Queue<Integer> workQueue = new LinkedList<>();
        // 初始化？
        for (Integer currentGroup : groupResult) {
            Set<Integer> workItems = groupWorkItems.getOrDefault(currentGroup, new HashSet<>());
            for (Integer workItem : workItems) {
                if (nodeInDegree.get(workItem) == 0) {
                    workQueue.offer(workItem);
                    resultWorkItems.add(workItem);
                }
            }
            while (!workQueue.isEmpty()) {
                int currentNode = workQueue.poll();
                Set<Integer> nextNodes = nodeMatrix.get(currentNode);
                for (Integer nextNode : nextNodes) {
                    nodeInDegree.put(nextNode, nodeInDegree.get(nextNode) - 1);
                    if (nodeInDegree.get(nextNode) == 0 && group[nextNode] == currentGroup) {
                        workQueue.offer(nextNode);
                        resultWorkItems.add(nextNode);
                    }
                }
            }
        }

        if (resultWorkItems.size() != n) {
            return new int[]{};
        }
        return resultWorkItems.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        int n = 5, m = 3;
        int[] group = new int[]{0, 0, 2, 1, 0};
        int[][] array = new int[][]{{3}, {}, {}, {}, {1, 3, 2}};
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < array[i].length; j++) {
                temp.add(array[i][j]);
            }
            list.add(temp);
        }
        int[] result = new LeetCode1203项目管理().sortItems(n, m, group, list);
        System.out.println(Arrays.toString(result));
    }
}
