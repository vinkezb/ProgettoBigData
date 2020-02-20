import java.io.{BufferedInputStream, BufferedReader, File, FileInputStream, FileOutputStream, FileWriter, IOException, InputStream, InputStreamReader, StringWriter}
import java.net.{HttpURLConnection, URI, URL}
import java.nio.channels.{Channels, ReadableByteChannel}
import java.nio.file.{Files, Path, Paths, StandardCopyOption}
import java.util.Properties
import java.util.zip.{GZIPInputStream, ZipInputStream}

import classes.{Actor, Author, Repo, Wrapper, Wrapper_}
import com.opencsv.CSVWriter
import org.apache.commons.io.FileUtils
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.{DataFrame, Dataset, Encoder, RelationalGroupedDataset, Row, SparkSession}
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.{SparkConf, SparkContext, sql}
import org.apache.spark.sql.hive.HiveContext
import org.apache.spark.sql.types.StructType

import scala.reflect.ClassTag

object MainClasseAndrea {
  def main(args: Array[String]) = {

    var conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    //    val sc = new SparkContext(conf)
    //    val sqlContext = new HiveContext(sc)
    val schema = ScalaReflection.schemaFor[Wrapper].dataType.asInstanceOf[StructType]
    val url = "http://data.githubarchive.org/" + readProperties().getProperty("anno") + "-" + readProperties().getProperty("mese") + "-" + readProperties().getProperty("giorno") + "-" + "0.json.gz"
   // val unzippedFile = connection(url) //download and unzip file
    val spark = SparkSession.builder.config(conf).getOrCreate()

    val jsonDF = spark.read.schema(schema).json(System.getProperty("user.dir") +"\\src\\test\\resources\\test.txt")



    import spark.sqlContext.implicits._


    val actorDF = jsonDF.select("actor")
    val authorDF = jsonDF.select($"payload.commits.author")
    val repoDF = jsonDF.select("repo")
    val numOfActorFromDF = println("numero di actor da DF: " + jsonDF.select("actor").count())
    val numOfRepoFromDF = println("numero di repo da DF: " + jsonDF.select("repo").count())
    val jsonDFForTypeEvent = jsonDF.select("type").distinct().toDF()



    val jsonDS =  jsonDF.as[Wrapper_]
    val jsonDSForTypeEvent = jsonDS.select("type").distinct()


    val actorDS = jsonDS.select("actor").distinct()
    val authorDS = jsonDS.select("payload.commits.author").distinct()
    val repoDS = jsonDS.select("repo").distinct()
    val numOfActorFromDS = println("numero di actor da DS: " + jsonDS.select("actor").distinct().count())
    val numOfRepoFromDS = println("numero di repo da DS: " + jsonDS.select("repo").distinct().count())

    val actorRDD: RDD[Row] = actorDF.rdd
    val authorRDD: RDD[Row] = authorDF.rdd
    val repoRDD: RDD[Row] = repoDF.rdd
    val jsonRDDForTypeEvent: RDD[Row] = jsonDFForTypeEvent.rdd
    val numOfActorFromRDD = println("numero di actor da RDD: " + actorRDD.count())
    val numOfRepoFromRDD = println("numero di repo da RDD: " + repoRDD.count())




    setCSVFileForDF("actorDF", actorDF)
    setCSVFileForDF("authorDF", authorDF)
    setCSVFileForDF("repoDF", repoDF)
    setCSVFileForDF("typeOfEventDF", jsonDFForTypeEvent)

    setCSVFileForRDD("actorRDD", actorRDD)
    setCSVFileForRDD("authorRDD", authorRDD)
    setCSVFileForRDD("repoRDD", repoRDD)
      setCSVFileForDS("typeOfEventDS", jsonDSForTypeEvent)

    setCSVFileForDS("actorDS", actorDS)
    setCSVFileForDS("authorDS", authorDS)
    setCSVFileForDS("repoDS", repoDS)
    setCSVFileForRDD("typeOfEventRDD", jsonRDDForTypeEvent)


  }

  def readProperties(): Properties ={
    val property = new Properties()
    property.load(new FileInputStream(new File(System.getProperty("user.dir") +"\\src\\test\\resources\\progetto.properties")))
    property
  }

  def setCSVFileForDF(nameFile: String, dataSource: DataFrame){

    val w = new FileWriter(System.getProperty("user.dir") +"\\src\\test\\resources\\" + nameFile + ".csv")
    val writer : CSVWriter = new CSVWriter(w, CSVWriter.DEFAULT_SEPARATOR)
    writer.writeNext(dataSource.collect().map(x => x.toString()))
    writer.close()
    println("Ho scritto il file " + nameFile + ".csv da DF")
  }


  def setCSVFileForRDD[T: ClassTag](nameFile: String, dataSource: RDD[T]){
    val w = new FileWriter(System.getProperty("user.dir") +"\\src\\test\\resources\\" + nameFile + ".csv")
    val writer : CSVWriter = new CSVWriter(w, CSVWriter.DEFAULT_SEPARATOR)
    writer.writeNext(dataSource.collect().map(x => x.toString()))
    writer.close()
    println("Ho scritto il file " + nameFile + ".csv da RDD")
  }

  def setCSVFileForDS[T: ClassTag](nameFile: String, dataSource: Dataset[T]){
    val w = new FileWriter(System.getProperty("user.dir") +"\\src\\test\\resources\\" + nameFile + ".csv")
    val writer : CSVWriter = new CSVWriter(w, CSVWriter.DEFAULT_SEPARATOR)
    writer.writeNext(dataSource.collect().map(x => x.toString))
    writer.close()
    println("Ho scritto il file " + nameFile + ".csv da DS")
  }


  def connection(url: String): Unit ={
    val obj = new URL(url)
    val con =  obj.openConnection().asInstanceOf[HttpURLConnection]
    con.setRequestMethod("GET");
    con.setRequestProperty("User-Agent", "")
    val responseCode = con.getResponseCode;
    println("GET Response Code :: " + responseCode)
    val f = new File((System.getProperty("user.dir") + "\\src\\test\\resources\\test.txt"))
    val FILE_NAME = f.toString
    f.createNewFile();
    if(responseCode == 301){
      val in = new URL(con.getHeaderField("Location")).openConnection().asInstanceOf[HttpURLConnection]
      in.setRequestMethod("GET");
      in.setRequestProperty("User-Agent", "")
      val zis = new GZIPInputStream(in.getInputStream)
      println("ciao")
      Files.copy(zis, Paths.get(FILE_NAME), StandardCopyOption.REPLACE_EXISTING);



    }





  }



}
