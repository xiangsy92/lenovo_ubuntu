package org.example
import org.apache.spark.sql.SparkSession
object SparkSessionTest extends App{
  val spark = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExample")
    .getOrCreate();

  println("First SparkContext:")
  println("APP Name :"+spark.sparkContext.appName);
  println("Deploy Mode :"+spark.sparkContext.deployMode);
  println("Master :"+spark.sparkContext.master);

  val sparkSession2 = SparkSession.builder()
    .master("local[1]")
    .appName("SparkByExample-test")
    .getOrCreate();

  println("Second SparkContext:")
  println("APP Name :"+sparkSession2.sparkContext.appName);
  println("Deploy Mode :"+sparkSession2.sparkContext.deployMode);
  println("Master :"+sparkSession2.sparkContext.master);

  //---
  println("----------------")

  import spark.implicits._

  val someDF = Seq(
    (8, "bat"),
    (64, "mouse"),
    (-27, "horse")
  ).toDF("number", "word")
  someDF.printSchema()
  println("----------------")
  someDF.show()
}