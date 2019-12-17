import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

object MainClasseAndrea {
  def main(args: Array[String]) = {

    var conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)
    val jsonDF = sqlContext.read.json("C:/Users/Studente/Documents/2018-03-01-0.json")
    jsonDF.dtypes.foreach(x => println(x))
    println("Print nuovo")
    println(jsonDF.toString())
    println(jsonDF.show())


  }
}
