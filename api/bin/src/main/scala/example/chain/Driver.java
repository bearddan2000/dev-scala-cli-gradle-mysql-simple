package example.chain;

import com.typesafe.scalalogging.slf4j.LazyLogging

class Driver extends ILink, LazyLogging {

  val next: ILink = new DbConnect();

  override def hasResource(driverStr: String, connectionStr: String): Boolean =
  {
    if(this.hasDriver(driverStr))
      return this.next.hasResource(driverStr, connectionStr);
    else
      return false;
  }
}

object Driver {
  def hasDriver(driverStr: String): Boolean =
  {
    var result = false;
    try {
        // The newInstance() call is a work around for some
        // broken Java implementations
        instanceOf[driverStr]
        result = true;
        logger.info("Success driver found.");
    } catch {
      case Exception::class
        logger.fatal("Fail driver not found.");
    }
    return result;
  }
}
