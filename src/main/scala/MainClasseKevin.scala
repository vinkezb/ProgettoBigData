import org.apache.spark.sql.SQLContext
import org.apache.spark.{SparkConf, SparkContext}
import org.json4s._
import org.json4s.jackson.JsonMethods._

object MainClasseKevin {
 def main(args: Array[String]) = {
   val conf = new SparkConf().setMaster("local[2]")
     .setAppName("MainClasse")

   val sc = new SparkContext(conf)

   //creazione sqlContext
   val sqlContext = new SQLContext(sc)
   import sqlContext.implicits._

   val file_location ="C:\\Users\\kevin\\Desktop\\json"
   val rddJson = sc.textFile(file_location)

   rddJson.map{row =>
     val json_row = parse(row)
     (compact(json_row), compact(json_row))}
     .collect().foreach{println(_)}

//   val JsonDfActor = sqlContext.read.json("C:\\Users\\kevin\\Desktop\\json\\actor.json");
//   val rdd = JsonDfActor.as[Actor].rdd
//   rdd.foreach(println)

 }
}
