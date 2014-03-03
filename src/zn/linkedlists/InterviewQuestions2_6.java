package zn.linkedlists;

public class InterviewQuestions2_6 {

    /**
     * FIXME very tricky, this question need review again
     * this is CJ's answer, find colliding point firstly, then latter shift y step; put prior to head
     * at last, both shift until collide
     * please draw a x, y graph before coding this question TODO
     * @param head
     * @return
     */
    public static LinkedListNode findBeginingsFromCircle1(LinkedListNode head) {
        LinkedListNode prior;
        LinkedListNode latter;
        int countPrior = 0;
        int countLatter = 0;

        prior = head;
        latter = head;
        while (prior != null && latter != null) {
            prior = prior.next;
            countPrior = countPrior + 1;
            latter = latter.next.next;
            countLatter = countLatter + 2;
            if (prior.equals(latter))
                break;
        }

        if (prior == null || latter == null) {
            return null;
        }
        prior = head;
        for (int i = 0; i < (countLatter - countPrior); i++) {
            latter = latter.next;
        }
        while (true) {
            prior = prior.next;
            latter = latter.next;
            if (prior.equals(latter))
                break;
        }
        return prior;
    }

    /**
     * this is book's answer, prior shift 1step one time, latter shift 2step one time
     * find colliding point firstly, then put prior to head;
     * at last, both shift step by step until collide
     * FIXME books use a very tricky condition that the speed of latter is double of speed of prior
     * very tricky, need review
     * @param head
     * @return
     */
    public static LinkedListNode findBeginingsFromCircle2(LinkedListNode head) {
        LinkedListNode prior;
        LinkedListNode latter;

        prior = head;
        latter = head;
        while (prior != null && latter != null) {
            prior = prior.next;
            latter = latter.next.next;
            if (prior.equals(latter))
                break;
        }

        if (prior == null || latter == null) {
            return null;
        }
        prior = head;
        while (true) {
            prior = prior.next;
            latter = latter.next;
            if (prior.equals(latter))
                break;
        }
        return prior;
    }

    public static void main(String[] args) {
        int[] test = new int[] { 4, 6, 1, 3 };
        LinkedListNode head = new LinkedListNode(test[0]);
        for (int i = 1; i < 4; i++) {
            head.appendToTrail(test[i]);
        }
        LinkedListNode iter = head;
        while (iter.next != null) {// TODO remember, want to stay in the last element, condition must be iter!= null, not iter.next !=null
            iter = iter.next;
        }
        iter.next = head.next.next;
        System.out.println(InterviewQuestions2_6.findBeginingsFromCircle2(iter).get());

    }
}
