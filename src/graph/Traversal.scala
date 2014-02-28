package graph
import scala.collection.mutable._

trait Traversal[T <: Double] {
  self: BinaryTree[T] =>
    def inOrder(): LinkedList[Point[T]] = {
      def traversalFn(node: Node[T], result: LinkedList[Point[T]]): LinkedList[Point[T]] = {
        var x = result
        var y = new LinkedList[Point[T]]()
        var z = new LinkedList[Point[T]]()
        if (!node.leftChildren.isEmpty) { y = traversalFn(node.leftChildren(0), result) }
        x = x.append(y)
        x = x :+ node.element
        if (!node.rightChildren.isEmpty) { z = traversalFn(node.rightChildren(0), result) }
        x = x.append(z)
        x
      }

      traversalFn(self.root, new LinkedList[Point[T]]())
    }

    def preOrder(): LinkedList[Point[T]] = {
      def traversalFn(node: Node[T], result: LinkedList[Point[T]]): LinkedList[Point[T]] = {
        var x = result
        var y = new LinkedList[Point[T]]()
        var z = new LinkedList[Point[T]]()
        x = x :+ node.element
        if (!node.leftChildren.isEmpty) { y = traversalFn(node.leftChildren(0), result) }
        x = x.append(y)
        if (!node.rightChildren.isEmpty) { z = traversalFn(node.rightChildren(0), result) }
        x = x.append(z)
        x
      }

      traversalFn(self.root, new LinkedList[Point[T]]())
    }

    def postOrder(): LinkedList[Point[T]] = {
      def traversalFn(node: Node[T], result: LinkedList[Point[T]]): LinkedList[Point[T]] = {
        var x = result
        var y = new LinkedList[Point[T]]()
        var z = new LinkedList[Point[T]]()
        if (!node.leftChildren.isEmpty) { y = traversalFn(node.leftChildren(0), result) }
        x = x.append(y)
        if (!node.rightChildren.isEmpty) { z = traversalFn(node.rightChildren(0), result) }
        x = x.append(z)
        x = x :+ node.element
        x
      }

      traversalFn(self.root, new LinkedList[Point[T]]())
    }
}