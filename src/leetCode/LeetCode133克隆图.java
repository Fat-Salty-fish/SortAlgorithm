package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lizhongjie
 * @desc
 * @create_time 2021/12/28
 */
public class LeetCode133克隆图 {

    Map<Node,Node> nodeMap = new HashMap<>();


    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        if (nodeMap.containsKey(node)){
            return nodeMap.get(node);
        }
        Node resultNode = new Node(node.val);
        nodeMap.put(node,resultNode);
        for (Node oldNeighbor:node.neighbors){
            resultNode.neighbors.add(cloneGraph(oldNeighbor));
        }
        return resultNode;
    }
}
