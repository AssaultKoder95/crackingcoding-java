/**
 * CTCI 3.7
 */
package stacks_queues;

import java.util.LinkedList;

public class QueueWith2Q {

    public abstract class animal {
        public String name;
        public int order;

        animal(String n) {
            this.name = n;
            this.order = 0;
        }

        public int compareWithOther(animal t) throws Exception {
            return this.order - t.order;
        }
    }

    public class animalQueue {
        LinkedList<Dog> dogs = new LinkedList<Dog>();
        LinkedList<Cat> cats = new LinkedList<Cat>();
        private int internalOrder;

        public void enqueue(animal a) throws Exception {
            a.order = internalOrder++;
            if (a instanceof Dog) {
                dogs.addLast((Dog) a);
            } else if (a instanceof Cat) {
                cats.addLast((Cat) a);
            } else {
                throw new Exception("no such animal");
            }
        }

        public animal dequeue() throws Exception {
            if (dogs.isEmpty() && cats.isEmpty()) {
                throw new Exception("no animals in queue");
            } else if (cats.isEmpty()) {
                return dogs.pollFirst();
            } else if (dogs.isEmpty()) {
                return cats.pollFirst();
            } else {
                Dog dog = dogs.peek();
                Cat cat = cats.peek();
                if (dog.compareWithOther(cat) < 0) {
                    return dogs.poll();
                } else {
                    return cats.poll();
                }
            }

        }
    }

    public class Dog extends animal {
        public Dog(String n) {
            super(n);
        }
    }

    public class Cat extends animal {
        public Cat(String n) {
            super(n);
        }
    }
}
