package linkedList.practice;

import java.util.HashMap;
import java.util.Map;

public class CopyListOfRandomLinkedList {
    class Pair{
        Node node;
        Integer val;
        Pair(int val, Node node){
            this.node=node;
            this.val = val;
        }
    }

    // this solution works only when all node values are unique
    public Node copyRandomListSolnOne(Node head) {
        Node prevNode = new Node(-1);
        Map<Integer, Pair> map = new HashMap<>();
        Node newHead = prevNode;

        // create new list and store mapping of old node value to new node and random value in map
        while(head != null){
            Node newNode = new Node(head.val);
            prevNode.next = newNode;
            Integer randomVal = head.random != null ? head.random.val : Integer.MIN_VALUE;
            map.put(head.val, new Pair(randomVal, newNode));
            prevNode = newNode;
            head = head.next;
        }

        Node temp = newHead.next;

        // assign random pointers in new list using map
        while(temp != null){
            Pair mapPair = map.get(temp.val);
            if(mapPair.val != Integer.MIN_VALUE){
                Pair mapRandomPair = map.get(mapPair.val);
                temp.random = mapRandomPair.node;
            }
            temp = temp.next;
        }

        return newHead.next;
    }

    // this is the best and optimial solution which works for all cases
    public Node copyRandomList(Node head) {
        Node prevNode = new Node(-1);
        Map<Node, Node> otd = new HashMap<>(); // this is the map to store old to new node mapping
        Map<Node, Node> dto = new HashMap<>(); // this is the map to store new to old node mapping
        Node newHead = prevNode;
        while(head != null){
            Node newNode = new Node(head.val);
            prevNode.next = newNode;
            otd.put(head, newNode);
            dto.put(newNode,head);
            prevNode = newNode;
            head = head.next;
        }

        Node temp = newHead.next;

        while(temp != null){
            Node oNode = dto.get(temp);
            temp.random = otd.get(oNode.random);
            temp = temp.next;
        }

        return newHead.next;
    }
}
