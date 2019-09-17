package leetCode;

import jdk.nashorn.internal.objects.NativeUint8Array;

import javax.swing.*;

/**
 * @author acer
 * @Date 2019/7/30 19:51
 */
public class LeetCode117 {
    public Node connect(Node root) {
        build(root);
        return root;
    }

    public void build (Node node){
        if(node == null){
            return ;
        }
        if(node.left!=null){
            if(node.right !=null){
                node.left.next = node.right;
            }else {
                if(node.next!=null){
                    Node current = node.next;
                    Node target = null;
                    while (current!=null){
                        if(current.left!=null){
                            target = current.left;
                            break;
                        }else if(current.right !=null){
                            target = current.right;
                            break;
                        }
                        current = current.next;
                    }
                    node.left.next=target;
                }else {
                    node.left.next = null;
                }
            }
        }
        if(node.right!=null){
            if(node.next!=null){
                Node current = node.next;
                Node target = null;
                while (current!=null){
                    if(current.left!=null){
                        target = current.left;
                        break;
                    }else if(current.right !=null){
                        target = current.right;
                        break;
                    }
                    current = current.next;
                }
                node.right.next=target;
            }else {
                node.right.next = null;
            }
        }
        build(node.right);
        build(node.left);
    }

    public static void main(String[] args) {
        Node root = new Node(2, new Node(1,new Node(0,new Node(2,null,null,null),null,null),new Node(7,new Node(1,null,null
        ,null),new Node(0,new Node(7,null,null,null),null,null),null),null),new Node(3,new Node(9,null,null,null),new Node(1,new Node(8,null,null,null),new Node(8,null,null,null),null),null),null);
        new LeetCode117().connect(root);
    }
}
