import scala.collection.mutable._

package object graph {
  def print(msg: String) {
    println(msg)
  }
    
  def main(args: Array[String]) {
    val point1 = new Point[Double](List(1, 1))
    val point2 = new Point[Double](List(2, 2))
    val point3 = new Point[Double](List(3, 3))
    val point4 = new Point[Double](List(4, 4))
    val point5 = new Point[Double](List(5, 5))

    val leaf1 = new Node[Double](point1)
    val leaf2 = new Node[Double](point3)
    val leaf3 = new Node[Double](point5)
    val node1 = new Node[Double](point4)
    val node2 = new Node[Double](point2)
    node2.addChild(leaf1)
    node2.addChild(leaf2)
    node1.addChild(node2)
    node1.addChild(leaf3)
    val binaryTree = new BinaryTree[Double](node1)
    print("Inorder traversal : " + binaryTree.inOrder().mkString(","))
    print("Preorder traversal : " + binaryTree.preOrder().mkString(","))
    print("Postorder traversal : " + binaryTree.postOrder().mkString(","))
  }
}