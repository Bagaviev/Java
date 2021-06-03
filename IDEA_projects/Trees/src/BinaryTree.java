import java.nio.file.StandardCopyOption;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BinaryTree {
    public static void main(String[] params) {
        Tree root =
                new Tree(20,
                        new Tree(7,
                                new Tree(4, null, new Tree(6)), new Tree(9)),
                        new Tree(35,
                                new Tree(31, new Tree(28), null),
                                new Tree(40, new Tree(38), new Tree(52))));

        System.out.println("Сумма дерева (в глубину, рекурсивно): " + sumRecursive(root));
        System.out.println("Сумма дерева (в глубину, итеративно через стек): " + sumDeep(root));
        System.out.println("Сумма дерева (в ширину, итеративно через очередь): " + sumWide(root));
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value) {
            this.value = value;
        }
    }

    public static int sumRecursive(Tree root) {
        int summ = root.value;

        if (root.left != null) {
            summ += sumRecursive(root.left);
        }

        if (root.right != null) {
            summ += sumRecursive(root.right);
        }

        return summ;
    }

    public static int sumDeep(Tree root) {
        Stack<Tree> stack = new Stack<>();
        stack.push(root);

        int summ = 0;

        while (!stack.isEmpty()) {
            Tree node = stack.pop();

            System.out.print(node.value + " ");

            summ = summ + node.value;

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return summ;
    }

    public static int sumWide(Tree root) {
        LinkedBlockingQueue<Tree> queue = new LinkedBlockingQueue<>();
        queue.add(root);

        int summ = 0;

        while (!queue.isEmpty()) {
            Tree node = queue.remove();

            System.out.print(node.value + " ");

            summ = summ + node.value;

            if (node.left != null) {
                queue.add(node.left);
            }

            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return summ;
    }
}

