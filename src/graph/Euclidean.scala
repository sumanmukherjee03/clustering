package graph
import scala.collection.mutable._

case class Euclidean[T <: Double](first: Point[T], last: Point[T]) extends Distance[T]{
  def value: Double = {
    def add(res: Double, b: Double): Double = (res + b)
    
    def sigma(list: LinkedList[Double]): Double = list.reduceLeft(add)
    
    def squares: LinkedList[Double] = {
      var list: LinkedList[Double] = new LinkedList[Double]()
      for(i <- 1 to first.dimension) {
        var diff = first.elements(i) - last.elements(i)
        list = list :+ (diff * diff)
      }
      list
    }
    
    sigma(squares)
  }
}