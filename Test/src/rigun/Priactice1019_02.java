package rigun;

// LinkedList 로 Stack 구현
	// Node 만들어야 됨 
	// Node : 데이터와 다음 노드를 가르키는 주소로 구성

class Node {

    private int data;
    private Node nextNode;

    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    protected void linkNode(Node node) {
        this.nextNode = node;
    }

    protected int getData() {
        return this.data;
    }

    protected Node getNextNode() {
        return this.nextNode;
    }
}

class UserLinkedListStack {

    Node top;

    public UserLinkedListStack() {
        this.top = null;
    }

    void push(int data) {
        Node node = new Node(data);
        node.linkNode(top);
        top = node;
    }

    public int peek() {
        return top.getData();
    }

    void pop() {
        if (empty())
            throw new ArrayIndexOutOfBoundsException();
        else {
            top = top.getNextNode();
        }
    }

    int search(int item) {
        Node searchNode = top;
        int index = 1;
        while(true) {
            if (searchNode.getData() == item) {
                return index;
            } else {
                searchNode = searchNode.getNextNode();
                index ++;
                if (searchNode == null)
                    break;
            }
        }

        return -1;
    }

    private boolean empty() {
        return top == null;
    }
}

public class Priactice1019_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UserLinkedListStack ulls = new UserLinkedListStack();
		ulls.push(4);
		ulls.search(5);
	}

}
