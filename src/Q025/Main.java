package Q025;
/*622.원형 큐 디자인*/

public class Main {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(5);
        circularQueue.enQueue(10);
        circularQueue.enQueue(20);
        circularQueue.enQueue(30);
        circularQueue.enQueue(40);
        circularQueue.Rear();
        circularQueue.isFull();
        circularQueue.deQueue();
        circularQueue.deQueue();
        circularQueue.enQueue(50);
        circularQueue.enQueue(60);
        circularQueue.Rear();
        circularQueue.enQueue(70);
        circularQueue.isFull();
        circularQueue.Front();
    }

    static class MyCircularQueue {
        int[] q;
        int front = 0, rear = -1, len = 0;

        public MyCircularQueue(int k) {
            this.q = new int[k];
        }

        public boolean enQueue(int value) {
            if (!this.isFull()) {
                this.rear = (this.rear + 1) % this.q.length;
                this.q[rear] = value;
                this.len++;
                return true;
            } else
                return false;
        }

        public boolean deQueue() {
            if (!this.isEmpty()) {
                this.front = (this.front + 1) % this.q.length;
                this.len--;
                return true;
            } else
                return false;
        }

        public int Front() {
            return (this.isEmpty()) ? -1 : this.q[this.front];
        }

        public int Rear() {
            return (this.isEmpty() ? -1 : this.q[this.rear]);
        }

        public boolean isEmpty() {
            return this.len == 0;
        }

        public boolean isFull() {
            return this.len == this.q.length;
        }
    }
}
