package com.algorithms.heap;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
    private List<Integer> heap;
    MinHeap(){
        heap = new ArrayList<>();
    }

    public boolean insert(int value){
        try{
            heap.add(value);
            int ind = heap.size() -1;
            while(ind>0){
                int parentInd = (ind-1)/2;
                if(heap.get(parentInd)<heap.get(ind))
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

    public void printHeap(){
        System.out.println(heap);
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
        int smallest = ind;
        if(l<n && heap.get(smallest) > heap.get(l))
            smallest = l;
        if(r<n && heap.get(smallest) > heap.get(r))
            smallest = r;

        if(smallest!=ind){
            swap(smallest,ind);
            heapIfy(smallest);
        }
    }

    public int getMin() throws Exception {
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
        MinHeap minHeap = new MinHeap();
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(9);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.printHeap();
        System.out.println(minHeap.getMin());
        minHeap.delete();
        minHeap.delete();
        System.out.println(minHeap.getMin());
        minHeap.delete();
        System.out.println(minHeap.getMin());
        minHeap.insert(9);
        minHeap.insert(2);
        minHeap.insert(10);
        minHeap.printHeap();
    }


}
