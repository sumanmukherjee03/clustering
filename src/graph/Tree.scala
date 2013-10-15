package graph

import scala.collection.mutable._

class BinaryTree[T <: NumberLikeInt](node: Node[T]) extends Traversal[T] {
  var _root: Node[T] = node

  def root: Node[T] = { return _root }

  def root_=(node: Node[T]) = { _root = node }

  def search(data: T): Option[Node[T]] = {
    def searchFn(node: Node[T], searchedItem: T): Option[Node[T]] = {
      if (node.value == data) {
        return Some(node)
      } else if (node.value < data && !node.rightChildren.isEmpty) {
        searchFn(node.rightChildren(0), data)
      } else if (node.value > data && !node.leftChildren.isEmpty) {
        searchFn(node.leftChildren(0), data)
      } else {
        None
      }
    }

    searchFn(root, data)
  }
}