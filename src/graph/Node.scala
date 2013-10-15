package graph

import scala.collection.mutable._

class Node[T <: NumberLikeInt](data: T) {
	var _value: T = data
	var _children = new LinkedList[Node[T]]()
	
	def value: T = _value
	
	def value_=(x: T) = { _value = x }
	
	def children: LinkedList[Node[T]] = _children
	
	def addChild(item: Node[T]) = { _children = _children :+ item }
	
	def leftChildren: LinkedList[Node[T]] = { children.filter((node: Node[T]) => {node.value < value}) }
	
	def rightChildren: LinkedList[Node[T]] = { children.filter((node: Node[T]) => {node.value > value}) }
	
	def isLeaf: Boolean = _children.isEmpty
}