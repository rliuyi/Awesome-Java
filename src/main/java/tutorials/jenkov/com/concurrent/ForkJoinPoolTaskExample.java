package tutorials.jenkov.com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolTaskExample {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MyRecursiveTask myRecursiveTask = new MyRecursiveTask(100);
        Long result = forkJoinPool.invoke(myRecursiveTask);
        System.out.println("Final result: " + result);
    }

    private static class MyRecursiveTask extends RecursiveTask<Long> {

        private static final long serialVersionUID = -3122578599833966018L;

        private static final int WORKLOAD_THRESHOLD = 16;

        private final long workLoad;

        public MyRecursiveTask(long workLoad) {
            this.workLoad = workLoad;
        }

        @Override
        protected Long compute() {
            if (this.workLoad > WORKLOAD_THRESHOLD) {
                System.out.println("Splitting workload : " + this.workLoad);
                List<MyRecursiveTask> subTasks = this.createSubTasks();

                Long result = 0L;
                for (MyRecursiveTask subTask : subTasks) {
                    subTask.fork();
                    result += subTask.join();
                }

                return result;
            } else {
                String result = "Doing workLoad myself: " + this.workLoad;
                System.out.println(result);

                return this.workLoad * 3;
            }
        }

        private List<MyRecursiveTask> createSubTasks() {
            List<MyRecursiveTask> myRecursiveTasks = new ArrayList<MyRecursiveTask>(2);
            MyRecursiveTask myRecursiveTask0 = new MyRecursiveTask(this.workLoad / 2);
            MyRecursiveTask myRecursiveTask1 = new MyRecursiveTask(this.workLoad / 2);
            myRecursiveTasks.add(myRecursiveTask0);
            myRecursiveTasks.add(myRecursiveTask1);

            return myRecursiveTasks;
        }

    }
}
