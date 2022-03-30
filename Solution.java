public class Solution {
    class Foo {

        private volatile int mark=0;

        public Foo() {}

        public void first(Runnable printFirst) throws InterruptedException {

            printFirst.run();

            mark++;

        }

        public void second(Runnable printSecond) throws InterruptedException {
            while (mark != 1) {
                // waiting for the first job to be done.
            }
            // printSecond.run() outputs "second".
            printSecond.run();
            mark++;
        }

        public void third(Runnable printThird) throws InterruptedException {
            while (mark != 2) {
                // waiting for the second job to be done.
            }
            mark++;
        }
    }
}
