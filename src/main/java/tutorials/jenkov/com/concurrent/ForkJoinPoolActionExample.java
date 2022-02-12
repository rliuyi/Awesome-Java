package tutorials.jenkov.com.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinPoolActionExample {

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        MyRecursiveAction myRecursiveAction = new MyRecursiveAction(100);
        forkJoinPool.invoke(myRecursiveAction);
    }

    private static class MyRecursiveAction extends RecursiveAction {

        private static final long serialVersionUID = -3122578599833966018L;

        private static final int WORKLOAD_THRESHOLD = 16;

        private final int workLoad;

        public MyRecursiveAction(int workLoad) {
            this.workLoad = workLoad;
        }

        @Override
        protected void compute() {
            if (this.workLoad > WORKLOAD_THRESHOLD) {
                System.out.println("Splitting workload : " + this.workLoad);
                List<MyRecursiveAction> subActions = this.createSubActions();
                subActions.stream().forEach((action) -> {
                    action.fork();
                });
            } else {
                String result = "Doing workLoad myself: " + this.workLoad;
                System.out.println(result);
            }
        }

        private List<MyRecursiveAction> createSubActions() {
            List<MyRecursiveAction> myRecursiveActions = new ArrayList<MyRecursiveAction>(2);
            MyRecursiveAction myRecursiveAction0 = new MyRecursiveAction(this.workLoad / 2);
            MyRecursiveAction myRecursiveAction1 = new MyRecursiveAction(this.workLoad / 2);
            myRecursiveActions.add(myRecursiveAction0);
            myRecursiveActions.add(myRecursiveAction1);

            return myRecursiveActions;
        }

    }
}
