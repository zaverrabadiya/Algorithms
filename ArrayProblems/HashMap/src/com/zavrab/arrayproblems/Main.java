package com.zavrab.arrayproblems;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        HashMap hashMap = new HashMap();
        hashMap.put("ab", 1);
        System.out.println(hashMap.get("ab"));

        hashMap.put("ab", 12);
        System.out.println(hashMap.get("ab"));

        // Collision-cases
        hashMap.put("a", 2, 2);
        hashMap.put("b", 3, 2);

        System.out.println("a: " + hashMap.get("a", 2));
        System.out.println("b: " + hashMap.get("b", 2));
    }


    private static class HashMap {

        private List<Node>[] map;

        public HashMap() {
            this(16);
        }

        public HashMap(int capacity) {
            map = new ArrayList[capacity];
        }

        public boolean put(String key, int value) {
            return put(key, value, key.hashCode());
        }

        public boolean put(String key, int value, int hashCode) {
            if (key == null || key.isEmpty()) {
                throw new IllegalArgumentException("Key not valid");
            }

            boolean isAdded = true;

            int kHash = hashCode;

            int idx = kHash % map.length;

            List<Node> existingValues = map[idx];

            if (existingValues == null) {
                existingValues = new ArrayList<Node>(1);
                existingValues.add(new Node(key, value));
            } else {
                Node n = getNode(key, existingValues);

                if (n != null) {
                    n.value = value;
                } else {
                    existingValues.add(new Node(key, value));
                }
            }

            map[idx] = existingValues;

            return isAdded;
        }

        public int get(String key) {
            return get(key, key.hashCode());
        }

        public int get(String key, int hashCode) {
            if (key == null || key.isEmpty()) {
                throw new IllegalArgumentException("Key not valid");
            }

            int idx = hashCode % map.length;

            List<Node> existingValues = map[idx];

            Node n = getNode(key, existingValues);

            return n != null ? n.value : Integer.MAX_VALUE;
        }

        private Node getNode(String key, List<Node> nodes) {
            if (nodes != null) {
                for (Node node : nodes) {
                    if (node.key.equals(key)) {
                        return node;
                    }
                }
            }
            return null;
        }
    }

    private static class Node {
        String key;
        int value;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
