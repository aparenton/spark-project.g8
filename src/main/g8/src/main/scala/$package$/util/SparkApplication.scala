package $package$.util

import org.apache.spark.SparkConf
import org.apache.spark.sql.SparkSession

trait SparkApplication {
  def sparkConfig: Map[String, String]

  def withSparkSession(f: SparkSession   => Unit): Unit = {
    val conf = new SparkConf()

    sparkConfig.foreach { case (k, v) => conf.setIfMissing(k, v) }

    val sparkSession = SparkSession.builder().config(conf).getOrCreate()

    f(sparkSession)

    sparkSession.stop()
  }
}
