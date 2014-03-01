package graph
import scala.collection.mutable._

class Point[T <: Double](val elements: List[T]) {
  def dimension = elements.length

  override def toString = "(" + elements.mkString(",") + ")"

  def <(other: Point[T]): Boolean = {
    elements(0) <= other.elements(0) && elements(1) <= other.elements(1)
  }

  def >(other: Point[T]): Boolean = {
    elements(0) >= other.elements(0) && elements(1) >= other.elements(1)
  }

  def ==(other: Point[T]) = {
    elements(0) == other.elements(0) && elements(1) == other.elements(1)
  }
  
  def distance(other: Point[T], kind: String): Double = { Euclidean[T](this, other).value }
}
