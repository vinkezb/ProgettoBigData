import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object MainClasseKevin {
 def main(args: Array[String]) = {
   val conf = new SparkConf().setMaster("local[2]")
     .setAppName("MainClasse")

   val sc = new SparkContext(conf)

   //creazione sqlContext
   val sqlContext = new SQLContext(sc)

   val JsonDf = sqlContext.read.json("C:\\Users\\kevin\\Desktop\\json");
   JsonDf.show(200)
   JsonDf.dtypes.foreach(x => println(x))
 }
}
