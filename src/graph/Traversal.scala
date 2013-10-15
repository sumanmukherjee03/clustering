package graph

import scala.collection.mutable._

trait Traversal[T <: NumberLikeInt] {
  self: BinaryTree[T] =>
    def inOrder(): LinkedList[T] = {
      def traversalFn(node: Node[T], result: LinkedList[T]): LinkedList[T] = {
        var x = result
        var y = new LinkedList[T]()
        var z = new LinkedList[T]()
        if (!node.leftChildren.isEmpty) { y = traversalFn(node.leftChildren(0), result) }
        x = x.append(y)
        x = x :+ node.value
        if (!node.rightChildren.isEmpty) { z = traversalFn(node.rightChildren(0), result) }
        x = x.append(z)
        x
      }

      traversalFn(self.root, new LinkedList[T]())
    }

    def preOrder(): LinkedList[T] = {
      def traversalFn(node: Node[T], result: LinkedList[T]): LinkedList[T] = {
        var x = result
        var y = new LinkedList[T]()
        var z = new LinkedList[T]()
        x = x :+ node.value
        if (!node.leftChildren.isEmpty) { y = traversalFn(node.leftChildren(0), result) }
        x = x.append(y)
        if (!node.rightChildren.isEmpty) { z = traversalFn(node.rightChildren(0), result) }
        x = x.append(z)
        x
      }

      traversalFn(self.root, new LinkedList[T]())
    }

    def postOrder(): LinkedList[T] = {
      def traversalFn(node: Node[T], result: LinkedList[T]): LinkedList[T] = {
        var x = result
        var y = new LinkedList[T]()
        var z = new LinkedList[T]()
        if (!node.leftChildren.isEmpty) { y = traversalFn(node.leftChildren(0), result) }
        x = x.append(y)
        if (!node.rightChildren.isEmpty) { z = traversalFn(node.rightChildren(0), result) }
        x = x.append(z)
        x = x :+ node.value
        x
      }

      traversalFn(self.root, new LinkedList[T]())
    }
}