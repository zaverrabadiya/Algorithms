package com.zavrab.recursionproblems;

/**
 * Diameter of a Tree:
 * We are given a tree. The tree is not necessarily a binary tree. Each edge of the tree has a positive number associated with it,
 * a distance between the nodes it connects. The distance between any two nodes in the tree is defined as the sum of distances of the edges
 * that make the path between them. The diameter of the tree is defined as the distance between the two most distant nodes.
 * We are asked to find the diameter of the node.
 *
 * We observe that the diameter of a tree can be achieved in two different ways. The first is when the diameter path goes through the root.
 * In that case the diameter will be the sum of distances between the root and the two most distant leaves in two different
 * subtrees of the the root. If the root has only one subtree the root itself will be the end point of that path.
 * In the second way the diameter path doesn’t go through the root. In that case the diameter of the root will be the diameter of one of its sons.
 * The diameter of the tree is the maximum achieved by those two ways. The recursive call should return two values
 * the diameter of the sub tree and the distance between the root and the most distant leaf in that tree.
 * */

public class TreeDiameter {

    public static void main(String[] args) {
        Node root = buildTree();
        System.out.println("Diameter of tree is: " + diameter(root));
    }

    public static int diameter(Node root) {
        if (root == null) {
            return -1;
        }
        return diameterRec(root).diameter;
    }

    private static DiameterReturnValue diameterRec(Node root) {
        DiameterReturnValue returnValue = new DiameterReturnValue();
        if (root.childs.size() == 0) {
            returnValue.diameter = 0;
            returnValue.distance = root.distanceFromFather;
            return returnValue;
        }

        returnValue.diameter = -1;
        int totalMaxDistance = 0, total2ndMaxDistance = 0;
        for (Node child : root.childs) {
            DiameterReturnValue currentReturnValue = diameterRec(child);
            returnValue.diameter = Math.max(currentReturnValue.diameter, returnValue.diameter);

            if (currentReturnValue.distance > totalMaxDistance) {
                total2ndMaxDistance = totalMaxDistance;
                totalMaxDistance = currentReturnValue.distance;
            } else if (currentReturnValue.distance > total2ndMaxDistance) {
                total2ndMaxDistance = currentReturnValue.distance;
            }
        }

        returnValue.distance = totalMaxDistance + root.distanceFromFather;
        returnValue.diameter = Math.max(returnValue.diameter, (total2ndMaxDistance + totalMaxDistance));
        return returnValue;
    }

    private static Node buildTree() {
        Node root = new Node(1, 0);
        root.childs.add(new Node(2, 1));
        root.childs.add(new Node(3, 5));

        Node child = root.childs.get(0);
        child.childs.add(new Node(4, 8));
        child.childs.add(new Node(5, 10));

        return root;
    }
}


