package zn.stacks.queues;

import java.util.LinkedList;

public class InterviewQuestions3_7 {

    /**
     * use two queue to mimic a common queue's property
     */
    public abstract class animal {
        String name;
        int order;

        animal(String n) {
            this.name = n;
            this.order = 0;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public int getOrder() {
            return this.order;
        }

        public int compareWithOther(animal t) throws Exception {
            if (this.getOrder() < t.getOrder())
                return -1;
            else if (this.getOrder() == t.getOrder())
                return 0;
            else if (this.getOrder() > t.getOrder())
                return 1;
            else
                throw new Exception("can not comapre!");
        }
    }

    public class animalQueue {
        LinkedList<Dog> dogs = new LinkedList<Dog>(); //LinkedList implement all queue operation in java
        LinkedList<Cat> cats = new LinkedList<Cat>();//LinkedList implement all queue operation in java
        private int order; //just a timestamp

        public void enqueue(animal a) throws Exception {
            a.setOrder(order++);
            if (a instanceof Dog) //TODO this is usual way for java use parent instance to operate child instance
                dogs.addLast((Dog) a); //TODO when up to down transformation, need cast
            else if (a instanceof Cat)
                cats.addLast((Cat) a);
            else
                throw new Exception("no this animal");

        }

        public animal dequeue() throws Exception {
            if (dogs.isEmpty() && cats.isEmpty()) {
                throw new Exception("no ele in queue");
            } else if (cats.isEmpty()) {
                return dogs.poll(); //TODO this built-in dequeue methods for LinkedList
            } else if (dogs.isEmpty())
                return cats.getFirst(); //TODO this built-in dequeue methods for LinkedList
            else {
                Dog dog = dogs.peek();
                Cat cat = cats.peek();
                if (dog.compareWithOther(cat) < 0)
                    return dogs.poll();
                else
                    return cats.poll();
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

    public static void main(String[] args) {
        InterviewQuestions3_7 test = new InterviewQuestions3_7();
        animalQueue innerQueue = test.new animalQueue();//TODO this is the way to instancelize the inner class 
    }
}
