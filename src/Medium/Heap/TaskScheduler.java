package Medium.Heap;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class TaskScheduler {

    public static int leastInterval(char[] tasks, int n) {

        Map<Character,Integer> map = new HashMap<>();

        //build freq of characters
        for(char ch: tasks){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }

        // build the maxheap for getting the maxfreqeuncy after each operation
        PriorityQueue<Task> taskpq = new PriorityQueue<>();

        //insert task in PQ
        for(Character ch: map.keySet()){
            int frequncy = map.get(ch);
            taskpq.offer(new Task(frequncy, 0));
        }

        //build the queue
        Queue<Task> taskQueue = new LinkedList<>();
        int time = 0;
        while (!taskQueue.isEmpty() || !taskpq.isEmpty()){
            time++;
            //check if there is task in pq & process it
            if(!taskpq.isEmpty()){
                Task task = taskpq.poll(); //gives task of maximum frequency
                task.freq--;
                if(task.freq>0){
                    //update the execution time
                    task.executiontime = time + n;
                    taskQueue.offer(task);
                }
            }

            //shift the active process to priorityQueue
            if(!taskQueue.isEmpty() && taskQueue.peek().executiontime == time){
                taskpq.offer(taskQueue.poll());
            }
        }

        return time;

    }



    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','C'};
        int n = 1;
        int result = leastInterval(tasks, n);
        System.out.println(result);
    }
}

class Task implements Comparable<Task>{
     int freq;
     int executiontime;

    public Task(int freq, int executiontime) {
        this.freq = freq;
        this.executiontime = executiontime;
    }

    @Override
    public int compareTo(Task that) {
        return that.freq - this.freq; //descending order
    }
}

