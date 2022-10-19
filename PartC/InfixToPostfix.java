/**
 * ----------------------------------------------------------------------
 * ||||||     Postorder: 3 1 + 3 * 9 5 - 2 + / 3 7 4 - * 6 + -     ||||||
 * ----------------------------------------------------------------------
 */
import java.io.*;
import java.util.*;

public class InfixToPostfix {
    public TStack expressions;

    public InfixToPostfix() {
        expressions = new TStack();
    }

    public void getExpression() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter and infix expression: ");
        String exp = s.nextLine();
        buildExpression(exp);
    }

    public String buildExpression(String E) {
        for(int i = 0;i < E.length();i++) {
            if(E.charAt(i) == ')') {
                addTree();
            }
            else if(E.charAt(i) != '(') {
                TNode n = new TNode(E.charAt(i), null, null);
                BTree t = new BTree();
                t.setRoot(n);
                expressions.push(t);
            }
        }
        BTree postfix = expressions.pop();
        return postfix.postOrderTrav(postfix.getRoot());  //  returns postfix order so that it can be output
    }

    public void addTree() {
        BTree r = expressions.pop();
        BTree opp = expressions.pop();
        BTree l = expressions.pop();
        BTree t = attach(opp.getRoot(), l, r);
        expressions.push(t);  
    }

    public BTree attach(TNode p, BTree leftTree, BTree rightTree) {
        BTree t = new BTree();
        t.setRoot(p);
        if(!leftTree.isEmpty()) {
            p.setLeft(leftTree.getRoot());
        }
        if(!rightTree.isEmpty()) {
            p.setRight(rightTree.getRoot());
        }
        t.setSize(leftTree.getSize() + rightTree.getSize() + t.getSize());
        leftTree.reset();
        rightTree.reset();
        return t;
    }

}
