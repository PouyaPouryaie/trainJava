package normaltrain.codetrain.javatrain;

import java.util.*;

public class QueuesAndStacks {

    // Write your code here.
    //Stack<Character> stack = new Stack<>();
    //Queue<Character> queue = new LinkedList<>();

    List<Character> queue = new ArrayList<>();
    List<Character> stack = new ArrayList<>();
    int indexStack = 0;
    int indexQueue = 0;
    int head = 0;

    public void pushCharacter(char p){
        stack.add(p);
        indexStack++;
    }
    public void enqueueCharacter(char p){
        queue.add(p);
        indexQueue++;
    }

    public char popCharacter(){
        indexStack--;
        return stack.get(indexStack);
    }
    public char dequeueCharacter(){
        head++;
        return queue.get(head - 1);
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();

        // Convert input String to an array of characters:
        char[] s = input.toCharArray();

        // Create a Solution object:
        QueuesAndStacks p = new QueuesAndStacks();

        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }

        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is "
                + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}
