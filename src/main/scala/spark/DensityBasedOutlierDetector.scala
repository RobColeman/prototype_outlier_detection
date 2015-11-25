package spark

import metrics.outlierScore
import breeze.linalg.DenseMatrix
import org.apache.spark.rdd.RDD
import org.apache.spark.mllib.linalg.{Vector, Vectors}

class DensityBasedOutlierDetector(k: Int) extends Serializable {

  def findNeighbors(x: Vector): DenseMatrix[Double] = ???

  def train(dataRDD: RDD[Vector]): Unit = ???

  def score(v: Vector): Double = outlierScore(v, this.findNeighbors(v))
  def score(dataRDD: RDD[Vector]): RDD[Double] = {
    dataRDD.map(score)
  }


}
