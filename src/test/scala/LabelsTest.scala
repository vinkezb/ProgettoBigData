import classes.Labels_
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.sql.SQLContext
import org.apache.spark.sql.catalyst.ScalaReflection
import org.apache.spark.sql.types.StructType
import org.scalatest.{FlatSpec, Matchers}

class LabelsTest extends FlatSpec with Matchers {

  "A Stack" should "pop values in last-in-first-out order" in {
    val conf = new SparkConf().setMaster("local[2]")
      .setAppName("LabelsTest")

    val sc = new SparkContext(conf)
    val sqlContext = new SQLContext(sc)
    import sqlContext.implicits._

    val schema = ScalaReflection.schemaFor[Labels_].dataType.asInstanceOf[StructType]
    val JsonDfLabels_ = sqlContext.read.schema(schema).json("src/test/resources/labels.json");
    val rdd = JsonDfLabels_.as[Labels_].rdd
    rdd.foreach(println)

    assert(true)
  }
}
