import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object MainLalli {
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)

    val mySqlContext = new HiveContext(sc)
    val jsonDF = mySqlContext.read.json("C:/Users/Studente/Desktop/Lalli Ludovico - LYNX/BIG DATA/qwerty.json")

    println(jsonDF.toString())
    println("hello world")
    jsonDF.dtypes.foreach(x=>println(x))


  }
}
