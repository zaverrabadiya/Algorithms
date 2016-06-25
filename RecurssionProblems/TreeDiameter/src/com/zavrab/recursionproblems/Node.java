package com.zavrab.recursionproblems;

import java.util.ArrayList;
import java.util.List;

public class Node {
    public int value;
    public int distanceFromFather;
    public List<Node> childs;

    public Node(int value, int distance) {
        this.value = value;
        this.distanceFromFather = distance;
        childs = new ArrayList<Node>();
    }
}
