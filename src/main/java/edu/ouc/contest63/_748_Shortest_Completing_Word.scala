package edu.ouc.contest63

object _748_Shortest_Completing_Word {

  def shortestCompletingWord(licensePlate: String, words: Array[String]): String = {
//    val s = licensePlate.replaceAll("\\d|\\u0020", "").map(x => (x.toLower,1)).reduce(
//      (x,y) => (if(x._1 == y._1) (x._1, x._2+y._2)))
    val s = ""
    println("s:" + s)
    var shortestLen = 1001
    var shortestIndex = -1

    for( i <- 0 until words.length){
      val word = words(i)
//      if(word.length < shortestLen && canCompleted(s, word)){
//        shortestLen = word.length
//        shortestIndex = i
//      }
    }
    words(shortestIndex)
  }
  def canCompleted(plate: String, word : String): Boolean = {
    var retVal = false

    retVal
  }

  def main(args: Array[String]): Unit = {
    val words = Array("step", "steps", "stripe", "stepple")
    val licensePlate = "1s3 PSt"
    val s = "{\"1\":\"百度手机卫士\",\"2\":\"cn.opda.a.phonoalbumshoushou\",\"3\":\"9.6.0\",\"4\":\"04545988C3201C113BB195BB97F9D38E|5609616500001A\",\"5\":\"1003105\",\"6\":1512870963857,\"7\":\"\",\"8\":\"600000027\",\"9\":\"techain\",\"10\":\"3.0.8\",\"11\":\"\",\"12\":\"\",\"13\":1,\"14\":1,\"20\":\"70184403BC0536C7A3552A37C2DBADA4|5609616500001A\",\"21\":\"70184403BC0536C7A3552A37C2DBADA4|5609616500001A\",\"22\":\"8519fb943ed40c64affb0ee3a5add466\",\"module_section\":[{\"0\":0,\"1\":100028,\"2\":\"2.8.3.1\"}],\"101\":\"1512871216\",\"102\":\"118.252.166.182\",\"103\":\"5f4c0ec4-d6c1-4166-9520-dcddcafa8660\",\"104\":\"600000027\"}"
    println(s.length)

    shortestCompletingWord(licensePlate, words)

  }
}
