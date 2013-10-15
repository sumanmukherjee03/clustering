package object graph {
  def print(msg: String) {
    println(msg)
  }
  
  def main(args: Array[String]) {
    val leaf1 = new Node[NumberLikeInt](NumberLikeInt(1))
    val leaf2 = new Node[NumberLikeInt](NumberLikeInt(3))
    val leaf3 = new Node[NumberLikeInt](NumberLikeInt(5))
    val node1 = new Node[NumberLikeInt](NumberLikeInt(4))
    val node2 = new Node[NumberLikeInt](NumberLikeInt(2))
    node2.addChild(leaf1)
    node2.addChild(leaf2)
    node1.addChild(node2)
    node1.addChild(leaf3)
    val binaryTree = new BinaryTree[NumberLikeInt](node1)
    print("Inorder traversal : " + binaryTree.inOrder().mkString(","))
    print("Preorder traversal : " + binaryTree.preOrder().mkString(","))
    print("Postorder traversal : " + binaryTree.postOrder().mkString(","))
  }
}