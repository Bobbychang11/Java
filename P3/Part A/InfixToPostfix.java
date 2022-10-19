import java.io.*;
import java.util.*;

//Implement a main driver class to test implementations
class PostFixCalculator {
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter and infix expression: ");
        String exp = s.nextLine();
        
        InfixToPostfix i = new InfixToPostfix();
        String pf = i.buildExpression(exp);
        System.out.println("Infix converted to Postfix: " + pf);
        PostFix p = new PostFix();
        System.out.println("The result is " + p.calculate(pf));
    }
}

public class InfixToPostfix {
    public TStack expressions;

    public InfixToPostfix() {
        expressions = new TStack();
    }
    //creating new stack

    public void getExpression() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter and infix expression(i.e. ((2+3)*5): ");
        String exp = s.nextLine();
        buildExpression(exp);
    }
    //scanner to retrive infix 

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
        //checks to make sure expression was typed properly
        BTree postfix = expressions.pop();
        return postfix.postOrderTrav(postfix.getRoot());  //  returns postfix order so that it can be output
    }

    public void addTree() {
        BTree r = expressions.pop();
        BTree opp = expressions.pop();
        BTree l = expressions.pop();
        BTree p = attach(opp.getRoot(), l, r);
        expressions.push(p);  
    }
    //adding the elements of the expression to the tree

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
