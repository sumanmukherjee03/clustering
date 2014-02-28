package graph
import scala.collection.mutable._

class Point[T <: Double](val elements: List[T]) {
  def dimension = elements.length

  override def toString = "(" + elements.mkString(",") + ")"

  def <(another: Point[T]): Boolean = {
    elements(0) <= another.elements(0) && elements(1) <= elements(1)
  }

  def >(another: Point[T]): Boolean = {
    elements(0) >= another.elements(0) && elements(1) >= elements(1)
  }

  def ==(another: Point[T]) = {
    elements(0) == another.elements(0) && elements(1) == elements(1)
  }
}
