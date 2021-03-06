package com.algorithms.heap;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap {
    private List<Integer> heap;
    MaxHeap(){
        heap = new ArrayList<>();
    }

    public boolean insert(int value){
        try{
            heap.add(value);
            int ind = heap.size() -1;
            while(ind>0){
                int parentInd = (ind-1)/2;
                if(heap.get(parentInd)>=heap.get(ind))
                    break;
                swap(parentInd,ind);
                ind = parentInd;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * deletes max element from heap.
     * @return
     */
    public int delete() throws Exception {
        if(heap.size()==0)
            throw new Exception("Heap is Empty");
        int t = heap.get(0);
        heap.set(0,heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        heapIfy(0);
        return t;
    }

    private void heapIfy(int ind) {
        int n = heap.size();
        int l = ind * 2 + 1;
        int r = l+1;
        int largest = ind;
        if(l<n && heap.get(largest) < heap.get(l))
            largest = l;
        if(r<n && heap.get(largest)<heap.get(r))
            largest = r;

        if(largest!=ind){
            swap(largest,ind);
            heapIfy(largest);
        }
    }

    public void printHeap(){
        System.out.println(heap);
    }

    public int getMax() throws Exception {
        if(heap.size()==0)
            throw new Exception("Heap is Empty");
        return heap.get(0);
    }

    private void swap(int largest, int ind) {
        int t = heap.get(largest);
        heap.set(largest,heap.get(ind));
        heap.set(ind,t);
    }

    public static void main(String[] args) throws Exception {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(5);
        maxHeap.insert(4);
        maxHeap.insert(9);
        maxHeap.insert(2);
        maxHeap.insert(10);
        maxHeap.printHeap();
        System.out.println(maxHeap.getMax());
        maxHeap.delete();
        maxHeap.delete();
        System.out.println(maxHeap.getMax());
        maxHeap.delete();
        System.out.println(maxHeap.getMax());
        maxHeap.insert(9);
        maxHeap.insert(2);
        maxHeap.insert(10);
        maxHeap.printHeap();
    }
}
