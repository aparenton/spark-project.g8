package $package$

import $package$.util.SparkApplication

class $name;format="Camel"$Job extends SparkApplication {
  override def sparkConfig: Map[String, String] = Map(
    "spark.master"   -> "local[*]",
    "spark.app.name" -> "$name$"
  )

  def start(): Unit = {
    withSparkSession { sparkSession =>
      // FIXME
    }
  }
}

object $name;format="Camel"$Job {
  def run(): Unit = {
    val job = new $name;format="Camel"$Job()
    job.start()
  }
}
