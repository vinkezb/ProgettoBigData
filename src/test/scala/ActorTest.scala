import classes.Actor
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.scalatest.{FlatSpec, Matchers}

class ActorTest extends  FlatSpec  with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("ActorTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val JsonDfActor = sqlContext.read.json("src/test/resources/actor.json");
    val rdd = JsonDfActor.as[Actor].rdd
    rdd.foreach(println)

    assert(true)
  }
}

