package graph

import scala.collection.mutable._

class Node[T <: Double](data: Point[T]) {
	var _element: Point[T] = data
	var _children = new LinkedList[Node[T]]()
	
	def element: Point[T] = _element
	
	def element_=(x: Point[T]) = { _element = x }
	
	def children: LinkedList[Node[T]] = _children
	
	def addChild(item: Node[T]) = { _children = _children :+ item }
	
	def leftChildren: LinkedList[Node[T]] = { children.filter((node: Node[T]) => { node.element < element }) }
	
	def rightChildren: LinkedList[Node[T]] = { children.filter((node: Node[T]) => { node.element > element }) }
	
	def isLeaf: Boolean = _children.isEmpty
}