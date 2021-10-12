package controllers

import javax.inject._
import play.api._
import play.api.mvc._

import scala.concurrent.Future
import scala.concurrent.duration._
import scala.io.StdIn

import akka.actor.ActorSystem
import akka.stream.ActorMaterializer
import akka.stream.scaladsl.{Flow, Keep, Sink, Source}
import akka.util.ByteString
import serial.SerialService
import akka.serial.SerialSettings
import akka.serial.Parity
import akka.actor.ActorSystem
import scala.io.StdIn

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  def index() = Action { implicit request: Request[AnyContent] =>
    Ok(views.html.index())
  }

  def discover() = Action {
    import play.api.libs.json.Json
    /* send message to Serial Port mediator */
    val port = "COM5"
    val baud = 115200
    val cs = 8
    val tsb = false
    val parity = Parity(0)
    val settings = SerialSettings(baud, cs, tsb, parity)
    val system = ActorSystem("Example")
     val actor = system.actorOf(SerialService.apply(port, settings), "e1")
//     Thread.sleep(2000)
//  actor ! "ATI\r\n"
//  Thread.sleep(2000)
//  actor ! "close"
//  Thread.sleep(2000)

   // .withDispatcher("akka-serial")
    /* await response and send response back to client */
    val nieces = Seq("Aleka", "Christina", "Emily", "Hannah", "Molly", "David")
    Ok(Json.toJson(nieces))
  }
}