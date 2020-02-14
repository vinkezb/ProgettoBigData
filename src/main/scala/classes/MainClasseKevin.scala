package classes

import org.apache.spark.sql.functions.explode
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
   val numeroCommitAttore = DfJson.withColumn("author",  explode($"payload.commits.author")).groupBy($"payload.commits.author").count().show(10)


   val numeroCommitAttoreType = DfJson.select($"payload.member.type", $"payload.commits.author").groupBy($"payload.member.type",$"payload.commits.author").count().show(12)
 }
}
