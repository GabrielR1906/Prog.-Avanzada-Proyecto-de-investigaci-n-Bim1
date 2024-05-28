import scala.concurrent.{Future, Await}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._

object Ejecutor extends App {
  // Tarea 1: Sumar los números del 1 al 5
  val future1: Future[Int] = Future {
    var sum = 0
    for (i <- 1 to 5) {
      sum += i
      Thread.sleep(100) // Simula un cálculo costoso
    }
    sum
  }

  // Tarea 2: Sumar los números del 6 al 10
  val future2: Future[Int] = Future {
    var sum = 0
    for (i <- 6 to 10) {
      sum += i
      Thread.sleep(100) // Simula un cálculo costoso
    }
    sum
  }

  // Obtiene los resultados de las tareas y los suma
  val totalSum = Await.result(future1, Duration.Inf) + Await.result(future2, Duration.Inf)
  println("La suma total es "+totalSum)
}