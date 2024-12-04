package DoublyLinkedList;

public class BrowserHistory {
    private Node current;

    // Node definition for doubly linked list.
    static class Node {
        String url;
        Node prev, next;

        Node(String url) {
            this.url = url;
        }
    }

    // Constructor to initialize browser history with the homepage.
    public BrowserHistory(String homepage) {
        current = new Node(homepage);
    }

    // Visit a new URL and clear forward history.
    public void visit(String url) {
        Node newNode = new Node(url);
        current.next = newNode; // Clear forward history.
        newNode.prev = current;
        current = newNode; // Move to the new URL.
    }

    // Go back up to 'steps' in the history.
    public String back(int steps) {
        while (steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }

    // Move forward up to 'steps' in the history.
    public String forward(int steps) {
        while (steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }

    // Main method to test the functionality.
    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");

        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");

        System.out.println(browserHistory.back(1)); // facebook.com
        System.out.println(browserHistory.back(1)); // google.com
        System.out.println(browserHistory.forward(1)); // facebook.com

        browserHistory.visit("linkedin.com");

        System.out.println(browserHistory.forward(2)); // linkedin.com
        System.out.println(browserHistory.back(2)); // google.com
        System.out.println(browserHistory.back(7)); // leetcode.com
    }
}
