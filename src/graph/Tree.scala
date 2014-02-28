package graph

import scala.collection.mutable._

class BinaryTree[T <: Double](node: Node[T]) extends Traversal[T] {
  var _root: Node[T] = node

  def root: Node[T] = { return _root }

  def root_=(node: Node[T]) = { _root = node }

  def search(point: Point[T]): Option[Node[T]] = {
    def searchFn(node: Node[T], searchedItem: Point[T]): Option[Node[T]] = {
      if (node.element == searchedItem) {
        return Some(node)
      } else if (node.element < searchedItem && !node.rightChildren.isEmpty) {
        searchFn(node.rightChildren(0), searchedItem)
      } else if (node.element > searchedItem && !node.leftChildren.isEmpty) {
        searchFn(node.leftChildren(0), searchedItem)
      } else {
        None
      }
    }

    searchFn(root, point)
  }
}