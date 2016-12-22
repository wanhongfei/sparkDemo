import org.apache.spark.{SparkConf, SparkContext}

object SimpleApp {
  def main(args: Array[String]) {
    println("hello test")
    val logFile = "file:///E:/spark-2.0.2-bin-hadoop2.7/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("Lines with a: %s, Lines with b: %s".format(numAs, numBs))
  }
}