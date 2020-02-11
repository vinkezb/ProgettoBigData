import java.io.{BufferedInputStream, BufferedReader, File, FileInputStream, FileOutputStream, IOException, InputStream, InputStreamReader}
import java.net.{HttpURLConnection, URI, URL}
import java.nio.channels.{Channels, ReadableByteChannel}
import java.nio.file.{Files, Path, Paths, StandardCopyOption}
import java.util.Properties
import java.util.zip.{GZIPInputStream, ZipInputStream}

import org.apache.commons.io.FileUtils
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.hive.HiveContext

object MainClasseAndrea {
  def main(args: Array[String]) = {

    var conf = new SparkConf().setMaster("local[2]").setAppName("CountingSheep")
    val sc = new SparkContext(conf)
    val sqlContext = new HiveContext(sc)

    val url = "http://data.githubarchive.org/" + readProperties().getProperty("anno") + "-" + readProperties().getProperty("mese") + "-" + readProperties().getProperty("giorno") + "-" + "0.json.gz"
    connection(url)
    //val jsonDF = sqlContext.read.json("C:/Users/Studente/Documents/" +  "-03-01-0.json")
    import sqlContext.implicits._
    /*jsonDF.dtypes.foreach(x => println(x))
        println("Print nuovo")
        println(jsonDF.toString())
        println(jsonDF.show())
    */
    //   val JsonDfActor = sqlContext.read.json("C:\\Users\\kevin\\Desktop\\json\\actor.json");
    //   val rdd = JsonDfActor.as[Actor].rdd
    //   rdd.foreach(println)

    // val jsonDFPayloadComment = sqlContext.read.json("C:\\Users\\Studente\\Desktop\\json");
    // val RDDPayloadComment = jsonDFPayloadComment.as[Comment].rdd

  }

  def readProperties(): Properties ={
    val property = new Properties()
    property.load(new FileInputStream(new File(System.getProperty("user.dir") +"\\src\\test\\resources\\progetto.properties")))
    property
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
