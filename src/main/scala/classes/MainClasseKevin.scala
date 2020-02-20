package classes

import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{Row, SparkSession}
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.functions._
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.StructType
import org.apache.spark.{SparkConf, SparkContext}

object MainClasseKevin {
 def main(args: Array[String]) = {
   val conf = new SparkConf().setMaster("local[2]")
     .setAppName("MainClasse")

   val sc = new SparkContext(conf)

   //creazione sqlContext
   val sqlContext = new HiveContext(sc)
   val schema = ScalaReflection.schemaFor[Wrapper].dataType.asInstanceOf[StructType]
   val spark = SparkSession.builder.config(conf).getOrCreate()
   import spark.sqlContext.implicits._

   val DfJson = sqlContext.read.schema(schema)json(System.getProperty("user.dir") + "\\src\\test\\resources\\test.txt")
   val dataSetCommit = DfJson.as[Wrapper_]
   val rdd : RDD[Row] = DfJson.rdd

   //numero di commits
   val numeroCommit = println(DfJson.select($"Payload.commits").count())

   //DS
   val numeroCommitDS = dataSetCommit.select($"payload.commits").count()
   println(numeroCommitDS)

   //numero commits per actor
   val numeroCAttori = DfJson.withColumn("actor", $"Actor".as("actor")).groupBy($"actor").count().show(24)

   //DS
   val nCAttoriDS = dataSetCommit.withColumn("actor", $"Actor".as("actor")).groupBy($"actor").count().show(24)

   //numero commit per type
   val numeroCommitAutoreType = DfJson.withColumn("type" ,$"Type".as("type")).groupBy( $"type").count()

   //DS
   val numeroCommitAutoreTypeDS = dataSetCommit.withColumn("type" ,$"Type".as("type")).groupBy( $"type").count()

   //numero commit divisi per type e actor
   val numeroCommitAT = DfJson.select($"Actor".as("actor"), $"Type".as("type")).groupBy($"actor", $"type").count().show(24)

   //DS
   val numeroCommitATDS = dataSetCommit.select($"Actor".as("actor"), $"Type".as("type")).groupBy($"actor", $"type").count().show(24)

   //numero commit divisi per type actor e event
   DfJson.createOrReplaceTempView("tabella")
   sqlContext.sql("select Type , count(Type), Actor from tabella   group by Type,Actor ").show(10)
   //val numeroCommitTAE = DfJson.select($"Type" , count($"Type"), $"Actor").groupBy($"Actor", $"Type").count().show(10)

   //numero commit per type actor e ora
   val numeroCTAO = DfJson.groupBy($"Actor", $"Type", $"Created_at").agg($"Type").count()
   println(numeroCTAO)

   val numeroCTAODS = dataSetCommit.groupBy($"Actor", $"Type", $"Created_at").agg($"Type").count()
   println(numeroCTAODS)

   //numero massimo/minimo commit per ora
   val numeroMassimoC = DfJson.groupBy($"payload.commits",$"created_at").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val numeroMinimoC = DfJson.groupBy($"payload.commits",$"created_at").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //DS
   val nMassimoCDS = dataSetCommit.groupBy($"payload.commits",$"created_at").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val nMinimoCDS = dataSetCommit.groupBy($"payload.commits",$"created_at").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //numero massimo/minimo commit per actor
   val numeroMassimoCA = DfJson.groupBy($"payload.commits",$"actor").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val numeroMinimoCA = DfJson.groupBy($"payload.commits",$"actor").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //DS
   val nMassimoCDSA = dataSetCommit.groupBy($"payload.commits",$"actor").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val nMinimoCDSA = dataSetCommit.groupBy($"payload.commits",$"actor").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //numero massimo/minimo commit per repo
   val numeroMassimoCR = DfJson.groupBy($"payload.commits",$"repo").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val numeroMinimoCR = DfJson.groupBy($"payload.commits",$"repo").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //DS
   val nMassimoCDSR = dataSetCommit.groupBy($"payload.commits",$"repo").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val nMinimoCDSR = dataSetCommit.groupBy($"payload.commits",$"repo").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //numero massimo/minimo commit per ora e actor
   val numeroMassimoCOA = DfJson.groupBy($"payload.commits",$"actor", $"created_at").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val numeroMinimoCOA = DfJson.groupBy($"payload.commits",$"actor", $"created_at").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //DS
   val nMassimoCDSOA = dataSetCommit.groupBy($"payload.commits",$"actor", $"created_at").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val nMinimoCDSOA = dataSetCommit.groupBy($"payload.commits",$"actor", $"created_at").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //numero massimo/minimo commit per ora e repo
   val numeroMassimoCOR = DfJson.groupBy($"payload.commits",$"repo", $"created_at").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val numeroMinimoCOR = DfJson.groupBy($"payload.commits",$"repo", $"created_at").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //DS
   val nMassimoCDSOR = dataSetCommit.groupBy($"payload.commits",$"repo", $"created_at").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val nMinimoCDSOR = dataSetCommit.groupBy($"payload.commits",$"repo", $"created_at").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //numero massimo/minimo commit per ora, actor e repo
   val numeroMassimoCOAR = DfJson.groupBy($"payload.commits",$"actor", $"created_at", $"repo").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val numeroMinimoCOAR = DfJson.groupBy($"payload.commits",$"actor", $"created_at", $"repo").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //DS
   val nMassimoCDSOAR = dataSetCommit.groupBy($"payload.commits",$"actor", $"created_at", $"repo").agg(count($"payload.commits") as("a")).agg(max("a")).show()
   val nMinimoCDSOAR = dataSetCommit.groupBy($"payload.commits",$"actor", $"created_at", $"repo").agg(count($"payload.commits") as("a")).agg(min("a")).show()

   //numero actor attivi per ora
   val nAttoriAttivi  = DfJson.select($"actor", $"created_at").groupBy($"created_at").count().show(24)

   //DS
   val nAttoriAttiviDS = dataSetCommit.select($"actor", $"created_at").groupBy($"created_at").count().show(24)

   //numero attori divisi per type e ora
   val nAttoriTO = DfJson.groupBy($"created_at", $"type", $"actor").agg($"actor").count()
   println(nAttoriTO)

   //DS
   val nAttoriTODS = dataSetCommit.groupBy($"created_at", $"type", $"actor").agg($"actor").count()
   println(nAttoriTODS)

   //numero attori divisi per type ora e repo
   val nActorTRO = DfJson.groupBy($"created_at", $"type", $"actor", $"repo").agg($"actor").count()
   println(nActorTRO)

   //DS
   val nActorTRODS = dataSetCommit.groupBy($"created_at", $"type", $"actor", $"repo").agg($"actor").count()
   println(nActorTRODS)


   //massimo/minimo actor attivi per ora
   val maxActorO  = DfJson.groupBy($"created_at", $"actor").agg(count($"actor") as ("a")).agg(max("a")).show()
   val minActorO  = DfJson.groupBy($"created_at", $"actor").agg(count($"actor") as ("a")).agg(min("a")).show()

   //DS
   val maxActorODS  = dataSetCommit.groupBy($"created_at", $"actor").agg(count($"actor") as ("a")).agg(max("a")).show()
   val minActorODS  = dataSetCommit.groupBy($"created_at", $"actor").agg(count($"actor") as ("a")).agg(min("a")).show()


   //massimo/minimo actor attivi per ora e type
   val maxActorOT  = DfJson.groupBy($"created_at", $"actor", $"type").agg(count($"actor") as ("a")).agg(max("a")).show()
   val minActorOT  = DfJson.groupBy($"created_at", $"actor", $"type").agg(count($"actor") as ("a")).agg(min("a")).show()

   //DS
   val maxActorOTDS  = dataSetCommit.groupBy($"created_at", $"actor", $"type").agg(count($"actor") as ("a")).agg(max("a")).show()
   val minActorOTDS  = dataSetCommit.groupBy($"created_at", $"actor", $"type").agg(count($"actor") as ("a")).agg(min("a")).show()

   //massimo/minimo actor attivi per ora, type e repo
   val maxActorOTR  = DfJson.groupBy($"created_at", $"actor", $"type", $"repo").agg(count($"actor") as ("a")).agg(max("a")).show()
   val minActorOTR  = DfJson.groupBy($"created_at", $"actor", $"type", $"repo").agg(count($"actor") as ("a")).agg(min("a")).show()

   //DS
   val maxActorOTRDS  = dataSetCommit.groupBy($"created_at", $"actor", $"type", $"repo").agg(count($"actor") as ("a")).agg(max("a")).show()
   val minActorOTRDS  = dataSetCommit.groupBy($"created_at", $"actor", $"type", $"repo").agg(count($"actor") as ("a")).agg(min("a")).show()

 }
}
