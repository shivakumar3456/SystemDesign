package org.lrucache;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;


public class LRUCache<VALUE> {

    private final @NotNull HashMap<String, Node<VALUE>> map = new HashMap<>();
    private final int capacity;
    private @Nullable Node<VALUE> head;
    private @Nullable Node<VALUE> tail;

    int count = 0;

    public LRUCache(){
        this(5);
    }

    public LRUCache(int capacity){
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public void print(){
        System.out.println("*************************");
        System.out.println("Map contents -> " + map.values());
        System.out.println("List Contents");
        Node<VALUE> iter = head;
        while(iter != null){
            System.out.println(iter.key + " -> " + iter.value);
            iter = iter.next;
        }
        System.out.println("Head -> " + head);
        System.out.println("*************************");

    }

    public @Nullable VALUE get(@NotNull String key){
        if (!map.containsKey(key)){
            return null;
        }
        Node<VALUE> node = map.get(key);
        promoteNode(node);
        return node.getValue();
    }

    public void put(@NotNull String key, @NotNull VALUE value){
        if (map.containsKey(key)){
            Node<VALUE> updatingNode = map.get(key);
            updatingNode.value = value;
            promoteNode(updatingNode);
        }else{
            count++;
            Node<VALUE> newNode = new Node<>(key, value);
            map.put(key, newNode);
            addToFront(newNode);
            if (count > capacity){
                evict(tail);
                count--;
            }
        }
    }

    private void promoteNode(@NotNull Node<VALUE> node) {
        delete(node);
        addToFront(node);
    }

    private void delete(@NotNull Node<VALUE> node){
        if (head == node && tail == node){
            head = null;
            tail = null;
        }else if (node == tail){
            tail = tail.prev;
            tail.next = null;
        }else if (node == head){
            head = node.next;
            head.prev = null;
        }else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    private void addToFront(@NotNull Node<VALUE> node) {
        if (head == null){
            head = node;
            tail = node;
        }else {
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    private void evict(@NotNull Node<VALUE> tail) {
        map.remove(tail.getKey());
        delete(tail);
    }

    private static class Node<VALUE> {
        private final @NotNull String key;
        public @Nullable Node<VALUE> prev;
        public @Nullable Node<VALUE> next;
        private @Nullable VALUE value;


        private Node(@NotNull String key, @NotNull VALUE value) {
            this.value = value;
            this.key = key;
        }

        @NotNull
        public String getKey() {
            return key;
        }

        public @Nullable VALUE getValue() {
            return value;
        }

        @Override
        public String toString() {
            return key + " -> " + value;
        }
    }
}
