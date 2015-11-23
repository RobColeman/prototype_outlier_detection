package metrics

import breeze.linalg.Vector
import breeze.linalg.functions._
import breeze.linalg.squaredDistance

/**
 * Created by rcoleman on 11/23/15.
 */
object distance {
  def apply(x: Vector[Double], y: Vector[Double], metric: String = "euclidean"): Double = {
    metric match {
      case "cosine" => cosineDistance(x, y)
      case "manhattan" => manhattanDistance(x, y)
      case "minkowski" => minkowskiDistance(x, y)
      case "squared" => squaredDistance(x, y)
      case "jaccard" => tanimotoDistance(x,y)
      case "tanimoto" => tanimotoDistance(x,y)
      case "euclidean" => euclideanDistance(x, y)
      case _ => euclideanDistance(x, y)
    }
  }
}
