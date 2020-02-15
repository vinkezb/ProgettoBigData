package classes

import org.apache.spark.sql.functions._
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.{SparkConf, SparkContext}

object MainClasseKevin {
 def main(args: Array[String]) = {
   val conf = new SparkConf().setMaster("local[2]")
     .setAppName("MainClasse")

   val sc = new SparkContext(conf)

   //creazione sqlContext
   val sqlContext = new HiveContext(sc)
   import sqlContext.implicits._

   val DfJson = sqlContext.read.json(System.getProperty("user.dir") + "\\src\\test\\resources\\test.txt")
   DfJson.dtypes.foreach(println)

   //numero di commits
   val numeroCommit = println(DfJson.select($"Payload.commits").count())

   //numero commits per author
   val numeroCAttori = DfJson.withColumn("author", $"payload.commits.author".cast("String").as("author")).groupBy($"author").count()

   //numero commit per type
   val numeroCommitAutoreType = DfJson.withColumn("type" ,$"Type".as("type")).groupBy( $"type").count()

  //numero commit divisi per type e author
   val divisiAT = DfJson.select($"Actor".as("actor"), $"Type".as("type")).groupBy($"actor", $"type").count().show(30)

 }
}
