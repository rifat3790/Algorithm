import java.util.PriorityQueue;
import java.util.Comparator;

class HuffmanNode {
    int item;
    char c;
    HuffmanNode left;
    HuffmanNode right;

}

class ImplementComparator implements Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.item - y.item;
    }

}

public class Main {
    public static void printCode(HuffmanNode root, String s) {

        if (root.left == null && root.right == null && Character.

                isLetter(root.c)) {

            System.out.println(root.c + " | " + s);

            return;
        }
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        int n = 7;
        char[] charArray = { 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
        int[] charFeq = { 2, 10, 3, 20, 7, 11, 4 };
        PriorityQueue<HuffmanNode> q = new PriorityQueue<HuffmanNode>(n, new ImplementComparator());
        for (int i = 0; i < n; i++) {
            HuffmanNode hn = new HuffmanNode();
            hn.c = charArray[i];
            hn.item = charFeq[i];
            hn.left = null;
            hn.right = null;
            q.add(hn);
        }

        HuffmanNode root = null;
        while (q.size() > 1) {
            HuffmanNode x = q.peek();
            q.poll();

            HuffmanNode y = q.peek();
            q.poll();
            HuffmanNode f = new HuffmanNode();
            f.item = x.item + y.item;
            f.c = '-';
            f.left = x;
            f.right = y;

            root = f;
            q.add(f);

        }

        System.out.println(" Char | Code ");
        printCode(root, "");

    }

}