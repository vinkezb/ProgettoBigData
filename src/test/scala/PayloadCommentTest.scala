import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.scalatest.{FlatSpec, Matchers}

class PayloadCommentTest extends  FlatSpec  with Matchers{

  "Comment" should "print comment's datas" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("PayloadCommentTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfActor = sqlContext.read.json("C:\\Users\\Studente\\Desktop\\json");
    val rdd = JsonDfActor.as[Comment].rdd
    rdd.foreach(println)

    assert(true)
  }

}
