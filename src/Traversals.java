import java.util.*;

public class Traversals {

  /**
   * Testing
   * Returns the sum of the values of all leaf nodes in the given tree of integers.
   * A leaf node is defined as a node with no children.
   * If node is null, this method returns 0.
   *
   * @param node the node of the tree
   * @return the sum of leaf node values, or 0 if the tree is null
   */
  public static int sumLeafNodes(TreeNode<Integer> node) {
    int total = 0;
    if(node == null)
    {
      return 0;
    }
    if(node.right == null && node.left == null) return node.value;
    
    total = sumLeafNodes(node.right) + sumLeafNodes(node.left); 
    return total;
  }

  /**
   * Counts the number of internal nodes (non-leaf nodes) in the given tree of integers.
   * An internal node has at least one child.
   * If node is null, this method returns 0.
   *
   * @param node the node of the tree
   * @return the count of internal nodes, or 0 if the tree is null
   */
  public static int countInternalNodes(TreeNode<Integer> node) {
    int count = 0;
    if(node == null)
    {
      return 0;
    }

    if(node.right == null && node.left == null) return 0;
    
    
    count = countInternalNodes(node.left) + countInternalNodes(node.right);
    return count + 1;
  }

  /**
   * Creates a string by concatenating the string representation of each node's value
   * in a post-order traversal of the tree. For example, if the post-order visitation
   * encounters values "a", "b", and "c" in that order, the result is "abc".
   * If node is null, returns an empty string.
   *
   * @param node the node of the tree
   * @param <T>  the type of values stored in the tree
   * @return a post-order traversal string, or an empty string if the tree is null
   */
  public static <T> String buildPostOrderString(TreeNode<T> node) {
    String concat = "";
    if(node == null)
    {
      return "";
    }

    concat +=buildPostOrderString(node.left);
    concat +=buildPostOrderString(node.right);
    
    return concat+=node.value;
  }

  /**
   * Collects the values of all nodes in the tree level by level, from top to bottom.
   * If node is null, returns an empty list.
   *
   * @param node the node of the tree
   * @param <T>  the type of values stored in the tree
   * @return a list of node values in a top-to-bottom order, or an empty list if the tree is null
   */
  public static <T> List<T> collectLevelOrderValues(TreeNode<T> node) {
    Queue<TreeNode<T>> queue = new LinkedList<>();
    List<T> list = new ArrayList<>();

    if(node == null)
    {
      return list;
    }

    queue.add(node);
    while(!queue.isEmpty())
    {
      TreeNode<T> current = queue.poll();
      if(current == null)
      {
        continue;
      }
      list.add(current.value);
      queue.add(current.left);
      queue.add(current.right);
  }
  return list;
}

  /**
   * Counts the distinct values in the given tree.
   * If node is null, returns 0.
   *
   * @param node the node of the tree
   * @return the number of unique values in the tree, or 0 if the tree is null
   */
  public static int countDistinctValues(TreeNode<Integer> node) {
    Stack<TreeNode<Integer>> stack = new Stack<>();
    Set<Integer> list = new HashSet<>();

    if(node == null)
    {
      return 0;
    }

    stack.add(node);
    while(!stack.isEmpty())
    {
      TreeNode<Integer> current = stack.pop();
      if(current == null)
      {
        continue;
      }
      list.add(current.value);
      stack.add(current.left);
      stack.add(current.right);
  }

  return list.size();
  }

  /**
   * Determines whether there is at least one root-to-leaf path in the tree
   * where each successive node's value is strictly greater than the previous node's value.
   * If node is null, returns false.
   *
   * @param node the node of the tree
   * @return true if there exists a strictly increasing root-to-leaf path, false otherwise
   */
  public static boolean hasStrictlyIncreasingPath(TreeNode<Integer> node) {
    if (node == null) return false;

    Stack<TreeNode<Integer>> currStack = new Stack<>();
    Stack<Integer> prevStack = new Stack<>();

    currStack.push(node);
    prevStack.push(null);  

    while (!currStack.isEmpty()) {
        TreeNode<Integer> current = currStack.pop();
        Integer prevVal = prevStack.pop();

        if (prevVal != null && current.value <= prevVal) {
            continue; // Not strictly increasing, skip this path
        }

        // If it's a leaf node and path is valid
        if (current.left == null && current.right == null) {
            return true;
        }

        if (current.right != null) {
            currStack.push(current.right);
            prevStack.push(current.value);
        }
        if (current.left != null) {
            currStack.push(current.left);
            prevStack.push(current.value);
        }
      }
      return false;
  }

  // OPTIONAL CHALLENGE
  /**
   * Checks if two trees have the same shape. Two trees have the same shape
   * if they have exactly the same arrangement of nodes, irrespective of the node values.
   * If both trees are null, returns true. If one is null and the other is not, returns false.
   *
   * @param nodeA the node of the first tree
   * @param nodeB the node of the second tree
   * @param <T>   the type of values stored in the trees
   * @return true if the trees have the same shape, false otherwise
   */
  public static <T> boolean haveSameShape(TreeNode<T> nodeA, TreeNode<T> nodeB) {
    return false;
  }


  // OPTIONAL CHALLENGE
  // Very challenging!
  // Hints:
  // List.copyOf may be helpful
  // Consider adding a helper method
  // Consider keeping the current path in a separate variable
  // Consider removing the current node from the current path after the node's subtrees have been traversed.
  /**
   * Finds all paths from the root to every leaf in the given tree.
   * Each path is represented as a list of node values from root to leaf.
   * The paths should be added pre-order.
   * If node is null, returns an empty list.
   * 
   * Example:
   *
   *         1
   *        / \
   *       2   3
   *      / \    \
   *     4   5    6
   * 
   * Expected output:
   *   [[1, 2, 4], [1, 2, 5], [1, 3, 6]]
   * 
   * @param node the root node of the tree
   * @return a list of lists, where each inner list represents a root-to-leaf path in pre-order
   */
  public static <T> List<List<T>> findAllRootToLeafPaths(TreeNode<T> node) {
    return null;
  }
}
